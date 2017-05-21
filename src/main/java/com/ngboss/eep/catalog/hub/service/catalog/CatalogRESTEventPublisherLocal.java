package com.ngboss.eep.catalog.hub.service.catalog;

import javax.ejb.Local;
import com.ngboss.eep.catalog.hub.model.catalog.CatalogEvent;
import com.ngboss.eep.hub.model.Hub;

@Local
public interface CatalogRESTEventPublisherLocal {

    public void publish(Hub hub, CatalogEvent event);

}
