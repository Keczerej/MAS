package fitenssclub.view;

import fitenssclub.model.activities.Activity;
import fitenssclub.model.users.User;

import javax.swing.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Widok pojedynczego zajęcia na liście zajęć
 */
public class ActivityItem  {
    private JLabel dateFrom;
    private JLabel dateTo;
    private JLabel name;
    JPanel activityPanel;
    private JLabel room;
    private JLabel trainer;

    void load(Activity activity) {
        this.name.setText(activity.getName());
        this.dateFrom.setText(toDateString(activity.getDate()));
        this.dateTo.setText(toDateString(activity.getDate().plusMinutes(activity.getExercisesTime())));
        this.room.setText(activity.getRoom().getNumber());
        User user = ((User)activity.getTrainer());
        this.trainer.setText(user.getFirstName() + " " + user.getLastName());
    }

    private String toDateString(LocalDateTime localDateTime) {
        return localDateTime.toString().replace("T", " ").substring(0, 16);
    }


}
