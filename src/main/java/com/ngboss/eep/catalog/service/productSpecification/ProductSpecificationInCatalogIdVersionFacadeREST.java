package com.ngboss.eep.catalog.service.productSpecification;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.ngboss.eep.catalog.entity.product.ProductSpecificationEntity;
import com.ngboss.eep.commons.exceptions.BadUsageException;
import com.ngboss.eep.commons.jaxrs.PATCH;
import com.ngboss.eep.catalog.model.product.ProductSpecification;
import com.ngboss.eep.catalog.service.AbstractFacadeREST;
import com.ngboss.eep.commons.ParsedVersion;

/**
 *
 * @author bahman.barzideh
 *
 */
@Stateless
@Path("catalog/{catalogId}:({catalogVersion})/productSpecification")
public class ProductSpecificationInCatalogIdVersionFacadeREST extends AbstractFacadeREST<ProductSpecificationEntity> {

    private static final Logger logger = Logger.getLogger(ProductSpecification.class.getName());

    @EJB
    private ProductSpecificationFacade manager;

    /*
     *
     */
    public ProductSpecificationInCatalogIdVersionFacadeREST() {
        super(ProductSpecificationEntity.class);
    }

    /*
     *
     */
    @Override
    public Logger getLogger() {
        return logger;
    }

    /*
     *
     */
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response create(@PathParam("catalogId") String catalogId, @PathParam("catalogVersion") ParsedVersion catalogVersion, ProductSpecificationEntity input, @Context UriInfo uriInfo) {
        logger.log(Level.FINE, "ProductSpecificationInCatalogIdVersionFacadeREST:create(catalogId: {0}, catalogVersion: {1})", new Object[]{catalogId, catalogVersion});

        return Response.status(Response.Status.FORBIDDEN).build();
    }

    /*
     *
     */
    @PUT
    @Path("{entityId}")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response update(@PathParam("catalogId") String catalogId, @PathParam("catalogVersion") ParsedVersion catalogVersion, @PathParam("entityId") String entityId, ProductSpecificationEntity input, @Context UriInfo uriInfo) {
        logger.log(Level.FINE, "ProductSpecificationInCatalogIdVersionFacadeREST:update(catalogId: {0}, catalogVersion: {1}, entityId: {2})", new Object[]{catalogId, catalogVersion, entityId});

        return Response.status(Response.Status.FORBIDDEN).build();
    }

    /*
     *
     */
    @PUT
    @Path("{entityId}:({entityVersion})")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response update(@PathParam("catalogId") String catalogId, @PathParam("catalogVersion") ParsedVersion catalogVersion, @PathParam("entityId") String entityId, @PathParam("entityVersion") ParsedVersion entityVersion, ProductSpecificationEntity input, @Context UriInfo uriInfo) {
        logger.log(Level.FINE, "ProductSpecificationInCatalogIdVersionFacadeREST:update(catalogId: {0}, catalogVersion: {1}, entityId: {2}, entityVersion: {3})", new Object[]{catalogId, catalogVersion, entityId, entityVersion});

        return Response.status(Response.Status.FORBIDDEN).build();
    }

    /*
     *
     */
    @PATCH
    @Path("{entityId}")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response edit(@PathParam("catalogId") String catalogId, @PathParam("catalogVersion") ParsedVersion catalogVersion, @PathParam("entityId") String entityId, ProductSpecificationEntity input, @Context UriInfo uriInfo) {
        logger.log(Level.FINE, "ProductSpecificationInCatalogIdVersionFacadeREST:edit(catalogId: {0}, catalogVersion: {1}, entityId: {2})", new Object[]{catalogId, catalogVersion, entityId});

        return Response.status(Response.Status.FORBIDDEN).build();
    }

    /*
     *
     */
    @PATCH
    @Path("{entityId}:({entityVersion})")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response edit(@PathParam("catalogId") String catalogId, @PathParam("catalogVersion") ParsedVersion catalogVersion, @PathParam("entityId") String entityId, @PathParam("entityVersion") ParsedVersion entityVersion, ProductSpecificationEntity input, @Context UriInfo uriInfo) {
        logger.log(Level.FINE, "ProductSpecificationInCatalogIdVersionFacadeREST:edit(catalogId: {0}, catalogVersion: {1}, entityId: {2}, entityVersion: {3})", new Object[]{catalogId, catalogVersion, entityId, entityVersion});

        return Response.status(Response.Status.FORBIDDEN).build();
    }

    /*
     *
     */
    @DELETE
    @Path("{entityId}")
    public Response remove(@PathParam("catalogId") String catalogId, @PathParam("catalogVersion") ParsedVersion catalogVersion, @PathParam("entityId") String entityId) {
        logger.log(Level.FINE, "ProductSpecificationInCatalogIdVersionFacadeREST:remove(catalogId: {0}, catalogVersion: {1}, entityId: {2})", new Object[]{catalogId, catalogVersion, entityId});

        return Response.status(Response.Status.FORBIDDEN).build();
    }

    /*
     *
     */
    @DELETE
    @Path("{entityId}:({entityVersion})")
    public Response remove(@PathParam("catalogId") String catalogId, @PathParam("catalogVersion") ParsedVersion catalogVersion, @PathParam("entityId") String entityId, @PathParam("entityVersion") ParsedVersion entityVersion) {
        logger.log(Level.FINE, "ProductSpecificationInCatalogIdVersionFacadeREST:remove(catalogId: {0}, catalogVersion: {1}, entityId: {2}, entityVersion: {3})", new Object[]{catalogId, catalogVersion, entityId, entityVersion});

        return Response.status(Response.Status.FORBIDDEN).build();
    }

    /*
     *
     */
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response find(@PathParam("catalogId") String catalogId, @PathParam("catalogVersion") ParsedVersion catalogVersion, @QueryParam("depth") int depth, @Context UriInfo uriInfo) throws BadUsageException {
        logger.log(Level.FINE, "ProductSpecificationInCatalogIdVersionFacadeREST:find(catalogId: {0}, catalogVersion: {1}, depth: {2})", new Object[]{catalogId, catalogVersion, depth});

        return Response.status(Response.Status.FORBIDDEN).build();
    }

    /*
     *
     */
    @GET
    @Path("{entityId}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response findById(@PathParam("catalogId") String catalogId, @PathParam("catalogVersion") ParsedVersion catalogVersion, @PathParam("entityId") String entityId, @QueryParam("depth") int depth, @Context UriInfo uriInfo) {
        logger.log(Level.FINE, "ProductSpecificationInCatalogIdVersionFacadeREST:find(catalogId: {0}, catalogVersion: {1}, entityId: {2}, depth: {3})", new Object[]{catalogId, catalogVersion, entityId, depth});

        return Response.status(Response.Status.FORBIDDEN).build();
    }

    /*
     *
     */
    @GET
    @Path("{entityId}:({entityVersion})")
    @Produces({MediaType.APPLICATION_JSON})
    public Response find(@PathParam("catalogId") String catalogId, @PathParam("catalogVersion") ParsedVersion catalogVersion, @PathParam("entityId") String entityId, @PathParam("entityVersion") ParsedVersion entityVersion, @QueryParam("depth") int depth, @Context UriInfo uriInfo) {
        logger.log(Level.FINE, "ProductSpecificationInCatalogIdVersionFacadeREST:find(catalogId: {0}, catalogVersion: {1}, entityId: {2}, entityVersion: {3}, depth: {4})", new Object[]{catalogId, catalogVersion, entityId, entityVersion, depth});

        return Response.status(Response.Status.FORBIDDEN).build();
    }

    /*
     *
     */
    @GET
    @Path("admin/proto")
    @Produces({MediaType.APPLICATION_JSON})
    public Response proto(@PathParam("catalogId") String catalogId, @PathParam("catalogVersion") ParsedVersion catalogVersion) {
        logger.log(Level.FINE, "ProductSpecificationInCatalogIdVersionFacadeREST:proto(catalogId: {0}, catalogVersion: {1})", new Object[]{catalogId, catalogVersion});

        return Response.ok(ProductSpecificationEntity.createProto()).build();
    }

    /*
     *
     */
    @GET
    @Path("admin/count")
    @Produces({MediaType.TEXT_PLAIN})
    public Response count(@PathParam("catalogId") String catalogId, @PathParam("catalogVersion") ParsedVersion catalogVersion) {
        logger.log(Level.FINE, "ProductSpecificationInCatalogIdVersionFacadeREST:count(catalogId: {0}, catalogVersion: {1})", new Object[]{catalogId, catalogVersion});

        return Response.status(Response.Status.FORBIDDEN).build();
    }

}
