package com.ngboss.eep.commons;

import java.util.HashMap;

/**
 *
 * @author bahman.barzideh
 *
 */
public class ClassFieldsCache {

    private final HashMap<Class, ClassFields> cache = new HashMap<>();

    public ClassFieldsCache() {
    }

    public ClassFields get(Class theClass) {
        ClassFields classFields = cache.get(theClass);
        if (classFields != null) {
            return classFields;
        }

        classFields = new ClassFields(theClass);
        cache.put(theClass, classFields);
        return classFields;
    }

}
