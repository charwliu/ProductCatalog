package com.ngboss.eep.catalog.hub.service.serviceCandidate;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.ngboss.eep.catalog.hub.model.serviceCandidate.ServiceCandidateEvent;
import com.ngboss.eep.commons.facade.AbstractFacade;

/**
 *
 * @author bahman.barzideh
 *
 */
@Stateless
public class ServiceCandidateEventFacade extends AbstractFacade<ServiceCandidateEvent> {

    @PersistenceContext(unitName = "DSProductCatalogPU")
    private EntityManager entityManager;

    public ServiceCandidateEventFacade() {
        super(ServiceCandidateEvent.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }

}
