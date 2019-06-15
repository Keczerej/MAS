package fitenssclub.database;

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

    DatabaseEntity() {

    }

    private Set<T> entities = new HashSet<>();

    /**
     * Wczytaj z pliku do pamieci wszystkie obiekty danego typu T
     *
     * @param filePath pelna sciezka do pliku
     */
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

    /**
     * Zapisz do pliku z pamieci wszystkie obiekty danego typu T
     *
     * @param filePath pelna sciezka do pliku
     */
    void writeToFile(String filePath) {
        try {
            new ObjectOutputStream(
                    new FileOutputStream(filePath)
            ).writeObject(new ArrayList<>(entities));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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
