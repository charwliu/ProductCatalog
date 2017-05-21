package com.ngboss.eep.catalog.hub.service.serviceCandidate;

import javax.ejb.Local;
import com.ngboss.eep.catalog.hub.model.serviceCandidate.ServiceCandidateEvent;
import com.ngboss.eep.hub.model.Hub;

/**
 *
 * @author bahman.barzideh
 *
 */
@Local
public interface ServiceCandidateRESTEventPublisherLocal {

    public void publish(Hub hub, ServiceCandidateEvent event);

}
