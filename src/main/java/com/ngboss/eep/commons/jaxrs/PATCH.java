package com.ngboss.eep.commons.jaxrs;

/**
 *
 * @author pierregauthier
 *
 */
import javax.ws.rs.HttpMethod;
import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@HttpMethod("PATCH")
public @interface PATCH {

}
