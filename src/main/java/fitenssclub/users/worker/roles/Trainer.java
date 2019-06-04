package fitenssclub.users.worker.roles;

import fitenssclub.users.worker.Worker;

import java.time.LocalDate;

public class Trainer extends Worker {

    public Trainer(String login, String password, String firstName, String lastName,  String city, String street, LocalDate birthDate) {
        super(login, password, firstName, lastName, city, street, birthDate);
    }

    public Trainer(String login, String password, String firstName, String lastName, LocalDate birthDate) {
        super(login, password, firstName, lastName, birthDate);
    }

    @Override
    public int getSalary() {
        double scale = this.getSalaryScale();
        return (int)(3000 * scale);
    }


}
