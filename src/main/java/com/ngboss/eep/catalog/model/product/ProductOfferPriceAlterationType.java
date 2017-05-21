package com.ngboss.eep.catalog.model.product;

import com.ngboss.eep.commons.exceptions.InvalidEnumeratedValueException;
import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonValue;

import java.util.EnumSet;

/**
 *
 * @author bahman.barzideh
 *
 */
public enum ProductOfferPriceAlterationType {
    RECURRING("recurring"),
    ONE_TIME("one time"),
    USAGE("usage");

    private final String value;

    ProductOfferPriceAlterationType(String value) {
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

    public static ProductOfferPriceAlterationType find(String value) {
        for (ProductOfferPriceAlterationType productOfferingPriceAlterationType : values()) {
            if (productOfferingPriceAlterationType.value.equals(value)) {
                return productOfferingPriceAlterationType;
            }
        }

        return null;
    }

    @JsonCreator
    public static ProductOfferPriceAlterationType fromJson(String value) throws InvalidEnumeratedValueException {
        if (value == null) {
            return null;
        }

        ProductOfferPriceAlterationType enumeratedValue = ProductOfferPriceAlterationType.find(value);
        if (enumeratedValue != null) {
            return enumeratedValue;
        }

        throw new InvalidEnumeratedValueException(value, EnumSet.allOf(ProductOfferPriceAlterationType.class));
    }
}
