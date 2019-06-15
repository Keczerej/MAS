package fitenssclub.view;

import fitenssclub.model.activities.Exercise;

public class ExerciseDTO {

    @Override
    public String toString() {
        return "ExerciseDTO{" +
                "isSelected=" + isSelected +
                ", name='" + name + '\'' +
                ", time=" + time +
                ", exercise=" + exercise +
                '}';
    }

    ExerciseDTO(Exercise exercise) {
        this.exercise = exercise;
        this.isSelected = false;
        this.name = exercise.getName();
        this.time = 10;
    }

    public ExerciseDTO(boolean isSelected, String name, Integer time, Exercise exercise) {
        this.isSelected = isSelected;
        this.name = name;
        this.time = time;
        this.exercise = exercise;
    }

    final boolean isSelected;
    public final String name;
    public final Integer time;
    public final Exercise exercise;

}
