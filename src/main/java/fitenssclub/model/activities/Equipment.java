package fitenssclub.model.activities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Equipment implements Serializable {

    private String name;
    protected Set<Exercise> exercises = new HashSet<>();

    public Equipment(String name) {
        this.name = name;
    }

    public ArrayList<Exercise> getExercises() {
        return new ArrayList<>(exercises);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Equipment{" +
                "name='" + name + '\'' +
                '}';
    }
}
