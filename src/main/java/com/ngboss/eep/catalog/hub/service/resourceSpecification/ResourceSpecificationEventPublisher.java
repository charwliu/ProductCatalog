package com.ngboss.eep.catalog.hub.service.resourceSpecification;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.ngboss.eep.catalog.hub.model.resourceSpecification.ResourceSpecificationEventType;
import com.ngboss.eep.catalog.hub.model.resourceSpecification.ResourceSpecificationEvent;
import com.ngboss.eep.catalog.model.resource.ResourceSpecification;
import com.ngboss.eep.commons.exceptions.BadUsageException;
import com.ngboss.eep.hub.model.Hub;
import com.ngboss.eep.hub.service.HubFacade;

/**
 *
 * @author bahman.barzideh
 *
 */
@Stateless
//@Asynchronous
public class ResourceSpecificationEventPublisher implements ResourceSpecificationEventPublisherLocal {

    @EJB
    HubFacade hubFacade;

    @EJB
    ResourceSpecificationEventFacade eventFacade;

    @EJB
    ResourceSpecificationRESTEventPublisherLocal restEventPublisherLocal;

    @Override
    public synchronized void publish(ResourceSpecificationEvent event) {
        try {
            eventFacade.create(event);
        } catch (BadUsageException ex) {
            Logger.getLogger(ResourceSpecificationEventPublisher.class.getName()).log(Level.SEVERE, null, ex);
        }

        List<Hub> hubList = hubFacade.findAll();
        Iterator<Hub> it = hubList.iterator();
        while (it.hasNext()) {
            Hub hub = it.next();
            restEventPublisherLocal.publish(hub, event);
        }
    }

    @Override
    public void createNotification(ResourceSpecification bean, String reason, Date date) {
        if (date == null) {
            date = new Date();
        }

        ResourceSpecificationEvent event = new ResourceSpecificationEvent();
        event.setResource(bean);
        event.setEventTime(date);
        event.setEventType(ResourceSpecificationEventType.ResourceSpecificationCreationNotification);
        publish(event);

    }

    @Override
    public void deletionNotification(ResourceSpecification bean, String reason, Date date) {
        if (date == null) {
            date = new Date();
        }

        ResourceSpecificationEvent event = new ResourceSpecificationEvent();
        event.setResource(bean);
        event.setEventTime(date);

        event.setEventType(ResourceSpecificationEventType.ResourceSpecificationDeletionNotification);
        publish(event);
    }

    @Override
    public void updateNotification(ResourceSpecification bean, String reason, Date date) {
        if (date == null) {
            date = new Date();
        }

        ResourceSpecificationEvent event = new ResourceSpecificationEvent();
        event.setResource(bean);
        event.setEventTime(date);

        event.setEventType(ResourceSpecificationEventType.ResourceSpecificationUpdateNotification);
        publish(event);
    }

    @Override
    public void valueChangedNotification(ResourceSpecification bean, String reason, Date date) {
        if (date == null) {
            date = new Date();
        }

        ResourceSpecificationEvent event = new ResourceSpecificationEvent();
        event.setResource(bean);
        event.setEventTime(date);

        event.setEventType(ResourceSpecificationEventType.ResourceSpecificationValueChangeNotification);
        publish(event);
    }
}
