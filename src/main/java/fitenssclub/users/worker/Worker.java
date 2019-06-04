package fitenssclub.users.worker;

import fitenssclub.activities.Activity;
import fitenssclub.users.User;
import fitenssclub.users.client.Client;
import fitenssclub.users.worker.form.WorkForm;
import fitenssclub.users.worker.roles.ITrainer;

import java.time.LocalDate;
import java.util.*;

public abstract class Worker extends User {

    protected WorkForm workForm = WorkForm.createUoP(this);

    public void setWorkForm(WorkForm workForm) {
        this.workForm = workForm;
    }

    public String getWorkFormName(){
        return this.workForm.getWorkFormName();
    }

    protected double getSalaryScale() {
        return this.workForm.getSalaryScale();
    }

    public Worker(String login, String password, String firstName, String lastName,  String city, String street, LocalDate birthDate) {
        super(login, password, firstName, lastName, city, street, birthDate);
    }

    protected Worker(String login, String password, String firstName, String lastName, LocalDate birthDate) {
        super(login, password, firstName, lastName, birthDate);
    }

    //MP03 1. Polimorfizm
    abstract public int getSalary();

    protected void changeRoleHelper(Worker prevWorker) {
        if(prevWorker.getClass() == this.getClass()){
            throw new IllegalArgumentException("Can't change role - it's the same.");
        }
        if(Arrays.asList(prevWorker.getClass().getInterfaces()).contains(ITrainer.class)) {
            List<Activity> toDelete = new ArrayList<>();
            for(Activity activity : Activity.getActivities()) {
                if(activity.getTrainer() == prevWorker) {
                    Iterator<Client> clients = activity.getContributors().iterator();
                    while(clients.hasNext()){
                        activity.removeContributor(clients.next().getLogin());
                    }
                    toDelete.add(activity);
                }
            }
            Activity.getActivities().remove(toDelete);
        }
        this.getAddresses().forEach(address -> this.getAddresses().add(address));
        this.workForm.cloneIntoWorker(this);
    }

}
