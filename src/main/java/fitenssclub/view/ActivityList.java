package fitenssclub.view;

import fitenssclub.database.Database;
import fitenssclub.model.activities.Activity;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActivityList extends AbstractView {
    JPanel activityPanel;
    private JList listOfActivities;
    private JButton dodajNoweZajęciaButton;
    private JButton anulujButton;

    ActivityList(MainController mainController) {
        super(mainController);
        dodajNoweZajęciaButton.addActionListener(e -> {
            mainController.openAddNewActivity();
        });
        anulujButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                mainController.openMainMenu();
            }
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
