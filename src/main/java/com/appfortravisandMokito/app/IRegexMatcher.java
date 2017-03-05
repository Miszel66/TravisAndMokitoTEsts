package com.appfortravisandMokito.app;

/**
 * Created by user on 04.03.2017.
 */
public interface IRegexMatcher {
    void setRegexPattern(String pattern);
    boolean checkIExpresionMatchesThePattern(String expression);
}
