package fitenssclub;

import java.io.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class User implements Serializable {

    private String login;
    private String password;
    private String firstName;
    private String lastName;
    private Address address; //Atrybut opcjonalny, Atrybut żłożony
    private LocalDate birthDate;
    private transient Integer age; //Atrybut pochodny, trwałość

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
        User.users.remove(this);
        User.users.add(this);
        if (this.age < 16) {
            throw new IllegalArgumentException("Użytkownik powinien mieć co najmniej 16 lat");
        }
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

    public Integer getAge() {
        if (this.age == null)
            calculateAndAssignAge();
        return age;
    }

    private void calculateAndAssignAge() {
        this.age = (int) ChronoUnit.YEARS.between(this.birthDate, LocalDate.now());
    }

    @Override //przesłonięcie, przeciążenie
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return login.equals(user.login);
    }

    @Override //przesłonięcie, przeciążenie
    public int hashCode() {
        return Objects.hash(login);
    }

    @Override //przesłonięcie, przeciążenie
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
            User.users.addAll(((List<User>) new ObjectInputStream(new FileInputStream(filePath)).readObject()));
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void writeToFile(String filePath) {
        try {
            new ObjectOutputStream(new FileOutputStream(filePath)).writeObject(new ArrayList<>(User.users));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Set<User> users = new HashSet<>(); //Ekstencja, Atrybut klasowy, Atrybut powtarzalny

    public static Set<User> getUsers() { //Metoda klasowa
        return new HashSet<>(User.users);
    }

}


