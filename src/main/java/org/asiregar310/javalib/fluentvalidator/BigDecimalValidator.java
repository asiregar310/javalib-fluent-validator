package org.asiregar310.javalib.fluentvalidator;

import java.math.BigDecimal;
import java.text.MessageFormat;

public class BigDecimalValidator extends BaseTypeValidator {

    private BigDecimal prop;

    public BigDecimalValidator(Validator validator, BigDecimal prop, String name) {
        super(validator, name);
        this.prop = prop;
    }

    public Validator mustNotNull(){
        if (prop == null) {
            message =  MessageFormat.format("{0} is null.", this.name);
        }

        return this.validator;
    }

    public Validator mustGreaterThan(BigDecimal limit){
        if (mustNotNull().isValid()) {
            if (prop.getClass() == BigDecimal.class)
                if (prop.doubleValue() > limit.doubleValue())
                    return this.validator;
        }

        if (this.isValid()) message = "is not greater than limit.";
        return this.validator;
    }

    public Validator mustEqualOrGreaterThan(BigDecimal limit){
        if (mustNotNull().isValid()) {
            if (prop.getClass() == BigDecimal.class)
                if (prop.doubleValue() >= limit.doubleValue())
                    return this.validator;
        }

        if (this.isValid()) message = "is not equal or greater than limit.";
        return this.validator;
    }
}
