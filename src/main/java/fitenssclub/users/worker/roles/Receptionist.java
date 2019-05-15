package fitenssclub.users.worker.roles;

import fitenssclub.users.Address;
import fitenssclub.users.worker.Worker;
import fitenssclub.users.worker.form.WorkForm;

import java.time.LocalDate;

public class Receptionist extends Worker {

    public Receptionist(String login, String password, String firstName, String lastName, Address address, LocalDate birthDate, WorkForm workForm) {
        super(login, password, firstName, lastName, address, birthDate, workForm);
    }

    public Receptionist(String login, String password, String firstName, String lastName, LocalDate birthDate, WorkForm workForm) {
        super(login, password, firstName, lastName, birthDate, workForm);
    }
}
