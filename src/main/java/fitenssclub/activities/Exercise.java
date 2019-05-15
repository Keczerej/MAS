package fitenssclub.activities;

import java.io.Serializable;
import java.util.*;

abstract public class Exercise  implements Serializable {

    //Asocjacja zwyczajna
    Set<Equipment> equipmentList = new HashSet<>();

    private String name;
    List<ActivityToExercise> activities = new ArrayList<>();

    public Exercise(String name) {
        this.name = name;
    }

    public List<Equipment> getEquipmentList() {
        return new ArrayList<>(this.equipmentList);
    }

    public void addEquipment(Equipment equipment) {
        this.equipmentList.add(equipment);
        equipment.exercises.add(this);
    }

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
                '}';
    }
}
