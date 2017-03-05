package com.appfortravisandMokito.app;


import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import  org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class MoneyTest {

    private final int VALID_AMOUNT = 1;
    private final String VALID_CURRENCY = "EUR";

    @Test
    @Parameters(method = "getMoney")
    public void constructorShouldSetRightAmountAndCurrency(int amount, String currency)
    {
        Money money = new Money(amount, currency);

        assertEquals(amount, money.getAmount());
        assertEquals(currency, money.getCurrency());
    }

    private static final Object [] getMoney(){
        return new Object[]{
                new Object[]{10,"USD"},
                new Object[] {20,"EUR"},
                new Object[] {120,"PLN"},
                new Object[] {320,"GB"}
        };
    }

    @Test(expected = IllegalArgumentException.class)
    @Parameters(method = "illegalAmount")
    public void moneyConstructorThrowsExceptionWhenAmountIsLessThen_0(int amount){
        Money money = new Money(amount, VALID_CURRENCY);
    }
    private static final Object [] illegalAmount()
    {
        return new Integer[][]
                {
                        {-12387},
                        {-5},
                        {-1}
                };
    }

    @Test(expected = IllegalArgumentException.class)
    @Parameters(method = "illegalCurrency")
    public void moneyConstructorThrowsExceptionWhenCurrencyIsNull(String currency) {
            Money money = new Money(VALID_AMOUNT,currency);
    }
    private static final Object [] illegalCurrency()
    {
        return new String[][]
                {
                        {null},
                        {""}
                };
    }

}
