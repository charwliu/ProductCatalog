package com.ngboss.eep.catalog.model.product;

import java.util.EnumSet;
import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonValue;
import com.ngboss.eep.commons.exceptions.InvalidEnumeratedValueException;

/**
 *
 * @author bahman.barzideh
 *
 */
public enum ProductOfferingPriceType {
    RECURRING("recurring"),
    ONE_TIME("one time"),
    USAGE("usage");

    private final String value;

    private ProductOfferingPriceType(String value) {
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

    public static ProductOfferingPriceType find(String value) {
        for (ProductOfferingPriceType productOfferingPriceType : values()) {
            if (productOfferingPriceType.value.equals(value)) {
                return productOfferingPriceType;
            }
        }

        return null;
    }

    @JsonCreator
    public static ProductOfferingPriceType fromJson(String value) throws InvalidEnumeratedValueException {
        if (value == null) {
            return null;
        }

        ProductOfferingPriceType enumeratedValue = ProductOfferingPriceType.find(value);
        if (enumeratedValue != null) {
            return enumeratedValue;
        }

        throw new InvalidEnumeratedValueException(value, EnumSet.allOf(ProductOfferingPriceType.class));
    }
}
