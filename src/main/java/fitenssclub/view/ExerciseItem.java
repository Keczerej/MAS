package fitenssclub.view;

import fitenssclub.model.activities.Exercise;

import javax.swing.*;
import java.awt.*;

class ExerciseItem {
    private JCheckBox selected;
    private JLabel name;
    private JSpinner time;
    private Exercise exercise;

    void load(ExerciseDTO exercise, JPanel jpanel) {
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
