package com.ngboss.eep.catalog.model.specification;

import com.ngboss.eep.catalog.model.TimeRange;
import com.ngboss.eep.commons.Utilities;
import org.codehaus.jackson.annotate.JsonIgnore;
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
 *     "id": "23",
 *     "href": " http://serverlocation:port/catalogManagement/resourceSpecification/23",
 *     "validFor": {
 *         "startDateTime": "2013-04-19T16:42:23-04:00",
 *         "endDateTime": ""
 *     },
 *     "type": "dependency"
 * }
 *
 */
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@Embeddable
public class SpecificationRelationship implements Serializable {

    public final static long serialVersionUID = 1L;

    @Column(name = "ID", nullable = false)
    private String id;

    @Column(name = "HREF")
    private String href;

    private TimeRange validFor;

    @Column(name = "TYPE")
    private SpecificationRelationshipType type;

    public SpecificationRelationship() {
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

    public TimeRange getValidFor() {
        return validFor;
    }

    public void setValidFor(TimeRange validFor) {
        this.validFor = validFor;
    }

    public SpecificationRelationshipType getType() {
        return type;
    }

    public void setType(SpecificationRelationshipType type) {
        this.type = type;
    }

    @JsonProperty(value = "validFor")
    public TimeRange validForToJson() {
        return (validFor != null && !validFor.isEmpty()) ? validFor : null;
    }

    @Override
    public int hashCode() {
        int hash = 3;

        hash = 79 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 79 * hash + (this.href != null ? this.href.hashCode() : 0);
        hash = 79 * hash + (this.validFor != null ? this.validFor.hashCode() : 0);
        hash = 79 * hash + (this.type != null ? this.type.hashCode() : 0);

        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        final SpecificationRelationship other = (SpecificationRelationship) object;
        if (!Utilities.areEqual(this.id, other.id)) {
            return false;
        }

        if (!Utilities.areEqual(this.href, other.href)) {
            return false;
        }

        if (!Utilities.areEqual(this.validFor, other.validFor)) {
            return false;
        }

        return this.type == other.type;
    }

    @Override
    public String toString() {
        return "SpecificationRelationship{" + "id=" + id + ", href=" + href + ", validFor=" + validFor + ", type=" + type + '}';
    }

    @JsonIgnore
    public boolean isValid() {
        return true;
    }

    public static SpecificationRelationship createProto() {
        SpecificationRelationship specificationRelationship = new SpecificationRelationship();

        specificationRelationship.id = "id";
        specificationRelationship.href = "href";
        specificationRelationship.validFor = TimeRange.createProto();
        specificationRelationship.type = SpecificationRelationshipType.DEPENDENCY;

        return specificationRelationship;
    }

}
