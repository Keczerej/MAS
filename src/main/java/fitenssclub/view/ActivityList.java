package fitenssclub.view;

import fitenssclub.database.Database;
import fitenssclub.model.activities.Activity;

import javax.swing.*;


/**
 * Główny widok listy zajęć
 */
public class ActivityList extends AbstractView {
    JPanel activityPanel;
    private JList<Activity> listOfActivities;
    private JButton dodajNoweZajeciaButton;
    private JButton anulujButton;

    ActivityList(MainController mainController) {
        super(mainController);
        dodajNoweZajeciaButton.addActionListener(e -> mainController.openAddNewActivity());
        anulujButton.addActionListener(actionEvent -> mainController.openMainMenu());
    }

    void loadActivities() {
        DefaultListModel<Activity> model = new DefaultListModel<>();
        Database.getActivities().forEach(activity -> {
            System.out.println(activity);
            model.addElement(activity);
        });
        listOfActivities.setModel(model);
        listOfActivities.setCellRenderer(new ActivityItemRenderer());
        listOfActivities.updateUI();
    }

}
