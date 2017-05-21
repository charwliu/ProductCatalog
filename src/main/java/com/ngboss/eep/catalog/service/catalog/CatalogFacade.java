package com.ngboss.eep.catalog.service.catalog;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.ngboss.eep.catalog.entity.catalog.CatalogEntity;
import com.ngboss.eep.catalog.service.AbstractFacade;

/**
 *
 * @author bahman.barzideh
 *
 */
@Stateless
public class CatalogFacade extends AbstractFacade<CatalogEntity> {

    @PersistenceContext(unitName = "DSProductCatalogPU")
    private EntityManager entityManager;

    public CatalogFacade() {
        super(CatalogEntity.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }

}
