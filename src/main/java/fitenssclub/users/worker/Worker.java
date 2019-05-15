package fitenssclub.users.worker;

import fitenssclub.users.Address;
import fitenssclub.users.User;
import fitenssclub.users.worker.form.WorkForm;

import java.time.LocalDate;

//TODO: Dynamizm -> zmiana roli
public abstract class Worker extends User implements WorkForm {

    private WorkForm workForm;

    public Worker(String login, String password, String firstName, String lastName, Address address, LocalDate birthDate, WorkForm workForm) {
        super(login, password, firstName, lastName, address, birthDate);
        this.workForm = workForm;
    }

    public Worker(String login, String password, String firstName, String lastName, LocalDate birthDate, WorkForm workForm) {
        super(login, password, firstName, lastName, birthDate);
        this.workForm = workForm;
    }

    public WorkForm getWorkForm() {
        return workForm;
    }

    public void setWorkForm(WorkForm workForm) {
        this.workForm = workForm;
    }

    @Override
    public String getWorkFormName(){
        return this.workForm.getWorkFormName();
    }

}
