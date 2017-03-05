package com.appfortravisandMokito.app;

import junitparams.JUnitParamsRunner;
import static junitparams.JUnitParamsRunner.$;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.management.InvalidAttributeValueException;

import static org.assertj.core.api.Assertions.*;

/**
 * Created by user on 05.03.2017.
 */
@RunWith(JUnitParamsRunner.class)
public class PasswordValidatorTest {
    private IPasswordValidator validator;
    private static final String FOUR_DIGITS = "\\d{4}";

    @Before
    public void setUp()
    {
        this.validator = new PasswordValidator(new RegexMatcherImpl());
    }

    @Test
    @Parameters(method = "getValidPasswords")
    public void validatesPassword_ShouldReturnTrue(String validPassword) throws InvalidAttributeValueException {

        validator.setUpPasswordPattern(FOUR_DIGITS);

        assertThat(validator.validatePassword(validPassword)).isTrue();
    }
    private static final Object [] getValidPasswords()
    {
        return $("1234","1111","1322","1124");
    }

    @Test
    @Parameters(method = "getInValidPasswords")
    public void validatesPassword_ShouldReturnFalse(String inValidPassword) throws InvalidAttributeValueException {

        validator.setUpPasswordPattern(FOUR_DIGITS);

        assertThat(validator.validatePassword(inValidPassword)).isFalse();
    }
    private static final Object [] getInValidPasswords()
    {
        return $("z","","13asd","11241111");
    }




}
