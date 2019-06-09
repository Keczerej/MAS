package fitenssclub.database;

import fitenssclub.model.activities.Exercise;

public class ExerciseEntity extends DatabaseEntity<Exercise> {

    private ExerciseEntity(){}

    private static ExerciseEntity instance = null;

    public static ExerciseEntity getInstance() {
        if(instance == null)
            instance = new ExerciseEntity();
        return instance;
    }

}
