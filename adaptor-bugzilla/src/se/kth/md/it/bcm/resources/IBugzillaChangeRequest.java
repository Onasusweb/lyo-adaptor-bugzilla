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
import se.kth.md.it.bcm.resources.IChangeRequest;
import se.kth.md.it.bcm.resources.IChangeRequest;
import se.kth.md.it.bcm.resources.IRequirement;
import se.kth.md.it.bcm.resources.IPerson;
import se.kth.md.it.bcm.resources.IPerson;
import se.kth.md.it.bcm.resources.IDiscussion;
import se.kth.md.it.bcm.resources.IRequirement;
import se.kth.md.it.bcm.resources.IChangeRequest;
import se.kth.md.it.bcm.resources.IRequirement;

// Start of user code imports
// End of user code

@OslcNamespace(BugzillaAdaptorConstants.BUGZILLA_NAMSPACE)
@OslcName(BugzillaAdaptorConstants.BUGZILLACHANGEREQUEST)
@OslcResourceShape(title = "BugzillaChangeRequest Resource Shape", describes = BugzillaAdaptorConstants.TYPE_BUGZILLACHANGEREQUEST)
public interface IBugzillaChangeRequest
{


    @OslcName("product")
    @OslcPropertyDefinition(BugzillaAdaptorConstants.BUGZILLA_NAMSPACE + "product")
    @OslcDescription("")
    @OslcOccurs(Occurs.ExactlyOne)
    @OslcValueType(ValueType.String)
    @OslcReadOnly(false)
    public String getProduct();

    @OslcName("component")
    @OslcPropertyDefinition(BugzillaAdaptorConstants.BUGZILLA_NAMSPACE + "component")
    @OslcDescription("The Bugzilla product definition for this change request.")
    @OslcOccurs(Occurs.ZeroOrOne)
    @OslcValueType(ValueType.String)
    @OslcReadOnly(false)
    @OslcTitle("Component")
    public String getComponent();

    @OslcName("version")
    @OslcPropertyDefinition(BugzillaAdaptorConstants.BUGZILLA_NAMSPACE + "version")
    @OslcDescription("The Bugzilla version for this change request.")
    @OslcOccurs(Occurs.ZeroOrOne)
    @OslcValueType(ValueType.String)
    @OslcReadOnly(true)
    @OslcTitle("Version")
    public String getVersion();

    @OslcName("priority")
    @OslcPropertyDefinition(BugzillaAdaptorConstants.BUGZILLA_NAMSPACE + "priority")
    @OslcDescription("The Bugzilla priority for this change request.")
    @OslcOccurs(Occurs.ZeroOrOne)
    @OslcValueType(ValueType.String)
    @OslcReadOnly(false)
    @OslcTitle("Priority")
    public String getPriority();

    @OslcName("platform")
    @OslcPropertyDefinition(BugzillaAdaptorConstants.BUGZILLA_NAMSPACE + "platform")
    @OslcDescription("The Bugzilla platform for this change request.")
    @OslcOccurs(Occurs.ZeroOrOne)
    @OslcValueType(ValueType.String)
    @OslcReadOnly(false)
    @OslcTitle("Platform")
    public String getPlatform();

    @OslcName("operatingSystem")
    @OslcPropertyDefinition(BugzillaAdaptorConstants.BUGZILLA_NAMSPACE + "operatingSystem")
    @OslcDescription("The Bugzilla operating system for this change request.")
    @OslcOccurs(Occurs.ZeroOrOne)
    @OslcValueType(ValueType.String)
    @OslcReadOnly(false)
    @OslcTitle("Operating System")
    public String getOperatingSystem();


    public void setProduct(final String product );
    public void setComponent(final String component );
    public void setVersion(final String version );
    public void setPriority(final String priority );
    public void setPlatform(final String platform );
    public void setOperatingSystem(final String operatingSystem );
}

