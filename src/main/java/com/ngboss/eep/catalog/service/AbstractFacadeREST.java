package com.ngboss.eep.catalog.service;

import com.ngboss.eep.catalog.exception.IllegalLifecycleStatusException;
import com.ngboss.eep.catalog.model.AbstractEntity;
import com.ngboss.eep.catalog.model.LifecycleStatus;
import com.ngboss.eep.commons.FieldSelector;
import com.ngboss.eep.commons.ParsedVersion;
import com.ngboss.eep.commons.QueryParameterParser;
import com.ngboss.eep.commons.ReferencedEntityGetter;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.Path;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author bahman.barzideh
 * @param <T>  type
 *
 */
public abstract class AbstractFacadeREST<T> {
    private final FieldSelector fieldSelector;
    private final ReferencedEntityGetter<T> referencedEntityGetter;

    /*
     *
     */
    protected AbstractFacadeREST(Class theClass) throws IllegalArgumentException {
        fieldSelector = new FieldSelector(theClass);
        referencedEntityGetter = new ReferencedEntityGetter<>(theClass);
    }

    /*
     *
     */
    public abstract Logger getLogger();

    /*
     *
     */
    public String getRelativeEntityContext() {
        Path path = getClass().getAnnotation(Path.class);
        String value = (path != null) ? path.value() :  null;
        if (value == null) {
            return null;
        }

        int index = value.lastIndexOf("/");
        return (index >= 0) ? value.substring(index + 1) : value;
    }

    /*
     *
     */
    protected void validateLifecycleStatus(AbstractEntity newEntity, AbstractEntity existingEntity) throws IllegalLifecycleStatusException {
        if (newEntity == null) {
            throw new IllegalArgumentException ("newEntity is required");
        }

        if (existingEntity == null) {
            throw new IllegalArgumentException ("existingEntity is required");
        }

        if (newEntity.canLifecycleTransitionFrom(existingEntity.getLifecycleStatus())) {
            return;
        }

        getLogger().log(Level.FINE, "invalid lifecycleStatus transition: {0} => {1}", new Object[]{existingEntity.getLifecycleStatus(), newEntity.getLifecycleStatus()});
        Set<LifecycleStatus> statusList = LifecycleStatus.transitionableStatues(existingEntity.getLifecycleStatus());
        if (statusList == null) {
            throw new IllegalLifecycleStatusException(existingEntity.getLifecycleStatus());
        }

        throw new IllegalLifecycleStatusException(existingEntity.getLifecycleStatus(), statusList);
    }

    /*
     *
     */
    public String buildHref(UriInfo uriInfo, String id, ParsedVersion parsedVersion) {
        URI uri = (uriInfo != null) ? uriInfo.getBaseUri() : null;
        String basePath = (uri != null) ? uri.toString() : null;
        if (basePath == null) {
            return null;
        }

        if (!basePath.endsWith("/")) {
            basePath += "/";
        }

        basePath += getRelativeEntityContext() + "/";
        if (id == null || id.length() <= 0) {
            return (basePath);
        }

        basePath += id;
        String version = (parsedVersion != null) ? parsedVersion.getExternalView() : null;
        if (version == null || version.length() <= 0) {
            return basePath;
        }

        return basePath + ":(" + version + ")";
    }

    /*
     *
     */
    public Set<String> getFieldSet(QueryParameterParser queryParameterParser) {
        Set<String> fieldSet = new HashSet<>();
        if (queryParameterParser == null) {
            return fieldSet;
        }

        List<String> queryParameterField = queryParameterParser.removeTagWithValues(ServiceConstants.QUERY_KEY_FIELD_ESCAPE + ServiceConstants.QUERY_KEY_FIELD);
        if (queryParameterField == null) {
            queryParameterField = queryParameterParser.removeTagWithValues(ServiceConstants.QUERY_KEY_FIELD);
        }

        if (queryParameterField != null && !queryParameterField.isEmpty()) {
            String queryParameterValue = queryParameterField.get(0);
            fieldSet.addAll(breakFieldList_(queryParameterValue));
        }

        return fieldSet;
    }

    /*
     *
     */
    protected void getReferencedEntities(T entity, int depth) {
        referencedEntityGetter.getReferencedEntities(entity, depth);
    }

    /*
     *
     */
    protected void getReferencedEntities(Set<T> entities, int depth) {
        referencedEntityGetter.getReferencedEntities(entities, depth);
    }

    /*
     *
     */
    protected Object selectFields(T inputEntity, Set<String> outputFields) {
        outputFields.add(ServiceConstants.ID_FIELD);

        return fieldSelector.selectFields(inputEntity, outputFields);
    }

    protected ArrayList<Object> selectFields(Set<T> inputEntities, Set<String> outputFields) {
       outputFields.add(ServiceConstants.ID_FIELD);

       ArrayList<Object> outputEntities = new ArrayList<>();
       inputEntities.forEach((entity) -> outputEntities.add(fieldSelector.selectFields(entity, outputFields)));

       return outputEntities;
    }

    private List<String> breakFieldList_(String input) {
        if (input == null) {
            return new ArrayList<>();
        }

        String tokenArray [] = input.split(",");
        return Arrays.asList(tokenArray);
    }

}
