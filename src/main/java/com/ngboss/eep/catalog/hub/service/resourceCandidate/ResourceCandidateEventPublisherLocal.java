package com.ngboss.eep.catalog.hub.service.resourceCandidate;

import java.util.Date;
import javax.ejb.Local;

import com.ngboss.eep.catalog.hub.model.resourceCandidate.ResourceCandidateEvent;
import com.ngboss.eep.catalog.model.resource.ResourceCandidate;

/**
 *
 * @author bahman.barzideh
 *
 */
@Local
public interface ResourceCandidateEventPublisherLocal {

    void publish(ResourceCandidateEvent event);

    public void createNotification(ResourceCandidate bean, String reason, Date date);

    public void deletionNotification(ResourceCandidate bean, String reason, Date date);

    public void updateNotification(ResourceCandidate bean, String reason, Date date);

    public void valueChangedNotification(ResourceCandidate bean, String reason, Date date);
}
