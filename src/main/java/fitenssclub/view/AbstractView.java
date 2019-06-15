package fitenssclub.view;

/**
 * Ta klasa jest rozszerzana przez widoki, które są widokami głównymi - czyli wyświetlają się w głównym Frame
 */
abstract class AbstractView {

    final MainController mainController;

    /**
     * @param mainController główny kontroler widoków w aplikacji
     */
    AbstractView(MainController mainController) {
        this.mainController = mainController;
    }

}
