package com.ngboss.eep.catalog.service.category;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.ngboss.eep.catalog.entity.category.CategoryEntity;
import com.ngboss.eep.catalog.service.AbstractFacade;

/**
 *
 * @author bahman.barzideh
 *
 */
@Stateless
public class CategoryFacade extends AbstractFacade<CategoryEntity> {

    @PersistenceContext(unitName = "DSProductCatalogPU")
    private EntityManager entityManager;

    public CategoryFacade() {
        super(CategoryEntity.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }

}
