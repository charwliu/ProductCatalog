package com.ngboss.eep.catalog.hub.service.resourceCandidate;

import javax.ejb.Local;

import com.ngboss.eep.catalog.hub.model.resourceCandidate.ResourceCandidateEvent;
import com.ngboss.eep.hub.model.Hub;

/**
 *
 * @author bahman.barzideh
 *
 */
@Local
public interface ResourceCandidateRESTEventPublisherLocal {

    public void publish(Hub hub, ResourceCandidateEvent event);

}
