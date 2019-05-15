package fitenssclub.users.worker.roles;

import fitenssclub.users.Address;
import fitenssclub.users.worker.Worker;
import fitenssclub.users.worker.form.WorkForm;

import java.time.LocalDate;

public class Manager extends Worker {

    public Manager(String login, String password, String firstName, String lastName, Address address, LocalDate birthDate, WorkForm workForm) {
        super(login, password, firstName, lastName, address, birthDate, workForm);
    }

    public Manager(String login, String password, String firstName, String lastName, LocalDate birthDate, WorkForm workForm) {
        super(login, password, firstName, lastName, birthDate, workForm);
    }
}
