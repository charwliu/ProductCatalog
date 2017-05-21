package com.ngboss.eep.catalog.hub.service.resourceCandidate;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.ngboss.eep.catalog.hub.model.resourceCandidate.ResourceCandidateEventType;
import com.ngboss.eep.commons.exceptions.BadUsageException;
import com.ngboss.eep.catalog.hub.model.resourceCandidate.ResourceCandidateEvent;
import com.ngboss.eep.catalog.model.resource.ResourceCandidate;
import com.ngboss.eep.hub.model.Hub;
import com.ngboss.eep.hub.service.HubFacade;

/**
 *
 * @author bahman.barzideh
 *
 */
@Stateless
//@Asynchronous
public class ResourceCandidateEventPublisher implements ResourceCandidateEventPublisherLocal {

    @EJB
    HubFacade hubFacade;

    @EJB
    ResourceCandidateEventFacade eventFacade;

    @EJB
    ResourceCandidateRESTEventPublisherLocal restEventPublisherLocal;

    @Override
    public synchronized void publish(ResourceCandidateEvent event) {
        try {
            eventFacade.create(event);
        } catch (BadUsageException ex) {
            Logger.getLogger(ResourceCandidateEventPublisher.class.getName()).log(Level.SEVERE, null, ex);
        }

        List<Hub> hubList = hubFacade.findAll();
        Iterator<Hub> it = hubList.iterator();
        while (it.hasNext()) {
            Hub hub = it.next();
            restEventPublisherLocal.publish(hub, event);
        }
    }

    @Override
    public void createNotification(ResourceCandidate bean, String reason, Date date) {
        if (date == null) {
            date = new Date();
        }

        ResourceCandidateEvent event = new ResourceCandidateEvent();
        event.setResource(bean);
        event.setEventTime(date);
        event.setEventType(ResourceCandidateEventType.ResourceCandidateCreationNotification);
        publish(event);

    }

    @Override
    public void deletionNotification(ResourceCandidate bean, String reason, Date date) {
        if (date == null) {
            date = new Date();
        }

        ResourceCandidateEvent event = new ResourceCandidateEvent();
        event.setResource(bean);
        event.setEventTime(date);

        event.setEventType(ResourceCandidateEventType.ResourceCandidateDeletionNotification);
        publish(event);
    }

    @Override
    public void updateNotification(ResourceCandidate bean, String reason, Date date) {
        if (date == null) {
            date = new Date();
        }

        ResourceCandidateEvent event = new ResourceCandidateEvent();
        event.setResource(bean);
        event.setEventTime(date);

        event.setEventType(ResourceCandidateEventType.ResourceCandidateUpdateNotification);
        publish(event);
    }

    @Override
    public void valueChangedNotification(ResourceCandidate bean, String reason, Date date) {
        if (date == null) {
            date = new Date();
        }

        ResourceCandidateEvent event = new ResourceCandidateEvent();
        event.setResource(bean);
        event.setEventTime(date);

        event.setEventType(ResourceCandidateEventType.ResourceCandidateValueChangeNotification);
        publish(event);
    }
}
