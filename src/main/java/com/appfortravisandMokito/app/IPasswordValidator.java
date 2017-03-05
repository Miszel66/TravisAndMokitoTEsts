package com.appfortravisandMokito.app;

import javax.management.InvalidAttributeValueException;

/**
 * Created by user on 05.03.2017.
 */
public interface IPasswordValidator {
    boolean validatePassword(String password) throws InvalidAttributeValueException;
    void setUpPasswordPattern(String pattern);
}
