package fitenssclub.view;

import fitenssclub.model.activities.Activity;

import javax.swing.*;
import java.awt.*;

/**
 * Sposób renderowania pojedynczego zajęcia na liscie zajęć
 */
public class ActivityItemRenderer implements ListCellRenderer<ActivityItemDTO> {
    @Override
    public Component getListCellRendererComponent(JList list, ActivityItemDTO activity, int index, boolean isSelected, boolean cellHasFocus) {
        ActivityItem activityItem = new ActivityItem();
        activityItem.load(activity);
        return activityItem.activityPanel;
    }
}
