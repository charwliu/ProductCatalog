/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ngboss.eep.catalog.hub.model.catalog;

import org.codehaus.jackson.annotate.JsonCreator;

/**
 *
 * @author pierregauthier
 */

public enum CatalogEventType {

    CatalogCreationNotification("CatalogCreationNotification"),
    CatalogUpdateNotification("CatalogUpdateNotification"),
    CatalogDeletionNotification("CatalogDeletionNotification"),
    CatalogValueChangeNotification("CatalogValueChangeNotification");

    private final String text;

    @JsonCreator
    CatalogEventType(String text) {
        this.text = text;
    }

    /**
     *
     * @return
     */
    public String getText() {
        return this.text;
    }

    /**
     *
     * @param text
     * @return
     */
    public static CatalogEventType fromString(String text) {
        if (text != null) {
            for (CatalogEventType b : CatalogEventType.values()) {
                if (text.equalsIgnoreCase(b.text)) {
                    return b;
                }
            }
        }
        return null;
    }
}
