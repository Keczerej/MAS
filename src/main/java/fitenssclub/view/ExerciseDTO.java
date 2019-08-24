package fitenssclub.view;

import fitenssclub.model.activities.Exercise;

/**
 * DTO - Klasa transferu danych
 * Klasa przechowująca uproszczone informacje o cwiczeniach
 */
public class ExerciseDTO {

    final boolean isSelected;
    public final String name;
    public final Integer time;
    public final Exercise exercise;

    ExerciseDTO(Exercise exercise) {
        this.exercise = exercise;
        this.isSelected = false;
        this.name = exercise.getName();
        this.time = 10;
    }

    ExerciseDTO(boolean isSelected, String name, Integer time, Exercise exercise) {
        this.isSelected = isSelected;
        this.name = name;
        this.time = time;
        this.exercise = exercise;
    }

    static String getDetailsString(Exercise exercise) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Typ: \n");
        exercise.getTypes().forEach(type ->
                stringBuilder.append("   " + type.name + "\n")
        );
        stringBuilder.append("Części ciała: \n");
        exercise.getTypes().forEach(type ->
                stringBuilder.append("   " + type.bodyPart + "\n")
        );
        stringBuilder.append("Akcesoria:\n");
        exercise.getEquipmentList().forEach(equipment ->
                stringBuilder.append("   " + equipment.getName() + "\n")
        );
        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        return "Nazwa: " + name + ", czas trwania: " + time + " [min]";
    }

}
