package com.ngboss.eep.catalog.model;

import com.ngboss.eep.commons.Utilities;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author bahman.barzideh
 *
 * {
 *     "id": "28",
 *     "href": "http://serverlocation:port/slaManagement/serviceLevelAgreement/28",
 *     "name": "Standard SLA"
 * }
 *
 */
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@Embeddable
public class ServiceLevelAgreement implements Serializable {

    public final static long serialVersionUID = 1L;

    @Column(name = "SLA_ID")
    private String id;

    @Column(name = "SLA_HREF")
    private String href;

    @Column(name = "SLA_NAME")
    private String name;

    public ServiceLevelAgreement() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        int hash = 5;

        hash = 67 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 67 * hash + (this.href != null ? this.href.hashCode() : 0);
        hash = 67 * hash + (this.name != null ? this.name.hashCode() : 0);

        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        final ServiceLevelAgreement other = (ServiceLevelAgreement) object;
        if (!Utilities.areEqual(this.id, other.id)) {
            return false;
        }

        if (!Utilities.areEqual(this.href, other.href)) {
            return false;
        }

        return Utilities.areEqual(this.name, other.name);
    }

    @Override
    public String toString() {
        return "ServiceLevelAgreement{" + "id=" + id + ", href=" + href + ", name=" + name + '}';
    }

    public static ServiceLevelAgreement createProto() {
        ServiceLevelAgreement ServiceLevelAgreement = new ServiceLevelAgreement();

        ServiceLevelAgreement.id = "id";
        ServiceLevelAgreement.href = "href";
        ServiceLevelAgreement.name = "name";

        return ServiceLevelAgreement;
    }

}
