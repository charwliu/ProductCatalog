package com.ngboss.eep.catalog.hub.service.productOffering;

import javax.ejb.Local;

import com.ngboss.eep.hub.model.Hub;
import com.ngboss.eep.catalog.hub.model.productOffering.ProductOfferingEvent;

/**
 *
 * @author bahman.barzideh
 *
 */
@Local
public interface ProductOfferingRESTEventPublisherLocal {

    public void publish(Hub hub, ProductOfferingEvent event);

}
