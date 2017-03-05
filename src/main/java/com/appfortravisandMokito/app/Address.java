package com.appfortravisandMokito.app;

/**
 * Created by user on 04.03.2017.
 */
public class Address {
    private String cityName;
    private String postCode;

    public Address(String cityName, String postCode) {
        this.cityName = cityName;
        this.postCode = postCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Address address = (Address) o;

        if (cityName != null ? !cityName.equals(address.cityName) : address.cityName != null) return false;
        return postCode != null ? postCode.equals(address.postCode) : address.postCode == null;
    }

    @Override
    public int hashCode() {
        int result = cityName != null ? cityName.hashCode() : 0;
        result = 31 * result + (postCode != null ? postCode.hashCode() : 0);
        return result;
    }
}
