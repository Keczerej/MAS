package fitenssclub.users.client;

import fitenssclub.activities.Activity;
import fitenssclub.users.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
        return super.toString() +  " -> Client{" +
                "activityList=" + activityList +
                '}';
    }
}
