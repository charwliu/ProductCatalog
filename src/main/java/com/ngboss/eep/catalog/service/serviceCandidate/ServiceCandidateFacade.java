package com.ngboss.eep.catalog.service.serviceCandidate;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.ngboss.eep.catalog.entity.service.ServiceCandidateEntity;
import com.ngboss.eep.catalog.service.AbstractFacade;

/**
 *
 * @author bahman.barzideh
 *
 */
@Stateless
public class ServiceCandidateFacade extends AbstractFacade<ServiceCandidateEntity> {

    @PersistenceContext(unitName = "DSProductCatalogPU")
    private EntityManager entityManager;

    public ServiceCandidateFacade() {
        super(ServiceCandidateEntity.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }

}
