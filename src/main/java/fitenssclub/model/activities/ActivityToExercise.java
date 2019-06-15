package fitenssclub.model.activities;

import java.io.Serializable;


/**
 *  Przechowuje relację wiążącą zajęcoa z ćwiczeniem
 */
public class ActivityToExercise implements Serializable {

    private Exercise exercise;
    private Activity activity;
    private long minutesForExercise;

    /**
     * @param exercise ćwiczenie
     * @param activity zajęcia
     * @param minutesForExercise czas trwania ćwiczenia w trakcie zajęć
     */
    ActivityToExercise(Exercise exercise, Activity activity, long minutesForExercise) {
        this.exercise = exercise;
        this.activity = activity;
        this.minutesForExercise = minutesForExercise;
        this.exercise.activities.add(this);
        this.activity.exercises.add(this);
    }

    /**
     * @return ćwieczenie
     */
    public Exercise getExercise() {
        return exercise;
    }

    /**
     * @return zajęcia
     */
    public Activity getActivity() {
        return activity;
    }

    /**
     * @return czas ćwiczenia
     */
    long getMinutesForExercise() {
        return minutesForExercise;
    }

    /**
     * @param minutesForExercise nowy czas ćwiczeń
     */
    public void setMinutesForExercise(long minutesForExercise) {
        this.minutesForExercise = minutesForExercise;
    }

    /**
     * Usuwa tą relację z obiektów, których dotyczy
     */
    void removeAssocation(){
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
