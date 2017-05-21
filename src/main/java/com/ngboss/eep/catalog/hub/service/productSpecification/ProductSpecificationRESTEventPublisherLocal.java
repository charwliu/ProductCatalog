package com.ngboss.eep.catalog.hub.service.productSpecification;

import javax.ejb.Local;

import com.ngboss.eep.catalog.hub.model.productSpecification.ProductSpecificationEvent;
import com.ngboss.eep.hub.model.Hub;

/**
 *
 * @author bahman.barzideh
 *
 */
@Local
public interface ProductSpecificationRESTEventPublisherLocal {

    public void publish(Hub hub, ProductSpecificationEvent event);

}
