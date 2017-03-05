package com.appfortravisandMokito.app;

import javax.management.InvalidAttributeValueException;

/**
 * Created by user on 04.03.2017.
 */
public interface IRegexMatcher {
    void setRegexPattern(String pattern);
    boolean checkIfExpressionMatchesThePattern(String expression) throws InvalidAttributeValueException;
}
