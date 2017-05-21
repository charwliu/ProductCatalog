package com.ngboss.eep.commons.criteria;

import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;

import com.ngboss.eep.commons.exceptions.BadUsageException;
import com.ngboss.eep.commons.exceptions.ExceptionType;
import com.ngboss.eep.commons.ParsedVersion;

/**
 *
 * @author bahman.barzideh
 *
 */
public class Operation {

    private static final SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssX");

    private Operator operator;
    private final HashSet<OperationValue> values = new HashSet<>();

    public Operation(Operator operator) throws IllegalArgumentException {
        if (operator == null) {
            throw new IllegalArgumentException("operator is required");
        }

        this.operator = operator;
    }

    public Operator getOperator() {
        return operator;
    }

    public Set<OperationValue> getValues() {
        return values;
    }

    public void addValue(String value) throws IllegalArgumentException {
        if (value == null) {
            throw new IllegalArgumentException("value is required");
        }

        values.add(new OperationValue(value));
    }

    public void normalizeValuesAsVersion() {
        values.forEach((value) -> {
            ParsedVersion parsedVersion = new ParsedVersion(value.getInputValue());
            value.setObjectValue(parsedVersion.getInternalView());
        });
    }

    public void normalizeValuesAsNumber() throws BadUsageException {
        for (OperationValue value : values) {
            try {
                value.setObjectValue((Comparable) NumberFormat.getInstance().parse(value.getInputValue()));
            } catch (ParseException ex) {
                System.err.println("Failed to parse '" + value.getInputValue() + "' as Number");
                throw new BadUsageException(ExceptionType.BAD_USAGE_FORMAT, "Wrong format for value " + value);
            }
        }
    }

    public void normalizeValuesAsDate() throws BadUsageException {
        for (OperationValue value : values) {
            try {
                value.setObjectValue(dateFormatter.parse(value.getInputValue()));
            } catch (ParseException ex) {
                System.err.println("Failed to parse '" + value.getInputValue() + "' as Date");
                throw new BadUsageException(ExceptionType.BAD_USAGE_FORMAT, "Wrong format for value " + value);
            }
        }
    }

    public void normalizeValuesAsEnumeration(Object enumeratedValues[]) throws BadUsageException {
        if (enumeratedValues == null || enumeratedValues.length <= 0) {
            return;
        }

        for (OperationValue value : values) {
            String inputValue = value.getInputValue();
            if (inputValue == null) {
                value.setObjectValue(null);
                continue;
            }

            for (Object object : enumeratedValues) {
                if (object == null || (object instanceof Enum) == false) {
                    continue;
                }

                if (inputValue.equals(object.toString()) == false) {
                    continue;
                }

                value.setObjectValue((Comparable) object);
                break;
            }
        }
    }

    @Override
    public String toString() {
        return "Operation{" + "operator=" + operator + ", values=" + values + '}';
    }

}
