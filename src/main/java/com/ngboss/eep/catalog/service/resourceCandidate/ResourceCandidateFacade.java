package com.ngboss.eep.catalog.service.resourceCandidate;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.ngboss.eep.catalog.entity.resource.ResourceCandidateEntity;
import com.ngboss.eep.catalog.service.AbstractFacade;

/**
 *
 * @author bahman.barzideh
 *
 */
@Stateless
public class ResourceCandidateFacade extends AbstractFacade<ResourceCandidateEntity> {

    @PersistenceContext(unitName = "DSProductCatalogPU")
    private EntityManager entityManager;

    public ResourceCandidateFacade() {
        super(ResourceCandidateEntity.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }

}
