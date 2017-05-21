package com.ngboss.eep.catalog.model.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Embeddable;

import com.ngboss.eep.catalog.model.TimeRange;
import com.ngboss.eep.catalog.model.specification.CharacteristicValueType;
import com.ngboss.eep.catalog.model.specification.SpecificationCharacteristicRelationship;
import com.ngboss.eep.catalog.model.specification.SpecificationCharacteristicValue;
import com.ngboss.eep.commons.Utilities;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * @author bahman.barzideh
 *         <p>
 *         {
 *         "id": "34",
 *         "name": "Screen Size",
 *         "description": "Screen size",
 *         "valueType": "number",
 *         "configurable": false,
 *         "validFor": {
 *         "startDateTime": "2013-04-19T16:42:23-04:00",
 *         "endDateTime": ""
 *         },
 *         "serviceSpecCharRelationship": [
 *         {
 *         "type": "dependency",
 *         "id": "43",
 *         "validFor": {
 *         "startDateTime": "2013-04-19T16:42:23-04:00",
 *         "endDateTime": ""
 *         }
 *         }
 *         ],
 *         "serviceSpecCharacteristicValue": [
 *         {
 *         "valueType": "number",
 *         "default": true,
 *         "value": "4.2",
 *         "unitOfMeasure": "inches",
 *         "valueFrom": "",
 *         "valueTo": "",
 *         "validFor": {
 *         "startDateTime": "2013-04-19T16:42:23-04:00",
 *         "endDateTime": ""
 *         }
 *         }
 *         ]
 *         }
 */
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@Embeddable
public class ServiceSpecCharacteristic implements Serializable {

    public final static long serialVersionUID = 1L;

    private String id;
    private String name;
    private String description;
    private TimeRange validFor;
    private CharacteristicValueType valueType;
    private Boolean configurable;
    private List<SpecificationCharacteristicRelationship> serviceSpecCharRelationship;
    private List<SpecificationCharacteristicValue> serviceSpecCharacteristicValue;

    public ServiceSpecCharacteristic() {
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

    public List<SpecificationCharacteristicRelationship> getServiceSpecCharRelationship() {
        return serviceSpecCharRelationship;
    }

    public void setServiceSpecCharRelationship(List<SpecificationCharacteristicRelationship> serviceSpecCharRelationship) {
        this.serviceSpecCharRelationship = serviceSpecCharRelationship;
    }

    public List<SpecificationCharacteristicValue> getServiceSpecCharacteristicValue() {
        return serviceSpecCharacteristicValue;
    }

    public void setServiceSpecCharacteristicValue(List<SpecificationCharacteristicValue> serviceSpecCharacteristicValue) {
        this.serviceSpecCharacteristicValue = serviceSpecCharacteristicValue;
    }

    @JsonProperty(value = "validFor")
    public TimeRange validForToJson() {
        return (validFor != null && !validFor.isEmpty()) ? validFor : null;
    }

    @JsonProperty(value = "serviceSpecCharRelationship")
    public List<SpecificationCharacteristicRelationship> serviceSpecCharRelationshipToJson() {
        return (serviceSpecCharRelationship != null && serviceSpecCharRelationship.size() > 0) ? serviceSpecCharRelationship : null;
    }

    @JsonProperty(value = "serviceSpecCharacteristicValue")
    public List<SpecificationCharacteristicValue> serviceSpecCharacteristicValueToJson() {
        return (serviceSpecCharacteristicValue != null && serviceSpecCharacteristicValue.size() > 0) ? serviceSpecCharacteristicValue : null;
    }

    @Override
    public int hashCode() {
        int hash = 5;

        hash = 67 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 67 * hash + (this.name != null ? this.name.hashCode() : 0);
        hash = 67 * hash + (this.description != null ? this.description.hashCode() : 0);
        hash = 67 * hash + (this.validFor != null ? this.validFor.hashCode() : 0);
        hash = 67 * hash + (this.valueType != null ? this.valueType.hashCode() : 0);
        hash = 67 * hash + (this.configurable != null ? this.configurable.hashCode() : 0);
        hash = 67 * hash + (this.serviceSpecCharRelationship != null ? this.serviceSpecCharRelationship.hashCode() : 0);
        hash = 67 * hash + (this.serviceSpecCharacteristicValue != null ? this.serviceSpecCharacteristicValue.hashCode() : 0);

        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        final ServiceSpecCharacteristic other = (ServiceSpecCharacteristic) object;
        if (!Utilities.areEqual(this.id, other.id)) {
            return false;
        }

        if (!Utilities.areEqual(this.name, other.name)) {
            return false;
        }

        if (!Utilities.areEqual(this.description, other.description)) {
            return false;
        }

        if (!Utilities.areEqual(this.validFor, other.validFor)) {
            return false;
        }

        if (this.valueType != other.valueType) {
            return false;
        }

        if (!Utilities.areEqual(this.configurable, other.configurable)) {
            return false;
        }

        if (!Utilities.areEqual(this.serviceSpecCharRelationship, other.serviceSpecCharRelationship)) {
            return false;
        }

        if (!Utilities.areEqual(this.serviceSpecCharacteristicValue, other.serviceSpecCharacteristicValue)) {
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        return "ServiceSpecCharacteristic{" + "id=" + id + ", name=" + name + ", description=" + description + ", validFor=" + validFor + ", valueType=" + valueType + ", configurable=" + configurable + ", serviceSpecCharRelationship=" + serviceSpecCharRelationship + ", serviceSpecCharacteristicValue=" + serviceSpecCharacteristicValue + '}';
    }

    @JsonIgnore
    public boolean isValid() {
        if (!validateCharacteristicValues()) {
            return false;
        }

        return true;
    }

    private boolean validateCharacteristicValues() {
        if (!Utilities.hasContents(this.serviceSpecCharacteristicValue)) {
            return true;
        }

        int defaultCount = 0;
        /*
        for (SpecificationCharacteristicValue characteristicValue : this.serviceSpecCharacteristicValue) {
            if (Objects.equals(characteristicValue.getDefaultValue(), Boolean.TRUE)) {
                defaultCount++;
            }
        }
        */

        defaultCount = this.serviceSpecCharacteristicValue.stream().filter((characteristicValue) -> (Objects.equals(characteristicValue.getDefaultValue(), Boolean.TRUE))).map((_item) -> 1).reduce(defaultCount, Integer::sum);


        return defaultCount <= 1;
    }

    public static ServiceSpecCharacteristic createProto() {
        ServiceSpecCharacteristic serviceSpecCharacteristic = new ServiceSpecCharacteristic();

        serviceSpecCharacteristic.id = "id";
        serviceSpecCharacteristic.name = "name";
        serviceSpecCharacteristic.description = "description";
        serviceSpecCharacteristic.valueType = CharacteristicValueType.NUMBER;
        serviceSpecCharacteristic.configurable = true;
        serviceSpecCharacteristic.validFor = TimeRange.createProto();

        serviceSpecCharacteristic.serviceSpecCharRelationship = new ArrayList<>();
        serviceSpecCharacteristic.serviceSpecCharRelationship.add(SpecificationCharacteristicRelationship.createProto());

        serviceSpecCharacteristic.serviceSpecCharacteristicValue = new ArrayList<>();
        serviceSpecCharacteristic.serviceSpecCharacteristicValue.add(SpecificationCharacteristicValue.createProto());

        return serviceSpecCharacteristic;
    }

}
