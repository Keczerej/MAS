package fitenssclub.view;

import com.github.lgooddatepicker.components.DateTimePicker;
import fitenssclub.database.Database;
import fitenssclub.model.activities.Activity;
import fitenssclub.model.users.User;
import fitenssclub.model.users.worker.roles.ITrainer;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AddNewActivityForm extends AbstractView {
    public JPanel addNewActivityPanel;
    private JTextField podajNazwęDlaZajęćTextField;
    private DateTimePicker dateTimePicker;
    private JButton anulujButton;
    private JButton dalejButton;
    private JPanel exerciseList;
    private List<ExerciseItem> exerciseItems;

    public AddNewActivityForm(MainController mainController) {
        super(mainController);
        anulujButton.addActionListener(actionEvent -> mainController.openActivityList());
        dalejButton.addActionListener(actionEvent -> {
            try {
                ActivityDTO activityDTO = createActivityDTO();
                activityDTO.validate();
                mainController.openAddRoomAndTrainer(
                        activityDTO,
                        getTrainers(activityDTO.startTime, activityDTO.getEndTime()),
                        getRooms(activityDTO.startTime, activityDTO.getEndTime())
                );
            } catch (IllegalArgumentException e) {
                if(e.getMessage() != null)
                    mainController.showError(e.getMessage());
            }
        });
    }

    private List<RoomDTO> getRooms(LocalDateTime min, LocalDateTime max) {
        List<RoomDTO> rooms = Database.getRooms()
                .stream()
                .filter(room -> Database.getActivities()
                        .stream()
                        .noneMatch(activity -> activity.getRoom() == room && isBetween(min, max, activity))
                )
                .map(RoomDTO::new)
                .collect(Collectors.toList());
        if(rooms.isEmpty()) throw new IllegalArgumentException("Nie znaleziono wolnych sal dla wybranego terminu.");
        return rooms;
    }

    private List<ITrainerDTO> getTrainers(LocalDateTime min, LocalDateTime max) {
        List<ITrainerDTO> trainers = Database.getUsers()
                .stream()
                .filter(this::isTrainer)
                .map(user -> new ITrainerDTO((ITrainer) user))
                .filter(dto -> Database.getActivities()
                        .stream()
                        .noneMatch(activity -> activity.getTrainer() == dto.trainer && isBetween(min, max, activity))
                )
                .collect(Collectors.toList());
        if(trainers.isEmpty()) throw new IllegalArgumentException("Nie znaleziono wolnych trenerów dla wybranego terminu.");
        return trainers;
    }

    private boolean isBetween(LocalDateTime min, LocalDateTime max, Activity activity) {
        return isTimeBetween(min, max, activity.getDate()) ||
        isTimeBetween(min, max, activity.getDate().plusMinutes(activity.getExercisesTime()));
    }

    private boolean isTimeBetween(final LocalDateTime min, final LocalDateTime max, final LocalDateTime time){
        return !(time.isBefore(min) || time.isBefore(max));
    }

    private Boolean isTrainer(User user) {
        return Arrays.asList(user.getClass().getInterfaces()).contains(ITrainer.class);
    }

    private ActivityDTO createActivityDTO() {
        return new ActivityDTO(
                this.podajNazwęDlaZajęćTextField.getText(),
                this.dateTimePicker.getDateTimePermissive(),
                this.exerciseItems.stream().map(ExerciseItem::createExerciseDTO).collect(Collectors.toList())
        );
    }

    void load(ActivityDTO activityDTO) {
        this.podajNazwęDlaZajęćTextField.setText(activityDTO.name);
        this.dateTimePicker.setDateTimePermissive(activityDTO.startTime);
        this.loadExercises(activityDTO.exerciseList);
        this.mainController.pack();
    }

    private void loadExercises(List<ExerciseDTO> exerciseList) {
        this.exerciseList.setLayout(new GridLayout(exerciseList.size(), 3, 10, 10));
        this.exerciseItems = new ArrayList<>();
        exerciseList.forEach(exercise -> {
            System.out.println(exercise);
            ExerciseItem exerciseItem = new ExerciseItem();
            exerciseItem.load(exercise, this.exerciseList);
            this.exerciseItems.add(exerciseItem);
        });
    }

}
