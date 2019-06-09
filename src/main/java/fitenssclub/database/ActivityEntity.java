package fitenssclub.database;

import fitenssclub.model.activities.Activity;

public class ActivityEntity extends DatabaseEntity<Activity> {

    private ActivityEntity(){}

    private static ActivityEntity instance = null;

    public static ActivityEntity getInstance() {
        if(instance == null)
            instance = new ActivityEntity();
        return instance;
    }

}
