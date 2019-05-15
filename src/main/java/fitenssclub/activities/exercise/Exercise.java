package fitenssclub.activities.exercise;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

abstract public class Exercise {

    //Asocjacja zwyczajna
    Set<Equipment> equipmentList = new HashSet<>();

    private String name;

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

}
