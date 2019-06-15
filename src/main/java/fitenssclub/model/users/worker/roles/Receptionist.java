package fitenssclub.model.users.worker.roles;

import fitenssclub.model.users.worker.Worker;

import java.time.LocalDate;

public class Receptionist extends Worker {

    public Receptionist(String login, String password, String firstName, String lastName, String city, String street,LocalDate birthDate) {
        super(login, password, firstName, lastName, city, street, birthDate);
    }

    //MP03 5. Dynamizm -> zmiana roli
    /**
     * Zwraca instancję tego samego pracownika, ale z nową rolą. Uwaga! Nie powinno korzystać się z instancji
     * prevWorker - traktować ją jakby nie istaniała.
     *
     * @param prevWorker pracownik, który zmienia rolę
     */
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
