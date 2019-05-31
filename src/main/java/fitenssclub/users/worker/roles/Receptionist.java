package fitenssclub.users.worker.roles;

import fitenssclub.users.Address;
import fitenssclub.users.worker.Worker;
import fitenssclub.users.worker.form.WorkForm;

import java.time.LocalDate;

public class Receptionist extends Worker {

    public Receptionist(String login, String password, String firstName, String lastName, String city, String street,LocalDate birthDate, WorkForm workForm) {
        super(login, password, firstName, lastName, city, street, birthDate, workForm);
    }

    public Receptionist(String login, String password, String firstName, String lastName, LocalDate birthDate, WorkForm workForm) {
        super(login, password, firstName, lastName, birthDate, workForm);
    }

    @Override
    public int getSalary() {
        double scale = 1;
        if(this.getWorkForm() == WorkForm.B2B) {
            scale = 1.3;
        }
        return (int)(2500 * scale);
    }
}
