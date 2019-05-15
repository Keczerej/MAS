package fitenssclub.users;

import java.io.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

public abstract class User implements Serializable {

    private static int MIN_AGE = 16;
    private String login;

    private String password;
    private String firstName;
    private String lastName;
    private Address address;
    private LocalDate birthDate;
    private transient Integer age;

    public User(String login, String password, String firstName, String lastName, Address address, LocalDate birthDate) {
        this(login, password, firstName, lastName, birthDate);
        this.address = address;
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
        User.users.remove(this);
        User.users.add(this);
    }

    public Optional<Address> getAddress() {
        return Optional.of(this.address);
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

    public void setAddress(Address address) {
        this.address = address;
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
                ", address=" + address +
                ", birthDate=" + birthDate +
                ", age=" + getAge() +
                '}';
    }

    public static void readFromFile(String filePath) {
        try {
            User.users.addAll(
                    (
                            (List<User>) new ObjectInputStream(
                                    new FileInputStream(filePath)
                            ).readObject()
                    )
            );
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void writeToFile(String filePath) {
        try {
            new ObjectOutputStream(
                    new FileOutputStream(filePath)
            ).writeObject(new ArrayList<>(User.users));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Set<User> users = new HashSet<>(); //Ekstensja,

    public static Set<User> getUsers() { //Metoda klasowa
        return new HashSet<>(User.users);
    } //Metoda klasowa,

}


