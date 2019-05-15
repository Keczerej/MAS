package fitenssclub.activities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Equipment {

    private String name;
    protected Set<Activity> activities = new HashSet<>();

    public Equipment(String name) {
        this.name = name;
    }

    public ArrayList<Activity> getActivities() {
        return new ArrayList<>(activities);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
