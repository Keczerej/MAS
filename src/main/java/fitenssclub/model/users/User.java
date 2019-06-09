package fitenssclub.model.users;

import fitenssclub.database.UserEntity;

import java.io.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

//MP03 1. Klasa Abstrakcyjna
public abstract class User implements Serializable {

    private static int MIN_AGE = 16;
    private String login;

    private String password;
    private String firstName;
    private String lastName;
    private List<Address> addresses = new ArrayList<>(); //Asocjacja - kompozycja
    private LocalDate birthDate;
    private transient Integer age;

    public User(String login, String password, String firstName, String lastName, String city, String street, LocalDate birthDate) {
        this(login, password, firstName, lastName, birthDate);
        this.addAddress(city, street);
    }

    public User(String login, String password, String firstName, String lastName, LocalDate birthDate) {
        this.login = login;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        calculateAndAssignAge();
        if (this.age < MIN_AGE) {
            throw new IllegalArgumentException("Użytkownik powinien mieć co najmniej 16 lat");
        }
        UserEntity.getInstance().remove(this);
        UserEntity.getInstance().add(this);
    }

    public List<Address> getAddresses() {
        return this.addresses;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void addAddress(String city, String street) {
        this.addresses.add(new Address(city, street, this));
    }

    public void removeAddress(Address address) {
        this.addresses.remove(address);
    }

    public Integer getAge() {
        if (this.age == null)
            calculateAndAssignAge();
        return age;
    }

    private void calculateAndAssignAge() {
        this.age = (int) ChronoUnit.YEARS.between(this.birthDate, LocalDate.now());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return login.equals(user.login);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login);
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", addresses=" + addresses +
                ", birthDate=" + birthDate +
                ", age=" + getAge() +
                '}';
    }

}


