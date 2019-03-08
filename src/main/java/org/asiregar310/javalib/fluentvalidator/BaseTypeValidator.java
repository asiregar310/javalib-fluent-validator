package org.asiregar310.javalib.fluentvalidator;

import java.text.MessageFormat;

public abstract class BaseTypeValidator {
    protected Validator validator;
    protected String name;
    protected String message;

    protected BaseTypeValidator(Validator validator, String name) {
        this.validator = validator;
        this.name = name;
        this.message = "";
    }

    protected boolean isValid() {
        return message.length() == 0;
    }

    public Validator mustTrue(Boolean condition){
        if (!condition) {
            message =  MessageFormat.format("{0} is incorrect.", this.name);
        }

        return this.validator;
    }

    public String getMessage() {
        return message;
    }
}
