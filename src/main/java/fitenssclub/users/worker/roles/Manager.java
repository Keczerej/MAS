package fitenssclub.users.worker.roles;

import fitenssclub.users.worker.Worker;
import fitenssclub.users.worker.form.WorkForm;

import java.time.LocalDate;

public class Manager extends Worker {

    public Manager(String login, String password, String firstName, String lastName, String city, String street, LocalDate birthDate, WorkForm workForm) {
        super(login, password, firstName, lastName, city, street, birthDate, workForm);
    }

    public Manager(String login, String password, String firstName, String lastName, LocalDate birthDate, WorkForm workForm) {
        super(login, password, firstName, lastName, birthDate, workForm);
    }

    @Override
    public int getSalary() {
        return 4500;
    }
}
