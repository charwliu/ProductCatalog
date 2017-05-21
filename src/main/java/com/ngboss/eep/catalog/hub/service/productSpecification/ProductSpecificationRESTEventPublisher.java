package com.ngboss.eep.catalog.hub.service.productSpecification;

import java.util.List;
import java.util.Set;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.core.MultivaluedMap;

import com.ngboss.eep.commons.utils.Jackson;
import com.ngboss.eep.commons.utils.URIParser;
import org.codehaus.jackson.node.ObjectNode;
import com.ngboss.eep.catalog.hub.model.productSpecification.ProductSpecificationEvent;
import com.ngboss.eep.hub.model.Hub;
import com.ngboss.eep.hub.service.RESTClient;

@Stateless
public class ProductSpecificationRESTEventPublisher implements ProductSpecificationRESTEventPublisherLocal {

    @EJB
    ProductSpecificationEventFacade eventFacade;

    @EJB
    RESTClient client;

    @Override
    public void publish(Hub hub, ProductSpecificationEvent event) {

        MultivaluedMap<String, String> query = URIParser.getParameters(hub.getQuery());
        query.putSingle("id", event.getId());

        // fields to filter view
        Set<String> fieldSet = URIParser.getFieldsSelection(query);

        List<ProductSpecificationEvent> resultList;
        resultList = eventFacade.findByCriteria(query, ProductSpecificationEvent.class);

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
