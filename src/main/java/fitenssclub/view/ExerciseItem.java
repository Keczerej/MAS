package fitenssclub.view;

import fitenssclub.model.activities.Exercise;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Widok pojedynczego zajęcia na liście
 */
class ExerciseItem {
    private JCheckBox selected;
    private JLabel name;
    private JSpinner time;
    private Exercise exercise;

    void load(ExerciseDTO exercise, JPanel jpanel, MainController mainController) {
        this.exercise = exercise.exercise;
        JPanel exercisePanel = new JPanel();
        exercisePanel.setLayout(new GridLayout(1, 2, 10, 10));
        this.selected = new JCheckBox();
        this.name = new JLabel();
        this.time = new JSpinner(new SpinnerNumberModel(10, 1, 1000, 1));
        this.selected.setSelected(exercise.isSelected);
        this.name.setText(exercise.name);
        this.time.setValue(exercise.time);
        exercisePanel.add(selected);
        exercisePanel.add(name);
        exercisePanel.add(time);
        jpanel.add(exercisePanel);
        this.name.setBorder(new EmptyBorder(5,5,5,5));
        this.name.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mainController.showExerciseDetails(exercise.exercise);
            }
        });
    }

    ExerciseDTO createExerciseDTO() {
        return new ExerciseDTO(
                selected.isSelected(),
                name.getText(),
                (Integer) time.getValue(),
                exercise
        );
    }

}
