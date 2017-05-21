package com.ngboss.eep.catalog.hub.service.resourceSpecification;

import javax.ejb.Local;
import com.ngboss.eep.catalog.hub.model.resourceSpecification.ResourceSpecificationEvent;
import com.ngboss.eep.hub.model.Hub;

/**
 *
 * @author bahman.barzideh
 *
 */
@Local
public interface ResourceSpecificationRESTEventPublisherLocal {

    public void publish(Hub hub, ResourceSpecificationEvent event);

}
