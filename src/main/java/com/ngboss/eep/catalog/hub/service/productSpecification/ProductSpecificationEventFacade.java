package com.ngboss.eep.catalog.hub.service.productSpecification;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.ngboss.eep.commons.facade.AbstractFacade;
import com.ngboss.eep.catalog.hub.model.productSpecification.ProductSpecificationEvent;

/**
 *
 * @author bahman.barzideh
 *
 */
@Stateless
public class ProductSpecificationEventFacade extends AbstractFacade<ProductSpecificationEvent> {

    @PersistenceContext(unitName = "DSProductCatalogPU")
    private EntityManager entityManager;

    public ProductSpecificationEventFacade() {
        super(ProductSpecificationEvent.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }

}
