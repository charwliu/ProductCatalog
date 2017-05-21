package com.ngboss.eep.catalog.hub.service.serviceSpecification;

import java.util.Date;
import javax.ejb.Local;
import com.ngboss.eep.catalog.hub.model.serviceSpecification.ServiceSpecificationEvent;
import com.ngboss.eep.catalog.model.service.ServiceSpecification;

/**
 *
 * @author bahman.barzideh
 *
 */
@Local
public interface ServiceSpecificationEventPublisherLocal {

    void publish(ServiceSpecificationEvent event);

    public void createNotification(ServiceSpecification bean, String reason, Date date);

    public void deletionNotification(ServiceSpecification bean, String reason, Date date);

    public void updateNotification(ServiceSpecification bean, String reason, Date date);

    public void valueChangedNotification(ServiceSpecification bean, String reason, Date date);
}
