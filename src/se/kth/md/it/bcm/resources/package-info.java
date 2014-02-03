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
@OslcSchema ({
	@OslcNamespaceDefinition(prefix = OslcConstants.DCTERMS_NAMESPACE_PREFIX,             namespaceURI = OslcConstants.DCTERMS_NAMESPACE),
	@OslcNamespaceDefinition(prefix = OslcConstants.OSLC_CORE_NAMESPACE_PREFIX,           namespaceURI = OslcConstants.OSLC_CORE_NAMESPACE),
	@OslcNamespaceDefinition(prefix = OslcConstants.OSLC_DATA_NAMESPACE_PREFIX,           namespaceURI = OslcConstants.OSLC_DATA_NAMESPACE),
	@OslcNamespaceDefinition(prefix = OslcConstants.RDF_NAMESPACE_PREFIX,                 namespaceURI = OslcConstants.RDF_NAMESPACE),
	@OslcNamespaceDefinition(prefix = OslcConstants.RDFS_NAMESPACE_PREFIX,                namespaceURI = OslcConstants.RDFS_NAMESPACE),
		@OslcNamespaceDefinition(prefix = BugzillaAdaptorConstants.OSLC_CORE_NAMSPACE_PREFIX, namespaceURI = BugzillaAdaptorConstants.OSLC_CORE_NAMSPACE)
,
		@OslcNamespaceDefinition(prefix = BugzillaAdaptorConstants.QUALITY_MANAGEMENT_NAMSPACE_PREFIX, namespaceURI = BugzillaAdaptorConstants.QUALITY_MANAGEMENT_NAMSPACE)
,
		@OslcNamespaceDefinition(prefix = BugzillaAdaptorConstants.CHANGE_MANAGEMENT_NAMSPACE_PREFIX, namespaceURI = BugzillaAdaptorConstants.CHANGE_MANAGEMENT_NAMSPACE)
,
		@OslcNamespaceDefinition(prefix = BugzillaAdaptorConstants.FOAF_NAMSPACE_PREFIX, namespaceURI = BugzillaAdaptorConstants.FOAF_NAMSPACE)
,
		@OslcNamespaceDefinition(prefix = BugzillaAdaptorConstants.DUBLIN_CORE_NAMSPACE_PREFIX, namespaceURI = BugzillaAdaptorConstants.DUBLIN_CORE_NAMSPACE)
,
		@OslcNamespaceDefinition(prefix = BugzillaAdaptorConstants.RDF_NAMSPACE_PREFIX, namespaceURI = BugzillaAdaptorConstants.RDF_NAMSPACE)
,
		@OslcNamespaceDefinition(prefix = BugzillaAdaptorConstants.RDFS_NAMSPACE_PREFIX, namespaceURI = BugzillaAdaptorConstants.RDFS_NAMSPACE)
,
		@OslcNamespaceDefinition(prefix = BugzillaAdaptorConstants.BUGZILLA_NAMSPACE_PREFIX, namespaceURI = BugzillaAdaptorConstants.BUGZILLA_NAMSPACE)
})
package se.kth.md.it.bcm.resources;

import org.eclipse.lyo.oslc4j.core.annotation.OslcNamespaceDefinition;
import org.eclipse.lyo.oslc4j.core.annotation.OslcSchema;
import org.eclipse.lyo.oslc4j.core.model.OslcConstants;

import se.kth.md.it.bcm.BugzillaAdaptorConstants;

