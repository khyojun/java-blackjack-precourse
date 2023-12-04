package src;

import src.controller.Controller;
import src.view.inputView.InputView;
import src.view.outputview.OutputView;

public class Application {

    public static void main(String[] args) {

        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        Controller controller = new Controller(inputView, outputView);

        controller.startBlackJack();
    }
}
