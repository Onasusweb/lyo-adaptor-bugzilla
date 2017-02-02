/*******************************************************************************
 * Copyright (c) 2012 IBM Corporation and others.
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
 *     Russell Boykin       - initial API and implementation
 *     Alberto Giammaria    - initial API and implementation
 *     Chris Peters         - initial API and implementation
 *     Gianluca Bernardini  - initial API and implementation
 *	   Sam Padgett	       - initial API and implementation
 *     Michael Fiedler     - adapted for OSLC4J
 *     Jad El-khoury        - initial implementation of code generator (https://bugs.eclipse.org/bugs/show_bug.cgi?id=422448)
 *
 * This file is generated by org.eclipse.lyo.oslc4j.codegenerator
 *******************************************************************************/

package se.kth.md.it.bcm.resources;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.Iterator;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import javax.ws.rs.core.UriBuilder;

import org.eclipse.lyo.oslc4j.core.annotation.OslcAllowedValue;
import org.eclipse.lyo.oslc4j.core.annotation.OslcDescription;
import org.eclipse.lyo.oslc4j.core.annotation.OslcMemberProperty;
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
import se.kth.md.it.bcm.resources.IPerson;
import se.kth.md.it.bcm.resources.IPerson;

// Start of user code imports
// End of user code

@OslcNamespace(BugzillaAdaptorConstants.REQUIREMENTS_MANAGEMENT_NAMSPACE)
@OslcName(BugzillaAdaptorConstants.REQUIREMENT)
@OslcResourceShape(title = "Requirement Resource Shape", describes = BugzillaAdaptorConstants.TYPE_REQUIREMENT)
public interface IRequirement
{

    public void addElaboratedBy(final Link elaboratedBy );
    public void addElaborates(final Link elaborates );
    public void addSpecifiedBy(final Link specifiedBy );
    public void addSpecifies(final Link specifies );
    public void addAffectedBy(final Link affectedBy );
    public void addTrackedBy(final Link trackedBy );
    public void addImplementedBy(final Link implementedBy );
    public void addValidatedBy(final Link validatedBy );
    public void addSatisfiedBy(final Link satisfiedBy );
    public void addSatisfies(final Link satisfies );
    public void addDecomposedBy(final Link decomposedBy );
    public void addDecomposes(final Link decomposes );
    public void addConstrainedBy(final Link constrainedBy );
    public void addConstrains(final Link constrains );

    @OslcName("title")
    @OslcPropertyDefinition(BugzillaAdaptorConstants.DUBLIN_CORE_NAMSPACE + "title")
    @OslcDescription("Title of the resource represented as rich text in XHTML content. SHOULD include only content that is valid inside an XHTML <span> element.")
    @OslcOccurs(Occurs.ExactlyOne)
    @OslcValueType(ValueType.XMLLiteral)
    @OslcReadOnly(false)
    public String getTitle();

    @OslcName("description")
    @OslcPropertyDefinition(BugzillaAdaptorConstants.DUBLIN_CORE_NAMSPACE + "description")
    @OslcDescription("Descriptive text about resource represented as rich text in XHTML content. SHOULD include only content that is valid and suitable inside an XHTML <div> element.")
    @OslcOccurs(Occurs.ExactlyOne)
    @OslcValueType(ValueType.XMLLiteral)
    @OslcReadOnly(false)
    public String getDescription();

    @OslcName("identifier")
    @OslcPropertyDefinition(BugzillaAdaptorConstants.DUBLIN_CORE_NAMSPACE + "identifier")
    @OslcDescription("A unique identifier for a resource. Typically read-only and assigned by the service provider when a resource is created. Not typically intended for end-user display.")
    @OslcOccurs(Occurs.ExactlyOne)
    @OslcValueType(ValueType.String)
    @OslcReadOnly(false)
    public String getIdentifier();

    @OslcName("shortTitle")
    @OslcPropertyDefinition(BugzillaAdaptorConstants.OSLC_NAMSPACE + "shortTitle")
    @OslcDescription("Shorter form of dcterms:title for the resource represented as rich text in XHTML content. SHOULD include only content that is valid inside an XHTML <span> element.")
    @OslcOccurs(Occurs.ExactlyOne)
    @OslcValueType(ValueType.XMLLiteral)
    @OslcReadOnly(false)
    public String getShortTitle();

    @OslcName("subject")
    @OslcPropertyDefinition(BugzillaAdaptorConstants.DUBLIN_CORE_NAMSPACE + "subject")
    @OslcDescription("Tag or keyword for a resource. Each occurrence of a dcterms:subject property denotes an additional tag for the resource.")
    @OslcOccurs(Occurs.ExactlyOne)
    @OslcValueType(ValueType.String)
    @OslcReadOnly(false)
    @OslcTitle("")
    public String getSubject();

    @OslcName("creator")
    @OslcPropertyDefinition(BugzillaAdaptorConstants.DUBLIN_CORE_NAMSPACE + "creator")
    @OslcDescription("Creator or creators of the resource. It is likely that the target resource will be a foaf:Person but that is not necessarily the case.")
    @OslcOccurs(Occurs.ExactlyOne)
    @OslcValueType(ValueType.Resource)
    @OslcRange({BugzillaAdaptorConstants.TYPE_PERSON})
    @OslcReadOnly(false)
    public Link getCreator();

    @OslcName("contributor")
    @OslcPropertyDefinition(BugzillaAdaptorConstants.DUBLIN_CORE_NAMSPACE + "contributor")
    @OslcDescription("Contributor or contributors to the resource. It is likely that the target resource will be a foaf:Person but that is not necessarily the case.")
    @OslcOccurs(Occurs.ExactlyOne)
    @OslcValueType(ValueType.Resource)
    @OslcRange({BugzillaAdaptorConstants.TYPE_PERSON})
    @OslcReadOnly(false)
    public Link getContributor();

    @OslcName("created")
    @OslcPropertyDefinition(BugzillaAdaptorConstants.DUBLIN_CORE_NAMSPACE + "created")
    @OslcDescription("Timestamp of resource creation")
    @OslcOccurs(Occurs.ExactlyOne)
    @OslcValueType(ValueType.DateTime)
    @OslcReadOnly(false)
    public Date getCreated();

    @OslcName("modified")
    @OslcPropertyDefinition(BugzillaAdaptorConstants.DUBLIN_CORE_NAMSPACE + "modified")
    @OslcDescription("Timestamp of latest resource modification")
    @OslcOccurs(Occurs.ExactlyOne)
    @OslcValueType(ValueType.DateTime)
    @OslcReadOnly(false)
    public Date getModified();

    @OslcName("type")
    @OslcPropertyDefinition(BugzillaAdaptorConstants.RDF_NAMSPACE + "type")
    @OslcDescription("The resource type URIs")
    @OslcOccurs(Occurs.ExactlyOne)
    @OslcValueType(ValueType.Resource)
    @OslcReadOnly(false)
    public Link getType();

    @OslcName("serviceProvider")
    @OslcPropertyDefinition(BugzillaAdaptorConstants.OSLC_NAMSPACE + "serviceProvider")
    @OslcDescription("A link to the resource's OSLC Service Provider. There may be cases when the subject resource is available from a service provider that implements multiple domain specifications, which could result in multiple values for this property.")
    @OslcOccurs(Occurs.ExactlyOne)
    @OslcReadOnly(false)
    public URI getServiceProvider();

    @OslcName("instanceShape")
    @OslcPropertyDefinition(BugzillaAdaptorConstants.OSLC_NAMSPACE + "instanceShape")
    @OslcDescription("The URI of a Resource Shape that describes the possible properties, occurrence, value types, allowed values and labels. This shape information is useful in displaying the subject resource as well as guiding clients in performing modifications. Instance shapes may be specific to the authenticated user associated with the request that retrieved the resource, the current state of the resource and other factors and thus should not be cached.")
    @OslcOccurs(Occurs.ExactlyOne)
    @OslcReadOnly(false)
    public URI getInstanceShape();

    @OslcName("elaboratedBy")
    @OslcPropertyDefinition(BugzillaAdaptorConstants.REQUIREMENTS_MANAGEMENT_NAMSPACE + "elaboratedBy")
    @OslcDescription("The subject is elaborated by the object. For example, a user requirement is elaborated by use case.")
    @OslcOccurs(Occurs.ZeroOrMany)
    @OslcValueType(ValueType.Resource)
    @OslcReadOnly(false)
    public HashSet<Link> getElaboratedBy();

    @OslcName("elaborates")
    @OslcPropertyDefinition(BugzillaAdaptorConstants.REQUIREMENTS_MANAGEMENT_NAMSPACE + "elaborates")
    @OslcDescription("The object is elaborated by the subject.")
    @OslcOccurs(Occurs.ZeroOrMany)
    @OslcValueType(ValueType.Resource)
    @OslcReadOnly(false)
    public HashSet<Link> getElaborates();

    @OslcName("specifiedBy")
    @OslcPropertyDefinition(BugzillaAdaptorConstants.REQUIREMENTS_MANAGEMENT_NAMSPACE + "specifiedBy")
    @OslcDescription("The subject is specified by the object. For example, a requirement is elaborated by a model element .")
    @OslcOccurs(Occurs.ZeroOrMany)
    @OslcValueType(ValueType.Resource)
    @OslcReadOnly(false)
    public HashSet<Link> getSpecifiedBy();

    @OslcName("specifies")
    @OslcPropertyDefinition(BugzillaAdaptorConstants.REQUIREMENTS_MANAGEMENT_NAMSPACE + "specifies")
    @OslcDescription("The object is specified by the subject.")
    @OslcOccurs(Occurs.ZeroOrMany)
    @OslcValueType(ValueType.Resource)
    @OslcReadOnly(false)
    public HashSet<Link> getSpecifies();

    @OslcName("affectedBy")
    @OslcPropertyDefinition(BugzillaAdaptorConstants.REQUIREMENTS_MANAGEMENT_NAMSPACE + "affectedBy")
    @OslcDescription("Requirement is affected by a resource, such as a defect or issue.")
    @OslcOccurs(Occurs.ZeroOrMany)
    @OslcValueType(ValueType.Resource)
    @OslcReadOnly(false)
    public HashSet<Link> getAffectedBy();

    @OslcName("trackedBy")
    @OslcPropertyDefinition(BugzillaAdaptorConstants.REQUIREMENTS_MANAGEMENT_NAMSPACE + "trackedBy")
    @OslcDescription("Resource, such as a change request, which tracks this requirement.")
    @OslcOccurs(Occurs.ZeroOrMany)
    @OslcValueType(ValueType.Resource)
    @OslcReadOnly(false)
    public HashSet<Link> getTrackedBy();

    @OslcName("implementedBy")
    @OslcPropertyDefinition(BugzillaAdaptorConstants.REQUIREMENTS_MANAGEMENT_NAMSPACE + "implementedBy")
    @OslcDescription("Resource, such as a change request, which implements this requirement.")
    @OslcOccurs(Occurs.ZeroOrMany)
    @OslcValueType(ValueType.Resource)
    @OslcReadOnly(false)
    public HashSet<Link> getImplementedBy();

    @OslcName("validatedBy")
    @OslcPropertyDefinition(BugzillaAdaptorConstants.REQUIREMENTS_MANAGEMENT_NAMSPACE + "validatedBy")
    @OslcDescription("Resource, such as a test case, which validates this requirement.")
    @OslcOccurs(Occurs.ZeroOrMany)
    @OslcValueType(ValueType.Resource)
    @OslcReadOnly(false)
    public HashSet<Link> getValidatedBy();

    @OslcName("satisfiedBy")
    @OslcPropertyDefinition(BugzillaAdaptorConstants.REQUIREMENTS_MANAGEMENT_NAMSPACE + "satisfiedBy")
    @OslcDescription("The subject is satisfied by the object. For example, a user requirement is satisfied by a system requirement.")
    @OslcOccurs(Occurs.ZeroOrMany)
    @OslcValueType(ValueType.Resource)
    @OslcReadOnly(false)
    public HashSet<Link> getSatisfiedBy();

    @OslcName("satisfies")
    @OslcPropertyDefinition(BugzillaAdaptorConstants.REQUIREMENTS_MANAGEMENT_NAMSPACE + "satisfies")
    @OslcDescription("The object is satisfied by the subject.")
    @OslcOccurs(Occurs.ZeroOrMany)
    @OslcValueType(ValueType.Resource)
    @OslcReadOnly(false)
    public HashSet<Link> getSatisfies();

    @OslcName("decomposedBy")
    @OslcPropertyDefinition(BugzillaAdaptorConstants.REQUIREMENTS_MANAGEMENT_NAMSPACE + "decomposedBy")
    @OslcDescription("The subject is decomposed by the object. For example, a system requirement is decomposed into a collection of system requirements.")
    @OslcOccurs(Occurs.ZeroOrMany)
    @OslcValueType(ValueType.Resource)
    @OslcReadOnly(false)
    public HashSet<Link> getDecomposedBy();

    @OslcName("decomposes")
    @OslcPropertyDefinition(BugzillaAdaptorConstants.REQUIREMENTS_MANAGEMENT_NAMSPACE + "decomposes")
    @OslcDescription("The object is decomposed by the subject.")
    @OslcOccurs(Occurs.ZeroOrMany)
    @OslcValueType(ValueType.Resource)
    @OslcReadOnly(false)
    public HashSet<Link> getDecomposes();

    @OslcName("constrainedBy")
    @OslcPropertyDefinition(BugzillaAdaptorConstants.REQUIREMENTS_MANAGEMENT_NAMSPACE + "constrainedBy")
    @OslcDescription("The subject is constrained by the object. For example, a functional requirement is constrained by a safety requirement.")
    @OslcOccurs(Occurs.ZeroOrMany)
    @OslcValueType(ValueType.Resource)
    @OslcReadOnly(false)
    public HashSet<Link> getConstrainedBy();

    @OslcName("constrains")
    @OslcPropertyDefinition(BugzillaAdaptorConstants.REQUIREMENTS_MANAGEMENT_NAMSPACE + "constrains")
    @OslcDescription("The object is constrained by the subject.")
    @OslcOccurs(Occurs.ZeroOrMany)
    @OslcValueType(ValueType.Resource)
    @OslcReadOnly(false)
    public HashSet<Link> getConstrains();


    public void setTitle(final String title );
    public void setDescription(final String description );
    public void setIdentifier(final String identifier );
    public void setShortTitle(final String shortTitle );
    public void setSubject(final String subject );
    public void setCreator(final Link creator );
    public void setContributor(final Link contributor );
    public void setCreated(final Date created );
    public void setModified(final Date modified );
    public void setType(final Link type );
    public void setServiceProvider(final URI serviceProvider );
    public void setInstanceShape(final URI instanceShape );
    public void setElaboratedBy(final HashSet<Link> elaboratedBy );
    public void setElaborates(final HashSet<Link> elaborates );
    public void setSpecifiedBy(final HashSet<Link> specifiedBy );
    public void setSpecifies(final HashSet<Link> specifies );
    public void setAffectedBy(final HashSet<Link> affectedBy );
    public void setTrackedBy(final HashSet<Link> trackedBy );
    public void setImplementedBy(final HashSet<Link> implementedBy );
    public void setValidatedBy(final HashSet<Link> validatedBy );
    public void setSatisfiedBy(final HashSet<Link> satisfiedBy );
    public void setSatisfies(final HashSet<Link> satisfies );
    public void setDecomposedBy(final HashSet<Link> decomposedBy );
    public void setDecomposes(final HashSet<Link> decomposes );
    public void setConstrainedBy(final HashSet<Link> constrainedBy );
    public void setConstrains(final HashSet<Link> constrains );
}

