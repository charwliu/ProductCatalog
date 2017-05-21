package com.ngboss.eep.catalog.entity.catalog;

import com.ngboss.eep.catalog.model.catalog.Catalog;
import com.ngboss.eep.catalog.model.catalog.CatalogId;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 *
 * @author bahman.barzideh
 *
 */
@Entity
@IdClass(CatalogId.class)
@Table(name = "CRI_CATALOG")
public class CatalogEntity extends Catalog implements Serializable {

    private final static long serialVersionUID = 1L;

    public CatalogEntity() {
    }

}
