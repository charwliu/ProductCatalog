package com.ngboss.eep.catalog.hub.service.resourceSpecification;

import java.util.List;
import java.util.Set;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.core.MultivaluedMap;

import com.ngboss.eep.commons.utils.Jackson;
import com.ngboss.eep.commons.utils.URIParser;
import com.ngboss.eep.hub.model.Hub;
import org.codehaus.jackson.node.ObjectNode;
import com.ngboss.eep.catalog.hub.model.resourceSpecification.ResourceSpecificationEvent;
import com.ngboss.eep.hub.service.RESTClient;

@Stateless
public class ResourceSpecificationRESTEventPublisher implements ResourceSpecificationRESTEventPublisherLocal {

    @EJB
    ResourceSpecificationEventFacade eventFacade;

    @EJB
    RESTClient client;

    @Override
    public void publish(Hub hub, ResourceSpecificationEvent event) {

        MultivaluedMap<String, String> query = URIParser.getParameters(hub.getQuery());
        query.putSingle("id", event.getId());

        // fields to filter view
        Set<String> fieldSet = URIParser.getFieldsSelection(query);

        List<ResourceSpecificationEvent> resultList = null;
        resultList = eventFacade.findByCriteria(query, ResourceSpecificationEvent.class);

        if (resultList != null && !resultList.isEmpty()) {
            if (!fieldSet.isEmpty() && !fieldSet.contains(URIParser.ALL_FIELDS)) {
                fieldSet.add("id");
                fieldSet.add("date");
                fieldSet.add("eventType");
                fieldSet.add("reason");
                ObjectNode rootNode = Jackson.createNode(event, fieldSet);
                client.publishEvent(hub.getCallback(), rootNode);
            } else {
                client.publishEvent(hub.getCallback(), event);
            }

        }
    }

}
