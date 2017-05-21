package com.ngboss.eep.commons.jaxrs.provider;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.ngboss.eep.commons.jaxrs.model.JsonFault;
import com.ngboss.eep.commons.exceptions.UnknownResourceException;

@Provider
public class UnknowResourceExceptionMapper implements ExceptionMapper<UnknownResourceException> {

    @Override
    public Response toResponse(UnknownResourceException ex) {
        JsonFault error = new JsonFault(ex.getType().getInfo(), ex.getMessage());
        return Response.status(404).entity(error).build();
    }
}
