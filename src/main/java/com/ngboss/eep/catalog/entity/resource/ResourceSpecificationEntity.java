package com.ngboss.eep.catalog.entity.resource;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.ngboss.eep.catalog.model.CatalogEntityId;
import com.ngboss.eep.catalog.model.resource.ResourceSpecification;

/**
 *
 * @author bahman.barzideh
 *
 */
@Entity
@IdClass(CatalogEntityId.class)
@Table(name = "CRI_RESOURCE_SPECIFICATION")
public class ResourceSpecificationEntity extends ResourceSpecification implements Serializable {

    private final static long serialVersionUID = 1L;

    public ResourceSpecificationEntity() {
    }

}
