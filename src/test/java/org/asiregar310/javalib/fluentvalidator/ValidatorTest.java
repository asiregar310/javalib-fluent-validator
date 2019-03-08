package org.asiregar310.javalib.fluentvalidator;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ValidatorTest {

    Validator validator = null;

    @Before
    public void before(){
        validator = Validator.create();
    }

    @After
    public void after(){
        validator = null;
    }

    @Test
    public void stringNotEmptyAndMinimalLength5_shouldSuccess() {
        String value = "abcde";

        validator
            .propertyOf(value, "checked-value").mustNotNullOrEmpty()
            .propertyOf(value, "checked-value").minLength(5)
            .validate();

        Assert.assertTrue(validator.isValid());
    }

    @Test
    public void stringNotEmpty_shouldFailed() {
        String value = "";

        validator
            .propertyOf(value, "checked-value").mustNotNullOrEmpty()
            .validate();

        Assert.assertFalse(validator.isValid());
    }

    @Test
    public void stringMinLength5_shouldFailed() {
        String value = "a";

        validator
            .propertyOf(value, "checked-value").minLength(5)
            .validate();

        Assert.assertFalse(validator.isValid());
    }
}