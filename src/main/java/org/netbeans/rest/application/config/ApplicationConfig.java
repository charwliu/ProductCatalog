package org.netbeans.rest.application.config;

import com.ngboss.eep.catalog.service.catalog.CatalogFacadeREST;
import com.ngboss.eep.catalog.service.category.CategoryFacadeREST;
import com.ngboss.eep.catalog.service.category.CategoryInCatalogIdFacadeREST;
import com.ngboss.eep.catalog.service.category.CategoryInCatalogIdVersionFacadeREST;
import com.ngboss.eep.catalog.service.productOffering.ProductOfferingFacadeREST;
import com.ngboss.eep.catalog.service.productOffering.ProductOfferingInCatalogIdFacadeREST;
import com.ngboss.eep.catalog.service.productOffering.ProductOfferingInCatalogIdVersionFacadeREST;
import com.ngboss.eep.catalog.service.productSpecification.ProductSpecificationFacadeREST;
import com.ngboss.eep.catalog.service.productSpecification.ProductSpecificationInCatalogIdFacadeREST;
import com.ngboss.eep.catalog.service.productSpecification.ProductSpecificationInCatalogIdVersionFacadeREST;
import com.ngboss.eep.catalog.service.resourceCandidate.ResourceCandidateFacadeREST;
import com.ngboss.eep.catalog.service.resourceCandidate.ResourceCandidateInCatalogIdFacadeREST;
import com.ngboss.eep.catalog.service.resourceCandidate.ResourceCandidateInCatalogIdVersionFacadeREST;
import com.ngboss.eep.catalog.service.resourceSpecification.ResourceSpecificationFacadeREST;
import com.ngboss.eep.catalog.service.resourceSpecification.ResourceSpecificationInCatalogIdFacadeREST;
import com.ngboss.eep.catalog.service.resourceSpecification.ResourceSpecificationInCatalogIdVersionFacadeREST;
import com.ngboss.eep.catalog.service.serviceCandidate.ServiceCandidateFacadeREST;
import com.ngboss.eep.catalog.service.serviceCandidate.ServiceCandidateInCatalogIdFacadeREST;
import com.ngboss.eep.catalog.service.serviceCandidate.ServiceCandidateInCatalogIdVersionFacadeREST;
import com.ngboss.eep.catalog.service.serviceSpecification.ServiceSpecificationFacadeREST;
import com.ngboss.eep.catalog.service.serviceSpecification.ServiceSpecificationInCatalogIdFacadeREST;
import com.ngboss.eep.catalog.service.serviceSpecification.ServiceSpecificationInCatalogIdVersionFacadeREST;
import com.ngboss.eep.commons.jaxrs.provider.BadUsageExceptionMapper;
import com.ngboss.eep.commons.jaxrs.provider.JacksonConfigurator;
import com.ngboss.eep.commons.jaxrs.provider.JsonMappingExceptionMapper;
import com.ngboss.eep.commons.jaxrs.provider.UnknowResourceExceptionMapper;
import com.ngboss.eep.jaxrs.resource.hub.CatalogHubResource;
import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("catalogManagement")
public class ApplicationConfig extends ResourceConfig {

    public ApplicationConfig() {
        packages ("org.codehaus.jackson.jaxrs");

        register(CatalogHubResource.class);
                
        register(CatalogFacadeREST.class);
        register(CategoryFacadeREST.class);
        register(CategoryInCatalogIdFacadeREST.class);
        register(CategoryInCatalogIdVersionFacadeREST.class);
        register(ProductOfferingFacadeREST.class);
        register(ProductOfferingInCatalogIdFacadeREST.class);
        register(ProductOfferingInCatalogIdVersionFacadeREST.class);
        register(ProductSpecificationFacadeREST.class);
        register(ProductSpecificationInCatalogIdFacadeREST.class);
        register(ProductSpecificationInCatalogIdVersionFacadeREST.class);
        register(ResourceCandidateFacadeREST.class);
        register(ResourceCandidateInCatalogIdFacadeREST.class);
        register(ResourceCandidateInCatalogIdVersionFacadeREST.class);
        register(ResourceSpecificationFacadeREST.class);
        register(ResourceSpecificationInCatalogIdFacadeREST.class);
        register(ResourceSpecificationInCatalogIdVersionFacadeREST.class);
        register(ServiceCandidateFacadeREST.class);
        register(ServiceCandidateInCatalogIdFacadeREST.class);
        register(ServiceCandidateInCatalogIdVersionFacadeREST.class);
        register(ServiceSpecificationFacadeREST.class);
        register(ServiceSpecificationInCatalogIdFacadeREST.class);
        register(ServiceSpecificationInCatalogIdVersionFacadeREST.class);
        register(BadUsageExceptionMapper.class);
        register(JacksonConfigurator.class);
        register(JsonMappingExceptionMapper.class);
        register(UnknowResourceExceptionMapper.class);
    }

}
