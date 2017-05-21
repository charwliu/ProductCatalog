package com.ngboss.eep.catalog.model.resource;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Embeddable;

import com.ngboss.eep.catalog.model.TimeRange;
import com.ngboss.eep.catalog.model.specification.SpecificationCharacteristicValue;
import com.ngboss.eep.commons.Utilities;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import com.ngboss.eep.catalog.model.specification.CharacteristicValueType;
import com.ngboss.eep.catalog.model.specification.SpecificationCharacteristicRelationship;

/**
 *
 * @author bahman.barzideh
 *
 * {
 *     "id": "54",
 *     "name": "Screen Size",
 *     "description": "Screen size",
 *     "validFor": {
 *         "startDateTime": "2013-04-19T16:42:23-04:00",
 *         "endDateTime": ""
 *     },
 *     "valueType": "number",
 *     "configurable": "false",
 *     "resourceSpecCharRelationship": [
 *         {
 *             "type": "dependency",
 *             "id": "43",
 *             "validFor": {
 *                 "startDateTime": "2013-04-19T16:42:23-04:00",
 *                 "endDateTime": ""
 *             }
 *         }
 *     ],
 *     "resourceSpecCharacteristicValue": [
 *         {
 *             "valueType": "number",
 *             "default": "true",
 *             "value": "4.2",
 *             "unitOfMeasure": "inches",
 *             "valueFrom": "",
 *             "valueTo": "",
 *             "validFor": {
 *                 "startDateTime": "2013-04-19T16:42:23-04:00",
 *                 "endDateTime": ""
 *             }
 *         }
 *     ]
 * }
 *
 */
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@Embeddable
public class ResourceSpecCharacteristic implements Serializable {

    public final static long serialVersionUID = 1L;

    private String id;
    private String name;
    private String description;
    private TimeRange validFor;
    private CharacteristicValueType valueType;
    private Boolean configurable;
    private List<SpecificationCharacteristicRelationship> resourceSpecCharRelationship;
    private List<SpecificationCharacteristicValue> resourceSpecCharacteristicValue;

    public ResourceSpecCharacteristic() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TimeRange getValidFor() {
        return validFor;
    }

    public void setValidFor(TimeRange validFor) {
        this.validFor = validFor;
    }

    public CharacteristicValueType getValueType() {
        return valueType;
    }

    public void setValueType(CharacteristicValueType valueType) {
        this.valueType = valueType;
    }

    public Boolean getConfigurable() {
        return configurable;
    }

    public void setConfigurable(Boolean configurable) {
        this.configurable = configurable;
    }

    public List<SpecificationCharacteristicRelationship> getResourceSpecCharRelationship() {
        return resourceSpecCharRelationship;
    }

    public void setResourceSpecCharRelationship(List<SpecificationCharacteristicRelationship> resourceSpecCharRelationship) {
        this.resourceSpecCharRelationship = resourceSpecCharRelationship;
    }

    public List<SpecificationCharacteristicValue> getResourceSpecCharacteristicValue() {
        return resourceSpecCharacteristicValue;
    }

    public void setResourceSpecCharacteristicValue(List<SpecificationCharacteristicValue> resourceSpecCharacteristicValue) {
        this.resourceSpecCharacteristicValue = resourceSpecCharacteristicValue;
    }

    @JsonProperty(value = "validFor")
    public TimeRange validForToJson() {
        return (validFor != null && validFor.isEmpty() == false) ? validFor : null;
    }

    @JsonProperty(value = "resourceSpecCharRelationship")
    public List<SpecificationCharacteristicRelationship> resourceSpecCharRelationshipToJson() {
        return (resourceSpecCharRelationship != null && resourceSpecCharRelationship.size() > 0) ? resourceSpecCharRelationship : null;
    }

    @JsonProperty(value = "resourceSpecCharacteristicValue")
    public List<SpecificationCharacteristicValue> resourceSpecCharacteristicValueToJson() {
        return (resourceSpecCharacteristicValue != null && resourceSpecCharacteristicValue.size() > 0) ? resourceSpecCharacteristicValue : null;
    }

    @Override
    public int hashCode() {
        int hash = 7;

        hash = 71 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 71 * hash + (this.name != null ? this.name.hashCode() : 0);
        hash = 71 * hash + (this.description != null ? this.description.hashCode() : 0);
        hash = 71 * hash + (this.valueType != null ? this.valueType.hashCode() : 0);
        hash = 71 * hash + (this.configurable != null ? this.configurable.hashCode() : 0);
        hash = 71 * hash + (this.validFor != null ? this.validFor.hashCode() : 0);
        hash = 71 * hash + (this.resourceSpecCharRelationship != null ? this.resourceSpecCharRelationship.hashCode() : 0);
        hash = 71 * hash + (this.resourceSpecCharacteristicValue != null ? this.resourceSpecCharacteristicValue.hashCode() : 0);

        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        final ResourceSpecCharacteristic other = (ResourceSpecCharacteristic) object;
        if (Utilities.areEqual(this.id, other.id) == false) {
            return false;
        }

        if (Utilities.areEqual(this.name, other.name) == false) {
            return false;
        }

        if (Utilities.areEqual(this.description, other.description) == false) {
            return false;
        }

        if (this.valueType != other.valueType) {
            return false;
        }

        if (Utilities.areEqual(this.configurable, other.configurable) == false) {
            return false;
        }

        if (Utilities.areEqual(this.validFor, other.validFor) == false) {
            return false;
        }

        if (Utilities.areEqual(this.resourceSpecCharRelationship, other.resourceSpecCharRelationship) == false) {
            return false;
        }

        return Utilities.areEqual(this.resourceSpecCharacteristicValue, other.resourceSpecCharacteristicValue) != false;
    }

    @Override
    public String toString() {
        return "ResourceSpecCharacteristic{" + "id=" + id + ", name=" + name + ", description=" + description + ", validFor=" + validFor + ", valueType=" + valueType + ", configurable=" + configurable + ", resourceSpecCharRelationship=" + resourceSpecCharRelationship + ", resourceSpecCharacteristicValue=" + resourceSpecCharacteristicValue + '}';
    }

    @JsonIgnore
    public boolean isValid() {
        return validateCharacteristicValues() != false;
    }

    private boolean validateCharacteristicValues() {
        if (Utilities.hasContents(this.resourceSpecCharacteristicValue) == false) {
            return true;
        }

        int defaultCount = 0;
        defaultCount = this.resourceSpecCharacteristicValue.stream().filter((characteristicValue) -> 
                (Objects.equals(characteristicValue.getDefaultValue(), Boolean.TRUE))).map((_item) -> 1).reduce(defaultCount, Integer::sum);

        return defaultCount <= 1;
    }

    public static ResourceSpecCharacteristic createProto() {
        ResourceSpecCharacteristic resourceSpecCharacteristic = new ResourceSpecCharacteristic();

        resourceSpecCharacteristic.id = "id";
        resourceSpecCharacteristic.name = "name";
        resourceSpecCharacteristic.description = "description";
        resourceSpecCharacteristic.valueType = CharacteristicValueType.NUMBER;
        resourceSpecCharacteristic.configurable = true;
        resourceSpecCharacteristic.validFor = TimeRange.createProto();

        resourceSpecCharacteristic.resourceSpecCharRelationship = new ArrayList<>();
        resourceSpecCharacteristic.resourceSpecCharRelationship.add(SpecificationCharacteristicRelationship.createProto());

        resourceSpecCharacteristic.resourceSpecCharacteristicValue = new ArrayList<>();
        resourceSpecCharacteristic.resourceSpecCharacteristicValue.add(SpecificationCharacteristicValue.createProto());

        return resourceSpecCharacteristic;
    }

}
