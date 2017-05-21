package com.ngboss.eep.catalog.entity.product;

import com.ngboss.eep.catalog.model.CatalogEntityId;
import com.ngboss.eep.catalog.model.product.ProductOffering;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 *
 * @author pierregauthier
 *
 */
@Entity
@IdClass(CatalogEntityId.class)
@Table(name = "CRI_PRODUCT_OFFERING")
public class ProductOfferingEntity extends ProductOffering implements Serializable {

    private final static long serialVersionUID = 1L;

    public ProductOfferingEntity() {
    }

}
