package fitenssclub.database;

import fitenssclub.model.activities.Activity;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

abstract class DatabaseEntity<T extends Serializable> {

    DatabaseEntity() {

    }

    private Set<T> entities = new HashSet<>();

    void readFromFile(String filePath) {
        try {
            entities.addAll(
                    (
                            (List<T>) new ObjectInputStream(
                                    new FileInputStream(filePath)
                            ).readObject()
                    )
                            .stream()
                            .filter(it -> !entities.contains(it))
                            .collect(Collectors.toList())
            );
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    void writeToFile(String filePath) {
        try {
            new ObjectOutputStream(
                    new FileOutputStream(filePath)
            ).writeObject(new ArrayList<>(entities));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    Set<T> getEntities() {
        return new HashSet<>(entities);
    }

    public void remove(T entity) {
        entities.remove(entity);
    }

    public void add(T entity) {
        entities.add(entity);
    }

    public void removeAll(List<T> toDelete) {
        this.entities.removeAll(toDelete);
    };
}
