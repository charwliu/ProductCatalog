package com.ngboss.eep.catalog.hub.service.resourceCandidate;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.ngboss.eep.catalog.hub.model.resourceCandidate.ResourceCandidateEvent;
import com.ngboss.eep.commons.facade.AbstractFacade;

/**
 *
 * @author bahman.barzideh
 *
 */
@Stateless
public class ResourceCandidateEventFacade extends AbstractFacade<ResourceCandidateEvent> {

    @PersistenceContext(unitName = "DSProductCatalogPU")
    private EntityManager entityManager;

    public ResourceCandidateEventFacade() {
        super(ResourceCandidateEvent.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }

}
