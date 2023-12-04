package controller;

public class GameFrontController {

    private GameController gameController;

    public GameFrontController(GameController gameController) {
        this.gameController = gameController;
    }

    public GameController getController() {
        return gameController;
    }
}
