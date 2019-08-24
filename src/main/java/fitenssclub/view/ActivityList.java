package fitenssclub.view;

import fitenssclub.database.Database;
import fitenssclub.model.activities.Activity;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;


/**
 * Główny widok listy zajęć
 */
public class ActivityList extends AbstractView {
    JPanel activityPanel;
    private JList<ActivityItemDTO> listOfActivities;
    private JButton dodajNoweZajeciaButton;
    private JButton anulujButton;

    ActivityList(MainController mainController) {
        super(mainController);
        dodajNoweZajeciaButton.addActionListener(e -> mainController.openAddNewActivity());
        anulujButton.addActionListener(actionEvent -> mainController.openMainMenu(LoginController.getLoggedManager()));
    }

    void loadActivities() {
        this.listOfActivities.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        DefaultListModel<ActivityItemDTO> model = new DefaultListModel<>();
        model.addElement(new ActivityItemDTO());
        List<Activity> activityList = new ArrayList<>(Database.getActivities());
        activityList.forEach(activity -> {
            model.addElement(new ActivityItemDTO(activity));
        });
        listOfActivities.setModel(model);
        listOfActivities.setCellRenderer(new ActivityItemRenderer());
        listOfActivities.updateUI();
        listOfActivities.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                JList list = (JList)evt.getSource();
                int index = list.locationToIndex(evt.getPoint());
                if(index > 0) {
                    mainController.openActivityDetails(activityList.get(index-1));
                }
            }
        });
    }

}
