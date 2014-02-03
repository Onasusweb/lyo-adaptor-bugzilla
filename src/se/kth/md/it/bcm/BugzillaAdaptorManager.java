/*******************************************************************************
 * Copyright (c) 2011, 2012 IBM Corporation.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompanies this distribution.
 *  
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * Contributors:
 *
 *     Sam Padgett          - initial API and implementation
 *     Michael Fiedler      - adapted for OSLC4J
 *     Russell Boykin       - initial API and implementation
 *     Alberto Giammaria    - initial API and implementation
 *     Chris Peters         - initial API and implementation
 *     Gianluca Bernardini  - initial API and implementation
 *     Michael Fiedler      - Bugzilla adpater implementations
 *******************************************************************************/

package se.kth.md.it.bcm;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.ServletContextEvent;
import java.util.List;

import se.kth.md.it.bcm.ServiceProviderInfo;
		import se.kth.md.it.bcm.resources.Type;
		import se.kth.md.it.bcm.resources.Person;
		import se.kth.md.it.bcm.resources.BugzillaChangeRequest;
		import se.kth.md.it.bcm.resources.ChangeRequest;

// Start of user code imports
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.util.Properties;

import org.eclipse.lyo.oslc4j.client.ServiceProviderRegistryURIs;
import org.eclipse.lyo.oslc4j.core.model.Link;

import com.j2bugzilla.base.Bug;
import com.j2bugzilla.base.BugFactory;
import com.j2bugzilla.base.BugzillaConnector;
import com.j2bugzilla.base.Product;
import com.j2bugzilla.rpc.BugSearch;
import com.j2bugzilla.rpc.CommentBug;
import com.j2bugzilla.rpc.GetBug;
import com.j2bugzilla.rpc.GetProduct;
import com.j2bugzilla.rpc.ReportBug;

import org.eclipse.lyo.oslc4j.bugzilla.jbugzx.rpc.GetAccessibleProducts;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response.Status;

import se.kth.md.it.bcm.servlet.ServletListener;
import se.kth.md.it.bcm.servlet.CredentialsFilter;
import se.kth.md.it.bcm.servlet.ServiceProviderCatalogSingleton;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.HashSet;

// End of user code


// Start of user code pre_class_code
// End of user code

public class BugzillaAdaptorManager {

	// Start of user code class_attributes
	public final static String REALM = "Bugzilla";
	
    private static String bugzillaUri = null;
	private static String admin = null;

    //Bugzilla adapter properties from bugz.properties 
    static {
        Properties props = new Properties();
        try {
        	//I simply could not get this load function to work. I get exceptions, and too tired to make it work. 
        	//I am instead simply hard coding the 2 variables for now.
            //props.load(BugzillaAdaptorManager.class.getResourceAsStream("/test/resources/bugz.properties"));
        	bugzillaUri="https://landfill.bugzilla.org/bugzilla-4.0-branch/";
           	admin="jelkhoury@hotmail.com";
            System.out.println("bugzilla_uri: " + bugzillaUri);
            System.out.println("admin: " + admin);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	// End of user code
	
	// Start of user code class_methods
    public static String getBugzillaUri() {
        return bugzillaUri;
    }

    public static void setBugzillaUri(String bugzillaUri) {
        BugzillaAdaptorManager.bugzillaUri = bugzillaUri;
    }

	public static String getAdmin() {
		return admin;
	}

    /**
     * get BugzillaConnector from the HttpSession
     * 
     * The connector should be placed in the session by the CredentialsFilter servlet filter
     * 
     * @param request
     * @return connector 
     */
	public static BugzillaConnector getBugzillaConnector(HttpServletRequest request) 
	{	
		//connector should never be null if CredentialsFilter is doing its job
		BugzillaConnector connector = (BugzillaConnector) request.getSession().getAttribute(CredentialsFilter.CONNECTOR_ATTRIBUTE);	
		return connector;
	}
	
	//The following are static utility methods are useful for getting, creating and updating Bugzilla bugs.  Primarily used by BugzillaChangeRequestService

	/**
	 * Converts a {@link Bug} to an OSLC-CM BugzillaChangeRequest.
	 * 
	 * @param bug
	 *            the bug
	 * @return the ChangeRequest to be serialized
	 * @throws URISyntaxException
	 *             on errors setting the bug URI
	 * @throws UnsupportedEncodingException
	 */
	public static BugzillaChangeRequest fromBug(Bug bug, final HttpServletRequest httpServletRequest, final String serviceProviderId)
			throws URISyntaxException, UnsupportedEncodingException {
		BugzillaChangeRequest changeRequest = new BugzillaChangeRequest();
		changeRequest.setIdentifier(Integer.toString(bug.getID()));
		changeRequest.setTitle(bug.getSummary());
		changeRequest.setStatus(bug.getStatus());

		//Map contributor to the person this bug is assigned to
		Object assignedTo = bug.getParameterMap().get("assigned_to");
		if (assignedTo != null) {
			String email = assignedTo.toString();
			Person contributor = new Person();
			//contributor.setMbox(email);
			contributor.setAbout(new URI(ServletListener.getServletBase() + "/person?mbox=" + URLEncoder.encode(email, "UTF-8")));
			HashSet<Person> contributors = new HashSet<Person>();
			contributors.add(contributor);
			changeRequest.setContributors(contributors);
		}
		
		Date createdDate = (Date) bug.getParameterMap().get("creation_time");
		changeRequest.setCreated(createdDate);
		
		Date modifiedDate = (Date) bug.getParameterMap().get("last_change_time");
		changeRequest.setModified(modifiedDate);
		
		changeRequest.setProduct(bug.getProduct());
		changeRequest.setComponent(bug.getComponent());
		
		// Work around a bug in j2bugzilla. Bug.getVersion() results in a class cast exception.
		Object version = bug.getParameterMap().get("version");
		if (version != null) {
			changeRequest.setVersion(version.toString());
		}
		
		changeRequest.setPriority(bug.getPriority());
		
		Map<?, ?> internals = bug.getParameterMap();
		changeRequest.setPlatform((String) internals.get("platform"));
		changeRequest.setOperatingSystem((String) internals.get("op_sys"));
		
		changeRequest.setServiceProvider(ServiceProviderCatalogSingleton.getServiceProvider(httpServletRequest, serviceProviderId).getAbout());  
		changeRequest.setAbout(BugzillaChangeRequest.constructURI(serviceProviderId, changeRequest.getIdentifier()));

		return changeRequest;
	}

    /**
     * Convert a list of Bugzilla Bugs to a list of BugzillaChangeRequests
     * 
     * @param httpServletRequest
     * @param bugList
     * @param productId
     * @return
     */
	public static List<BugzillaChangeRequest> changeRequestsFromBugList(final HttpServletRequest httpServletRequest, final List<Bug> bugList, final String serviceProviderId)
    {
    	List<BugzillaChangeRequest> results = new ArrayList<BugzillaChangeRequest>();
    	
        for (Bug bug : bugList) {
        	BugzillaChangeRequest changeRequest = null;
        	try {
        		changeRequest = BugzillaAdaptorManager.fromBug(bug, httpServletRequest, serviceProviderId);
        	} catch (Exception e) {
        		throw new WebApplicationException(e);
        	}
        	
        	if (changeRequest != null) {
        		results.add(changeRequest);
        	}
        }
        return results;
    }
	
	/**
	 * Create a list of Bugs for a product ID using paging
	 * 
	 * @param httpServletRequest
	 * @param productIdString
	 * @param page
	 * @param limit
	 * @return The list of bugs, paged if necessary
	 * @throws IOException
	 * @throws ServletException
	 */
	public static List<Bug> getBugsByProduct(final HttpServletRequest httpServletRequest, final String productIdString, int page, int limit) throws IOException, ServletException 
    {
    	List<Bug> results=null;
		
		

		try {
			final BugzillaConnector bc = BugzillaAdaptorManager.getBugzillaConnector(httpServletRequest);
			final String pageString = httpServletRequest.getParameter("page");
			
			if (null != pageString) {
				page = Integer.parseInt(pageString);
			}
			int productId = Integer.parseInt(productIdString);
			
			final GetProduct getProducts = new GetProduct(productId); 
			bc.executeMethod(getProducts);
			final Product product = getProducts.getProduct();
		
			final BugSearch bugSearch = createBugSearch(page, limit, product);			
			bc.executeMethod(bugSearch);
			results = bugSearch.getSearchResults();
		} catch (Exception e) {
			e.printStackTrace();
			throw new WebApplicationException(e);
		}
    	
    	return results;
    }
	
	protected static BugSearch createBugSearch(final String summary) 
	{
		BugSearch.SearchQuery summaryQuery = new BugSearch.SearchQuery(
				BugSearch.SearchLimiter.SUMMARY, summary);
		BugSearch.SearchQuery limitQuery = new BugSearch.SearchQuery(
				BugSearch.SearchLimiter.LIMIT, "50");
			
		BugSearch bugSearch = new BugSearch(summaryQuery, limitQuery);
			
		return bugSearch;
	}

	
	protected static BugSearch createBugSearch(int page, int limit, Product product) {
		BugSearch.SearchQuery productQuery = new BugSearch.SearchQuery(
				BugSearch.SearchLimiter.PRODUCT, product.getName());
		BugSearch.SearchQuery limitQuery = new BugSearch.SearchQuery(
				BugSearch.SearchLimiter.LIMIT, (limit + 1) + "");
		BugSearch.SearchQuery offsetQuery = new BugSearch.SearchQuery(
				BugSearch.SearchLimiter.OFFSET, (page * limit) + "");
		
		return new BugSearch(productQuery, limitQuery, offsetQuery);
	}
	
	/**
	 * Get a Bugzilla Bug by id
	 * @param request
	 * @param bugIdString
	 * @return Bug
	 * @throws IOException
	 * @throws ServletException
	 */
	public static Bug getBugById(final HttpServletRequest request, final String bugIdString) throws IOException, ServletException
	{
		int bugId = -1;
		Bug bug = null;
		
		try {
			bugId = Integer.parseInt(bugIdString);
			final BugzillaConnector bc = BugzillaAdaptorManager.getBugzillaConnector(request);			
			final GetBug getBug = new GetBug(bugId);
			bc.executeMethod(getBug);
			bug = getBug.getBug();	
			if (bug == null) {
				throw new WebApplicationException(Status.NOT_FOUND);
			}  
		} catch (Exception e) {
			e.printStackTrace();
			throw new WebApplicationException(e);
		}
		
		return bug;
	}
	
	public static Product getProduct(final HttpServletRequest httpServletRequest, final String productIdString)
	{
		int productId = Integer.parseInt(productIdString);
		Product product = null;
		
		try {
			final BugzillaConnector bc = BugzillaAdaptorManager.getBugzillaConnector(httpServletRequest);				
			GetProduct getProducts = new GetProduct(productId); 
			bc.executeMethod(getProducts);
			product = getProducts.getProduct();
		} catch (Exception e) {
			e.printStackTrace();
			throw new WebApplicationException(e);
		}
		return product;
	}
	
	/**
	 * Add OSLC links to the comment field of a Bug
	 * 
	 * @param request
	 * @param cr - BugzillaChangeRequest containing the links
	 * @throws ServletException
	 * @throws IOException
	 */
	public static void updateBug(final HttpServletRequest request, final BugzillaChangeRequest cr) throws  ServletException, IOException
	{
		try
		{
			final BugzillaConnector bc = BugzillaAdaptorManager.getBugzillaConnector(request);
			
			// No built in field to hold external links. Just add the new link as a comment for now.
			String comment = getLinksComment(cr);
			if (comment.length() != 0) {
				CommentBug bugzillaMethod = new CommentBug(Integer.parseInt(cr.getIdentifier()), comment);
				bc.executeMethod(bugzillaMethod);
			}
		} catch (Exception e)
		{
			e.printStackTrace();
			throw new WebApplicationException(e);
		}
	}
	
	protected static void addLinkComment(final StringBuffer buffer, final String linkType, final Link [] links) {
		if (links != null && (links.length !=0)) {
			buffer.append(linkType);
			buffer.append(":\n\n");
			for (Link link : links) {
				buffer.append(link.getValue().toString());
				buffer.append("\n");
			}
		}
	}

	protected static String getLinksComment(final BugzillaChangeRequest cr) {
		final StringBuffer b = new StringBuffer();
		
		addLinkComment(b, "Affected by Defect", cr.getAffectedByDefects().toArray(new Link[cr.getAffectedByDefects().size()]));
		addLinkComment(b, "Affects Plan Item", cr.getAffectsPlanItems().toArray(new Link[cr.getAffectsPlanItems().size()]));
		addLinkComment(b, "Affects Requirement", cr.getAffectsRequirements().toArray(new Link[cr.getAffectsRequirements().size()]));
		addLinkComment(b, "Affects Test Result", cr.getAffectsTestResults().toArray(new Link[cr.getAffectsTestResults().size()]));
		addLinkComment(b, "Blocks Test Execution Record", cr.getBlocksTestExecutionRecords().toArray(new Link[cr.getBlocksTestExecutionRecords().size()]));
		addLinkComment(b, "Implements Requirement", cr.getImplementsRequirements().toArray(new Link[cr.getImplementsRequirements().size()]));
		addLinkComment(b, "Related Change Request", cr.getRelatedChangeRequests().toArray(new Link[cr.getRelatedChangeRequests().size()]));
		addLinkComment(b, "Related Test Execution Record", cr.getRelatedTestExecutionRecords().toArray(new Link[cr.getRelatedTestExecutionRecords().size()]));
		addLinkComment(b, "Related Test Plane", cr.getRelatedTestPlans().toArray(new Link[cr.getRelatedTestPlans().size()]));
		addLinkComment(b, "Related Test Script", cr.getRelatedTestScripts().toArray(new Link[cr.getRelatedTestScripts().size()]));
		addLinkComment(b, "Tested by Test Case", cr.getTestedByTestCases().toArray(new Link[cr.getTestedByTestCases().size()]));
		addLinkComment(b, "Tracks Change Set", cr.getTracksChangeSets().toArray(new Link[cr.getTracksChangeSets().size()]));
		addLinkComment(b, "Tracks Requirement", cr.getTracksRequirements().toArray(new Link[cr.getTracksRequirements().size()]));
		
		return b.toString();
	}
	// End of user code


    public static void contextInitializeServletListener(final ServletContextEvent servletContextEvent)
    {
		// Establish connection to data backbone etc ...
		// Start of user code contextInitializeServletListener
		// End of user code
    }

	public static void contextDestroyServletListener(ServletContextEvent servletContextEvent) 
	{
		// Shutdown connections to data backbone etc...
		// Start of user code contextDestroyed
		// End of user code
	}



    public static ServiceProviderInfo [] getServiceProviderInfos(HttpServletRequest httpServletRequest)
    {
		ServiceProviderInfo [] serviceProviderInfos = {};
		// Start of user code (MUST_FILL_IN) getServiceProviderInfos userCode
		try {
			BugzillaConnector bc = BugzillaAdaptorManager.getBugzillaConnector(httpServletRequest);
			GetAccessibleProducts getProductIds = new GetAccessibleProducts();
			bc.executeMethod(getProductIds);
			Integer[] productIds = getProductIds.getIds();
			serviceProviderInfos = new ServiceProviderInfo [productIds.length];
			ServiceProviderInfo serviceProviderInfo;
			int index = 0;
	        for (Integer p : productIds) {
	        	serviceProviderInfo = new ServiceProviderInfo();
	        	//Check the original Lyo labs to see how one can extract the product name here.
	        	serviceProviderInfo.name = "Some Name";
	        	serviceProviderInfo.serviceProviderId = Integer.toString(p);
	        	serviceProviderInfos[index] = serviceProviderInfo; 
	        	index++;
	        }
		} catch (Exception e) {
			e.printStackTrace();
			throw new WebApplicationException(e,Status.INTERNAL_SERVER_ERROR);
		}
		// End of user code
		return serviceProviderInfos;
    }

    public static BugzillaChangeRequest getBugzillaChangeRequest(HttpServletRequest httpServletRequest, String bugzillaChangeRequestId, String serviceProviderId)
    {
		BugzillaChangeRequest aBugzillaChangeRequest = null;
		// Start of user code (MUST_FILL_IN) getResource userCode
		try {
	        final Bug bug = BugzillaAdaptorManager.getBugById(httpServletRequest, bugzillaChangeRequestId);
	        if (bug != null) {
	        	aBugzillaChangeRequest = BugzillaAdaptorManager.fromBug(bug, httpServletRequest, serviceProviderId);
	        }
		} catch (Exception e) {
			e.printStackTrace();
			throw new WebApplicationException(e,Status.INTERNAL_SERVER_ERROR);
		}
		// End of user code
		return aBugzillaChangeRequest;
    }

    public static List<BugzillaChangeRequest> getBugzillaChangeRequests(HttpServletRequest httpServletRequest, String serviceProviderId, int page, int limit)
    {
		List<BugzillaChangeRequest> bugzillaChangeRequests = null;
		// Start of user code (MUST_FILL_IN) getResources userCode
		try {
	        List<Bug> bugList = BugzillaAdaptorManager.getBugsByProduct(httpServletRequest, serviceProviderId, page, limit);      
	        bugzillaChangeRequests = BugzillaAdaptorManager.changeRequestsFromBugList(httpServletRequest, bugList, serviceProviderId);		
		} catch (Exception e) {
			e.printStackTrace();
			throw new WebApplicationException(e,Status.INTERNAL_SERVER_ERROR);
		}
		// End of user code
		return bugzillaChangeRequests;
    }

    public static List<BugzillaChangeRequest> searchBugzillaChangeRequests(HttpServletRequest httpServletRequest, String serviceProviderId, String terms)
    {
		List<BugzillaChangeRequest> bugzillaChangeRequests = null;
		// Start of user code (MUST_FILL_IN) searchResources userCode
			try {
				final BugzillaConnector bc = BugzillaAdaptorManager.getBugzillaConnector(httpServletRequest);
				BugSearch bugSearch = createBugSearch(terms);
				bc.executeMethod(bugSearch);
				List<Bug> bugList = bugSearch.getSearchResults();
				bugzillaChangeRequests = changeRequestsFromBugList(httpServletRequest, bugList, serviceProviderId);
	
			} catch (Exception e) {
				throw new WebApplicationException(e);
			}
		// End of user code
		return bugzillaChangeRequests;
    }

    public static BugzillaChangeRequest createBugzillaChangeRequest(HttpServletRequest httpServletRequest, final BugzillaChangeRequest aBugzillaChangeRequest, final String serviceProviderId)
    {
		BugzillaChangeRequest newBugzillaChangeRequest = null;
		// Start of user code (MUST_FILL_IN) createResource userCode
		//[comment TODO: We should actually enter ALL properties that the user set :-) and not just the 6 below!!!! /]
		String newBugId = null;
		try {
			final BugzillaConnector bc = BugzillaAdaptorManager.getBugzillaConnector(httpServletRequest);
			GetProduct getProducts = new GetProduct(Integer.parseInt(serviceProviderId));
			bc.executeMethod(getProducts);
			final Product product = getProducts.getProduct();

			String summary = aBugzillaChangeRequest.getTitle();
			String component = aBugzillaChangeRequest.getComponent();
			String version = aBugzillaChangeRequest.getVersion();
			String operatingSystem = aBugzillaChangeRequest.getOperatingSystem();
			String platform = aBugzillaChangeRequest.getPlatform();
			String description = aBugzillaChangeRequest.getDescription();

			BugFactory factory = new BugFactory().newBug().setProduct(product.getName());
			
			if (summary != null) {
				factory.setSummary(summary);
			}
			if (version != null) {
				factory.setVersion(version);
			}
			if (component != null) {
				factory.setComponent(component);
			}
			if (platform != null) {
				factory.setPlatform(platform);
			} else
				factory.setPlatform("Other");

			if (operatingSystem != null) {
				factory.setOperatingSystem(operatingSystem);
			} else
				factory.setOperatingSystem("Other");

			if (description != null) {
				factory.setDescription(description);
			}

			Bug bug = factory.createBug();
			ReportBug reportBug = new ReportBug(bug);
			bc.executeMethod(reportBug);
			newBugId = Integer.toString(reportBug.getID());
    		final Bug newBug = BugzillaAdaptorManager.getBugById(httpServletRequest, newBugId);
    		newBugzillaChangeRequest = BugzillaAdaptorManager.fromBug(newBug, httpServletRequest, serviceProviderId);

		} catch (Exception e) {
			e.printStackTrace();
			throw new WebApplicationException(e);
		}
		// End of user code
		return newBugzillaChangeRequest;
    }

}

