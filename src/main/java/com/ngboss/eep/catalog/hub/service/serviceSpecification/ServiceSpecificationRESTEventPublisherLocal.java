package com.ngboss.eep.catalog.hub.service.serviceSpecification;

import javax.ejb.Local;
import com.ngboss.eep.catalog.hub.model.serviceSpecification.ServiceSpecificationEvent;
import com.ngboss.eep.hub.model.Hub;

/**
 *
 * @author bahman.barzideh
 *
 */
@Local
public interface ServiceSpecificationRESTEventPublisherLocal {

    public void publish(Hub hub, ServiceSpecificationEvent event);

}
