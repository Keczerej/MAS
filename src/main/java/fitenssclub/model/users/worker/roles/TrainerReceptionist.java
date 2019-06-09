package fitenssclub.model.users.worker.roles;

import fitenssclub.model.users.worker.Worker;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

//MP03 3. Wielodziedziczenie
public class TrainerReceptionist extends Receptionist implements ITrainer {

    private Set<String> specializations = new HashSet<>();

    @Override
    public Set<String> getSpecializations() {
        return specializations;
    }

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
        return "TrainerReceptionist -> " + super.toString() + specialisationsString();
    }
}
