package fitenssclub.model.users.client;

import fitenssclub.model.activities.Activity;
import fitenssclub.model.users.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Klient
 */
public class Client extends User {

    List<Activity> activityList = new ArrayList<>();

    public Client(String login, String password, String firstName, String lastName, String city, String street, LocalDate birthDate) {
        super(login, password, firstName, lastName, city, street, birthDate);
    }

    public Client(String login, String password, String firstName, String lastName, LocalDate birthDate) {
        super(login, password, firstName, lastName, birthDate);
    }

    public void addActivity(Activity activity) {
        this.activityList.add(activity);
    }

    public void removeActivity(Activity activity) {
        this.activityList.remove(activity);
    }

    @Override
    public String toString() {
        return "Client -> " + super.toString() + " -> activityList: \n\t" +  activityList;
    }

}
