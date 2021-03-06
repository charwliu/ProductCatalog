package com.ngboss.eep.catalog.model.product;

import com.ngboss.eep.catalog.model.TimeRange;
import com.ngboss.eep.catalog.model.specification.CharacteristicValueType;
import com.ngboss.eep.catalog.model.specification.SpecificationCharacteristicRelationship;
import com.ngboss.eep.catalog.model.specification.SpecificationCharacteristicValue;
import com.ngboss.eep.commons.Utilities;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author pierregauthier
 *
 * {
 *     "id": "42",
 *     "name": "Screen Size",
 *     "description": "Screen size",
 *     "valueType": "number",
 *     "configurable": "false",
 *     "validFor": {
 *         "startDateTime": "2013-04-19T16:42:23-04:00",
 *         "endDateTime": ""
 *     },
 *     "productSpecCharRelationship": [
 *         {
 *             "type": "dependency",
 *             "id": "43",
 *             "validFor": {
 *                 "startDateTime": "2013-04-19T16:42:23-04:00",
 *                 "endDateTime": ""
 *             }
 *         }
 *     ],
 *     "productSpecCharacteristicValue": [
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
public class ProductSpecCharacteristic implements Serializable {

    public final static long serialVersionUID = 1L;

    private String id;
    private String name;

    @Column(name = "DESCRIPTION", length = 5000)
    private String description;

    private CharacteristicValueType valueType;
    private Boolean configurable;
    private TimeRange validFor;
    private List<SpecificationCharacteristicRelationship> productSpecCharRelationship;
    private List<SpecificationCharacteristicValue> productSpecCharacteristicValue;

    public ProductSpecCharacteristic() {
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

    public TimeRange getValidFor() {
        return validFor;
    }

    public void setValidFor(TimeRange validFor) {
        this.validFor = validFor;
    }

    public List<SpecificationCharacteristicRelationship> getProductSpecCharRelationship() {
        return productSpecCharRelationship;
    }

    public void setProductSpecCharRelationship(List<SpecificationCharacteristicRelationship> productSpecCharRelationship) {
        this.productSpecCharRelationship = productSpecCharRelationship;
    }

    public List<SpecificationCharacteristicValue> getProductSpecCharacteristicValue() {
        return productSpecCharacteristicValue;
    }

    public void setProductSpecCharacteristicValue(List<SpecificationCharacteristicValue> productSpecCharacteristicValue) {
        this.productSpecCharacteristicValue = productSpecCharacteristicValue;
    }

    @JsonProperty(value = "validFor")
    public TimeRange validForToJson() {
        return (validFor != null && !validFor.isEmpty()) ? validFor : null;
    }

    @JsonProperty(value = "productSpecCharRelationship")
    public List<SpecificationCharacteristicRelationship> productSpecCharRelationshipToJson() {
        return (productSpecCharRelationship != null && productSpecCharRelationship.size() > 0) ? productSpecCharRelationship : null;
    }

    @JsonProperty(value = "productSpecCharacteristicValue")
    public List<SpecificationCharacteristicValue> productSpecCharacteristicValueToJson() {
        return (productSpecCharacteristicValue != null && productSpecCharacteristicValue.size() > 0) ? productSpecCharacteristicValue : null;
    }

    @Override
    public int hashCode() {
        int hash = 5;

        hash = 71 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 71 * hash + (this.name != null ? this.name.hashCode() : 0);
        hash = 71 * hash + (this.description != null ? this.description.hashCode() : 0);
        hash = 71 * hash + (this.valueType != null ? this.valueType.hashCode() : 0);
        hash = 71 * hash + (this.configurable != null ? this.configurable.hashCode() : 0);
        hash = 71 * hash + (this.validFor != null ? this.validFor.hashCode() : 0);
        hash = 71 * hash + (this.productSpecCharRelationship != null ? this.productSpecCharRelationship.hashCode() : 0);
        hash = 71 * hash + (this.productSpecCharacteristicValue != null ? this.productSpecCharacteristicValue.hashCode() : 0);

        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        final ProductSpecCharacteristic other = (ProductSpecCharacteristic) object;
        if (!Utilities.areEqual(this.id, other.id)) {
            return false;
        }

        if (!Utilities.areEqual(this.name, other.name)) {
            return false;
        }

        if (!Utilities.areEqual(this.description, other.description)) {
            return false;
        }

        if (this.valueType != other.valueType) {
            return false;
        }

        if (!Utilities.areEqual(this.configurable, other.configurable)) {
            return false;
        }

        if (!Utilities.areEqual(this.validFor, other.validFor)) {
            return false;
        }

        if (!Utilities.areEqual(this.productSpecCharRelationship, other.productSpecCharRelationship)) {
            return false;
        }

        return Utilities.areEqual(this.productSpecCharacteristicValue, other.productSpecCharacteristicValue);
    }

    @Override
    public String toString() {
        return "ProductSpecCharacteristic{" + "id=" + id + ", name=" + name + ", description=" + description + ", valueType=" + valueType + ", configurable=" + configurable + ", validFor=" + validFor + ", productSpecCharRelationship=" + productSpecCharRelationship + ", productSpecCharacteristicValue=" + productSpecCharacteristicValue + '}';
    }

    @JsonIgnore
    public boolean isValid() {
        return validateCharacteristicValues();
    }

    private boolean validateCharacteristicValues() {
        if (!Utilities.hasContents(this.productSpecCharacteristicValue)) {
            return true;
        }

        int defaultCount = 0;
        for (SpecificationCharacteristicValue characteristicValue : this.productSpecCharacteristicValue) {
            if (Objects.equals(characteristicValue.getDefaultValue(), Boolean.TRUE)) {
                defaultCount++;
            }
        }

        return defaultCount <= 1;
    }

    public static ProductSpecCharacteristic createProto() {
        ProductSpecCharacteristic productSpecCharacteristic = new ProductSpecCharacteristic();

        productSpecCharacteristic.id = "id";
        productSpecCharacteristic.name = "name";
        productSpecCharacteristic.description = "description";
        productSpecCharacteristic.valueType = CharacteristicValueType.NUMBER;
        productSpecCharacteristic.configurable = true;
        productSpecCharacteristic.validFor = TimeRange.createProto();

        productSpecCharacteristic.productSpecCharRelationship = new ArrayList<>();
        productSpecCharacteristic.productSpecCharRelationship.add(SpecificationCharacteristicRelationship.createProto());

        productSpecCharacteristic.productSpecCharacteristicValue = new ArrayList<>();
        productSpecCharacteristic.productSpecCharacteristicValue.add(SpecificationCharacteristicValue.createProto());

        return productSpecCharacteristic;
    }

}
