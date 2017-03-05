package com.appfortravisandMokito.app;

import javax.management.InvalidAttributeValueException;

/**
 * Created by user on 05.03.2017.
 */
public class PasswordValidator implements IPasswordValidator {

    IRegexMatcher matcher;

    public PasswordValidator(IRegexMatcher matcher) {
        this.matcher = matcher;
    }

    public boolean validatePassword(String password) throws InvalidAttributeValueException {
        return matcher.checkIfExpressionMatchesThePattern(password);
    }

    public void setUpPasswordPattern(String pattern) {
        matcher.setRegexPattern(pattern);
    }


}
