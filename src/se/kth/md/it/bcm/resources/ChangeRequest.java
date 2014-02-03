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
import se.kth.md.it.bcm.resources.Person;	
import se.kth.md.it.bcm.resources.Person;	
import se.kth.md.it.bcm.resources.Type;	

// Start of user code imports
// End of user code

@OslcNamespace(BugzillaAdaptorConstants.CHANGE_MANAGEMENT_NAMSPACE)
@OslcName(BugzillaAdaptorConstants.CHANGEREQUEST) 
@OslcResourceShape(title = "ChangeRequest Resource Shape", describes = BugzillaAdaptorConstants.TYPE_CHANGEREQUEST)
public class ChangeRequest
       extends AbstractResource
       
{

private HashSet<Link> affectedByDefects = new HashSet<Link>();  
private HashSet<Link> affectsPlanItems = new HashSet<Link>();  
private HashSet<Link> affectsRequirements = new HashSet<Link>();  
private HashSet<Link> affectsTestResults = new HashSet<Link>();  
private HashSet<Link> blocksTestExecutionRecords = new HashSet<Link>();  
private HashSet<Person> contributors = new HashSet<Person>();  
private HashSet<Person> creators = new HashSet<Person>();  
private HashSet<Type> dctermsTypes = new HashSet<Type>();  
private HashSet<Link> implementsRequirements = new HashSet<Link>();  
private HashSet<Link> relatedChangeRequests = new HashSet<Link>();  
private HashSet<Link> relatedTestCases = new HashSet<Link>();  
private HashSet<Link> relatedTestExecutionRecords = new HashSet<Link>();  
private HashSet<Link> relatedTestPlans = new HashSet<Link>();  
private HashSet<Link> relatedTestScripts = new HashSet<Link>();  
private HashSet<String> subjects = new HashSet<String>();  
private HashSet<Link> testedByTestCases = new HashSet<Link>();  
private HashSet<Link> tracksChangeSets = new HashSet<Link>();  
private HashSet<Link> tracksRequirements = new HashSet<Link>();  
private HashSet<URI> rdfTypes = new HashSet<URI>();  
private Boolean approved;  
private Boolean closed;  
private Date closeDate;  
private Date created;  
private String description;  
private Link discussedBy = new Link();  
private Boolean fixed;  
private String identifier;  
private Boolean inprogress;  
private Link instanceShape = new Link();  
private Date modified;  
private Boolean reviewed;  
private URI serviceProvider;  
private String shortTitle;  
private String status;  
private String title;  
private Boolean verified;  

public ChangeRequest()
       throws URISyntaxException
{
    super();

	// Start of user code constructor1
	// End of user code
}

public ChangeRequest(final URI about)
       throws URISyntaxException
{
    super(about);

	// Start of user code constructor2
	// End of user code
}

public static URI constructURI(String serviceProviderId, String changeRequestId) throws URISyntaxException, UnsupportedEncodingException
{
	return new URI(ServletListener.getServicesBase() + "/" + serviceProviderId + "/changeRequests/"+ changeRequestId);
}

public String toString()
{
		String result = "";
		// Start of user code toString_init
		// End of user code

		result = getAbout().toString();

		// Start of user code toString_finalize
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


    public void addAffectedByDefect(final Link affectedByDefect )
    {
        this.affectedByDefects.add(affectedByDefect);
    }
    public void addAffectsPlanItem(final Link affectsPlanItem )
    {
        this.affectsPlanItems.add(affectsPlanItem);
    }
    public void addAffectsRequirement(final Link affectsRequirement )
    {
        this.affectsRequirements.add(affectsRequirement);
    }
    public void addAffectsTestResult(final Link affectsTestResult )
    {
        this.affectsTestResults.add(affectsTestResult);
    }
    public void addBlocksTestExecutionRecord(final Link blocksTestExecutionRecord )
    {
        this.blocksTestExecutionRecords.add(blocksTestExecutionRecord);
    }
    public void addContributor(final Person contributor )
    {
        this.contributors.add(contributor);
    }
    public void addCreator(final Person creator )
    {
        this.creators.add(creator);
    }
    public void addType(final Type type )
    {
        this.dctermsTypes.add(type);
    }
    public void addImplementsRequirement(final Link implementsRequirement )
    {
        this.implementsRequirements.add(implementsRequirement);
    }
    public void addRelatedChangeRequest(final Link relatedChangeRequest )
    {
        this.relatedChangeRequests.add(relatedChangeRequest);
    }
    public void addRelatedTestCase(final Link relatedTestCase )
    {
        this.relatedTestCases.add(relatedTestCase);
    }
    public void addRelatedTestExecutionRecord(final Link relatedTestExecutionRecord )
    {
        this.relatedTestExecutionRecords.add(relatedTestExecutionRecord);
    }
    public void addRelatedTestPlan(final Link relatedTestPlan )
    {
        this.relatedTestPlans.add(relatedTestPlan);
    }
    public void addRelatedTestScript(final Link relatedTestScript )
    {
        this.relatedTestScripts.add(relatedTestScript);
    }
    public void addSubject(final String subject )
    {
        this.subjects.add(subject);
    }
    public void addTestedByTestCase(final Link testedByTestCase )
    {
        this.testedByTestCases.add(testedByTestCase);
    }
    public void addTracksChangeSet(final Link tracksChangeSet )
    {
        this.tracksChangeSets.add(tracksChangeSet);
    }
    public void addTracksRequirement(final Link tracksRequirement )
    {
        this.tracksRequirements.add(tracksRequirement);
    }
    public void addType(final URI type )
    {
        this.rdfTypes.add(type);
    }

   	@OslcName("affectedByDefect")
   	@OslcPropertyDefinition(BugzillaAdaptorConstants.CHANGE_MANAGEMENT_NAMSPACE + "affectedByDefect")
	@OslcDescription("Change request is affected by a reported defect. It is likely that the target resource will be an oslc_cm:ChangeRequest but that is not necessarily the case.")
	@OslcOccurs(Occurs.ZeroOrMany)
	@OslcValueType(ValueType.Resource)
	
	
	@OslcReadOnly(false)
	@OslcTitle("")
    public HashSet<Link> getAffectedByDefects()
    {
        return affectedByDefects;
    }

   	@OslcName("affectsPlanItem")
   	@OslcPropertyDefinition(BugzillaAdaptorConstants.CHANGE_MANAGEMENT_NAMSPACE + "affectsPlanItem")
	@OslcDescription("Change request affects a plan item. It is likely that the target resource will be an oslc_cm:ChangeRequest but that is not necessarily the case.")
	@OslcOccurs(Occurs.ZeroOrMany)
	@OslcValueType(ValueType.Resource)
	
	
	@OslcReadOnly(false)
	@OslcTitle("")
    public HashSet<Link> getAffectsPlanItems()
    {
        return affectsPlanItems;
    }

   	@OslcName("affectsRequirement")
   	@OslcPropertyDefinition(BugzillaAdaptorConstants.CHANGE_MANAGEMENT_NAMSPACE + "affectsRequirement")
	@OslcDescription("Change request affecting a Requirement. It is likely that the target resource will be an oslc_rm:Requirement but that is not necessarily the case.")
	@OslcOccurs(Occurs.ZeroOrMany)
	@OslcValueType(ValueType.Resource)
	
	
	@OslcReadOnly(false)
	@OslcTitle("")
    public HashSet<Link> getAffectsRequirements()
    {
        return affectsRequirements;
    }

   	@OslcName("affectsTestResult")
   	@OslcPropertyDefinition(BugzillaAdaptorConstants.CHANGE_MANAGEMENT_NAMSPACE + "affectsTestResult")
	@OslcDescription("Associated QM resource that is affected by this Change Request. It is likely that the target resource will be an oslc_qm:TestResult but that is not necessarily the case.")
	@OslcOccurs(Occurs.ZeroOrMany)
	@OslcValueType(ValueType.Resource)
	
	
	@OslcReadOnly(false)
	@OslcTitle("")
    public HashSet<Link> getAffectsTestResults()
    {
        return affectsTestResults;
    }

   	@OslcName("blocksTestExecutionRecord")
   	@OslcPropertyDefinition(BugzillaAdaptorConstants.CHANGE_MANAGEMENT_NAMSPACE + "blocksTestExecutionRecord")
	@OslcDescription("Associated QM resource that is blocked by this Change Request. It is likely that the target resource will be an oslc_qm:TestExecutionRecord but that is not necessarily the case.")
	@OslcOccurs(Occurs.ZeroOrMany)
	@OslcValueType(ValueType.Resource)
	
	
	@OslcReadOnly(false)
	@OslcTitle("")
    public HashSet<Link> getBlocksTestExecutionRecords()
    {
        return blocksTestExecutionRecords;
    }

   	@OslcName("contributor")
   	@OslcPropertyDefinition(BugzillaAdaptorConstants.DUBLIN_CORE_NAMSPACE + "contributor")
	@OslcDescription("The person(s) who are responsible for the work needed to complete the change request (reference: Dublin Core). It is likely that the target resource will be a foaf:Person but that is not necessarily the case.")
	@OslcOccurs(Occurs.ZeroOrMany)
	@OslcValueType(ValueType.LocalResource)
	
	@OslcRange(BugzillaAdaptorConstants.TYPE_PERSON)
	@OslcReadOnly(false)
	@OslcTitle("")
    public HashSet<Person> getContributors()
    {
        return contributors;
    }

   	@OslcName("creator")
   	@OslcPropertyDefinition(BugzillaAdaptorConstants.DUBLIN_CORE_NAMSPACE + "creator")
	@OslcDescription("Creator or creators of resource (reference: Dublin Core). It is likely that the target resource will be a foaf:Person but that is not necessarily the case.")
	@OslcOccurs(Occurs.ZeroOrMany)
	@OslcValueType(ValueType.LocalResource)
	
	@OslcRange(BugzillaAdaptorConstants.TYPE_PERSON)
	@OslcReadOnly(false)
	@OslcTitle("")
    public HashSet<Person> getCreators()
    {
        return creators;
    }

   	@OslcName("type")
   	@OslcPropertyDefinition(BugzillaAdaptorConstants.DUBLIN_CORE_NAMSPACE + "type")
	@OslcDescription("A short string representation for the type, example 'Defect'.")
	@OslcOccurs(Occurs.ZeroOrMany)
	@OslcValueType(ValueType.LocalResource)
	
	@OslcRange(BugzillaAdaptorConstants.TYPE_TYPE)
	@OslcReadOnly(false)
	@OslcTitle("")
    public HashSet<Type> getDctermsTypes()
    {
        return dctermsTypes;
    }

   	@OslcName("implementsRequirement")
   	@OslcPropertyDefinition(BugzillaAdaptorConstants.CHANGE_MANAGEMENT_NAMSPACE + "implementsRequirement")
	@OslcDescription("Implements associated Requirement. It is likely that the target resource will be an oslc_rm:Requirement but that is not necessarily the case.")
	@OslcOccurs(Occurs.ZeroOrMany)
	@OslcValueType(ValueType.Resource)
	
	
	@OslcReadOnly(false)
	@OslcTitle("")
    public HashSet<Link> getImplementsRequirements()
    {
        return implementsRequirements;
    }

   	@OslcName("relatedChangeRequest")
   	@OslcPropertyDefinition(BugzillaAdaptorConstants.CHANGE_MANAGEMENT_NAMSPACE + "relatedChangeRequest")
	@OslcDescription("This relationship is loosely coupled and has no specific meaning. It is likely that the target resource will be an oslc_cm:ChangeRequest but that is not necessarily the case.")
	@OslcOccurs(Occurs.ZeroOrMany)
	@OslcValueType(ValueType.Resource)
	
	
	@OslcReadOnly(false)
	@OslcTitle("")
    public HashSet<Link> getRelatedChangeRequests()
    {
        return relatedChangeRequests;
    }

   	@OslcName("relatedTestCase")
   	@OslcPropertyDefinition(BugzillaAdaptorConstants.CHANGE_MANAGEMENT_NAMSPACE + "relatedTestCase")
	@OslcDescription("Related QM test case resource. It is likely that the target resource will be an oslc_qm:TestCase but that is not necessarily the case.")
	@OslcOccurs(Occurs.ZeroOrMany)
	@OslcValueType(ValueType.Resource)
	
	
	@OslcReadOnly(false)
	@OslcTitle("")
    public HashSet<Link> getRelatedTestCases()
    {
        return relatedTestCases;
    }

   	@OslcName("relatedTestExecutionRecord")
   	@OslcPropertyDefinition(BugzillaAdaptorConstants.CHANGE_MANAGEMENT_NAMSPACE + "relatedTestExecutionRecord")
	@OslcDescription("Related to a QM test execution resource. It is likely that the target resource will be an oslc_qm:TestExecutionRecord but that is not necessarily the case.")
	@OslcOccurs(Occurs.ZeroOrMany)
	@OslcValueType(ValueType.Resource)
	
	
	@OslcReadOnly(false)
	@OslcTitle("")
    public HashSet<Link> getRelatedTestExecutionRecords()
    {
        return relatedTestExecutionRecords;
    }

   	@OslcName("relatedTestPlan")
   	@OslcPropertyDefinition(BugzillaAdaptorConstants.CHANGE_MANAGEMENT_NAMSPACE + "relatedTestPlan")
	@OslcDescription("Related QM test plan resource. It is likely that the target resource will be an oslc_qm:TestPlan but that is not necessarily the case.")
	@OslcOccurs(Occurs.ZeroOrMany)
	@OslcValueType(ValueType.Resource)
	
	
	@OslcReadOnly(false)
	@OslcTitle("")
    public HashSet<Link> getRelatedTestPlans()
    {
        return relatedTestPlans;
    }

   	@OslcName("relatedTestScript")
   	@OslcPropertyDefinition(BugzillaAdaptorConstants.CHANGE_MANAGEMENT_NAMSPACE + "relatedTestScript")
	@OslcDescription("Related QM test script resource. It is likely that the target resource will be an oslc_qm:TestScript but that is not necessarily the case.")
	@OslcOccurs(Occurs.ZeroOrMany)
	@OslcValueType(ValueType.Resource)
	
	
	@OslcReadOnly(false)
	@OslcTitle("")
    public HashSet<Link> getRelatedTestScripts()
    {
        return relatedTestScripts;
    }

   	@OslcName("subject")
   	@OslcPropertyDefinition(BugzillaAdaptorConstants.DUBLIN_CORE_NAMSPACE + "subject")
	@OslcDescription("Tag or keyword for a resource. Each occurrence of a dcterms:subject property denotes an additional tag for the resource.")
	@OslcOccurs(Occurs.ZeroOrMany)
	@OslcValueType(ValueType.String)
	
	
	@OslcReadOnly(false)
	@OslcTitle("")
    public HashSet<String> getSubjects()
    {
        return subjects;
    }

   	@OslcName("testedByTestCase")
   	@OslcPropertyDefinition(BugzillaAdaptorConstants.CHANGE_MANAGEMENT_NAMSPACE + "testedByTestCase")
	@OslcDescription("Test case by which this change request is tested. It is likely that the target resource will be an oslc_qm:TestCase but that is not necessarily the case.")
	@OslcOccurs(Occurs.ZeroOrMany)
	@OslcValueType(ValueType.Resource)
	
	
	@OslcReadOnly(false)
	@OslcTitle("")
    public HashSet<Link> getTestedByTestCases()
    {
        return testedByTestCases;
    }

   	@OslcName("tracksChangeSet")
   	@OslcPropertyDefinition(BugzillaAdaptorConstants.CHANGE_MANAGEMENT_NAMSPACE + "tracksChangeSet")
	@OslcDescription("Tracks SCM change set resource. It is likely that the target resource will be an oslc_scm:ChangeSet but that is not necessarily the case.")
	@OslcOccurs(Occurs.ZeroOrMany)
	@OslcValueType(ValueType.Resource)
	
	
	@OslcReadOnly(false)
	@OslcTitle("")
    public HashSet<Link> getTracksChangeSets()
    {
        return tracksChangeSets;
    }

   	@OslcName("tracksRequirement")
   	@OslcPropertyDefinition(BugzillaAdaptorConstants.CHANGE_MANAGEMENT_NAMSPACE + "tracksRequirement")
	@OslcDescription("Tracks the associated Requirement or Requirement ChangeSet resources. It is likely that the target resource will be an oslc_rm:Requirement but that is not necessarily the case.")
	@OslcOccurs(Occurs.ZeroOrMany)
	@OslcValueType(ValueType.Resource)
	
	
	@OslcReadOnly(false)
	@OslcTitle("")
    public HashSet<Link> getTracksRequirements()
    {
        return tracksRequirements;
    }

   	@OslcName("type")
   	@OslcPropertyDefinition(BugzillaAdaptorConstants.RDF_NAMSPACE + "type")
	@OslcDescription("The resource type URIs. One of at least has the value of http://open-services.net/ns/cm#ChangeRequest")
	@OslcOccurs(Occurs.ZeroOrMany)
	
	
	
	@OslcReadOnly(false)
	@OslcTitle("")
    public HashSet<URI> getRdfTypes()
    {
        return rdfTypes;
    }

   	@OslcName("approved")
   	@OslcPropertyDefinition(BugzillaAdaptorConstants.CHANGE_MANAGEMENT_NAMSPACE + "approved")
	@OslcDescription("Whether or not the Change Request has been approved.")
	@OslcOccurs(Occurs.ZeroOrOne)
	@OslcValueType(ValueType.Boolean)
	
	
	@OslcReadOnly(true)
	@OslcTitle("")
    public Boolean isApproved()
    {
        return approved;
    }

   	@OslcName("closed")
   	@OslcPropertyDefinition(BugzillaAdaptorConstants.CHANGE_MANAGEMENT_NAMSPACE + "closed")
	@OslcDescription("Whether or not the Change Request is completely done, no further fixes or fix verification is needed.")
	@OslcOccurs(Occurs.ZeroOrOne)
	@OslcValueType(ValueType.Boolean)
	
	
	@OslcReadOnly(true)
	@OslcTitle("")
    public Boolean isClosed()
    {
        return closed;
    }

   	@OslcName("closeDate")
   	@OslcPropertyDefinition(BugzillaAdaptorConstants.CHANGE_MANAGEMENT_NAMSPACE + "closeDate")
	@OslcDescription("The date at which no further activity or work is intended to be conducted.")
	@OslcOccurs(Occurs.ZeroOrOne)
	@OslcValueType(ValueType.DateTime)
	
	
	@OslcReadOnly(true)
	@OslcTitle("")
    public Date getCloseDate()
    {
        return closeDate;
    }

   	@OslcName("created")
   	@OslcPropertyDefinition(BugzillaAdaptorConstants.DUBLIN_CORE_NAMSPACE + "created")
	@OslcDescription("Timestamp of resource creation (reference: Dublin Core).")
	@OslcOccurs(Occurs.ZeroOrOne)
	@OslcValueType(ValueType.DateTime)
	
	
	@OslcReadOnly(true)
	@OslcTitle("")
    public Date getCreated()
    {
        return created;
    }

   	@OslcName("description")
   	@OslcPropertyDefinition(BugzillaAdaptorConstants.DUBLIN_CORE_NAMSPACE + "description")
	@OslcDescription("Descriptive text (reference: Dublin Core) about resource represented as rich text in XHTML content. SHOULD include only content that is valid and suitable inside an XHTML _div_ element.")
	@OslcOccurs(Occurs.ZeroOrOne)
	@OslcValueType(ValueType.XMLLiteral)
	
	
	@OslcReadOnly(false)
	@OslcTitle("")
    public String getDescription()
    {
        return description;
    }

   	@OslcName("discussedBy")
   	@OslcPropertyDefinition(BugzillaAdaptorConstants.OSLC_CORE_NAMSPACE + "discussedBy")
	@OslcDescription("A series of notes and comments about this change request.")
	@OslcOccurs(Occurs.ZeroOrOne)
	@OslcValueType(ValueType.Resource)
	
	
	@OslcReadOnly(false)
	@OslcTitle("")
    public Link getDiscussedBy()
    {
        return discussedBy;
    }

   	@OslcName("fixed")
   	@OslcPropertyDefinition(BugzillaAdaptorConstants.CHANGE_MANAGEMENT_NAMSPACE + "fixed")
	@OslcDescription("Whether or not the Change Request has been fixed.")
	@OslcOccurs(Occurs.ZeroOrOne)
	@OslcValueType(ValueType.Boolean)
	
	
	@OslcReadOnly(true)
	@OslcTitle("")
    public Boolean isFixed()
    {
        return fixed;
    }

   	@OslcName("identifier")
   	@OslcPropertyDefinition(BugzillaAdaptorConstants.DUBLIN_CORE_NAMSPACE + "identifier")
	@OslcDescription("A unique identifier for a resource. Assigned by the service provider when a resource is created. Not intended for end-user display.")
	@OslcOccurs(Occurs.ExactlyOne)
	@OslcValueType(ValueType.String)
	
	
	@OslcReadOnly(true)
	@OslcTitle("")
    public String getIdentifier()
    {
        return identifier;
    }

   	@OslcName("inprogress")
   	@OslcPropertyDefinition(BugzillaAdaptorConstants.CHANGE_MANAGEMENT_NAMSPACE + "inprogress")
	@OslcDescription("Whether or not the Change Request in a state indicating that active work is occurring. If oslc_cm:inprogress is true, then oslc_cm:fixed and oslc_cm:closed must also be false")
	@OslcOccurs(Occurs.ZeroOrOne)
	@OslcValueType(ValueType.Boolean)
	
	
	@OslcReadOnly(true)
	@OslcTitle("")
    public Boolean isInprogress()
    {
        return inprogress;
    }

   	@OslcName("instanceShape")
   	@OslcPropertyDefinition(BugzillaAdaptorConstants.OSLC_CORE_NAMSPACE + "instanceShape")
	@OslcDescription("Resource Shape that provides hints as to resource property value-types and allowed values.")
	@OslcOccurs(Occurs.ZeroOrOne)
	@OslcValueType(ValueType.Resource)
	
	
	@OslcReadOnly(false)
	@OslcTitle("")
    public Link getInstanceShape()
    {
        return instanceShape;
    }

   	@OslcName("modified")
   	@OslcPropertyDefinition(BugzillaAdaptorConstants.DUBLIN_CORE_NAMSPACE + "modified")
	@OslcDescription("Timestamp last latest resource modification (reference: Dublin Core).")
	@OslcOccurs(Occurs.ZeroOrOne)
	@OslcValueType(ValueType.DateTime)
	
	
	@OslcReadOnly(true)
	@OslcTitle("")
    public Date getModified()
    {
        return modified;
    }

   	@OslcName("reviewed")
   	@OslcPropertyDefinition(BugzillaAdaptorConstants.CHANGE_MANAGEMENT_NAMSPACE + "reviewed")
	@OslcDescription("Whether or not the Change Request has been reviewed.")
	@OslcOccurs(Occurs.ZeroOrOne)
	@OslcValueType(ValueType.Boolean)
	
	
	@OslcReadOnly(true)
	@OslcTitle("")
    public Boolean isReviewed()
    {
        return reviewed;
    }

   	@OslcName("serviceProvider")
   	@OslcPropertyDefinition(BugzillaAdaptorConstants.OSLC_CORE_NAMSPACE + "serviceProvider")
	@OslcDescription("The scope of a resource is a URI for the resource's OSLC Service Provider.")
	@OslcOccurs(Occurs.ExactlyOne)
	
	
	
	@OslcReadOnly(false)
	@OslcTitle("")
    public URI getServiceProvider()
    {
        return serviceProvider;
    }

   	@OslcName("shortTitle")
   	@OslcPropertyDefinition(BugzillaAdaptorConstants.OSLC_CORE_NAMSPACE + "shortTitle")
	@OslcDescription("Short name identifying a resource, often used as an abbreviated identifier for presentation to end-users. SHOULD include only content that is valid inside an XHTML _span_ element.")
	@OslcOccurs(Occurs.ZeroOrOne)
	@OslcValueType(ValueType.XMLLiteral)
	
	
	@OslcReadOnly(false)
	@OslcTitle("")
    public String getShortTitle()
    {
        return shortTitle;
    }

   	@OslcName("status")
   	@OslcPropertyDefinition(BugzillaAdaptorConstants.CHANGE_MANAGEMENT_NAMSPACE + "status")
	@OslcDescription("Used to indicate the status of the change request based on values defined by the service provider. Most often a read-only property. Some possible values may include: 'Submitted', 'Done', 'InProgress', etc.")
	@OslcOccurs(Occurs.ZeroOrOne)
	@OslcValueType(ValueType.String)
	
	
	@OslcReadOnly(false)
	@OslcTitle("")
    public String getStatus()
    {
        return status;
    }

   	@OslcName("title")
   	@OslcPropertyDefinition(BugzillaAdaptorConstants.DUBLIN_CORE_NAMSPACE + "title")
	@OslcDescription("Title (reference: Dublin Core) or often a single line summary of the resource represented as rich text in XHTML content. SHOULD include only content that is valid and suitable inside an XHTML _div_ element.")
	@OslcOccurs(Occurs.ExactlyOne)
	@OslcValueType(ValueType.XMLLiteral)
	
	
	@OslcReadOnly(false)
	@OslcTitle("")
    public String getTitle()
    {
        return title;
    }

   	@OslcName("verified")
   	@OslcPropertyDefinition(BugzillaAdaptorConstants.CHANGE_MANAGEMENT_NAMSPACE + "verified")
	@OslcDescription("Whether or not the resolution or fix of the Change Request has been verified.")
	@OslcOccurs(Occurs.ZeroOrOne)
	@OslcValueType(ValueType.Boolean)
	
	
	@OslcReadOnly(true)
	@OslcTitle("")
    public Boolean isVerified()
    {
        return verified;
    }


    public void setAffectedByDefects(final HashSet<Link> affectedByDefect )
    {
        this.affectedByDefects.clear();
        if (affectedByDefect != null)
        {
            this.affectedByDefects.addAll(affectedByDefect);
        }

    }
    public void setAffectsPlanItems(final HashSet<Link> affectsPlanItem )
    {
        this.affectsPlanItems.clear();
        if (affectsPlanItem != null)
        {
            this.affectsPlanItems.addAll(affectsPlanItem);
        }

    }
    public void setAffectsRequirements(final HashSet<Link> affectsRequirement )
    {
        this.affectsRequirements.clear();
        if (affectsRequirement != null)
        {
            this.affectsRequirements.addAll(affectsRequirement);
        }

    }
    public void setAffectsTestResults(final HashSet<Link> affectsTestResult )
    {
        this.affectsTestResults.clear();
        if (affectsTestResult != null)
        {
            this.affectsTestResults.addAll(affectsTestResult);
        }

    }
    public void setBlocksTestExecutionRecords(final HashSet<Link> blocksTestExecutionRecord )
    {
        this.blocksTestExecutionRecords.clear();
        if (blocksTestExecutionRecord != null)
        {
            this.blocksTestExecutionRecords.addAll(blocksTestExecutionRecord);
        }

    }
    public void setContributors(final HashSet<Person> contributor )
    {
        this.contributors.clear();
        if (contributor != null)
        {
            this.contributors.addAll(contributor);
        }

    }
    public void setCreators(final HashSet<Person> creator )
    {
        this.creators.clear();
        if (creator != null)
        {
            this.creators.addAll(creator);
        }

    }
    public void setDctermsTypes(final HashSet<Type> type )
    {
        this.dctermsTypes.clear();
        if (type != null)
        {
            this.dctermsTypes.addAll(type);
        }

    }
    public void setImplementsRequirements(final HashSet<Link> implementsRequirement )
    {
        this.implementsRequirements.clear();
        if (implementsRequirement != null)
        {
            this.implementsRequirements.addAll(implementsRequirement);
        }

    }
    public void setRelatedChangeRequests(final HashSet<Link> relatedChangeRequest )
    {
        this.relatedChangeRequests.clear();
        if (relatedChangeRequest != null)
        {
            this.relatedChangeRequests.addAll(relatedChangeRequest);
        }

    }
    public void setRelatedTestCases(final HashSet<Link> relatedTestCase )
    {
        this.relatedTestCases.clear();
        if (relatedTestCase != null)
        {
            this.relatedTestCases.addAll(relatedTestCase);
        }

    }
    public void setRelatedTestExecutionRecords(final HashSet<Link> relatedTestExecutionRecord )
    {
        this.relatedTestExecutionRecords.clear();
        if (relatedTestExecutionRecord != null)
        {
            this.relatedTestExecutionRecords.addAll(relatedTestExecutionRecord);
        }

    }
    public void setRelatedTestPlans(final HashSet<Link> relatedTestPlan )
    {
        this.relatedTestPlans.clear();
        if (relatedTestPlan != null)
        {
            this.relatedTestPlans.addAll(relatedTestPlan);
        }

    }
    public void setRelatedTestScripts(final HashSet<Link> relatedTestScript )
    {
        this.relatedTestScripts.clear();
        if (relatedTestScript != null)
        {
            this.relatedTestScripts.addAll(relatedTestScript);
        }

    }
    public void setSubjects(final HashSet<String> subject )
    {
        this.subjects.clear();
        if (subject != null)
        {
            this.subjects.addAll(subject);
        }

    }
    public void setTestedByTestCases(final HashSet<Link> testedByTestCase )
    {
        this.testedByTestCases.clear();
        if (testedByTestCase != null)
        {
            this.testedByTestCases.addAll(testedByTestCase);
        }

    }
    public void setTracksChangeSets(final HashSet<Link> tracksChangeSet )
    {
        this.tracksChangeSets.clear();
        if (tracksChangeSet != null)
        {
            this.tracksChangeSets.addAll(tracksChangeSet);
        }

    }
    public void setTracksRequirements(final HashSet<Link> tracksRequirement )
    {
        this.tracksRequirements.clear();
        if (tracksRequirement != null)
        {
            this.tracksRequirements.addAll(tracksRequirement);
        }

    }
    public void setRdfTypes(final HashSet<URI> type )
    {
        this.rdfTypes.clear();
        if (type != null)
        {
            this.rdfTypes.addAll(type);
        }

    }
    public void setApproved(final Boolean approved )
    {
        this.approved = approved;
    }
    public void setClosed(final Boolean closed )
    {
        this.closed = closed;
    }
    public void setCloseDate(final Date closeDate )
    {
        this.closeDate = closeDate;
    }
    public void setCreated(final Date created )
    {
        this.created = created;
    }
    public void setDescription(final String description )
    {
        this.description = description;
    }
    public void setDiscussedBy(final Link discussedBy )
    {
        this.discussedBy = discussedBy;
    }
    public void setFixed(final Boolean fixed )
    {
        this.fixed = fixed;
    }
    public void setIdentifier(final String identifier )
    {
        this.identifier = identifier;
    }
    public void setInprogress(final Boolean inprogress )
    {
        this.inprogress = inprogress;
    }
    public void setInstanceShape(final Link instanceShape )
    {
        this.instanceShape = instanceShape;
    }
    public void setModified(final Date modified )
    {
        this.modified = modified;
    }
    public void setReviewed(final Boolean reviewed )
    {
        this.reviewed = reviewed;
    }
    public void setServiceProvider(final URI serviceProvider )
    {
        this.serviceProvider = serviceProvider;
    }
    public void setShortTitle(final String shortTitle )
    {
        this.shortTitle = shortTitle;
    }
    public void setStatus(final String status )
    {
        this.status = status;
    }
    public void setTitle(final String title )
    {
        this.title = title;
    }
    public void setVerified(final Boolean verified )
    {
        this.verified = verified;
    }

    static public String affectedByDefectsToHtmlForCreation (final HttpServletRequest httpServletRequest, final String serviceProviderId)
    {
		String s = "";

		// Start of user code affectedByDefectsasHtmlForCreation_init
		// End of user code

		s = s + "<label for=\"affectedByDefect\">affectedByDefect: </LABEL>";

		// Start of user code affectedByDefectsasHtmlForCreation_mid
		// End of user code


		// Start of user code affectedByDefectsasHtmlForCreation_finalize
		// End of user code

		return s; 
    }
    static public String affectsPlanItemsToHtmlForCreation (final HttpServletRequest httpServletRequest, final String serviceProviderId)
    {
		String s = "";

		// Start of user code affectsPlanItemsasHtmlForCreation_init
		// End of user code

		s = s + "<label for=\"affectsPlanItem\">affectsPlanItem: </LABEL>";

		// Start of user code affectsPlanItemsasHtmlForCreation_mid
		// End of user code


		// Start of user code affectsPlanItemsasHtmlForCreation_finalize
		// End of user code

		return s; 
    }
    static public String affectsRequirementsToHtmlForCreation (final HttpServletRequest httpServletRequest, final String serviceProviderId)
    {
		String s = "";

		// Start of user code affectsRequirementsasHtmlForCreation_init
		// End of user code

		s = s + "<label for=\"affectsRequirement\">affectsRequirement: </LABEL>";

		// Start of user code affectsRequirementsasHtmlForCreation_mid
		// End of user code


		// Start of user code affectsRequirementsasHtmlForCreation_finalize
		// End of user code

		return s; 
    }
    static public String affectsTestResultsToHtmlForCreation (final HttpServletRequest httpServletRequest, final String serviceProviderId)
    {
		String s = "";

		// Start of user code affectsTestResultsasHtmlForCreation_init
		// End of user code

		s = s + "<label for=\"affectsTestResult\">affectsTestResult: </LABEL>";

		// Start of user code affectsTestResultsasHtmlForCreation_mid
		// End of user code


		// Start of user code affectsTestResultsasHtmlForCreation_finalize
		// End of user code

		return s; 
    }
    static public String blocksTestExecutionRecordsToHtmlForCreation (final HttpServletRequest httpServletRequest, final String serviceProviderId)
    {
		String s = "";

		// Start of user code blocksTestExecutionRecordsasHtmlForCreation_init
		// End of user code

		s = s + "<label for=\"blocksTestExecutionRecord\">blocksTestExecutionRecord: </LABEL>";

		// Start of user code blocksTestExecutionRecordsasHtmlForCreation_mid
		// End of user code


		// Start of user code blocksTestExecutionRecordsasHtmlForCreation_finalize
		// End of user code

		return s; 
    }
    static public String contributorsToHtmlForCreation (final HttpServletRequest httpServletRequest, final String serviceProviderId)
    {
		String s = "";

		// Start of user code contributorsasHtmlForCreation_init
		// End of user code

		s = s + "<label for=\"contributor\">contributor: </LABEL>";

		// Start of user code contributorsasHtmlForCreation_mid
		// End of user code


		// Start of user code contributorsasHtmlForCreation_finalize
		// End of user code

		return s; 
    }
    static public String creatorsToHtmlForCreation (final HttpServletRequest httpServletRequest, final String serviceProviderId)
    {
		String s = "";

		// Start of user code creatorsasHtmlForCreation_init
		// End of user code

		s = s + "<label for=\"creator\">creator: </LABEL>";

		// Start of user code creatorsasHtmlForCreation_mid
		// End of user code


		// Start of user code creatorsasHtmlForCreation_finalize
		// End of user code

		return s; 
    }
    static public String dctermsTypesToHtmlForCreation (final HttpServletRequest httpServletRequest, final String serviceProviderId)
    {
		String s = "";

		// Start of user code dctermsTypesasHtmlForCreation_init
		// End of user code

		s = s + "<label for=\"type\">type: </LABEL>";

		// Start of user code dctermsTypesasHtmlForCreation_mid
		// End of user code


		// Start of user code dctermsTypesasHtmlForCreation_finalize
		// End of user code

		return s; 
    }
    static public String implementsRequirementsToHtmlForCreation (final HttpServletRequest httpServletRequest, final String serviceProviderId)
    {
		String s = "";

		// Start of user code implementsRequirementsasHtmlForCreation_init
		// End of user code

		s = s + "<label for=\"implementsRequirement\">implementsRequirement: </LABEL>";

		// Start of user code implementsRequirementsasHtmlForCreation_mid
		// End of user code


		// Start of user code implementsRequirementsasHtmlForCreation_finalize
		// End of user code

		return s; 
    }
    static public String relatedChangeRequestsToHtmlForCreation (final HttpServletRequest httpServletRequest, final String serviceProviderId)
    {
		String s = "";

		// Start of user code relatedChangeRequestsasHtmlForCreation_init
		// End of user code

		s = s + "<label for=\"relatedChangeRequest\">relatedChangeRequest: </LABEL>";

		// Start of user code relatedChangeRequestsasHtmlForCreation_mid
		// End of user code


		// Start of user code relatedChangeRequestsasHtmlForCreation_finalize
		// End of user code

		return s; 
    }
    static public String relatedTestCasesToHtmlForCreation (final HttpServletRequest httpServletRequest, final String serviceProviderId)
    {
		String s = "";

		// Start of user code relatedTestCasesasHtmlForCreation_init
		// End of user code

		s = s + "<label for=\"relatedTestCase\">relatedTestCase: </LABEL>";

		// Start of user code relatedTestCasesasHtmlForCreation_mid
		// End of user code


		// Start of user code relatedTestCasesasHtmlForCreation_finalize
		// End of user code

		return s; 
    }
    static public String relatedTestExecutionRecordsToHtmlForCreation (final HttpServletRequest httpServletRequest, final String serviceProviderId)
    {
		String s = "";

		// Start of user code relatedTestExecutionRecordsasHtmlForCreation_init
		// End of user code

		s = s + "<label for=\"relatedTestExecutionRecord\">relatedTestExecutionRecord: </LABEL>";

		// Start of user code relatedTestExecutionRecordsasHtmlForCreation_mid
		// End of user code


		// Start of user code relatedTestExecutionRecordsasHtmlForCreation_finalize
		// End of user code

		return s; 
    }
    static public String relatedTestPlansToHtmlForCreation (final HttpServletRequest httpServletRequest, final String serviceProviderId)
    {
		String s = "";

		// Start of user code relatedTestPlansasHtmlForCreation_init
		// End of user code

		s = s + "<label for=\"relatedTestPlan\">relatedTestPlan: </LABEL>";

		// Start of user code relatedTestPlansasHtmlForCreation_mid
		// End of user code


		// Start of user code relatedTestPlansasHtmlForCreation_finalize
		// End of user code

		return s; 
    }
    static public String relatedTestScriptsToHtmlForCreation (final HttpServletRequest httpServletRequest, final String serviceProviderId)
    {
		String s = "";

		// Start of user code relatedTestScriptsasHtmlForCreation_init
		// End of user code

		s = s + "<label for=\"relatedTestScript\">relatedTestScript: </LABEL>";

		// Start of user code relatedTestScriptsasHtmlForCreation_mid
		// End of user code


		// Start of user code relatedTestScriptsasHtmlForCreation_finalize
		// End of user code

		return s; 
    }
    static public String subjectsToHtmlForCreation (final HttpServletRequest httpServletRequest, final String serviceProviderId)
    {
		String s = "";

		// Start of user code subjectsasHtmlForCreation_init
		// End of user code

		s = s + "<label for=\"subject\">subject: </LABEL>";

		// Start of user code subjectsasHtmlForCreation_mid
		// End of user code

				s= s + "<input name=\"subject\" type=\"text\" style=\"width: 400px\" id=\"subject\" >";

		// Start of user code subjectsasHtmlForCreation_finalize
		// End of user code

		return s; 
    }
    static public String testedByTestCasesToHtmlForCreation (final HttpServletRequest httpServletRequest, final String serviceProviderId)
    {
		String s = "";

		// Start of user code testedByTestCasesasHtmlForCreation_init
		// End of user code

		s = s + "<label for=\"testedByTestCase\">testedByTestCase: </LABEL>";

		// Start of user code testedByTestCasesasHtmlForCreation_mid
		// End of user code


		// Start of user code testedByTestCasesasHtmlForCreation_finalize
		// End of user code

		return s; 
    }
    static public String tracksChangeSetsToHtmlForCreation (final HttpServletRequest httpServletRequest, final String serviceProviderId)
    {
		String s = "";

		// Start of user code tracksChangeSetsasHtmlForCreation_init
		// End of user code

		s = s + "<label for=\"tracksChangeSet\">tracksChangeSet: </LABEL>";

		// Start of user code tracksChangeSetsasHtmlForCreation_mid
		// End of user code


		// Start of user code tracksChangeSetsasHtmlForCreation_finalize
		// End of user code

		return s; 
    }
    static public String tracksRequirementsToHtmlForCreation (final HttpServletRequest httpServletRequest, final String serviceProviderId)
    {
		String s = "";

		// Start of user code tracksRequirementsasHtmlForCreation_init
		// End of user code

		s = s + "<label for=\"tracksRequirement\">tracksRequirement: </LABEL>";

		// Start of user code tracksRequirementsasHtmlForCreation_mid
		// End of user code


		// Start of user code tracksRequirementsasHtmlForCreation_finalize
		// End of user code

		return s; 
    }
    static public String rdfTypesToHtmlForCreation (final HttpServletRequest httpServletRequest, final String serviceProviderId)
    {
		String s = "";

		// Start of user code rdfTypesasHtmlForCreation_init
		// End of user code

		s = s + "<label for=\"type\">type: </LABEL>";

		// Start of user code rdfTypesasHtmlForCreation_mid
		// End of user code

				s= s + "<input name=\"type\" type=\"text\" style=\"width: 400px\" id=\"type\" >";

		// Start of user code rdfTypesasHtmlForCreation_finalize
		// End of user code

		return s; 
    }
    static public String approvedToHtmlForCreation (final HttpServletRequest httpServletRequest, final String serviceProviderId)
    {
		String s = "";

		// Start of user code approvedasHtmlForCreation_init
		// End of user code

		s = s + "<label for=\"approved\">approved: </LABEL>";

		// Start of user code approvedasHtmlForCreation_mid
		// End of user code

				s= s + "<input name=\"approved\" type=\"radio\" value=\"true\">True<br><input name=\"approved\" type=\"radio\" value=\"false\">False";

		// Start of user code approvedasHtmlForCreation_finalize
		// End of user code

		return s; 
    }
    static public String closedToHtmlForCreation (final HttpServletRequest httpServletRequest, final String serviceProviderId)
    {
		String s = "";

		// Start of user code closedasHtmlForCreation_init
		// End of user code

		s = s + "<label for=\"closed\">closed: </LABEL>";

		// Start of user code closedasHtmlForCreation_mid
		// End of user code

				s= s + "<input name=\"closed\" type=\"radio\" value=\"true\">True<br><input name=\"closed\" type=\"radio\" value=\"false\">False";

		// Start of user code closedasHtmlForCreation_finalize
		// End of user code

		return s; 
    }
    static public String closeDateToHtmlForCreation (final HttpServletRequest httpServletRequest, final String serviceProviderId)
    {
		String s = "";

		// Start of user code closeDateasHtmlForCreation_init
		// End of user code

		s = s + "<label for=\"closeDate\">closeDate: </LABEL>";

		// Start of user code closeDateasHtmlForCreation_mid
		// End of user code

				s= s + "<input name=\"closeDate\" type=\"text\" style=\"width: 400px\" id=\"closeDate\" >";

		// Start of user code closeDateasHtmlForCreation_finalize
		// End of user code

		return s; 
    }
    static public String createdToHtmlForCreation (final HttpServletRequest httpServletRequest, final String serviceProviderId)
    {
		String s = "";

		// Start of user code createdasHtmlForCreation_init
		// End of user code

		s = s + "<label for=\"created\">created: </LABEL>";

		// Start of user code createdasHtmlForCreation_mid
		// End of user code

				s= s + "<input name=\"created\" type=\"text\" style=\"width: 400px\" id=\"created\" >";

		// Start of user code createdasHtmlForCreation_finalize
		// End of user code

		return s; 
    }
    static public String descriptionToHtmlForCreation (final HttpServletRequest httpServletRequest, final String serviceProviderId)
    {
		String s = "";

		// Start of user code descriptionasHtmlForCreation_init
		// End of user code

		s = s + "<label for=\"description\">description: </LABEL>";

		// Start of user code descriptionasHtmlForCreation_mid
		// End of user code

				s= s + "<input name=\"description\" type=\"text\" style=\"width: 400px\" id=\"description\" >";

		// Start of user code descriptionasHtmlForCreation_finalize
		// End of user code

		return s; 
    }
    static public String discussedByToHtmlForCreation (final HttpServletRequest httpServletRequest, final String serviceProviderId)
    {
		String s = "";

		// Start of user code discussedByasHtmlForCreation_init
		// End of user code

		s = s + "<label for=\"discussedBy\">discussedBy: </LABEL>";

		// Start of user code discussedByasHtmlForCreation_mid
		// End of user code


		// Start of user code discussedByasHtmlForCreation_finalize
		// End of user code

		return s; 
    }
    static public String fixedToHtmlForCreation (final HttpServletRequest httpServletRequest, final String serviceProviderId)
    {
		String s = "";

		// Start of user code fixedasHtmlForCreation_init
		// End of user code

		s = s + "<label for=\"fixed\">fixed: </LABEL>";

		// Start of user code fixedasHtmlForCreation_mid
		// End of user code

				s= s + "<input name=\"fixed\" type=\"radio\" value=\"true\">True<br><input name=\"fixed\" type=\"radio\" value=\"false\">False";

		// Start of user code fixedasHtmlForCreation_finalize
		// End of user code

		return s; 
    }
    static public String identifierToHtmlForCreation (final HttpServletRequest httpServletRequest, final String serviceProviderId)
    {
		String s = "";

		// Start of user code identifierasHtmlForCreation_init
		// End of user code

		s = s + "<label for=\"identifier\">identifier: </LABEL>";

		// Start of user code identifierasHtmlForCreation_mid
		// End of user code

				s= s + "<input name=\"identifier\" type=\"text\" style=\"width: 400px\" id=\"identifier\" >";

		// Start of user code identifierasHtmlForCreation_finalize
		// End of user code

		return s; 
    }
    static public String inprogressToHtmlForCreation (final HttpServletRequest httpServletRequest, final String serviceProviderId)
    {
		String s = "";

		// Start of user code inprogressasHtmlForCreation_init
		// End of user code

		s = s + "<label for=\"inprogress\">inprogress: </LABEL>";

		// Start of user code inprogressasHtmlForCreation_mid
		// End of user code

				s= s + "<input name=\"inprogress\" type=\"radio\" value=\"true\">True<br><input name=\"inprogress\" type=\"radio\" value=\"false\">False";

		// Start of user code inprogressasHtmlForCreation_finalize
		// End of user code

		return s; 
    }
    static public String instanceShapeToHtmlForCreation (final HttpServletRequest httpServletRequest, final String serviceProviderId)
    {
		String s = "";

		// Start of user code instanceShapeasHtmlForCreation_init
		// End of user code

		s = s + "<label for=\"instanceShape\">instanceShape: </LABEL>";

		// Start of user code instanceShapeasHtmlForCreation_mid
		// End of user code


		// Start of user code instanceShapeasHtmlForCreation_finalize
		// End of user code

		return s; 
    }
    static public String modifiedToHtmlForCreation (final HttpServletRequest httpServletRequest, final String serviceProviderId)
    {
		String s = "";

		// Start of user code modifiedasHtmlForCreation_init
		// End of user code

		s = s + "<label for=\"modified\">modified: </LABEL>";

		// Start of user code modifiedasHtmlForCreation_mid
		// End of user code

				s= s + "<input name=\"modified\" type=\"text\" style=\"width: 400px\" id=\"modified\" >";

		// Start of user code modifiedasHtmlForCreation_finalize
		// End of user code

		return s; 
    }
    static public String reviewedToHtmlForCreation (final HttpServletRequest httpServletRequest, final String serviceProviderId)
    {
		String s = "";

		// Start of user code reviewedasHtmlForCreation_init
		// End of user code

		s = s + "<label for=\"reviewed\">reviewed: </LABEL>";

		// Start of user code reviewedasHtmlForCreation_mid
		// End of user code

				s= s + "<input name=\"reviewed\" type=\"radio\" value=\"true\">True<br><input name=\"reviewed\" type=\"radio\" value=\"false\">False";

		// Start of user code reviewedasHtmlForCreation_finalize
		// End of user code

		return s; 
    }
    static public String serviceProviderToHtmlForCreation (final HttpServletRequest httpServletRequest, final String serviceProviderId)
    {
		String s = "";

		// Start of user code serviceProviderasHtmlForCreation_init
		// End of user code

		s = s + "<label for=\"serviceProvider\">serviceProvider: </LABEL>";

		// Start of user code serviceProviderasHtmlForCreation_mid
		// End of user code

				s= s + "<input name=\"serviceProvider\" type=\"text\" style=\"width: 400px\" id=\"serviceProvider\" >";

		// Start of user code serviceProviderasHtmlForCreation_finalize
		// End of user code

		return s; 
    }
    static public String shortTitleToHtmlForCreation (final HttpServletRequest httpServletRequest, final String serviceProviderId)
    {
		String s = "";

		// Start of user code shortTitleasHtmlForCreation_init
		// End of user code

		s = s + "<label for=\"shortTitle\">shortTitle: </LABEL>";

		// Start of user code shortTitleasHtmlForCreation_mid
		// End of user code

				s= s + "<input name=\"shortTitle\" type=\"text\" style=\"width: 400px\" id=\"shortTitle\" >";

		// Start of user code shortTitleasHtmlForCreation_finalize
		// End of user code

		return s; 
    }
    static public String statusToHtmlForCreation (final HttpServletRequest httpServletRequest, final String serviceProviderId)
    {
		String s = "";

		// Start of user code statusasHtmlForCreation_init
		// End of user code

		s = s + "<label for=\"status\">status: </LABEL>";

		// Start of user code statusasHtmlForCreation_mid
		// End of user code

				s= s + "<input name=\"status\" type=\"text\" style=\"width: 400px\" id=\"status\" >";

		// Start of user code statusasHtmlForCreation_finalize
		// End of user code

		return s; 
    }
    static public String titleToHtmlForCreation (final HttpServletRequest httpServletRequest, final String serviceProviderId)
    {
		String s = "";

		// Start of user code titleasHtmlForCreation_init
		// End of user code

		s = s + "<label for=\"title\">title: </LABEL>";

		// Start of user code titleasHtmlForCreation_mid
		// End of user code

				s= s + "<input name=\"title\" type=\"text\" style=\"width: 400px\" id=\"title\" >";

		// Start of user code titleasHtmlForCreation_finalize
		// End of user code

		return s; 
    }
    static public String verifiedToHtmlForCreation (final HttpServletRequest httpServletRequest, final String serviceProviderId)
    {
		String s = "";

		// Start of user code verifiedasHtmlForCreation_init
		// End of user code

		s = s + "<label for=\"verified\">verified: </LABEL>";

		// Start of user code verifiedasHtmlForCreation_mid
		// End of user code

				s= s + "<input name=\"verified\" type=\"radio\" value=\"true\">True<br><input name=\"verified\" type=\"radio\" value=\"false\">False";

		// Start of user code verifiedasHtmlForCreation_finalize
		// End of user code

		return s; 
    }

    public String affectedByDefectsToHtml()
    {
		String s = "";

		// Start of user code affectedByDefectstoHtml_init
		// End of user code

		s = s + "<label for=\"affectedByDefect\"><strong>affectedByDefect</strong>: </LABEL>";

		// Start of user code affectedByDefectstoHtml_mid
		// End of user code

		try {
		        s = s + "<ul>";
				Iterator<Link> itr = affectedByDefects.iterator();
				while(itr.hasNext()) {
					s = s + "<li>";
							s = s + itr.next().getValue().toString();
					s = s + "</li>";
				}
		        s = s + "</ul>";
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

		// Start of user code affectedByDefectstoHtml_finalize
		// End of user code

		return s; 
    }
    public String affectsPlanItemsToHtml()
    {
		String s = "";

		// Start of user code affectsPlanItemstoHtml_init
		// End of user code

		s = s + "<label for=\"affectsPlanItem\"><strong>affectsPlanItem</strong>: </LABEL>";

		// Start of user code affectsPlanItemstoHtml_mid
		// End of user code

		try {
		        s = s + "<ul>";
				Iterator<Link> itr = affectsPlanItems.iterator();
				while(itr.hasNext()) {
					s = s + "<li>";
							s = s + itr.next().getValue().toString();
					s = s + "</li>";
				}
		        s = s + "</ul>";
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

		// Start of user code affectsPlanItemstoHtml_finalize
		// End of user code

		return s; 
    }
    public String affectsRequirementsToHtml()
    {
		String s = "";

		// Start of user code affectsRequirementstoHtml_init
		// End of user code

		s = s + "<label for=\"affectsRequirement\"><strong>affectsRequirement</strong>: </LABEL>";

		// Start of user code affectsRequirementstoHtml_mid
		// End of user code

		try {
		        s = s + "<ul>";
				Iterator<Link> itr = affectsRequirements.iterator();
				while(itr.hasNext()) {
					s = s + "<li>";
							s = s + itr.next().getValue().toString();
					s = s + "</li>";
				}
		        s = s + "</ul>";
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

		// Start of user code affectsRequirementstoHtml_finalize
		// End of user code

		return s; 
    }
    public String affectsTestResultsToHtml()
    {
		String s = "";

		// Start of user code affectsTestResultstoHtml_init
		// End of user code

		s = s + "<label for=\"affectsTestResult\"><strong>affectsTestResult</strong>: </LABEL>";

		// Start of user code affectsTestResultstoHtml_mid
		// End of user code

		try {
		        s = s + "<ul>";
				Iterator<Link> itr = affectsTestResults.iterator();
				while(itr.hasNext()) {
					s = s + "<li>";
							s = s + itr.next().getValue().toString();
					s = s + "</li>";
				}
		        s = s + "</ul>";
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

		// Start of user code affectsTestResultstoHtml_finalize
		// End of user code

		return s; 
    }
    public String blocksTestExecutionRecordsToHtml()
    {
		String s = "";

		// Start of user code blocksTestExecutionRecordstoHtml_init
		// End of user code

		s = s + "<label for=\"blocksTestExecutionRecord\"><strong>blocksTestExecutionRecord</strong>: </LABEL>";

		// Start of user code blocksTestExecutionRecordstoHtml_mid
		// End of user code

		try {
		        s = s + "<ul>";
				Iterator<Link> itr = blocksTestExecutionRecords.iterator();
				while(itr.hasNext()) {
					s = s + "<li>";
							s = s + itr.next().getValue().toString();
					s = s + "</li>";
				}
		        s = s + "</ul>";
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

		// Start of user code blocksTestExecutionRecordstoHtml_finalize
		// End of user code

		return s; 
    }
    public String contributorsToHtml()
    {
		String s = "";

		// Start of user code contributorstoHtml_init
		// End of user code

		s = s + "<label for=\"contributor\"><strong>contributor</strong>: </LABEL>";

		// Start of user code contributorstoHtml_mid
		// End of user code

		try {
		        s = s + "<ul>";
				Iterator<Person> itr = contributors.iterator();
				while(itr.hasNext()) {
					s = s + "<li>";
						s = s + itr.next().toHtml();
					s = s + "</li>";
				}
		        s = s + "</ul>";
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

		// Start of user code contributorstoHtml_finalize
		// End of user code

		return s; 
    }
    public String creatorsToHtml()
    {
		String s = "";

		// Start of user code creatorstoHtml_init
		// End of user code

		s = s + "<label for=\"creator\"><strong>creator</strong>: </LABEL>";

		// Start of user code creatorstoHtml_mid
		// End of user code

		try {
		        s = s + "<ul>";
				Iterator<Person> itr = creators.iterator();
				while(itr.hasNext()) {
					s = s + "<li>";
						s = s + itr.next().toHtml();
					s = s + "</li>";
				}
		        s = s + "</ul>";
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

		// Start of user code creatorstoHtml_finalize
		// End of user code

		return s; 
    }
    public String dctermsTypesToHtml()
    {
		String s = "";

		// Start of user code dctermsTypestoHtml_init
		// End of user code

		s = s + "<label for=\"type\"><strong>type</strong>: </LABEL>";

		// Start of user code dctermsTypestoHtml_mid
		// End of user code

		try {
		        s = s + "<ul>";
				Iterator<Type> itr = dctermsTypes.iterator();
				while(itr.hasNext()) {
					s = s + "<li>";
						s = s + itr.next().toHtml();
					s = s + "</li>";
				}
		        s = s + "</ul>";
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

		// Start of user code dctermsTypestoHtml_finalize
		// End of user code

		return s; 
    }
    public String implementsRequirementsToHtml()
    {
		String s = "";

		// Start of user code implementsRequirementstoHtml_init
		// End of user code

		s = s + "<label for=\"implementsRequirement\"><strong>implementsRequirement</strong>: </LABEL>";

		// Start of user code implementsRequirementstoHtml_mid
		// End of user code

		try {
		        s = s + "<ul>";
				Iterator<Link> itr = implementsRequirements.iterator();
				while(itr.hasNext()) {
					s = s + "<li>";
							s = s + itr.next().getValue().toString();
					s = s + "</li>";
				}
		        s = s + "</ul>";
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

		// Start of user code implementsRequirementstoHtml_finalize
		// End of user code

		return s; 
    }
    public String relatedChangeRequestsToHtml()
    {
		String s = "";

		// Start of user code relatedChangeRequeststoHtml_init
		// End of user code

		s = s + "<label for=\"relatedChangeRequest\"><strong>relatedChangeRequest</strong>: </LABEL>";

		// Start of user code relatedChangeRequeststoHtml_mid
		// End of user code

		try {
		        s = s + "<ul>";
				Iterator<Link> itr = relatedChangeRequests.iterator();
				while(itr.hasNext()) {
					s = s + "<li>";
							s = s + itr.next().getValue().toString();
					s = s + "</li>";
				}
		        s = s + "</ul>";
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

		// Start of user code relatedChangeRequeststoHtml_finalize
		// End of user code

		return s; 
    }
    public String relatedTestCasesToHtml()
    {
		String s = "";

		// Start of user code relatedTestCasestoHtml_init
		// End of user code

		s = s + "<label for=\"relatedTestCase\"><strong>relatedTestCase</strong>: </LABEL>";

		// Start of user code relatedTestCasestoHtml_mid
		// End of user code

		try {
		        s = s + "<ul>";
				Iterator<Link> itr = relatedTestCases.iterator();
				while(itr.hasNext()) {
					s = s + "<li>";
							s = s + itr.next().getValue().toString();
					s = s + "</li>";
				}
		        s = s + "</ul>";
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

		// Start of user code relatedTestCasestoHtml_finalize
		// End of user code

		return s; 
    }
    public String relatedTestExecutionRecordsToHtml()
    {
		String s = "";

		// Start of user code relatedTestExecutionRecordstoHtml_init
		// End of user code

		s = s + "<label for=\"relatedTestExecutionRecord\"><strong>relatedTestExecutionRecord</strong>: </LABEL>";

		// Start of user code relatedTestExecutionRecordstoHtml_mid
		// End of user code

		try {
		        s = s + "<ul>";
				Iterator<Link> itr = relatedTestExecutionRecords.iterator();
				while(itr.hasNext()) {
					s = s + "<li>";
							s = s + itr.next().getValue().toString();
					s = s + "</li>";
				}
		        s = s + "</ul>";
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

		// Start of user code relatedTestExecutionRecordstoHtml_finalize
		// End of user code

		return s; 
    }
    public String relatedTestPlansToHtml()
    {
		String s = "";

		// Start of user code relatedTestPlanstoHtml_init
		// End of user code

		s = s + "<label for=\"relatedTestPlan\"><strong>relatedTestPlan</strong>: </LABEL>";

		// Start of user code relatedTestPlanstoHtml_mid
		// End of user code

		try {
		        s = s + "<ul>";
				Iterator<Link> itr = relatedTestPlans.iterator();
				while(itr.hasNext()) {
					s = s + "<li>";
							s = s + itr.next().getValue().toString();
					s = s + "</li>";
				}
		        s = s + "</ul>";
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

		// Start of user code relatedTestPlanstoHtml_finalize
		// End of user code

		return s; 
    }
    public String relatedTestScriptsToHtml()
    {
		String s = "";

		// Start of user code relatedTestScriptstoHtml_init
		// End of user code

		s = s + "<label for=\"relatedTestScript\"><strong>relatedTestScript</strong>: </LABEL>";

		// Start of user code relatedTestScriptstoHtml_mid
		// End of user code

		try {
		        s = s + "<ul>";
				Iterator<Link> itr = relatedTestScripts.iterator();
				while(itr.hasNext()) {
					s = s + "<li>";
							s = s + itr.next().getValue().toString();
					s = s + "</li>";
				}
		        s = s + "</ul>";
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

		// Start of user code relatedTestScriptstoHtml_finalize
		// End of user code

		return s; 
    }
    public String subjectsToHtml()
    {
		String s = "";

		// Start of user code subjectstoHtml_init
		// End of user code

		s = s + "<label for=\"subject\"><strong>subject</strong>: </LABEL>";

		// Start of user code subjectstoHtml_mid
		// End of user code

		try {
		        s = s + "<ul>";
				Iterator<String> itr = subjects.iterator();
				while(itr.hasNext()) {
					s = s + "<li>";
					s= s + itr.next().toString();
					s = s + "</li>";
				}
		        s = s + "</ul>";
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

		// Start of user code subjectstoHtml_finalize
		// End of user code

		return s; 
    }
    public String testedByTestCasesToHtml()
    {
		String s = "";

		// Start of user code testedByTestCasestoHtml_init
		// End of user code

		s = s + "<label for=\"testedByTestCase\"><strong>testedByTestCase</strong>: </LABEL>";

		// Start of user code testedByTestCasestoHtml_mid
		// End of user code

		try {
		        s = s + "<ul>";
				Iterator<Link> itr = testedByTestCases.iterator();
				while(itr.hasNext()) {
					s = s + "<li>";
							s = s + itr.next().getValue().toString();
					s = s + "</li>";
				}
		        s = s + "</ul>";
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

		// Start of user code testedByTestCasestoHtml_finalize
		// End of user code

		return s; 
    }
    public String tracksChangeSetsToHtml()
    {
		String s = "";

		// Start of user code tracksChangeSetstoHtml_init
		// End of user code

		s = s + "<label for=\"tracksChangeSet\"><strong>tracksChangeSet</strong>: </LABEL>";

		// Start of user code tracksChangeSetstoHtml_mid
		// End of user code

		try {
		        s = s + "<ul>";
				Iterator<Link> itr = tracksChangeSets.iterator();
				while(itr.hasNext()) {
					s = s + "<li>";
							s = s + itr.next().getValue().toString();
					s = s + "</li>";
				}
		        s = s + "</ul>";
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

		// Start of user code tracksChangeSetstoHtml_finalize
		// End of user code

		return s; 
    }
    public String tracksRequirementsToHtml()
    {
		String s = "";

		// Start of user code tracksRequirementstoHtml_init
		// End of user code

		s = s + "<label for=\"tracksRequirement\"><strong>tracksRequirement</strong>: </LABEL>";

		// Start of user code tracksRequirementstoHtml_mid
		// End of user code

		try {
		        s = s + "<ul>";
				Iterator<Link> itr = tracksRequirements.iterator();
				while(itr.hasNext()) {
					s = s + "<li>";
							s = s + itr.next().getValue().toString();
					s = s + "</li>";
				}
		        s = s + "</ul>";
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

		// Start of user code tracksRequirementstoHtml_finalize
		// End of user code

		return s; 
    }
    public String rdfTypesToHtml()
    {
		String s = "";

		// Start of user code rdfTypestoHtml_init
		// End of user code

		s = s + "<label for=\"type\"><strong>type</strong>: </LABEL>";

		// Start of user code rdfTypestoHtml_mid
		// End of user code

		try {
		        s = s + "<ul>";
				Iterator<URI> itr = rdfTypes.iterator();
				while(itr.hasNext()) {
					s = s + "<li>";
					s= s + itr.next().toString();
					s = s + "</li>";
				}
		        s = s + "</ul>";
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

		// Start of user code rdfTypestoHtml_finalize
		// End of user code

		return s; 
    }
    public String approvedToHtml()
    {
		String s = "";

		// Start of user code approvedtoHtml_init
		// End of user code

		s = s + "<label for=\"approved\"><strong>approved</strong>: </LABEL>";

		// Start of user code approvedtoHtml_mid
		// End of user code

		try {
				if (approved == null) {
					s= s + "<em>null</em>";				
				}
				else {
					s= s + approved.toString();				
				}
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

		// Start of user code approvedtoHtml_finalize
		// End of user code

		return s; 
    }
    public String closedToHtml()
    {
		String s = "";

		// Start of user code closedtoHtml_init
		// End of user code

		s = s + "<label for=\"closed\"><strong>closed</strong>: </LABEL>";

		// Start of user code closedtoHtml_mid
		// End of user code

		try {
				if (closed == null) {
					s= s + "<em>null</em>";				
				}
				else {
					s= s + closed.toString();				
				}
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

		// Start of user code closedtoHtml_finalize
		// End of user code

		return s; 
    }
    public String closeDateToHtml()
    {
		String s = "";

		// Start of user code closeDatetoHtml_init
		// End of user code

		s = s + "<label for=\"closeDate\"><strong>closeDate</strong>: </LABEL>";

		// Start of user code closeDatetoHtml_mid
		// End of user code

		try {
				if (closeDate == null) {
					s= s + "<em>null</em>";				
				}
				else {
					s= s + closeDate.toString();				
				}
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

		// Start of user code closeDatetoHtml_finalize
		// End of user code

		return s; 
    }
    public String createdToHtml()
    {
		String s = "";

		// Start of user code createdtoHtml_init
		// End of user code

		s = s + "<label for=\"created\"><strong>created</strong>: </LABEL>";

		// Start of user code createdtoHtml_mid
		// End of user code

		try {
				if (created == null) {
					s= s + "<em>null</em>";				
				}
				else {
					s= s + created.toString();				
				}
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

		// Start of user code createdtoHtml_finalize
		// End of user code

		return s; 
    }
    public String descriptionToHtml()
    {
		String s = "";

		// Start of user code descriptiontoHtml_init
		// End of user code

		s = s + "<label for=\"description\"><strong>description</strong>: </LABEL>";

		// Start of user code descriptiontoHtml_mid
		// End of user code

		try {
				if (description == null) {
					s= s + "<em>null</em>";				
				}
				else {
					s= s + description.toString();				
				}
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

		// Start of user code descriptiontoHtml_finalize
		// End of user code

		return s; 
    }
    public String discussedByToHtml()
    {
		String s = "";

		// Start of user code discussedBytoHtml_init
		// End of user code

		s = s + "<label for=\"discussedBy\"><strong>discussedBy</strong>: </LABEL>";

		// Start of user code discussedBytoHtml_mid
		// End of user code

		try {
					s = s + discussedBy.getValue().toString();


	    } catch (Exception e) {
	        e.printStackTrace();
	    }

		// Start of user code discussedBytoHtml_finalize
		// End of user code

		return s; 
    }
    public String fixedToHtml()
    {
		String s = "";

		// Start of user code fixedtoHtml_init
		// End of user code

		s = s + "<label for=\"fixed\"><strong>fixed</strong>: </LABEL>";

		// Start of user code fixedtoHtml_mid
		// End of user code

		try {
				if (fixed == null) {
					s= s + "<em>null</em>";				
				}
				else {
					s= s + fixed.toString();				
				}
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

		// Start of user code fixedtoHtml_finalize
		// End of user code

		return s; 
    }
    public String identifierToHtml()
    {
		String s = "";

		// Start of user code identifiertoHtml_init
		// End of user code

		s = s + "<label for=\"identifier\"><strong>identifier</strong>: </LABEL>";

		// Start of user code identifiertoHtml_mid
		// End of user code

		try {
				if (identifier == null) {
					s= s + "<em>null</em>";				
				}
				else {
					s= s + identifier.toString();				
				}
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

		// Start of user code identifiertoHtml_finalize
		// End of user code

		return s; 
    }
    public String inprogressToHtml()
    {
		String s = "";

		// Start of user code inprogresstoHtml_init
		// End of user code

		s = s + "<label for=\"inprogress\"><strong>inprogress</strong>: </LABEL>";

		// Start of user code inprogresstoHtml_mid
		// End of user code

		try {
				if (inprogress == null) {
					s= s + "<em>null</em>";				
				}
				else {
					s= s + inprogress.toString();				
				}
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

		// Start of user code inprogresstoHtml_finalize
		// End of user code

		return s; 
    }
    public String instanceShapeToHtml()
    {
		String s = "";

		// Start of user code instanceShapetoHtml_init
		// End of user code

		s = s + "<label for=\"instanceShape\"><strong>instanceShape</strong>: </LABEL>";

		// Start of user code instanceShapetoHtml_mid
		// End of user code

		try {
					s = s + instanceShape.getValue().toString();


	    } catch (Exception e) {
	        e.printStackTrace();
	    }

		// Start of user code instanceShapetoHtml_finalize
		// End of user code

		return s; 
    }
    public String modifiedToHtml()
    {
		String s = "";

		// Start of user code modifiedtoHtml_init
		// End of user code

		s = s + "<label for=\"modified\"><strong>modified</strong>: </LABEL>";

		// Start of user code modifiedtoHtml_mid
		// End of user code

		try {
				if (modified == null) {
					s= s + "<em>null</em>";				
				}
				else {
					s= s + modified.toString();				
				}
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

		// Start of user code modifiedtoHtml_finalize
		// End of user code

		return s; 
    }
    public String reviewedToHtml()
    {
		String s = "";

		// Start of user code reviewedtoHtml_init
		// End of user code

		s = s + "<label for=\"reviewed\"><strong>reviewed</strong>: </LABEL>";

		// Start of user code reviewedtoHtml_mid
		// End of user code

		try {
				if (reviewed == null) {
					s= s + "<em>null</em>";				
				}
				else {
					s= s + reviewed.toString();				
				}
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

		// Start of user code reviewedtoHtml_finalize
		// End of user code

		return s; 
    }
    public String serviceProviderToHtml()
    {
		String s = "";

		// Start of user code serviceProvidertoHtml_init
		// End of user code

		s = s + "<label for=\"serviceProvider\"><strong>serviceProvider</strong>: </LABEL>";

		// Start of user code serviceProvidertoHtml_mid
		// End of user code

		try {
				if (serviceProvider == null) {
					s= s + "<em>null</em>";				
				}
				else {
					s= s + serviceProvider.toString();				
				}
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

		// Start of user code serviceProvidertoHtml_finalize
		// End of user code

		return s; 
    }
    public String shortTitleToHtml()
    {
		String s = "";

		// Start of user code shortTitletoHtml_init
		// End of user code

		s = s + "<label for=\"shortTitle\"><strong>shortTitle</strong>: </LABEL>";

		// Start of user code shortTitletoHtml_mid
		// End of user code

		try {
				if (shortTitle == null) {
					s= s + "<em>null</em>";				
				}
				else {
					s= s + shortTitle.toString();				
				}
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

		// Start of user code shortTitletoHtml_finalize
		// End of user code

		return s; 
    }
    public String statusToHtml()
    {
		String s = "";

		// Start of user code statustoHtml_init
		// End of user code

		s = s + "<label for=\"status\"><strong>status</strong>: </LABEL>";

		// Start of user code statustoHtml_mid
		// End of user code

		try {
				if (status == null) {
					s= s + "<em>null</em>";				
				}
				else {
					s= s + status.toString();				
				}
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

		// Start of user code statustoHtml_finalize
		// End of user code

		return s; 
    }
    public String titleToHtml()
    {
		String s = "";

		// Start of user code titletoHtml_init
		// End of user code

		s = s + "<label for=\"title\"><strong>title</strong>: </LABEL>";

		// Start of user code titletoHtml_mid
		// End of user code

		try {
				if (title == null) {
					s= s + "<em>null</em>";				
				}
				else {
					s= s + title.toString();				
				}
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

		// Start of user code titletoHtml_finalize
		// End of user code

		return s; 
    }
    public String verifiedToHtml()
    {
		String s = "";

		// Start of user code verifiedtoHtml_init
		// End of user code

		s = s + "<label for=\"verified\"><strong>verified</strong>: </LABEL>";

		// Start of user code verifiedtoHtml_mid
		// End of user code

		try {
				if (verified == null) {
					s= s + "<em>null</em>";				
				}
				else {
					s= s + verified.toString();				
				}
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

		// Start of user code verifiedtoHtml_finalize
		// End of user code

		return s; 
    }

}

