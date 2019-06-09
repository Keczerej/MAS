package fitenssclub.activities;

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

    ExerciseType(String name, String bodyPart) {
        this.name = name;
        this.bodyPart = bodyPart;
    }
}
