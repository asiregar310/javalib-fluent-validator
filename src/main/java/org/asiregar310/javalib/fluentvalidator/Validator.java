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

    public StringValidatorBase propertyOf(String prop) {
        return propertyOf(prop, "");
    }

    public StringValidatorBase propertyOf(String prop, String name){
        validators.add(new StringValidatorBase(this, prop, name));
        return (StringValidatorBase)validators.get(validators.size() - 1);
    }

    public IntegerValidatorBase propertyOf(Integer prop) {
        return propertyOf(prop, "");
    }

    public IntegerValidatorBase propertyOf(Integer prop, String name){
        validators.add(new IntegerValidatorBase(this, prop, name));
        return (IntegerValidatorBase)validators.get(validators.size() - 1);
    }

    public DoubleValidatorBase propertyOf(Double prop) {
        return propertyOf(prop, "");
    }

    public DoubleValidatorBase propertyOf(Double prop, String name){
        validators.add(new DoubleValidatorBase(this, prop, name));
        return (DoubleValidatorBase)validators.get(validators.size() - 1);
    }

    public DateValidatorBase propertyOf(Date prop){
        return propertyOf(prop, "");
    }

    public DateValidatorBase propertyOf(Date prop, String name){
        validators.add(new DateValidatorBase(this, prop, name));
        return (DateValidatorBase)validators.get(validators.size() - 1);
    }

    public BigDecimalValidatorBase propertyOf(BigDecimal prop){
        return propertyOf(prop, "");
    }

    public BigDecimalValidatorBase propertyOf(BigDecimal prop, String name){
        validators.add(new BigDecimalValidatorBase(this, prop, name));
        return (BigDecimalValidatorBase)validators.get(validators.size() - 1);
    }
}
