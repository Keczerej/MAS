package fitenssclub.model.activities;

import fitenssclub.database.ExerciseEntity;

import java.io.Serializable;
import java.util.*;

/**
 * Ćwiczenie
 * Stworzenie obiektu automatycznie zapisuje go w bazie danych w pamieci
 */
public class Exercise implements Serializable {

    //Asocjacja zwyczajna
    private Set<Equipment> equipmentList = new HashSet<>();

    //MP03 2. Overlapping
    private EnumSet<ExerciseType> types;

    private String name;
    List<ActivityToExercise> activities = new ArrayList<>();

    /**
     * @param name nazwa
     * @param types typy pod jakie podlega ćwiczenie
     */
    public Exercise(String name, EnumSet<ExerciseType> types) {
        this.name = name;
        if(types.size() == 0) throw new IllegalArgumentException("Define at least one type of exercise");
        this.types = types;
        ExerciseEntity.getInstance().remove(this);
        ExerciseEntity.getInstance().add(this);
    }

    public EnumSet<ExerciseType> getTypes() {
        return types;
    }

    public List<Equipment> getEquipmentList() {
        return new ArrayList<>(this.equipmentList);
    }

    /**
     * Dodaje sprzęt do ćwiczeń
     *
     * @param equipment nowy sprzęt używany w ćwiczenie
     */
    public void addEquipment(Equipment equipment) {
        this.equipmentList.add(equipment);
        equipment.exercises.add(this);
    }

    /**
     * Usuwa sprzęt z ćwiczenia
     *
     * @param equipment sprzęt do usunięcia
     */
    public void removeEquipment(Equipment equipment) {
        this.equipmentList.remove(equipment);
        equipment.exercises.remove(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Exercise{" +
                "equipmentList=" + equipmentList +
                ", name='" + name + '\'' +
                ", types='" + types + '\'' +
                '}';
    }
}
