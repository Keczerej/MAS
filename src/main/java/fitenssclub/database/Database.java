package fitenssclub.database;

import fitenssclub.model.activities.Activity;
import fitenssclub.model.activities.Exercise;
import fitenssclub.model.activities.Room;
import fitenssclub.model.users.User;

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
        userEntity.readFromFile(filePath + ".udb");
        activityEntity.readFromFile(filePath + ".adb");
        exerciseEntity.readFromFile(filePath + ".edb");
        roomEntity.readFromFile(filePath + ".rdb");
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
        userEntity.writeToFile(filePath + ".udb");
        activityEntity.writeToFile(filePath + ".adb");
        exerciseEntity.writeToFile(filePath + ".edb");
        roomEntity.writeToFile(filePath + ".rdb");
    }

    public static Set<User> getUsers() {
        return userEntity.getEntities();
    }

    public static Set<Room> getRooms() {
        return roomEntity.getEntities();
    }

    public static Set<Activity> getActivities() {
        return activityEntity.getEntities();
    }

    public static Set<Exercise> getExercises() {
        return exerciseEntity.getEntities();
    }

}
