package com.ngboss.eep.catalog.hub.service.category;

import javax.ejb.Local;
import com.ngboss.eep.catalog.hub.model.category.CategoryEvent;
import com.ngboss.eep.hub.model.Hub;

/**
 *
 * @author bahman.barzideh
 *
 */
@Local
public interface CategoryRESTEventPublisherLocal {

    public void publish(Hub hub, CategoryEvent event);

}
