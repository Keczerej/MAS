package fitenssclub.view;

import fitenssclub.model.activities.Activity;
import fitenssclub.model.users.User;

import javax.swing.*;

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
        this.dateFrom.setText(activity.getDate().toString());
        this.dateTo.setText(activity.getDate().plusMinutes(activity.getExercisesTime()).toString());
        this.room.setText(activity.getRoom().getNumber());
        User user = ((User)activity.getTrainer());
        this.trainer.setText(user.getFirstName() + " " + user.getLastName());
    }



}
