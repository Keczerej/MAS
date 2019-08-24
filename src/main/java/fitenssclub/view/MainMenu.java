package fitenssclub.view;

import fitenssclub.model.users.worker.roles.Manager;

import javax.swing.*;

/**
 * Główny widok menu głównego
 */
public class MainMenu extends AbstractView {
    private JButton listaZajecButton;
    JPanel panelMain;
    private JLabel loggedUser;

    MainMenu(MainController mainController) {
        super(mainController);
        listaZajecButton.addActionListener(e -> mainController.openActivityList());
    }

    public void load(Manager loggedUser) {
        this.loggedUser.setText(loggedUser.getFirstName() + " " + loggedUser.getLastName());
    }
}
