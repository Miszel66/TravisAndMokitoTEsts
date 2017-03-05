package com.appfortravisandMokito.app;

import org.junit.Before;
import org.junit.Test;

import javax.management.InvalidAttributeValueException;

import static org.assertj.core.api.Assertions.*;

/**
 * Created by user on 04.03.2017.
 */
public class RegexMatcherTest {

    private IRegexMatcher matcher;

    @Before
    public void setUp()
    {
        matcher = new RegexMatcherImpl();
    }

    @Test
    public void checkIfMathcerReturnsTrue()
    {
        matcher.setRegexPattern("\\d*");
        try {
            assertThat(matcher.checkIfExpressionMatchesThePattern("1234")).isTrue();
        } catch (InvalidAttributeValueException e) {
            e.printStackTrace();
        }
    }

    @Test(expected = InvalidAttributeValueException.class)
    public void patterValueMustBeSetBeforecheckingMatch() throws InvalidAttributeValueException {
            assertThat(matcher.checkIfExpressionMatchesThePattern("123")).isTrue();

    }
}
