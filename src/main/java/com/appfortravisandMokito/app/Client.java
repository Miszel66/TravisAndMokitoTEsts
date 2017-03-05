package com.appfortravisandMokito.app;

import com.sun.javaws.exceptions.InvalidArgumentException;

import java.security.InvalidParameterException;

/**
 * Created by user on 04.03.2017.
 */
public class Client {
    private Address address;

    public Client(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    public void changeAddres(String cityName, String postCode) throws InvalidParameterException
    {
       checkIfAddressParametersAreNotNullNorEmpty(cityName,postCode);

        this.address = new Address(cityName,postCode);
    }
    private void checkIfAddressParametersAreNotNullNorEmpty(String cityName, String postCode)
    {
        if(cityName == null|| postCode == null)
            throw new InvalidParameterException("cityName or PostCode is Null");
        if(cityName == ""|| postCode == "")
            throw new InvalidParameterException("cityName or PostCode is empty");
    }
}
