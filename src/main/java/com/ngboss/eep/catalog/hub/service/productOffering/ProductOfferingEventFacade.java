package com.ngboss.eep.catalog.hub.service.productOffering;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.ngboss.eep.commons.facade.AbstractFacade;
import com.ngboss.eep.catalog.hub.model.productOffering.ProductOfferingEvent;

/**
 *
 * @author bahman.barzideh
 *
 */
@Stateless
public class ProductOfferingEventFacade extends AbstractFacade<ProductOfferingEvent> {

    @PersistenceContext(unitName = "DSProductCatalogPU")
    private EntityManager entityManager;

    public ProductOfferingEventFacade() {
        super(ProductOfferingEvent.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }

}
