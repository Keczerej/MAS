package fitenssclub.view;

import fitenssclub.model.activities.Activity;

import javax.swing.*;

public class ActivityItem  {
    private JLabel dateFrom;
    private JLabel dateTo;
    private JLabel name;
    JPanel activityPanel;

    void load(Activity activity) {
        this.name.setText(activity.getName());
        this.dateFrom.setText(activity.getDate().toString());
        this.dateTo.setText(activity.getDate().plusMinutes(activity.getExercisesTime()).toString());
    }



}
