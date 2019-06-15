package fitenssclub.model.activities;

/**
 * Typ ćwiczenia
 * Stworzenie obiektu automatycznie zapisuje go w bazie danych w pamieci
 */
public enum ExerciseType {
    Relax("Relaksacyjne", "Kręgosłup"),
    Strength("Siłowe", "Triceps+Biceps"),
    Aerobic("Aerobowe", "Brzuch");

    private final String name;
    private final String bodyPart;

    @Override
    public String toString() {
        return "ExerciseType{" +
                "name='" + name + '\'' +
                ", bodyPart='" + bodyPart + '\'' +
                "} " + super.toString();
    }

    /**
     * @param name nazwa
     * @param bodyPart część ciała
     */
    ExerciseType(String name, String bodyPart) {
        this.name = name;
        this.bodyPart = bodyPart;
    }
}
