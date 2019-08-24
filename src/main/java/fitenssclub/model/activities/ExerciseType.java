package fitenssclub.model.activities;

/**
 * Typ ćwiczenia
 * Stworzenie obiektu automatycznie zapisuje go w bazie danych w pamieci
 */
public enum ExerciseType {
    Relax("Relaksacyjne", "Kręgosłup"),
    Strength("Siłowe", "Triceps"),
    Aerobic("Aerobowe", "Brzuch");

    public final String name;
    public final String bodyPart;

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
