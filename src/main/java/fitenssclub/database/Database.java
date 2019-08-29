package fitenssclub.database;

import fitenssclub.model.activities.Activity;
import fitenssclub.model.activities.Exercise;
import fitenssclub.model.activities.Room;
import fitenssclub.model.users.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Zarządzanie bazą danych w pamięci oraz zapisywanie/wczytywanie do pliku.
 */
public class Database {

    private static UserEntity userEntity = UserEntity.getInstance();
    private static ActivityEntity activityEntity = ActivityEntity.getInstance();
    private static ExerciseEntity exerciseEntity = ExerciseEntity.getInstance();
    private static RoomEntity roomEntity = RoomEntity.getInstance();

    /**
     * Zapisuje stan bazy w pamieci do pliku
     *
     * @param filePath sciezka do pliku
     */
    public static void readFromPath(String filePath) {
        try {
            ArrayList<Object> database = (ArrayList<Object>)new ObjectInputStream(
                                    new FileInputStream(filePath)
                            ).readObject();
            userEntity.readFromDatabase(database, User.class);
            activityEntity.readFromDatabase(database, Activity.class);
            exerciseEntity.readFromDatabase(database, Exercise.class);
            roomEntity.readFromDatabase(database, Room.class);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Wczytuje stan bazy z pliku do pamięci
     *
     * @param filePath sciezka do pliku
     */
    public static void writeToPath(String filePath) {
        ArrayList<Object> database = new ArrayList<>();
        database.addAll(userEntity.getEntities());
        database.addAll(activityEntity.getEntities());
        database.addAll(exerciseEntity.getEntities());
        database.addAll(roomEntity.getEntities());
        try {
            new ObjectOutputStream(
                    new FileOutputStream(filePath)
            ).writeObject(new ArrayList<>(database));
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
