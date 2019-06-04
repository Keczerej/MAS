package fitenssclub.users.worker.roles;

import fitenssclub.users.worker.Worker;

import java.time.LocalDate;

public class Manager extends Worker {

    public Manager(String login, String password, String firstName, String lastName, String city, String street, LocalDate birthDate) {
        super(login, password, firstName, lastName, city, street, birthDate);
    }

    public Manager(String login, String password, String firstName, String lastName, LocalDate birthDate) {
        super(login, password, firstName, lastName, birthDate);
    }

    //MP03 5. Dynamizm -> zmiana roli
    public Manager(Worker prevWorker) {
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
        return (int)(4500 * scale);
    }
}
