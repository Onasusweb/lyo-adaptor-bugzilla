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

package se.kth.md.it.bcm.servlet;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

import org.eclipse.lyo.oslc4j.client.ServiceProviderRegistryURIs;
import org.eclipse.lyo.oslc4j.core.exception.OslcCoreApplicationException;
import org.eclipse.lyo.oslc4j.core.model.OslcConstants;
import org.eclipse.lyo.oslc4j.core.model.PrefixDefinition;
import org.eclipse.lyo.oslc4j.core.model.Publisher;
import org.eclipse.lyo.oslc4j.core.model.ServiceProvider;
import org.eclipse.lyo.oslc4j.core.model.ServiceProviderFactory;

import se.kth.md.it.bcm.BugzillaAdaptorConstants;
import se.kth.md.it.bcm.services.BugzillaChangeRequestService;	


// Start of user code imports
// End of user code

public class BugzillaAdaptorServiceProviderFactory
{
    private static Class<?>[] RESOURCE_CLASSES =
    {
		BugzillaChangeRequestService.class	
    };

    private BugzillaAdaptorServiceProviderFactory()
    {
        super();
    }

    /**
     * Create �a new Bugzilla OSLC change management service provider.
     * @param baseURI
     * @param serviceProviderTitle
     * @param parameterValueMap - a map containing the path replacement value for {serviceProviderId}.  See ServiceProviderCatalogSingleton.initServiceProviders()
     * @return
     * @throws OslcCoreApplicationException
     * @throws URISyntaxException
     */
    public static ServiceProvider createServiceProvider(final String baseURI, final String title, final String description, final Publisher publisher, final Map<String,Object> parameterValueMap)
           throws OslcCoreApplicationException, URISyntaxException
    {
        final ServiceProvider serviceProvider = ServiceProviderFactory.createServiceProvider(baseURI,
                                                                                             ServiceProviderRegistryURIs.getUIURI(),
                                                                                             title,
                                                                                             description,
                                                                                             publisher,
                                                                                             RESOURCE_CLASSES,
                                                                                             parameterValueMap);
        URI detailsURIs[] = {new URI(baseURI)};
        serviceProvider.setDetails(detailsURIs);

        final PrefixDefinition[] prefixDefinitions =
        {
            new PrefixDefinition(OslcConstants.DCTERMS_NAMESPACE_PREFIX, new URI(OslcConstants.DCTERMS_NAMESPACE)),
            new PrefixDefinition(OslcConstants.OSLC_CORE_NAMESPACE_PREFIX, new URI(OslcConstants.OSLC_CORE_NAMESPACE)),
            new PrefixDefinition(OslcConstants.OSLC_DATA_NAMESPACE_PREFIX, new URI(OslcConstants.OSLC_DATA_NAMESPACE)),
            new PrefixDefinition(OslcConstants.RDF_NAMESPACE_PREFIX, new URI(OslcConstants.RDF_NAMESPACE)),
            new PrefixDefinition(OslcConstants.RDFS_NAMESPACE_PREFIX, new URI(OslcConstants.RDFS_NAMESPACE)),
			new PrefixDefinition(BugzillaAdaptorConstants.OSLC_CORE_NAMSPACE_PREFIX, new URI(BugzillaAdaptorConstants.OSLC_CORE_NAMSPACE))
,
			new PrefixDefinition(BugzillaAdaptorConstants.QUALITY_MANAGEMENT_NAMSPACE_PREFIX, new URI(BugzillaAdaptorConstants.QUALITY_MANAGEMENT_NAMSPACE))
,
			new PrefixDefinition(BugzillaAdaptorConstants.CHANGE_MANAGEMENT_NAMSPACE_PREFIX, new URI(BugzillaAdaptorConstants.CHANGE_MANAGEMENT_NAMSPACE))
,
			new PrefixDefinition(BugzillaAdaptorConstants.FOAF_NAMSPACE_PREFIX, new URI(BugzillaAdaptorConstants.FOAF_NAMSPACE))
,
			new PrefixDefinition(BugzillaAdaptorConstants.DUBLIN_CORE_NAMSPACE_PREFIX, new URI(BugzillaAdaptorConstants.DUBLIN_CORE_NAMSPACE))
,
			new PrefixDefinition(BugzillaAdaptorConstants.RDF_NAMSPACE_PREFIX, new URI(BugzillaAdaptorConstants.RDF_NAMSPACE))
,
			new PrefixDefinition(BugzillaAdaptorConstants.RDFS_NAMSPACE_PREFIX, new URI(BugzillaAdaptorConstants.RDFS_NAMSPACE))
,
			new PrefixDefinition(BugzillaAdaptorConstants.BUGZILLA_NAMSPACE_PREFIX, new URI(BugzillaAdaptorConstants.BUGZILLA_NAMSPACE))
        };

        serviceProvider.setPrefixDefinitions(prefixDefinitions);

        return serviceProvider;
    }
}

