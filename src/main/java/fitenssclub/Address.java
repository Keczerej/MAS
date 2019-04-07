package fitenssclub;

import java.io.Serializable;

public class Address implements Serializable {

    private String city;
    private String address;

    public Address(String city, String address) {
        this.city = city;
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
