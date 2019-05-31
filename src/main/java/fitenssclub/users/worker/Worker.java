package fitenssclub.users.worker;

import fitenssclub.activities.Activity;
import fitenssclub.users.User;
import fitenssclub.users.client.Client;
import fitenssclub.users.worker.form.WorkForm;
import fitenssclub.users.worker.form.WorkFormInterface;
import fitenssclub.users.worker.roles.Manager;
import fitenssclub.users.worker.roles.Receptionist;
import fitenssclub.users.worker.roles.Trainer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//MP03 Dziedziczenie po użytkowniku
public abstract class Worker extends User implements WorkFormInterface {

    private WorkForm workForm;

    public Worker(String login, String password, String firstName, String lastName,  String city, String street, LocalDate birthDate, WorkForm workForm) {
        super(login, password, firstName, lastName, city, street, birthDate);
        this.workForm = workForm;
    }

    public Worker(String login, String password, String firstName, String lastName, LocalDate birthDate, WorkForm workForm) {
        super(login, password, firstName, lastName, birthDate);
        this.workForm = workForm;
    }

    //MP03 Wieloaspektowość
    public WorkForm getWorkForm() {
        return workForm;
    }

    public void setWorkForm(WorkForm workForm) {
        this.workForm = workForm;
    }

    //MP03 Polimorfizm
    abstract public int getSalary();

    //MP03 Dynamizm -> zmiana roli
    public <T extends Worker> T changeRole(Class<T> role) {
        if(this.getClass() == role){
            return (T) this;
        }
        if(this.getClass() == Trainer.class) {
            List<Activity> toDelete = new ArrayList<>();
            for(Activity activity : Activity.getActivities()) {
                    if(activity.getTrainer() == this) {
                        Iterator<Client> clients = activity.getContributors().iterator();
                        while(clients.hasNext()){
                            activity.removeContributor(clients.next().getLogin());
                        }
                        toDelete.add(activity);
                    }
            }
            Activity.getActivities().remove(toDelete);
        }
        User.getUsers().remove(this);
        T newInstance = null;
        if(role == Manager.class) {
            newInstance = (T) new Manager(
                    this.getLogin(),
                    this.getPassword(),
                    this.getFirstName(),
                    this.getLastName(),
                    this.getBirthDate(),
                    this.getWorkForm()
            );
        }
        if(role == Receptionist.class) {
            newInstance = (T) new Receptionist(
                    this.getLogin(),
                    this.getPassword(),
                    this.getFirstName(),
                    this.getLastName(),
                    this.getBirthDate(),
                    this.getWorkForm()
            );
        }
        if(role == Trainer.class) {
            newInstance = (T) new Trainer(
                    this.getLogin(),
                    this.getPassword(),
                    this.getFirstName(),
                    this.getLastName(),
                    this.getBirthDate(),
                    this.getWorkForm()
            );
        }
        T finalNewInstance = newInstance;
        this.getAddresses().forEach(address -> {
            finalNewInstance.getAddresses().add(address);
        });
        return finalNewInstance;
    }

    @Override
    //MP03 Polimorfizm
    public String getWorkFormName(){
        return this.workForm.getWorkFormName();
    }

}
