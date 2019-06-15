package fitenssclub.model.activities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Sprzęt używany w ćwieczeniach
 */
public class Equipment implements Serializable {

    private String name;
    Set<Exercise> exercises = new HashSet<>();

    /**
     * @param name nazwa
     */
    public Equipment(String name) {
        this.name = name;
    }

    public ArrayList<Exercise> getExercises() {
        return new ArrayList<>(exercises);
    }

    /**
     * @return nazwa
     */
    public String getName() {
        return name;
    }

    /**
     * @param name nowa nazwa
     */
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
