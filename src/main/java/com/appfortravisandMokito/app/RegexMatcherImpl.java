package com.appfortravisandMokito.app;


import jdk.nashorn.internal.runtime.regexp.joni.Regex;

/**
 * Created by user on 04.03.2017.
 */
public class RegexMatcherImpl implements IRegexMatcher {

    private String pattern;

    public void setRegexPattern(String pattern) {
        this.pattern = pattern;
    }

    public boolean checkIExpresionMatchesThePattern(String expression) {
        return expression.matches(pattern);
    }
}
