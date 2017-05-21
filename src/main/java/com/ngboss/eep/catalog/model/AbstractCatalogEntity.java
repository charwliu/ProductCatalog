package com.ngboss.eep.catalog.model;

import com.ngboss.eep.commons.ParsedVersion;
import com.ngboss.eep.commons.Utilities;
import com.ngboss.eep.commons.annotation.VersionProperty;
import org.codehaus.jackson.annotate.JsonIgnore;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PostLoad;
import javax.persistence.Transient;

/**
 *
 * @author bahman.barzideh
 *
 */
@MappedSuperclass
public abstract class AbstractCatalogEntity extends AbstractEntity implements Serializable {

    public final static String ROOT_CATALOG_ID = "";

    @Id
    @Column(name = "CATALOG_ID", nullable = false)
    @JsonIgnore
    private String catalogId;

    @Id
    @Column(name = "CATALOG_VERSION", nullable = false)
    @JsonIgnore
    @VersionProperty
    private String catalogVersion;

    @Transient
    @JsonIgnore
    private ParsedVersion parsedCatalogVersion;

    public AbstractCatalogEntity() {
    }

    public String getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(String catalogId) {
        this.catalogId = catalogId;
    }

    public String getCatalogVersion() {
        return catalogVersion;
    }

    public void setCatalogVersion(String catalogVersion) {
        loadCatalogVersions(catalogVersion);
    }

    public ParsedVersion getParsedCatalogVersion() {
        if (parsedCatalogVersion == null && catalogVersion != null) {
            setCatalogVersion(catalogVersion);
        }

        return parsedCatalogVersion;
    }

    public void setParsedCatalogVersion(ParsedVersion parsedCatalogVersion) {
        this.parsedCatalogVersion = parsedCatalogVersion;
        this.catalogVersion = (this.parsedCatalogVersion != null) ? this.parsedCatalogVersion.getInternalView() : null;
    }

    @Override
    public int hashCode() {
        int hash = 3;

        hash = 53 * hash + super.hashCode();

        hash = 31 * hash + (this.catalogId != null ? this.catalogId.hashCode() : 0);
        hash = 31 * hash + (this.catalogVersion != null ? this.catalogVersion.hashCode() : 0);

        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass() || !super.equals(object)) {
            return false;
        }

        final AbstractCatalogEntity other = (AbstractCatalogEntity) object;
        if (!Utilities.areEqual(this.catalogId, other.catalogId)) {
            return false;
        }

        if (!Utilities.areEqual(this.catalogVersion, other.catalogVersion)) {
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        return "AbstractCatalogEntity{" + "catalogId=" + catalogId + ", catalogVersion=" + catalogVersion + ", parsedCatalogVersion=" + parsedCatalogVersion + '}';
    }

    @Override
    public boolean keysMatch(AbstractEntity input) {
        if (input == null) {
            return false;
        }

        if (input == this) {
            return true;
        }

        if (!super.keysMatch(input)) {
            return false;
        }

        AbstractCatalogEntity other = (AbstractCatalogEntity) input;
        if (!Utilities.areEqual(this.catalogId, other.catalogId)) {
            return false;
        }

        if (!Utilities.areEqual(this.catalogVersion, other.catalogVersion)) {
            return false;
        }

        return true;
    }

    public void configureCatalogIdentifier() {
        setCatalogId(ROOT_CATALOG_ID);
        setParsedCatalogVersion(ParsedVersion.ROOT_CATALOG_VERSION);
    }

    @PostLoad
    @Override
    protected void onLoad() {
        super.onLoad();

        loadCatalogVersions(catalogVersion);

    }

    private void loadCatalogVersions(String catalogVersion) {
        if (ParsedVersion.ROOT_CATALOG_VERSION.getInternalView().equals(catalogVersion)) {
            this.parsedCatalogVersion = ParsedVersion.ROOT_CATALOG_VERSION;
            this.catalogVersion = this.parsedCatalogVersion.getInternalView();
            return;
        }

        if (catalogVersion == null) {
            this.parsedCatalogVersion = null;
            this.catalogVersion = null;
            return;
        }

        this.parsedCatalogVersion = new ParsedVersion(catalogVersion);
        this.catalogVersion = this.parsedCatalogVersion.getInternalView();
    }

}
