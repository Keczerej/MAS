package fitenssclub.view;

import javax.swing.*;

public class MainMenu extends AbstractView {
    private JButton listaZajęćButton;
    JPanel panelMain;

    MainMenu(MainController mainController) {
        super(mainController);
        listaZajęćButton.addActionListener(e -> mainController.openActivityList());
    }
}
