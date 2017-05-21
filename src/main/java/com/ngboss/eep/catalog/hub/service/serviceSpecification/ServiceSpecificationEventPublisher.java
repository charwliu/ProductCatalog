package com.ngboss.eep.catalog.hub.service.serviceSpecification;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.ngboss.eep.catalog.hub.model.serviceSpecification.ServiceSpecificationEvent;
import com.ngboss.eep.catalog.model.service.ServiceSpecification;
import com.ngboss.eep.commons.exceptions.BadUsageException;
import com.ngboss.eep.hub.service.HubFacade;
import com.ngboss.eep.catalog.hub.model.serviceSpecification.ServiceSpecificationEventType;
import com.ngboss.eep.hub.model.Hub;

/**
 *
 * @author bahman.barzideh
 *
 */
@Stateless
//@Asynchronous
public class ServiceSpecificationEventPublisher implements ServiceSpecificationEventPublisherLocal {

    @EJB
    HubFacade hubFacade;

    @EJB
    ServiceSpecificationEventFacade eventFacade;

    @EJB
    ServiceSpecificationRESTEventPublisherLocal restEventPublisherLocal;

    @Override
    public synchronized void publish(ServiceSpecificationEvent event) {
        try {
            eventFacade.create(event);
        } catch (BadUsageException ex) {
            Logger.getLogger(ServiceSpecificationEventPublisher.class.getName()).log(Level.SEVERE, null, ex);
        }

        List<Hub> hubList = hubFacade.findAll();
        Iterator<Hub> it = hubList.iterator();
        while (it.hasNext()) {
            Hub hub = it.next();
            restEventPublisherLocal.publish(hub, event);
        }
    }

    @Override
    public void createNotification(ServiceSpecification bean, String reason, Date date) {
        if (date == null) {
            date = new Date();
        }

        ServiceSpecificationEvent event = new ServiceSpecificationEvent();
        event.setResource(bean);
        event.setEventTime(date);
        event.setEventType(ServiceSpecificationEventType.ServiceSpecificationCreationNotification);
        publish(event);

    }

    @Override
    public void deletionNotification(ServiceSpecification bean, String reason, Date date) {
        if (date == null) {
            date = new Date();
        }

        ServiceSpecificationEvent event = new ServiceSpecificationEvent();
        event.setResource(bean);
        event.setEventTime(date);

        event.setEventType(ServiceSpecificationEventType.ServiceSpecificationDeletionNotification);
        publish(event);
    }

    @Override
    public void updateNotification(ServiceSpecification bean, String reason, Date date) {
        if (date == null) {
            date = new Date();
        }

        ServiceSpecificationEvent event = new ServiceSpecificationEvent();
        event.setResource(bean);
        event.setEventTime(date);

        event.setEventType(ServiceSpecificationEventType.ServiceSpecificationUpdateNotification);
        publish(event);
    }

    @Override
    public void valueChangedNotification(ServiceSpecification bean, String reason, Date date) {
        if (date == null) {
            date = new Date();
        }

        ServiceSpecificationEvent event = new ServiceSpecificationEvent();
        event.setResource(bean);
        event.setEventTime(date);

        event.setEventType(ServiceSpecificationEventType.ServiceSpecificationValueChangeNotification);
        publish(event);
    }
}
