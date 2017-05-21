package com.ngboss.eep.commons;

import java.util.List;

/**
 *
 * @author baman.barzideh
 *
 */
public class Utilities {

    private Utilities() {
    }

    public static boolean areEqual(Object objectOne, Object objectTwo) {
        if (objectOne == null) {
            return (objectTwo == null);
        }

        return objectOne.equals(objectTwo);
    }

    public static boolean hasValue(String input) {
        if (input == null) {
            return false;
        }

        return input.trim().length() > 0;
    }

    public static boolean hasContents(List<?> input) {
        return !(input == null || input.size() <= 0);
    }

}
