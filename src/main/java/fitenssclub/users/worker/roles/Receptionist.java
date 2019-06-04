package fitenssclub.users.worker.roles;

import fitenssclub.users.Address;
import fitenssclub.users.worker.Worker;
import fitenssclub.users.worker.form.WorkForm;

import java.time.LocalDate;

public class Receptionist extends Worker {

    public Receptionist(String login, String password, String firstName, String lastName, String city, String street,LocalDate birthDate) {
        super(login, password, firstName, lastName, city, street, birthDate);
    }

    public Receptionist(String login, String password, String firstName, String lastName, LocalDate birthDate) {
        super(login, password, firstName, lastName, birthDate);
    }

    @Override
    public int getSalary() {
        double scale = this.getSalaryScale();
        return (int)(2500 * scale);
    }
}
