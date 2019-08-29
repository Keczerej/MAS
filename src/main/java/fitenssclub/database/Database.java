package fitenssclub.database;

import fitenssclub.model.activities.Activity;
import fitenssclub.model.activities.Exercise;
import fitenssclub.model.activities.Room;
import fitenssclub.model.users.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Zarządzanie bazą danych w pamięci oraz zapisywanie/wczytywanie do pliku.
 */
public class Database {

    private static UserEntity userEntity = UserEntity.getInstance();
    private static ActivityEntity activityEntity = ActivityEntity.getInstance();
    private static ExerciseEntity exerciseEntity = ExerciseEntity.getInstance();
    private static RoomEntity roomEntity = RoomEntity.getInstance();

    /**
     * Zapisuje stan bazy w pamieci do plików
     * Np. podajac scieżkę /home/test
     * zostaną stworzone pliki
     * /home/test.udb - uzytkownicy
     * /home/test.adb - zajecia
     * /home/test.edb - ćwiczenia
     * /home/test.rdb - sale
     *
     * @param filePath sciezka do pliku
     */
    public static void readFromPath(String filePath) {
        try {
            ArrayList<Object> entities = (ArrayList<Object>)new ObjectInputStream(
                                    new FileInputStream(filePath)
                            ).readObject();
            userEntity.readFromFile(entities, User.class);
            activityEntity.readFromFile(entities, Activity.class);
            exerciseEntity.readFromFile(entities, Exercise.class);
            roomEntity.readFromFile(entities, Room.class);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Wczytuje stan bazy z plików do pamięci
     * Np. podajac scieżkę /home/test
     * zostaną wczytane pliki
     * /home/test.udb - uzytkownicy
     * /home/test.adb - zajecia
     * /home/test.edb - ćwiczenia
     * /home/test.rdb - sale
     *
     * @param filePath sciezka do pliku
     */
    public static void writeToPath(String filePath) {
        ArrayList<Object> entities = new ArrayList<>();
        entities.addAll(userEntity.getEntities());
        entities.addAll(activityEntity.getEntities());
        entities.addAll(exerciseEntity.getEntities());
        entities.addAll(roomEntity.getEntities());
        try {
            new ObjectOutputStream(
                    new FileOutputStream(filePath)
            ).writeObject(new ArrayList<>(entities));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Set<User> getUsers() {
        return userEntity.getEntities();
    }

    public static void deleteUser(User user) {
        List<User> toDelete = new ArrayList<>();
        toDelete.add(user);
        userEntity.removeAll(toDelete);
    }

    public static Set<Room> getRooms() {
        return roomEntity.getEntities();
    }

    public static void deleteRoom(Room room) {
        List<Room> toDelete = new ArrayList<>();
        toDelete.add(room);
        roomEntity.removeAll(toDelete);
    }

    public static Set<Activity> getActivities() {
        return activityEntity.getEntities();
    }

    public static void deleteActivity(Activity activity) {
        List<Activity> toDelete = new ArrayList<>();
        toDelete.add(activity);
        activityEntity.removeAll(toDelete);
    }

    public static Set<Exercise> getExercises() {
        return exerciseEntity.getEntities();
    }

    public static void deleteExercise(Exercise exercise) {
        List<Exercise> toDelete = new ArrayList<>();
        toDelete.add(exercise);
        exerciseEntity.removeAll(toDelete);
    }

}
