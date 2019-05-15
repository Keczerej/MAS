package fitenssclub.users;

import java.io.Serializable;

public class Address implements Serializable {

    private final User user;
    private String city;
    private String street;

    Address(String city, String address, User user) {
        this.city = city;
        this.street = address;
        this.user = user;
    }

    public String getAddress() {
        return street;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", street='" + street + '\'' +
                '}';
    }

    public User getUser() {
        return user;
    }
}
