package fitenssclub.model.users.worker.roles;

import fitenssclub.model.users.worker.Worker;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Trainer extends Worker implements ITrainer {

    private Set<String> specializations = new HashSet<>();

    @Override
    public Set<String> getSpecializations() {
        return specializations;
    }

    public Trainer(String login, String password, String firstName, String lastName, String city, String street, LocalDate birthDate, Set<String> specialization) {
        super(login, password, firstName, lastName, city, street, birthDate);
        this.specializations.addAll(specialization);
    }

    //MP03 5. Dynamizm -> zmiana roli
    public Trainer(Worker prevWorker) {
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
        return getSalary(workForm);
    }

    @Override
    public String toString() {
        return "Trainer -> " + super.toString() + specialisationsString();
    }
}
