package fitenssclub.view;

import fitenssclub.model.activities.Activity;

import javax.swing.*;

public class ActivityDetails extends AbstractView {

    JPanel activityDetailsPanel;
    private Activity activity;

    /**
     * @param mainController główny kontroler widoków w aplikacji
     */
    ActivityDetails(MainController mainController) {
        super(mainController);
    }

    public void load(Activity activity) {
        this.activity = activity;
    }

}
