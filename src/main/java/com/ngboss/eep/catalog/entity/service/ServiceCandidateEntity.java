package com.ngboss.eep.catalog.entity.service;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.ngboss.eep.catalog.model.CatalogEntityId;
import com.ngboss.eep.catalog.model.service.ServiceCandidate;

/**
 *
 * @author bahman.barzideh
 *
 */
@Entity
@IdClass(CatalogEntityId.class)
@Table(name = "CRI_SERVICE_CANDIDATE")
public class ServiceCandidateEntity extends ServiceCandidate implements Serializable {

    private static final long serialVersionUID = 1L;

    public ServiceCandidateEntity() {
    }

}
