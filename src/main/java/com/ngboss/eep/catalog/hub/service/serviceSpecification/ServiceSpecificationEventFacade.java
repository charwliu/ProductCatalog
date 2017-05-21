package com.ngboss.eep.catalog.hub.service.serviceSpecification;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.ngboss.eep.catalog.hub.model.serviceSpecification.ServiceSpecificationEvent;
import com.ngboss.eep.commons.facade.AbstractFacade;

/**
 *
 * @author bahman.barzideh
 *
 */
@Stateless
public class ServiceSpecificationEventFacade extends AbstractFacade<ServiceSpecificationEvent> {

    @PersistenceContext(unitName = "DSProductCatalogPU")
    private EntityManager entityManager;

    public ServiceSpecificationEventFacade() {
        super(ServiceSpecificationEvent.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }

}
