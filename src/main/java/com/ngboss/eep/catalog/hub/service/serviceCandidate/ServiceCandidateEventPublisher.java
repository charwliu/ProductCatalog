package com.ngboss.eep.catalog.hub.service.serviceCandidate;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.ngboss.eep.catalog.hub.model.serviceCandidate.ServiceCandidateEvent;
import com.ngboss.eep.catalog.hub.model.serviceCandidate.ServiceCandidateEventType;
import com.ngboss.eep.catalog.model.service.ServiceCandidate;
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
public class ServiceCandidateEventPublisher implements ServiceCandidateEventPublisherLocal {

    @EJB
    HubFacade hubFacade;

    @EJB
    ServiceCandidateEventFacade eventFacade;

    @EJB
    ServiceCandidateRESTEventPublisherLocal restEventPublisherLocal;

    @Override
    public synchronized void publish(ServiceCandidateEvent event) {
        try {
            eventFacade.create(event);
        } catch (BadUsageException ex) {
            Logger.getLogger(ServiceCandidateEventPublisher.class.getName()).log(Level.SEVERE, null, ex);
        }

        List<Hub> hubList = hubFacade.findAll();
        Iterator<Hub> it = hubList.iterator();
        while (it.hasNext()) {
            Hub hub = it.next();
            restEventPublisherLocal.publish(hub, event);
        }
    }

    @Override
    public void createNotification(ServiceCandidate bean, String reason, Date date) {
        if (date == null) {
            date = new Date();
        }

        ServiceCandidateEvent event = new ServiceCandidateEvent();
        event.setResource(bean);
        event.setEventTime(date);
        event.setEventType(ServiceCandidateEventType.ServiceCandidateCreationNotification);
        publish(event);

    }

    @Override
    public void deletionNotification(ServiceCandidate bean, String reason, Date date) {
        if (date == null) {
            date = new Date();
        }

        ServiceCandidateEvent event = new ServiceCandidateEvent();
        event.setResource(bean);
        event.setEventTime(date);

        event.setEventType(ServiceCandidateEventType.ServiceCandidateDeletionNotification);
        publish(event);
    }

    @Override
    public void updateNotification(ServiceCandidate bean, String reason, Date date) {
        if (date == null) {
            date = new Date();
        }

        ServiceCandidateEvent event = new ServiceCandidateEvent();
        event.setResource(bean);
        event.setEventTime(date);

        event.setEventType(ServiceCandidateEventType.ServiceCandidateUpdateNotification);
        publish(event);
    }

    @Override
    public void valueChangedNotification(ServiceCandidate bean, String reason, Date date) {
        if (date == null) {
            date = new Date();
        }

        ServiceCandidateEvent event = new ServiceCandidateEvent();
        event.setResource(bean);
        event.setEventTime(date);

        event.setEventType(ServiceCandidateEventType.ServiceCandidateValueChangeNotification);
        publish(event);
    }
}
