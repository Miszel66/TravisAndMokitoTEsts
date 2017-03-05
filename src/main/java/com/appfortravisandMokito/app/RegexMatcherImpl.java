package com.appfortravisandMokito.app;

import javax.management.InvalidAttributeValueException;


/**
 * Created by user on 04.03.2017.
 */
public class RegexMatcherImpl implements IRegexMatcher {

    private String pattern;

    public void setRegexPattern(String pattern) {
        this.pattern = pattern;
    }

    public boolean checkIfExpressionMatchesThePattern(String expression) throws InvalidAttributeValueException {
        checkIfPatterIsProvided();

        return expression.matches(pattern);
    }
    private void checkIfPatterIsProvided()throws InvalidAttributeValueException
    {
        if(pattern == null)
            throw new InvalidAttributeValueException("pattern was not provided");
    }
}
