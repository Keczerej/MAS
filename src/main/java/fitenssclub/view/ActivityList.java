package fitenssclub.view;

import fitenssclub.database.Database;
import fitenssclub.model.activities.Activity;

import javax.swing.*;

public class ActivityList extends AbstractView {
    JPanel activityPanel;
    private JList listOfActivities;
    private JButton dodajNoweZajęciaButton;

    ActivityList(MainController mainController) {
        super(mainController);
        dodajNoweZajęciaButton.addActionListener(e -> {
            //TODO: Dodawanie nowych zajęć
        });
    }

    public void loadActivities() {
        DefaultListModel<Activity> model = new DefaultListModel<>();
        Database.getActivities().forEach(activity -> {
            System.out.println(activity);
            ActivityItem activityItem = new ActivityItem();
            model.addElement(activity);
            activityItem.load(activity);
        });
        listOfActivities.setModel(model);
        listOfActivities.setCellRenderer(new ActivityItemRenderer());
        listOfActivities.updateUI();
    }

}
