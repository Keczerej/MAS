package fitenssclub.users.worker.roles;

import fitenssclub.users.worker.Worker;

import java.time.LocalDate;

public class Receptionist extends Worker {

    public Receptionist(String login, String password, String firstName, String lastName, String city, String street,LocalDate birthDate) {
        super(login, password, firstName, lastName, city, street, birthDate);
    }

    public Receptionist(String login, String password, String firstName, String lastName, LocalDate birthDate) {
        super(login, password, firstName, lastName, birthDate);
    }

    //MP03 5. Dynamizm -> zmiana roli
    public Receptionist(Worker prevWorker) {
        super(
                prevWorker.getLogin(),
                prevWorker.getPassword(),
                prevWorker.getFirstName(),
                prevWorker.getLastName(),
                prevWorker.getBirthDate()
        );
        this.clone(prevWorker);
    }

    @Override
    public int getSalary() {
        double scale = this.getSalaryScale();
        return (int)(2500 * scale);
    }
}
