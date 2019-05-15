package fitenssclub.activities;

import java.util.ArrayList;
import java.util.List;

public class Activity {

    //Asocjacja zwyczajna
    List<Equipment> equipmentList = new ArrayList<>();

    private String name;

    public Activity(String name) {
        this.name = name;
    }

    public List<Equipment> getEquipmentList() {
        return new ArrayList<>(this.equipmentList);
    }

    public void addEquipment(String name) {
        this.equipmentList.add(new Equipment(name, this));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

