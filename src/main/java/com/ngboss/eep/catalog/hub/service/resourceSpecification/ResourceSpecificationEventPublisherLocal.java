package com.ngboss.eep.catalog.hub.service.resourceSpecification;

import java.util.Date;
import javax.ejb.Local;

import com.ngboss.eep.catalog.model.resource.ResourceSpecification;
import com.ngboss.eep.catalog.hub.model.resourceSpecification.ResourceSpecificationEvent;

/**
 *
 * @author bahman.barzideh
 *
 */
@Local
public interface ResourceSpecificationEventPublisherLocal {

    void publish(ResourceSpecificationEvent event);

    public void createNotification(ResourceSpecification bean, String reason, Date date);

    public void deletionNotification(ResourceSpecification bean, String reason, Date date);

    public void updateNotification(ResourceSpecification bean, String reason, Date date);

    public void valueChangedNotification(ResourceSpecification bean, String reason, Date date);
}
