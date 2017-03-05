package com.appfortravisandMokito.app;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * Created by user on 04.03.2017.
 */
public class RegexMatcherTests {

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
        assertThat(matcher.checkIExpresionMatchesThePattern("1234")).isTrue();
    }
}
