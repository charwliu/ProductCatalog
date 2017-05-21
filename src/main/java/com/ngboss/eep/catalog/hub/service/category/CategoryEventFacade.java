package com.ngboss.eep.catalog.hub.service.category;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.ngboss.eep.catalog.hub.model.category.CategoryEvent;
import com.ngboss.eep.commons.facade.AbstractFacade;

/**
 *
 * @author bahman.barzideh
 *
 */
@Stateless
public class CategoryEventFacade extends AbstractFacade<CategoryEvent> {

    @PersistenceContext(unitName = "DSProductCatalogPU")
    private EntityManager entityManager;

    public CategoryEventFacade() {
        super(CategoryEvent.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }

}
