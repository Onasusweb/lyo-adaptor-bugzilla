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

package se.kth.md.it.bcm.resources;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.Iterator;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.eclipse.lyo.oslc4j.core.annotation.OslcAllowedValue;
import org.eclipse.lyo.oslc4j.core.annotation.OslcDescription;
import org.eclipse.lyo.oslc4j.core.annotation.OslcName;
import org.eclipse.lyo.oslc4j.core.annotation.OslcNamespace;
import org.eclipse.lyo.oslc4j.core.annotation.OslcOccurs;
import org.eclipse.lyo.oslc4j.core.annotation.OslcPropertyDefinition;
import org.eclipse.lyo.oslc4j.core.annotation.OslcRange;
import org.eclipse.lyo.oslc4j.core.annotation.OslcReadOnly;
import org.eclipse.lyo.oslc4j.core.annotation.OslcRepresentation;
import org.eclipse.lyo.oslc4j.core.annotation.OslcResourceShape;
import org.eclipse.lyo.oslc4j.core.annotation.OslcTitle;
import org.eclipse.lyo.oslc4j.core.annotation.OslcValueType;
import org.eclipse.lyo.oslc4j.core.model.AbstractResource;
import org.eclipse.lyo.oslc4j.core.model.Link;
import org.eclipse.lyo.oslc4j.core.model.Occurs;
import org.eclipse.lyo.oslc4j.core.model.OslcConstants;
import org.eclipse.lyo.oslc4j.core.model.Representation;
import org.eclipse.lyo.oslc4j.core.model.ValueType;

import se.kth.md.it.bcm.servlet.ServletListener; 
import se.kth.md.it.bcm.BugzillaAdaptorConstants;
import se.kth.md.it.bcm.resources.Type;	
import se.kth.md.it.bcm.resources.Person;	
import se.kth.md.it.bcm.resources.Person;	

// Start of user code imports
import se.kth.md.it.bcm.BugzillaAdaptorManager;

import org.eclipse.lyo.oslc4j.bugzilla.jbugzx.rpc.GetLegalValues;

import com.j2bugzilla.base.BugzillaConnector;
import javax.ws.rs.WebApplicationException;
// End of user code

@OslcNamespace(BugzillaAdaptorConstants.BUGZILLA_NAMSPACE)
@OslcName(BugzillaAdaptorConstants.BUGZILLACHANGEREQUEST) 
@OslcResourceShape(title = "BugzillaChangeRequest Resource Shape", describes = BugzillaAdaptorConstants.TYPE_BUGZILLACHANGEREQUEST)
public class BugzillaChangeRequest
       extends ChangeRequest
       
{

private String product;  
private String component;  
private String version;  
private String priority;  
private String platform;  
private String operatingSystem;  

public BugzillaChangeRequest()
       throws URISyntaxException
{
    super();

	// Start of user code constructor1
	// End of user code
}

public BugzillaChangeRequest(final URI about)
       throws URISyntaxException
{
    super(about);

	// Start of user code constructor2
	// End of user code
}

public static URI constructURI(String serviceProviderId, String bugzillaChangeRequestId) throws URISyntaxException, UnsupportedEncodingException
{
	return new URI(ServletListener.getServicesBase() + "/" + serviceProviderId + "/bugzillaChangeRequests/"+ bugzillaChangeRequestId);
}

public String toString()
{
		String result = "";
		// Start of user code toString_init
		// End of user code

		result = getAbout().toString();

		// Start of user code toString_finalize
		result = getIdentifier() + ":" + getTitle();
		// End of user code

		return result;
}

public String toHtml()
{
		String result = "";
		// Start of user code toHtml_init
		// End of user code

		result = "<a href=\"" + getAbout() + "\">" + toString() + "</a>";

		// Start of user code toHtml_finalize
		// End of user code

		return result;
}



   	@OslcName("product")
   	@OslcPropertyDefinition(BugzillaAdaptorConstants.BUGZILLA_NAMSPACE + "product")
	@OslcDescription("")
	@OslcOccurs(Occurs.ExactlyOne)
	@OslcValueType(ValueType.String)
	
	
	@OslcReadOnly(false)
	
    public String getProduct()
    {
        return product;
    }

   	@OslcName("component")
   	@OslcPropertyDefinition(BugzillaAdaptorConstants.BUGZILLA_NAMSPACE + "component")
	@OslcDescription("The Bugzilla product definition for this change request.")
	@OslcOccurs(Occurs.ZeroOrOne)
	@OslcValueType(ValueType.String)
	
	
	@OslcReadOnly(false)
	@OslcTitle("Component")
    public String getComponent()
    {
        return component;
    }

   	@OslcName("version")
   	@OslcPropertyDefinition(BugzillaAdaptorConstants.BUGZILLA_NAMSPACE + "version")
	@OslcDescription("The Bugzilla version for this change request.")
	@OslcOccurs(Occurs.ZeroOrOne)
	@OslcValueType(ValueType.String)
	
	
	@OslcReadOnly(true)
	@OslcTitle("Version")
    public String getVersion()
    {
        return version;
    }

   	@OslcName("priority")
   	@OslcPropertyDefinition(BugzillaAdaptorConstants.BUGZILLA_NAMSPACE + "priority")
	@OslcDescription("The Bugzilla priority for this change request.")
	@OslcOccurs(Occurs.ZeroOrOne)
	@OslcValueType(ValueType.String)
	
	
	@OslcReadOnly(false)
	@OslcTitle("Priority")
    public String getPriority()
    {
        return priority;
    }

   	@OslcName("platform")
   	@OslcPropertyDefinition(BugzillaAdaptorConstants.BUGZILLA_NAMSPACE + "platform")
	@OslcDescription("The Bugzilla platform for this change request.")
	@OslcOccurs(Occurs.ZeroOrOne)
	@OslcValueType(ValueType.String)
	
	
	@OslcReadOnly(false)
	@OslcTitle("Platform")
    public String getPlatform()
    {
        return platform;
    }

   	@OslcName("operatingSystem")
   	@OslcPropertyDefinition(BugzillaAdaptorConstants.BUGZILLA_NAMSPACE + "operatingSystem")
	@OslcDescription("The Bugzilla operating system for this change request.")
	@OslcOccurs(Occurs.ZeroOrOne)
	@OslcValueType(ValueType.String)
	
	
	@OslcReadOnly(false)
	@OslcTitle("Operating System")
    public String getOperatingSystem()
    {
        return operatingSystem;
    }


    public void setProduct(final String product )
    {
        this.product = product;
    }
    public void setComponent(final String component )
    {
        this.component = component;
    }
    public void setVersion(final String version )
    {
        this.version = version;
    }
    public void setPriority(final String priority )
    {
        this.priority = priority;
    }
    public void setPlatform(final String platform )
    {
        this.platform = platform;
    }
    public void setOperatingSystem(final String operatingSystem )
    {
        this.operatingSystem = operatingSystem;
    }

    static public String productToHtmlForCreation (final HttpServletRequest httpServletRequest, final String serviceProviderId)
    {
		String s = "";

		// Start of user code productasHtmlForCreation_init
		// End of user code

		s = s + "<label for=\"product\">product: </LABEL>";

		// Start of user code productasHtmlForCreation_mid
		// End of user code

				s= s + "<input name=\"product\" type=\"text\" style=\"width: 400px\" id=\"product\" >";

		// Start of user code productasHtmlForCreation_finalize
		// End of user code

		return s; 
    }
    static public String componentToHtmlForCreation (final HttpServletRequest httpServletRequest, final String serviceProviderId)
    {
		String s = "";

		// Start of user code componentasHtmlForCreation_init
		// End of user code

		s = s + "<label for=\"component\">component: </LABEL>";

		// Start of user code componentasHtmlForCreation_mid
		String label = s;
		// End of user code

				s= s + "<input name=\"component\" type=\"text\" style=\"width: 400px\" id=\"component\" >";

		// Start of user code componentasHtmlForCreation_finalize
		s = label;
		try {
					BugzillaConnector bc = BugzillaAdaptorManager.getBugzillaConnector(httpServletRequest);
					GetLegalValues getValues = new GetLegalValues("component", Integer.parseInt(serviceProviderId));
					bc.executeMethod(getValues);
					List<String> values = Arrays.asList(getValues.getValues());
					s = s + "<select name=\"component\">";
					for (String v : values) {
						s = s + "<option value=\"" + v + "\">" + v + "</option>";
					}
					s = s + "</select>";
			} catch (Exception e) {
				throw new WebApplicationException(e);
			}
		// End of user code

		return s; 
    }
    static public String versionToHtmlForCreation (final HttpServletRequest httpServletRequest, final String serviceProviderId)
    {
		String s = "";

		// Start of user code versionasHtmlForCreation_init
		// End of user code

		s = s + "<label for=\"version\">version: </LABEL>";

		// Start of user code versionasHtmlForCreation_mid
		String label = s;
		// End of user code

				s= s + "<input name=\"version\" type=\"text\" style=\"width: 400px\" id=\"version\" >";

		// Start of user code versionasHtmlForCreation_finalize
		s = label;
		try {
					BugzillaConnector bc = BugzillaAdaptorManager.getBugzillaConnector(httpServletRequest);
					
					GetLegalValues getValues = new GetLegalValues("version", Integer.parseInt(serviceProviderId));
					bc.executeMethod(getValues);
					List<String> values = Arrays.asList(getValues.getValues());
					s = s + "<select name=\"version\">";
					for (String v : values) {
						s = s + "<option value=\"" + v + "\">" + v + "</option>";
					}
					s = s + "</select>";
			} catch (Exception e) {
				throw new WebApplicationException(e);
			}
		// End of user code

		return s; 
    }
    static public String priorityToHtmlForCreation (final HttpServletRequest httpServletRequest, final String serviceProviderId)
    {
		String s = "";

		// Start of user code priorityasHtmlForCreation_init
		// End of user code

		s = s + "<label for=\"priority\">priority: </LABEL>";

		// Start of user code priorityasHtmlForCreation_mid
		// End of user code

				s= s + "<input name=\"priority\" type=\"text\" style=\"width: 400px\" id=\"priority\" >";

		// Start of user code priorityasHtmlForCreation_finalize
		// End of user code

		return s; 
    }
    static public String platformToHtmlForCreation (final HttpServletRequest httpServletRequest, final String serviceProviderId)
    {
		String s = "";

		// Start of user code platformasHtmlForCreation_init
		// End of user code

		s = s + "<label for=\"platform\">platform: </LABEL>";

		// Start of user code platformasHtmlForCreation_mid
		String label = s;
		// End of user code

				s= s + "<input name=\"platform\" type=\"text\" style=\"width: 400px\" id=\"platform\" >";

		// Start of user code platformasHtmlForCreation_finalize
		s = label;
		try {
					BugzillaConnector bc = BugzillaAdaptorManager.getBugzillaConnector(httpServletRequest);
					GetLegalValues getValues = new GetLegalValues("platform", -1);
					bc.executeMethod(getValues);
					List<String> values = Arrays.asList(getValues.getValues());
					s = s + "<select name=\"platform\">";
					for (String v : values) {
						s = s + "<option value=\"" + v + "\">" + v + "</option>";
					}
					s = s + "</select>";
			} catch (Exception e) {
				throw new WebApplicationException(e);
			}
		// End of user code

		return s; 
    }
    static public String operatingSystemToHtmlForCreation (final HttpServletRequest httpServletRequest, final String serviceProviderId)
    {
		String s = "";

		// Start of user code operatingSystemasHtmlForCreation_init
		// End of user code

		s = s + "<label for=\"operatingSystem\">operatingSystem: </LABEL>";

		// Start of user code operatingSystemasHtmlForCreation_mid
		String label = s;
		// End of user code

				s= s + "<input name=\"operatingSystem\" type=\"text\" style=\"width: 400px\" id=\"operatingSystem\" >";

		// Start of user code operatingSystemasHtmlForCreation_finalize
		s = label;
		try {
					BugzillaConnector bc = BugzillaAdaptorManager.getBugzillaConnector(httpServletRequest);
					GetLegalValues getValues = new GetLegalValues("op_sys", -1);
					bc.executeMethod(getValues);
					List<String> values = Arrays.asList(getValues.getValues());
					s = s + "<select name=\"operatingSystem\">";
					for (String v : values) {
						s = s + "<option value=\"" + v + "\">" + v + "</option>";
					}
					s = s + "</select>";
			} catch (Exception e) {
				throw new WebApplicationException(e);
			}
		// End of user code

		return s; 
    }

    public String productToHtml()
    {
		String s = "";

		// Start of user code producttoHtml_init
		// End of user code

		s = s + "<label for=\"product\"><strong>product</strong>: </LABEL>";

		// Start of user code producttoHtml_mid
		// End of user code

		try {
				if (product == null) {
					s= s + "<em>null</em>";				
				}
				else {
					s= s + product.toString();				
				}
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

		// Start of user code producttoHtml_finalize
		// End of user code

		return s; 
    }
    public String componentToHtml()
    {
		String s = "";

		// Start of user code componenttoHtml_init
		// End of user code

		s = s + "<label for=\"component\"><strong>component</strong>: </LABEL>";

		// Start of user code componenttoHtml_mid
		// End of user code

		try {
				if (component == null) {
					s= s + "<em>null</em>";				
				}
				else {
					s= s + component.toString();				
				}
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

		// Start of user code componenttoHtml_finalize
		// End of user code

		return s; 
    }
    public String versionToHtml()
    {
		String s = "";

		// Start of user code versiontoHtml_init
		// End of user code

		s = s + "<label for=\"version\"><strong>version</strong>: </LABEL>";

		// Start of user code versiontoHtml_mid
		// End of user code

		try {
				if (version == null) {
					s= s + "<em>null</em>";				
				}
				else {
					s= s + version.toString();				
				}
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

		// Start of user code versiontoHtml_finalize
		// End of user code

		return s; 
    }
    public String priorityToHtml()
    {
		String s = "";

		// Start of user code prioritytoHtml_init
		// End of user code

		s = s + "<label for=\"priority\"><strong>priority</strong>: </LABEL>";

		// Start of user code prioritytoHtml_mid
		// End of user code

		try {
				if (priority == null) {
					s= s + "<em>null</em>";				
				}
				else {
					s= s + priority.toString();				
				}
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

		// Start of user code prioritytoHtml_finalize
		// End of user code

		return s; 
    }
    public String platformToHtml()
    {
		String s = "";

		// Start of user code platformtoHtml_init
		// End of user code

		s = s + "<label for=\"platform\"><strong>platform</strong>: </LABEL>";

		// Start of user code platformtoHtml_mid
		// End of user code

		try {
				if (platform == null) {
					s= s + "<em>null</em>";				
				}
				else {
					s= s + platform.toString();				
				}
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

		// Start of user code platformtoHtml_finalize
		// End of user code

		return s; 
    }
    public String operatingSystemToHtml()
    {
		String s = "";

		// Start of user code operatingSystemtoHtml_init
		// End of user code

		s = s + "<label for=\"operatingSystem\"><strong>operatingSystem</strong>: </LABEL>";

		// Start of user code operatingSystemtoHtml_mid
		// End of user code

		try {
				if (operatingSystem == null) {
					s= s + "<em>null</em>";				
				}
				else {
					s= s + operatingSystem.toString();				
				}
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

		// Start of user code operatingSystemtoHtml_finalize
		// End of user code

		return s; 
    }

}

