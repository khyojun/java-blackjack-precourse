import controller.BlackJackController;
import controller.GameController;
import controller.GameFrontController;
import view.InputView;
import view.OutputView;

public class Application {

    public static void main(String[] args) {
        GameFrontController frontController = new GameFrontController(
            new BlackJackController(InputView.getInstance(),
                OutputView.getInstance()));
        GameController controller = frontController.getController();
        controller.start();

    }
}
