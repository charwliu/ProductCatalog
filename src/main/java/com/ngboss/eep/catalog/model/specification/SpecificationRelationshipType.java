package com.ngboss.eep.catalog.model.specification;

import com.ngboss.eep.commons.exceptions.InvalidEnumeratedValueException;
import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonValue;

import java.util.EnumSet;

/**
 *
 * @author bahman.barzideh
 *
 */
public enum SpecificationRelationshipType {
    MIGRATION("migration"),
    SUBSTITUTION("substitution"),
    DEPENDENCY("dependency"),
    EXCLUSIVITY("exclusivity");

    private final String value;

    SpecificationRelationshipType(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

    @JsonValue()
    public String getValue() {
        return this.value;
    }

    public static SpecificationRelationshipType find(String value) {
        for (SpecificationRelationshipType specificationRelationshipType : values()) {
            if (specificationRelationshipType.value.equals(value)) {
                return specificationRelationshipType;
            }
        }

        return null;
    }

    @JsonCreator
    public static SpecificationRelationshipType fromJson(String value) throws InvalidEnumeratedValueException {
        if (value == null) {
            return null;
        }

        SpecificationRelationshipType enumeratedValue = SpecificationRelationshipType.find(value);
        if (enumeratedValue != null) {
            return enumeratedValue;
        }

        throw new InvalidEnumeratedValueException(value, EnumSet.allOf(SpecificationRelationshipType.class));
    }
}
