package com.ngboss.eep.catalog.model.catalog;

import java.util.EnumSet;

import com.ngboss.eep.commons.exceptions.InvalidEnumeratedValueException;
import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonValue;

/**
 *
 * @author bahman.barzideh
 *
 */
public enum CatalogType {
    PRODUCT_CATALOG("Product Catalog"),
    SERVICE_CATALOG("Service Catalog"),
    RESOOURCE_CATALOG("Resource Catalog");

    private final String value;

    private CatalogType(String value) {
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

    public static CatalogType find(String value) {
        for (CatalogType catalogType : values()) {
            if (catalogType.value.equals(value)) {
                return catalogType;
            }
        }

        return null;
    }

    @JsonCreator
    public static CatalogType fromJson(String value) throws InvalidEnumeratedValueException {
        if (value == null) {
            return null;
        }

        CatalogType enumeratedValue = CatalogType.find(value);
        if (enumeratedValue != null) {
            return enumeratedValue;
        }

        throw new InvalidEnumeratedValueException(value, EnumSet.allOf(CatalogType.class));
    }
}
