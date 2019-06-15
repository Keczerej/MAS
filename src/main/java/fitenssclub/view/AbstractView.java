package fitenssclub.view;

abstract class AbstractView {

    protected final MainController mainController;

    AbstractView(MainController mainController) {
        this.mainController = mainController;
    }

}
