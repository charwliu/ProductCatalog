package com.ngboss.eep.catalog.service.productOffering;

import com.ngboss.eep.catalog.entity.product.ProductOfferingEntity;
import com.ngboss.eep.catalog.service.AbstractFacade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author pierregauthier
 *
 */
@Stateless
public class ProductOfferingFacade extends AbstractFacade<ProductOfferingEntity> {

    @PersistenceContext(unitName = "DSProductCatalogPU")
    private EntityManager entityManager;

    public ProductOfferingFacade() {
        super(ProductOfferingEntity.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }

}
