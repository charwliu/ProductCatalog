package com.ngboss.eep.catalog.model.specification;

import com.ngboss.eep.catalog.model.TimeRange;
import com.ngboss.eep.commons.Utilities;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author bahman.barzideh
 *
 * {
 *     "id": "13",
 *     "href": "http://serverlocation:port/catalogManagement/serviceSpecification/13",
 *     "name": "specification 1",
 *     "validFor": {
 *         "startDateTime": "2013-04-19T16:42:23-04:00",
 *         "endDateTime": ""
 *     }
 * }
 *
 */
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@Embeddable
public class RequiredSpecification implements Serializable {

    public final static long serialVersionUID = 1L;

    @Column(name = "ID")
    private String id;

    @Column(name = "HREF")
    private String href;

    @Column(name = "NAME")
    private String name;

    private TimeRange validFor;

    public RequiredSpecification() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TimeRange getValidFor() {
        return validFor;
    }

    public void setValidFor(TimeRange validFor) {
        this.validFor = validFor;
    }

    @JsonProperty(value = "validFor")
    public TimeRange validForToJson() {
        return (validFor != null && !validFor.isEmpty()) ? validFor : null;
    }

    @Override
    public int hashCode() {
        int hash = 7;

        hash = 97 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 97 * hash + (this.href != null ? this.href.hashCode() : 0);
        hash = 97 * hash + (this.name != null ? this.name.hashCode() : 0);
        hash = 97 * hash + (this.validFor != null ? this.validFor.hashCode() : 0);

        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        final RequiredSpecification other = (RequiredSpecification) object;
        if (!Utilities.areEqual(this.id, other.id)) {
            return false;
        }

        if (!Utilities.areEqual(this.href, other.href)) {
            return false;
        }

        if (!Utilities.areEqual(this.name, other.name)) {
            return false;
        }

        return Utilities.areEqual(this.validFor, other.validFor);
    }

    public static RequiredSpecification createProto() {
        RequiredSpecification requiredSpecification = new RequiredSpecification();

        requiredSpecification.id = "id";
        requiredSpecification.href = "href";
        requiredSpecification.name = "name";
        requiredSpecification.validFor = TimeRange.createProto();

        return requiredSpecification;
    }

}
