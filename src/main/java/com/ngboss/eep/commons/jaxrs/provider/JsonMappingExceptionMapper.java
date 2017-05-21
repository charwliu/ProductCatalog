package com.ngboss.eep.commons.jaxrs.provider;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.ngboss.eep.commons.exceptions.ExceptionType;
import com.ngboss.eep.commons.jaxrs.model.JsonFault;
import org.codehaus.jackson.map.JsonMappingException;

@Provider
public class JsonMappingExceptionMapper implements ExceptionMapper<JsonMappingException> {

    @Override
    public Response toResponse(JsonMappingException ex) {
        JsonFault error = new JsonFault(ExceptionType.BAD_USAGE_UNKNOWN_VALUE.getInfo(), ex.getMessage());
        return Response.status(Response.Status.BAD_REQUEST.getStatusCode()).entity(error).build();
    }
}
