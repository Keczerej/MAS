package fitenssclub.model.users.worker.roles;

import fitenssclub.model.users.worker.Worker;

import java.time.LocalDate;

public class Receptionist extends Worker {

    public Receptionist(String login, String password, String firstName, String lastName, String city, String street,LocalDate birthDate) {
        super(login, password, firstName, lastName, city, street, birthDate);
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
        this.changeRoleHelper(prevWorker);
    }

    @Override
    public int getSalary() {
        double scale = this.getSalaryScale();
        return (int)(2500 * scale);
    }

    @Override
    public String toString() {
        return "Receptionist -> " + super.toString();
    }

}
