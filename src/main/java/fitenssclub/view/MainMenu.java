package fitenssclub.view;

import javax.swing.*;

/**
 * Główny widok menu głównego
 */
public class MainMenu extends AbstractView {
    private JButton listaZajecButton;
    JPanel panelMain;

    MainMenu(MainController mainController) {
        super(mainController);
        listaZajecButton.addActionListener(e -> mainController.openActivityList());
    }
}
