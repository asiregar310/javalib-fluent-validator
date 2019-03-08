package org.asiregar310.javalib.fluentvalidator;

import java.text.MessageFormat;
import java.util.Date;

public class DateValidatorBase extends BaseTypeValidator {
    private Date prop;

    public DateValidatorBase(Validator validator, Date prop, String name) {
        super(validator, name);
        this.prop = prop;
    }

    public Validator mustNotNull(){
        if (prop == null) {
            message =  MessageFormat.format("{0} is null.", this.name);
        }

        return this.validator;
    }

    public Validator mustBefore(Date limit){
        mustNotNull();
        if (isValid())
            if (this.prop.equals(limit) || this.prop.after(limit))
                message =  MessageFormat.format("{0} must before {1}.", this.name, limit);

        return this.validator;
    }

    public Validator mustAfter(Date limit){
        mustNotNull();
        if (isValid())
            if (this.prop.equals(limit) || this.prop.before(limit))
                message =  MessageFormat.format("{0} must after {1}.", this.name, limit);

        return this.validator;
    }
}
