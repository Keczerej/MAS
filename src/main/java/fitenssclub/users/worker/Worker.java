package fitenssclub.users.worker;

import fitenssclub.activities.Activity;
import fitenssclub.users.User;
import fitenssclub.users.client.Client;
import fitenssclub.users.worker.form.WorkForm;
import fitenssclub.users.worker.roles.Manager;
import fitenssclub.users.worker.roles.Receptionist;
import fitenssclub.users.worker.roles.Trainer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class Worker extends User {

    private WorkForm workForm = WorkForm.createUoP(this);

    //MP03 4. Wieloaspektowość
    public String getWorkFormName(){
        return this.workForm.getWorkFormName();
    }

    public double getSalaryScale() {
        return this.workForm.getSalaryScale();
    }

    public Worker(String login, String password, String firstName, String lastName,  String city, String street, LocalDate birthDate) {
        super(login, password, firstName, lastName, city, street, birthDate);
    }

    public Worker(String login, String password, String firstName, String lastName, LocalDate birthDate) {
        super(login, password, firstName, lastName, birthDate);
    }

    //MP03 1. Polimorfizm
    abstract public int getSalary();

    //MP03 5. Dynamizm -> zmiana roli
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
                    this.getBirthDate()
            );
        }
        if(role == Receptionist.class) {
            newInstance = (T) new Receptionist(
                    this.getLogin(),
                    this.getPassword(),
                    this.getFirstName(),
                    this.getLastName(),
                    this.getBirthDate()
            );
        }
        if(role == Trainer.class) {
            newInstance = (T) new Trainer(
                    this.getLogin(),
                    this.getPassword(),
                    this.getFirstName(),
                    this.getLastName(),
                    this.getBirthDate()
            );
        }
        T finalNewInstance = newInstance;
        finalNewInstance.setWorkForm(
                this.workForm.cloneIntoWorker(finalNewInstance)
        );
        this.getAddresses().forEach(address -> {
            finalNewInstance.getAddresses().add(address);
        });
        return finalNewInstance;
    }


    public void setWorkForm(WorkForm workForm) {
        this.workForm = workForm;
    }

}
