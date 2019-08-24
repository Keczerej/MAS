package fitenssclub.view;

import fitenssclub.database.Database;
import fitenssclub.model.activities.Activity;
import fitenssclub.model.activities.Exercise;
import fitenssclub.model.users.User;
import fitenssclub.model.users.client.Client;

import javax.swing.*;
import javax.xml.crypto.Data;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.stream.Collectors;

public class ActivityDetails extends AbstractView {

    JPanel activityDetailsPanel;
    private JButton deleteButton;
    private JList<ExerciseDTO> exerciseList;
    private JList<ClientDTO> contributorsList;
    private JButton returnButton;
    private JLabel name;
    private JLabel from;
    private JLabel to;
    private JLabel trainer;
    private JLabel room;
    private JLabel menager;

    /**
     * @param mainController główny kontroler widoków w aplikacji
     */
    ActivityDetails(MainController mainController) {
        super(mainController);
    }

    void load(Activity activity) {
        setDetails(new ActivityItemDTO(activity));
        setExercisesList(activity);
        setContributorsList(activity);
        setReturnButton();
        setDeleteButton(activity);
    }

    private void setDetails(ActivityItemDTO activity) {
        name.setText(activity.name);
        from.setText(activity.from);
        to.setText(activity.to);
        trainer.setText(activity.trainer);
        room.setText(activity.room);
        menager.setText(activity.menager);
    }

    private void setReturnButton() {
        returnButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mainController.openActivityList();
            }
        });
    }

    private void setDeleteButton(Activity activity) {
        deleteButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Database.deleteActivity(activity);
                mainController.saveStateToDatabase();
                mainController.openActivityList();
            }
        });
    }

    private void setExercisesList(Activity activity) {
        this.exerciseList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        DefaultListModel<ExerciseDTO> model = new DefaultListModel<>();
        List<ExerciseDTO> exercises = activity
                .getExercises()
                .stream()
                .map(ExerciseDTO::new)
                .collect(Collectors.toList());
        exercises.forEach(model::addElement);
        exerciseList.setModel(model);
        exerciseList.updateUI();
        exerciseList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                JList list = (JList)evt.getSource();
                int index = list.locationToIndex(evt.getPoint());
                mainController.showExerciseDetails(exercises.get(index).exercise);
            }
        });
    }

    private void setContributorsList(Activity activity) {
        this.contributorsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        DefaultListModel<ClientDTO> model = new DefaultListModel<>();
        List<ClientDTO> contributors = activity
                .getContributors()
                .stream()
                .map(ClientDTO::new)
                .collect(Collectors.toList());
        contributors.forEach(model::addElement);
        contributorsList.setModel(model);
        contributorsList.updateUI();
        contributorsList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                JList list = (JList)evt.getSource();
                int index = list.locationToIndex(evt.getPoint());
                mainController.showContributorsList(contributors.get(index).getContributor());
            }
        });
    }

}
