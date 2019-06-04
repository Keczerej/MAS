package fitenssclub.users.worker.roles;

import fitenssclub.users.worker.Worker;

import java.time.LocalDate;

//MP03 3. Wielodziedziczenie
public class TrainerReceptionist extends Receptionist implements ITrainer {

    public TrainerReceptionist(String login, String password, String firstName, String lastName, String city, String street, LocalDate birthDate) {
        super(login, password, firstName, lastName, city, street, birthDate);
    }

    //MP03 5. Dynamizm -> zmiana roli
    public TrainerReceptionist(Worker prevWorker) {
        super(prevWorker);
        changeRoleHelper(prevWorker);
    }

    @Override
    public int getSalary() {
        return getSalary(workForm) + super.getSalary()/2;
    }

    @Override
    public String toString() {
        return "TrainerReceptionist{}\n" + super.toString() + specialisationsString();
    }
}
