package controller;

import java.util.Arrays;
import java.util.List;
import util.PlayerInputPolicyChecker;
import util.PolicyChecker;
import view.InputView;
import view.OutputView;

public class BlackJackController implements GameController{

    private InputView inputView;
    private OutputView outputView;
    private PolicyChecker policyChecker;

    public BlackJackController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    @Override
    public void start() {
        inputPlayer();



    }

    private List<String> inputPlayer() {
        try{
            policyChecker = new PlayerInputPolicyChecker();
            policyChecker.policyCheck(inputView.inputPlayers());
            return Arrays.asList(inputView.inputPlayers().split(", "));
        }catch (IllegalArgumentException error){
            outputView.printError(error.getMessage());
            return inputPlayer();
        }
    }
}
