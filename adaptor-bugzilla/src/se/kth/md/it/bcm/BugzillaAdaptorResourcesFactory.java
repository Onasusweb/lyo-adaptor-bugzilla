// Start of user code Copyright
/*******************************************************************************
 * Copyright (c) 2017 Jad El-khoury.
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
 *     Jad El-khoury        - initial implementation
 *     
 *******************************************************************************/
// End of user code

package se.kth.md.it.bcm;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.core.UriBuilder;

import org.eclipse.lyo.oslc4j.core.model.Link;
import org.eclipse.lyo.oslc4j.core.OSLC4JUtils;
import se.kth.md.it.bcm.resources.Discussion;
import se.kth.md.it.bcm.resources.Person;
import se.kth.md.it.bcm.resources.BugzillaChangeRequest;
import se.kth.md.it.bcm.resources.ChangeRequest;
import se.kth.md.it.bcm.resources.Requirement;

// Start of user code imports
// End of user code

// Start of user code pre_class_code
// End of user code

public class BugzillaAdaptorResourcesFactory {

    // Start of user code class_attributes
    // End of user code
    
    // Start of user code class_methods
    // End of user code

    //methods for BugzillaChangeRequest resource
    public static BugzillaChangeRequest createBugzillaChangeRequest(final String serviceProviderId, final String bugzillaChangeRequestId)
           throws URISyntaxException
    {
        return new BugzillaChangeRequest(constructURIForBugzillaChangeRequest(serviceProviderId, bugzillaChangeRequestId));
    }
    
    public static URI constructURIForBugzillaChangeRequest(final String serviceProviderId, final String bugzillaChangeRequestId)
    {
        String basePath = OSLC4JUtils.getServletURI();
        Map<String, Object> pathParameters = new HashMap<String, Object>();
        pathParameters.put("serviceProviderId", serviceProviderId);
        pathParameters.put("bugzillaChangeRequestId", bugzillaChangeRequestId);
        String instanceURI = "serviceProviders/{serviceProviderId}/bugzillaChangeRequests/{bugzillaChangeRequestId}";
    
        final UriBuilder builder = UriBuilder.fromUri(basePath);
        return builder.path(instanceURI).buildFromMap(pathParameters);
    }
    
    public static Link constructLinkForBugzillaChangeRequest(final String serviceProviderId, final String bugzillaChangeRequestId , final String label)
    {
        return new Link(constructURIForBugzillaChangeRequest(serviceProviderId, bugzillaChangeRequestId), label);
    }
    
    public static Link constructLinkForBugzillaChangeRequest(final String serviceProviderId, final String bugzillaChangeRequestId)
    {
        return new Link(constructURIForBugzillaChangeRequest(serviceProviderId, bugzillaChangeRequestId));
    }
    

}
