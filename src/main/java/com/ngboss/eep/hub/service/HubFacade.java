package com.ngboss.eep.hub.service;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.ngboss.eep.hub.model.Hub;
import com.ngboss.eep.commons.facade.AbstractFacade;

@Stateless
public class HubFacade extends AbstractFacade<Hub> {

    @PersistenceContext(unitName = "DSProductCatalogPU")
    private EntityManager em;

    /**
     *
     */
    public HubFacade() {
        super(Hub.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
