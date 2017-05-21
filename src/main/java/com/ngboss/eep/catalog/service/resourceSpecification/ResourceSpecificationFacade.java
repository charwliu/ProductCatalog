package com.ngboss.eep.catalog.service.resourceSpecification;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.ngboss.eep.catalog.entity.resource.ResourceSpecificationEntity;
import com.ngboss.eep.catalog.service.AbstractFacade;

/**
 *
 * @author bahman.barzideh
 *
 */
@Stateless
public class ResourceSpecificationFacade extends AbstractFacade<ResourceSpecificationEntity> {

    @PersistenceContext(unitName = "DSProductCatalogPU")
    private EntityManager entityManager;

    public ResourceSpecificationFacade() {
        super(ResourceSpecificationEntity.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }

}
