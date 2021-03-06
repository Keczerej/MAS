package fitenssclub.view;

import fitenssclub.model.activities.Exercise;

/**
 * DTO - Klasa transferu danych
 * Klasa przechowująca uproszczone informacje o cwiczeniach
 */
public class ExerciseDTO {

    final boolean isSelected;
    public final String name;
    public final Long time;
    public final Exercise exercise;

    ExerciseDTO(Exercise exercise, Long time) {
        this.exercise = exercise;
        this.isSelected = false;
        this.name = exercise.getName();
        this.time = time;
    }

    ExerciseDTO(boolean isSelected, String name, Long time, Exercise exercise) {
        this.isSelected = isSelected;
        this.name = name;
        this.time = time;
        this.exercise = exercise;
    }

    static String getDetailsString(Exercise exercise) {
        StringBuilder stringBuilder = new StringBuilder();
        if(exercise.getTypes().size() > 0) {
            stringBuilder.append("Typ: \n");
            exercise.getTypes().forEach(type ->
                    stringBuilder.append("   " + type.name + "\n")
            );
            stringBuilder.append("Części ciała: \n");
            exercise.getTypes().forEach(type ->
                    stringBuilder.append("   " + type.bodyPart + "\n")
            );
        }
        if(exercise.getEquipmentList().size() > 0) {
            stringBuilder.append("Akcesoria:\n");
            exercise.getEquipmentList().forEach(equipment ->
                    stringBuilder.append("   " + equipment.getName() + "\n")
            );
        }
        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        return "Nazwa: " + name + ", czas trwania: " + time + " [min]";
    }

}
