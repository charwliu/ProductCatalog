package com.ngboss.eep.catalog.service.serviceSpecification;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.ngboss.eep.catalog.service.AbstractFacade;
import com.ngboss.eep.catalog.entity.service.ServiceSpecificationEntity;

/**
 *
 * @author bahman.barzideh
 *
 */
@Stateless
public class ServiceSpecificationFacade extends AbstractFacade<ServiceSpecificationEntity> {

    @PersistenceContext(unitName = "DSProductCatalogPU")
    private EntityManager entityManager;

    public ServiceSpecificationFacade() {
        super(ServiceSpecificationEntity.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }

}
