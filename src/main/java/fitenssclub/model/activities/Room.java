package fitenssclub.model.activities;

import fitenssclub.database.RoomEntity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Room implements Serializable {

    private String number;
    private Integer capasity;
    private Set<Activity> activities = new HashSet<>();

    @Override
    public String toString() {
        return "Room{" +
                "number='" + number + '\'' +
                ", capasity=" + capasity +
                '}';
    }

    public Room(String number, Integer capasity) {
        this.number = number;
        this.capasity = capasity;
        RoomEntity.getInstance().add(this);
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Integer getCapasity() {
        return capasity;
    }

    public void setCapasity(Integer capasity) {
        this.capasity = capasity;
    }

    public void addActivity(Activity activity) {
        this.activities.add(activity);
    }
}
