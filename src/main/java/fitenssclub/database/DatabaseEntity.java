package fitenssclub.database;

import fitenssclub.model.activities.Activity;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Encja, która podlega bazie danych
 *
 * @param <T> typ encji (serializowalny)
 */
abstract class DatabaseEntity<T extends Serializable> {

    DatabaseEntity() { }

    private Set<T> entities = new HashSet<>();

    void readFromDatabase(ArrayList<Object> database, Class<T> tClass) {
        entities.addAll(
                database
                        .stream()
                        .filter(it -> tClass.isAssignableFrom(it.getClass()))
                        .map(it -> (T) it)
                        .filter(it -> !entities.contains(it))
                        .collect(Collectors.toList())
        );
    }

    /**
     * Zwraca obiekty danego typu T przechowywane w pamięci.
     *
     * @return encje z pamięci
     */
    Set<T> getEntities() {
        return new HashSet<>(entities);
    }

    /**
     * Usuwa obiekt typu T z pamięci
     *
     * @param entity do usuniecia
     */
    public void remove(T entity) {
        entities.remove(entity);
    }

    /**
     * Dodaje obiekt typu T do pamięci
     *
     * @param entity do usuniecia
     */
    public void add(T entity) {
        entities.add(entity);
    }

    /**
     * Usuwa podane obiekty typu T z pamięci
     *
     * @param toDelete obiekty do usuniecia
     */
    public void removeAll(List<T> toDelete) {
        this.entities.removeAll(toDelete);
    };

}
