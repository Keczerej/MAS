package fitenssclub.view;

import fitenssclub.model.activities.Activity;

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

    public ActivityItem() {

    }

    void load(ActivityItemDTO activity) {
        this.name.setText(activity.name);
        this.dateFrom.setText(activity.from);
        this.dateTo.setText(activity.to);
        this.room.setText(activity.room);
        this.trainer.setText(activity.trainer);
    }

}
