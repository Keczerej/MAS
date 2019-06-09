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
//
//        activityEntity.clear();
//        userEntity.clear();
//        exerciseEntity.clear();
//
//        activityEntity.readFromFile(filePath + ".adb");
//
//        List<User> existingUsers = activityEntity
//                .getEntities()
//                .stream()
//                .map(Activity::getContributors).flatMap(List::stream)
//                .collect(Collectors.toList());
//
//        List<User> existingTrainsers = activityEntity
//                .getEntities()
//                .stream()
//                .map(trainer -> (User) (trainer.getTrainer()))
//                .collect(Collectors.toList());
//
//
//        existingUsers.addAll(existingTrainsers);
//
//        userEntity.addEntities(existingUsers);
//        userEntity.readFromFile(filePath + ".udb");
//
//        List<Exercise> existingExercises = activityEntity
//                .getEntities()
//                .stream()
//                .map(Activity::getExercises).flatMap(List::stream)
//                .collect(Collectors.toList());
//
//        exerciseEntity.addEntities(existingExercises);
//        exerciseEntity.readFromFile(filePath + ".edb");
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
