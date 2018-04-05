// Start of user code Copyright
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
 *     Michael Fiedler      - Bugzilla adpater implementations
 *     Jad El-khoury        - initial implementation of code generator (https://bugs.eclipse.org/bugs/show_bug.cgi?id=422448)
 * 
 * This file is generated by org.eclipse.lyo.oslc4j.codegenerator
 *******************************************************************************/
// End of user code

package se.kth.md.it.bcm.resources;

import org.eclipse.lyo.oslc4j.core.model.OslcConstants;


// Start of user code imports
// End of user code

public interface OslcDomainConstants
{
    // Start of user code user constants
    // End of user code

    public static String OSLC_DOMAIN = "http://open-services.net/ns/core#";
    public static String OSLC_NAMSPACE = "http://open-services.net/ns/core#";
    public static String OSLC_NAMSPACE_PREFIX = "oslc";

    public static String ALLOWED_VALUES_PATH = "allowedValues";
    public static String ALLOWED_VALUES_NAMESPACE = OSLC_NAMSPACE; //namespace of the rdfs:class the resource describes
    public static String ALLOWED_VALUES_LOCALNAME = "AllowedValues"; //localName of the rdfs:class the resource describes
    public static String ALLOWED_VALUES_TYPE = ALLOWED_VALUES_NAMESPACE + ALLOWED_VALUES_LOCALNAME; //fullname of the rdfs:class the resource describes
    public static String DISCUSSION_PATH = "discussion";
    public static String DISCUSSION_NAMESPACE = OSLC_NAMSPACE; //namespace of the rdfs:class the resource describes
    public static String DISCUSSION_LOCALNAME = "Discussion"; //localName of the rdfs:class the resource describes
    public static String DISCUSSION_TYPE = DISCUSSION_NAMESPACE + DISCUSSION_LOCALNAME; //fullname of the rdfs:class the resource describes
    public static String PROPERTY_PATH = "property";
    public static String PROPERTY_NAMESPACE = OSLC_NAMSPACE; //namespace of the rdfs:class the resource describes
    public static String PROPERTY_LOCALNAME = "Property"; //localName of the rdfs:class the resource describes
    public static String PROPERTY_TYPE = PROPERTY_NAMESPACE + PROPERTY_LOCALNAME; //fullname of the rdfs:class the resource describes
    public static String RESOURCESHAPE_PATH = "resourceShape";
    public static String RESOURCESHAPE_NAMESPACE = OSLC_NAMSPACE; //namespace of the rdfs:class the resource describes
    public static String RESOURCESHAPE_LOCALNAME = "ResourceShape"; //localName of the rdfs:class the resource describes
    public static String RESOURCESHAPE_TYPE = RESOURCESHAPE_NAMESPACE + RESOURCESHAPE_LOCALNAME; //fullname of the rdfs:class the resource describes
    public static String SERVICEPROVIDER_PATH = "serviceProvider";
    public static String SERVICEPROVIDER_NAMESPACE = OSLC_NAMSPACE; //namespace of the rdfs:class the resource describes
    public static String SERVICEPROVIDER_LOCALNAME = "ServiceProvider"; //localName of the rdfs:class the resource describes
    public static String SERVICEPROVIDER_TYPE = SERVICEPROVIDER_NAMESPACE + SERVICEPROVIDER_LOCALNAME; //fullname of the rdfs:class the resource describes
}
