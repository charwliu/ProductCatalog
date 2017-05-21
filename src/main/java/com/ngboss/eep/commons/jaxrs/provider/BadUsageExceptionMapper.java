/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ngboss.eep.commons.jaxrs.provider;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.ngboss.eep.commons.exceptions.BadUsageException;
import com.ngboss.eep.commons.jaxrs.model.JsonFault;

@Provider
public class BadUsageExceptionMapper implements ExceptionMapper<BadUsageException> {

    @Override
    public Response toResponse(BadUsageException ex) {
        JsonFault error = new JsonFault(ex.getType().getInfo(), ex.getMessage());
        return Response.status(Response.Status.BAD_REQUEST.getStatusCode()).entity(error).build();
    }
}
