package fitenssclub.users.client;

import fitenssclub.users.Address;
import fitenssclub.users.User;

import java.time.LocalDate;

public class Client extends User {

    public Client(String login, String password, String firstName, String lastName, Address address, LocalDate birthDate) {
        super(login, password, firstName, lastName, address, birthDate);
    }

    public Client(String login, String password, String firstName, String lastName, LocalDate birthDate) {
        super(login, password, firstName, lastName, birthDate);
    }

}
