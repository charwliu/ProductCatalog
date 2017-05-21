package com.ngboss.eep.catalog.service.productSpecification;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.ngboss.eep.catalog.entity.product.ProductSpecificationEntity;
import com.ngboss.eep.catalog.service.AbstractFacade;

/**
 *
 * @author pierregauthier
 *
 */
@Stateless
public class ProductSpecificationFacade extends AbstractFacade<ProductSpecificationEntity> {

    @PersistenceContext(unitName = "DSProductCatalogPU")
    private EntityManager entityManager;

    public ProductSpecificationFacade() {
        super(ProductSpecificationEntity.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }

}
