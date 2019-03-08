package org.asiregar310.javalib.fluentvalidator;

import java.text.MessageFormat;

public class DoubleValidator extends BaseTypeValidator {
    private Double prop;

    public DoubleValidator(Validator validator, Double prop, String name) {
        super(validator, name);
        this.prop = prop;
    }

    public Validator mustNotNull(){
        if (prop == null) {
            message =  MessageFormat.format("{0} is null.", this.name);
        }

        return this.validator;
    }

    public Validator minValue(Double limit){
        mustNotNull();
        if (isValid())
            if (this.prop < limit)
                message =  MessageFormat.format("Minimum value of {0} is {1}.", this.name, limit);

        return this.validator;
    }

    public Validator maxValue(Double limit){
        mustNotNull();
        if (isValid())
            if (this.prop > limit)
                message =  MessageFormat.format("Maximum value of {0} is {1}.", this.name, limit);

        return this.validator;
    }

    public Validator mustGreaterThan(Double limit){
        if (mustNotNull().isValid()) {
            if (prop > limit)
                return this.validator;
        }

        if (this.isValid()) message = "is not greater than limit.";
        return this.validator;
    }
}
