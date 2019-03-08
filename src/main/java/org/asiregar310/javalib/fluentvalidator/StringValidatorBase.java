package org.asiregar310.javalib.fluentvalidator;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringValidatorBase extends BaseTypeValidator {
    private static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    private String prop;

    public StringValidatorBase(Validator validator, String prop, String name) {
        super(validator, name);
        this.prop = prop;
    }

    public Validator mustValidEmail(){
        mustNotNull();
        if (this.isValid()) {
            Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(prop);
            if (!matcher.find()) {
                message = MessageFormat.format("{0} is not valid.", this.name);
            }
        }

        return this.validator;
    }

    public Validator mustNotNull(){
        if (prop == null) {
            message =  MessageFormat.format("{0} is null.", this.name);
        }

        return this.validator;
    }

    public Validator mustNotNullOrEmpty(){
        mustNotNull();
        if (this.isValid())
            if (prop.isEmpty()) {
                message =  MessageFormat.format("{0} is null or empty.", this.name);
            }

        return this.validator;
    }

    public Validator minLength(int limit){
        mustNotNull();
        if (isValid())
            if (this.prop.length() < limit)
                message =  MessageFormat.format("Minimum length of {0} is {1} character(s).", this.name, limit);

        return this.validator;
    }

    public Validator maxLength(int limit) {
        mustNotNull();
        if (isValid())
            if (this.prop.length() > limit)
                message =  MessageFormat.format("Maximum length of {0} is {1} character(s).", this.name, limit);

        return this.validator;
    }

    public Validator isMemberOf(String[] list){
        List<String> lst = Arrays.asList(list);
        isMemberOf(lst);

        return this.validator;
    }

    public Validator isMemberOf(List<String> list){
        if (!list.contains(prop))
            message =  MessageFormat.format("{0} is not in the list.", this.name);

        return this.validator;
    }
}
