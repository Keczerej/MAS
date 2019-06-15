package fitenssclub.database;

import fitenssclub.model.activities.Activity;
import fitenssclub.model.activities.Exercise;
import fitenssclub.model.activities.Room;
import fitenssclub.model.users.User;

import java.util.Set;

public class Database {

    private static UserEntity userEntity = UserEntity.getInstance();
    private static ActivityEntity activityEntity = ActivityEntity.getInstance();
    private static ExerciseEntity exerciseEntity = ExerciseEntity.getInstance();
    private static RoomEntity roomEntity = RoomEntity.getInstance();

    public static void readFromPath(String filePath) {
        userEntity.readFromFile(filePath + ".udb");
        activityEntity.readFromFile(filePath + ".adb");
        exerciseEntity.readFromFile(filePath + ".edb");
        roomEntity.readFromFile(filePath + ".rdb");
    }

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
