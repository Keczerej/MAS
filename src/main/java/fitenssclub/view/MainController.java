package fitenssclub.view;

import fitenssclub.database.Database;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;


/**
 * Główny kontroler widoków w aplikacji. Zarządza również bazą danych.
 */
class MainController {

    private final static String DATABASE_NAME = "test";
    private final static JFrame FRAME =  new JFrame("FitnessClub");

    MainController() {
        Database.readFromPath(DATABASE_NAME);
        FRAME.setPreferredSize(new Dimension(800,600));
        FRAME.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        FRAME.pack();
        FRAME.setVisible(true);
        openMainMenu();
    }

    void openActivityList() {
        ActivityList activityList = new ActivityList(this);
        MainController.FRAME.setContentPane(activityList.activityPanel);
        MainController.FRAME.validate();
        activityList.loadActivities();
    }

    void openMainMenu() {
        MainController.FRAME.setContentPane(new MainMenu(this).panelMain);
        MainController.FRAME.validate();
    }


    void openAddNewActivity() {
        AddNewActivityForm addNewActivityForm = new AddNewActivityForm(this);
        MainController.FRAME.setContentPane(addNewActivityForm.addNewActivityPanel);
        MainController.FRAME.validate();
        ActivityDTO activityDTO = new ActivityDTO(
                "",
                LocalDateTime.now(),
                Database.getExercises().stream().map(ExerciseDTO::new).collect(Collectors.toList())
        );
        addNewActivityForm.load(activityDTO);
    }

    void openEditActivity(ActivityDTO activityDTO) {
        AddNewActivityForm addNewActivityForm = new AddNewActivityForm(this);
        MainController.FRAME.setContentPane(addNewActivityForm.addNewActivityPanel);
        MainController.FRAME.validate();
        addNewActivityForm.load(activityDTO);
    }

    void openAddRoomAndTrainer(ActivityDTO activityDTO, List<ITrainerDTO> trainerList, List<RoomDTO> roomList) {
        AddRoomAndTrainerForm addRoomAndTrainerForm = new AddRoomAndTrainerForm(this);
        MainController.FRAME.setContentPane(addRoomAndTrainerForm.addPanel);
        MainController.FRAME.validate();
        addRoomAndTrainerForm.load(activityDTO, trainerList, roomList);

    }

    void pack() {
        FRAME.pack();
    }

    void saveStateToDatabase() {
        Database.writeToPath(DATABASE_NAME );
    }

    void showError(String message) {
        JOptionPane.showMessageDialog(FRAME, message);
    }
}
