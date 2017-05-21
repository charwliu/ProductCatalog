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
public enum CharacteristicValueType {
    STRING("string"),
    NUMBER("number");

    private final String value;

    CharacteristicValueType(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

    @JsonValue(true)
    public String getValue() {
        return this.value;
    }

    public static CharacteristicValueType find(String value) {
        for (CharacteristicValueType characteristicValueType : values()) {
            if (characteristicValueType.value.equals(value)) {
                return characteristicValueType;
            }
        }

        return null;
    }

    @JsonCreator
    public static CharacteristicValueType fromJson(String value) throws InvalidEnumeratedValueException {
        if (value == null) {
            return null;
        }

        CharacteristicValueType enumeratedValue = CharacteristicValueType.find(value);
        if (enumeratedValue != null) {
            return enumeratedValue;
        }

        throw new InvalidEnumeratedValueException(value, EnumSet.allOf(CharacteristicValueType.class));
    }
}
