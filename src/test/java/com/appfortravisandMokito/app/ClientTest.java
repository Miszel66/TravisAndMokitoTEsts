package com.appfortravisandMokito.app;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.security.InvalidParameterException;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.assertEquals;

/**
 * Created by user on 04.03.2017.
 */
@RunWith(JUnitParamsRunner.class)
public class ClientTest {
    private Client client;
    private Address address;

    @Before
    public void setUp() {
        address = new Address("Pabianice", "95-200");
        client = new Client(address);
    }

    @Test
    public void newClientMustHaveAnAddress() {
        assertThat(client.getAddress()).isEqualTo(new Address("Pabianice", "95-200"));
    }

    @Test(expected = InvalidParameterException.class)
    @Parameters(method = "getInvalidAddress")
    public void changeClientAddress_If_Null_throws_exception(String address, String zipCode) {
        client.changeAddres(address, zipCode);
    }

    private static final Object[] getInvalidAddress() {
        return new Object[][]
                {
                        new Object[]{null, null},
                        new Object[]{null, "95-200"},
                        new Object[]{"notNull", null},
                        new Object[]{"", ""},
                        new Object[]{"", "95-200"},
                        new Object[]{"notEmpty", ""}

                };
    }

    @Test
    @Parameters(method = "getValidAddress")
    public void changedClientAddressEqualsToNewAddress(String cityName, String zipCode) {
        client.changeAddres(cityName, zipCode);

        assertEquals(client.getAddress(),new Address(cityName, zipCode));
    }

    private Object[] getValidAddress() {
        return new Object[][]
                {
                        new Object[]{"Lodz", "95-556"},
                        new Object[]{"Warszawa", "91-200"},
                        new Object[]{"Krakow", "11-323"}
                };
    }

}
