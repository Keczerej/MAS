package fitenssclub.view;

import fitenssclub.model.activities.Activity;

import javax.swing.*;
import java.awt.*;

public class ActivityItemRenderer implements ListCellRenderer<Activity> {
    @Override
    public Component getListCellRendererComponent(JList list, Activity activity, int index, boolean isSelected, boolean cellHasFocus) {
        ActivityItem activityItem = new ActivityItem();
        activityItem.load(activity);
        return activityItem.activityPanel;
    }
}
