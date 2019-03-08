package org.asiregar310.javalib.fluentvalidator;

import java.text.MessageFormat;

public class IntegerValidatorBase extends BaseTypeValidator {
    private Integer prop;

    public IntegerValidatorBase(Validator validator, Integer prop, String name) {
        super(validator, name);
        this.prop = prop;
    }

    public Validator mustNotNull(){
        if (prop == null) {
            message =  MessageFormat.format("{0} is null.", this.name);
        }

        return this.validator;
    }

    public Validator minValue(int limit){
        mustNotNull();
        if (isValid())
            if (this.prop < limit)
                message =  MessageFormat.format("Minimum value of {0} is {1}.", this.name, limit);

        return this.validator;
    }

    public Validator maxValue(int limit){
        mustNotNull();
        if (isValid())
            if (this.prop > limit)
                message =  MessageFormat.format("Maximum value of {0} is {1}.", this.name, limit);

        return this.validator;
    }
}
