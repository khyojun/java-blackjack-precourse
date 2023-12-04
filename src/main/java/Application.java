import controller.BlackJackController;
import controller.GameController;
import controller.GameFrontController;
import domain.user.Dealer;
import view.InputView;
import view.OutputView;

public class Application {

    public static void main(String[] args) {
        GameFrontController frontController = new GameFrontController(
            new BlackJackController(InputView.getInstance(),
                OutputView.getInstance(), new Dealer()));
        GameController controller = frontController.getController();
        controller.start();

    }
}
