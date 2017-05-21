package com.ngboss.eep.catalog.hub.model.serviceSpecification;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

import com.ngboss.eep.catalog.model.service.ServiceSpecification;
import com.ngboss.eep.commons.utils.CustomJsonDateSerializer;
import org.codehaus.jackson.annotate.JsonAutoDetect;
import static org.codehaus.jackson.annotate.JsonAutoDetect.Visibility.ANY;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 *
 * @author bahman.barzideh
 *
 */
@XmlRootElement
@Entity
@Table(name = "EVENT_SERVICE_SPECIFICATION")
@JsonPropertyOrder(value = {"event", "reason", "date", "eventType"})
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class ServiceSpecificationEvent implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "EVENT_ID", scale = 0)
    @JsonIgnore
    private String id;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonSerialize(using = CustomJsonDateSerializer.class)
    private Date eventTime;

    @JsonIgnore
    private ServiceSpecification resource;

    @Enumerated(value = EnumType.STRING)
    private ServiceSpecificationEventType eventType;

    @JsonAutoDetect(fieldVisibility = ANY)
    class EventBody {

        private final ServiceSpecification serviceSpecification;

        public EventBody(ServiceSpecification serviceSpecification) {
            this.serviceSpecification = serviceSpecification;
        }

        public ServiceSpecification getServiceSpecification() {
            return serviceSpecification;
        }
    }

    @JsonProperty("event")
    public EventBody getEvent() {
        return new EventBody(getResource());
    }

    public String getEventId() {
        return id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ServiceSpecificationEventType getEventType() {
        return eventType;
    }

    public void setEventType(ServiceSpecificationEventType eventType) {
        this.eventType = eventType;
    }

    public Date getEventTime() {
        return eventTime;
    }

    public void setEventTime(Date eventTime) {
        this.eventTime = eventTime;
    }

    public ServiceSpecification getResource() {
        return resource;
    }

    public void setResource(ServiceSpecification resource) {
        this.resource = resource;
    }

    @Override
    public String toString() {
        return "ServiceSpecificationEvent{" + "id=" + id + ", eventTime=" + eventTime + ", model=" + resource + ", eventType=" + eventType + '}';
    }
}
