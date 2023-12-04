package controller;

import domain.user.Player;
import domain.user.PlayerConverter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
        List<Player> players = inputPlayer();
        System.out.println(players);

    }

    private List<Player> inputPlayer() {
        try{
            List<String> names = inputPlayerName();
            Map<String, Double> playerInfo = inputBatting(names);
            return PlayerConverter.toPlayer(playerInfo);
        }catch (IllegalArgumentException error){
            outputView.printError(error.getMessage());
            return inputPlayer();
        }
    }

    private Map<String, Double> inputBatting(List<String> players) {
        try{
            Map<String, Double> playerInfo = new HashMap<>();
            makePlayerInfo(players, playerInfo);
            return playerInfo;
        }catch (IllegalArgumentException error){
            outputView.printError(error.getMessage());
            return inputBatting(players);
        }
    }

    private void makePlayerInfo(List<String> players, Map<String, Double> playerInfo) {
        for (String player : players) {
           // outputView.printBatting(player);
            playerInfo.put(player,inputView.inputBatting(player));
        }
    }

    private List<String> inputPlayerName() {
        try{
            policyChecker = new PlayerInputPolicyChecker();
            outputView.printPlayerName();
            String nameInput = inputView.inputPlayers();
            policyChecker.policyCheck(nameInput);
            return Arrays.asList(nameInput.split(", "));
        }catch (IllegalArgumentException error){
            outputView.printError(error.getMessage());
            return inputPlayerName();
        }
    }
}
