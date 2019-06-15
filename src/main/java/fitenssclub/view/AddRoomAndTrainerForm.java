package fitenssclub.view;

import fitenssclub.model.activities.Activity;

import javax.swing.*;
import java.util.List;

public class AddRoomAndTrainerForm extends AbstractView {
    JPanel addPanel;
    private JComboBox<RoomDTO> chooseRoom;
    private JComboBox<ITrainerDTO> chooseTrainer;
    private JButton anulujButton;
    private JButton zapiszButton;
    private ActivityDTO activityDTO;

    AddRoomAndTrainerForm(MainController mainController) {
        super(mainController);
        anulujButton.addActionListener(actionEvent -> mainController.openEditActivity(activityDTO));
        zapiszButton.addActionListener(actionEvent -> {
            Activity activity = new Activity(
                    activityDTO.name,
                    activityDTO.startTime,
                    ((ITrainerDTO) chooseTrainer.getSelectedItem()).trainer,
                    ((RoomDTO) chooseRoom.getSelectedItem()).room);
            this.activityDTO.exerciseList.forEach(exerciseDTO -> {
                if(exerciseDTO.isSelected) {
                    activity.addExercise(exerciseDTO.exercise, exerciseDTO.time);
                }
            });
            mainController.saveStateToDatabase();
            mainController.openActivityList();
        });
    }

    void load(ActivityDTO activityDTO, List<ITrainerDTO> trainerList, List<RoomDTO> roomList) {
        System.out.println(activityDTO);
        this.activityDTO = activityDTO;
        trainerList.forEach(trainer -> {
            chooseTrainer.addItem(trainer);
        });
        roomList.forEach(room -> {
            chooseRoom.addItem(room);
        });
        this.mainController.pack();
    }

}
