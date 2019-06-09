package fitenssclub.view;

import fitenssclub.database.Database;

import javax.swing.*;
import java.awt.*;

public class MainController {

    final static JFrame FRAME =  new JFrame("FitnessClub");

    MainController() {
        Database.readFromPath("test");
        FRAME.setPreferredSize(new Dimension(800,600));
        FRAME.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        FRAME.pack();
        FRAME.setVisible(true);
        openMainMenu();
    }

    public void openActivityList() {
        ActivityList activityList = new ActivityList(this);
        MainController.FRAME.setContentPane(activityList.activityPanel);
        MainController.FRAME.validate();
        activityList.loadActivities();
    }

    public void openMainMenu() {
        MainController.FRAME.setContentPane(new MainMenu(this).panelMain);
        MainController.FRAME.validate();
    }

}
