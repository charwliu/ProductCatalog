package com.ngboss.eep.catalog.entity.resource;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.ngboss.eep.catalog.model.CatalogEntityId;
import com.ngboss.eep.catalog.model.resource.ResourceCandidate;

/**
 *
 * @author bahman.barzideh
 *
 */
@Entity
@IdClass(CatalogEntityId.class)
@Table(name = "CRI_RESOURCE_CANDIDATE")
public class ResourceCandidateEntity extends ResourceCandidate implements Serializable {

    private static final long serialVersionUID = 1L;

    public ResourceCandidateEntity() {
    }

}
