package org.asiregar310.javalib.fluentvalidator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Validator {
    private final List<BaseTypeValidator> validators = new ArrayList<>();
    private final List<String> messages = new ArrayList<>();

    private Validator() {
    }

    public Validator validate(){
        for (BaseTypeValidator v: this.validators) {
            String message = v.getMessage();
            if (!message.isEmpty()) this.messages.add(message);
        }

        return this;
    }

    public Boolean isValid(){
        return this.messages.size() == 0;
    }

    public List<String> getMessages(){
        return this.messages;
    }

    // factory method
    public static Validator create() {
        return new Validator();
    }

    public StringValidator propertyOf(String prop) {
        return propertyOf(prop, "");
    }

    public StringValidator propertyOf(String prop, String name){
        validators.add(new StringValidator(this, prop, name));
        return (StringValidator)validators.get(validators.size() - 1);
    }

    public IntegerValidator propertyOf(Integer prop) {
        return propertyOf(prop, "");
    }

    public IntegerValidator propertyOf(Integer prop, String name){
        validators.add(new IntegerValidator(this, prop, name));
        return (IntegerValidator)validators.get(validators.size() - 1);
    }

    public DoubleValidator propertyOf(Double prop) {
        return propertyOf(prop, "");
    }

    public DoubleValidator propertyOf(Double prop, String name){
        validators.add(new DoubleValidator(this, prop, name));
        return (DoubleValidator)validators.get(validators.size() - 1);
    }

    public DateValidator propertyOf(Date prop){
        return propertyOf(prop, "");
    }

    public DateValidator propertyOf(Date prop, String name){
        validators.add(new DateValidator(this, prop, name));
        return (DateValidator)validators.get(validators.size() - 1);
    }

    public BigDecimalValidator propertyOf(BigDecimal prop){
        return propertyOf(prop, "");
    }

    public BigDecimalValidator propertyOf(BigDecimal prop, String name){
        validators.add(new BigDecimalValidator(this, prop, name));
        return (BigDecimalValidator)validators.get(validators.size() - 1);
    }
}
