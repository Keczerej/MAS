package fitenssclub.model.activities;

import java.io.Serializable;


public class ActivityToExercise implements Serializable {

    private Exercise exercise;
    private Activity activity;
    private long minutesForExercise;

    public ActivityToExercise(Exercise exercise, Activity activity, long minutesForExercise) {
        this.exercise = exercise;
        this.activity = activity;
        this.minutesForExercise = minutesForExercise;
        this.exercise.activities.add(this);
        this.activity.exercises.add(this);
    }

    public Exercise getExercise() {
        return exercise;
    }

    public Activity getActivity() {
        return activity;
    }

    public long getMinutesForExercise() {
        return minutesForExercise;
    }

    public void setMinutesForExercise(long minutesForExercise) {
        this.minutesForExercise = minutesForExercise;
    }

    public void removeAssocation(){
        this.activity.exercises.remove(this);
        this.exercise.activities.remove(this);
    }

    @Override
    public String toString() {
        return "ActivityToExercise{" +
                "exercise=" + exercise +
                ", minutesForExercise=" + minutesForExercise +
                '}';
    }
}
