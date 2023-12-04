package src.controller;

import java.util.List;
import java.util.Map;
import src.domain.card.Card;
import src.domain.card.CardFactory;
import src.domain.user.Dealer;
import src.domain.user.Player;
import src.dto.TransferViewToModelDto;
import src.service.BlackjackCardService;
import src.service.CreatePlayer;
import src.view.inputView.InputView;
import src.view.outputview.OutputView;

public class Controller {

    private final InputView inputView;
    private final OutputView outputView;

    private List<Player> playerList;
    private Dealer dealer;

    private List<Card> cards;



    public Controller(InputView inputView, OutputView outputView) {

        this.inputView = inputView;
        this.outputView = outputView;

    }

    public void startBlackJack() {
        createPlayerList();
        createDealer();
        createCards();

        BlackjackCardService blackjackCardService = new BlackjackCardService(cards);
        blackjackCardService.distributeTwoCard(playerList,dealer);



        for (Player player : playerList) {
            System.out.println("Player Name: " + player.getName());
            System.out.println("Betting Money: " + player.getBettingMoney());
        }


    }

    public  void createCards() {
        this.cards = CardFactory.create();
    }

    public void createDealer() {
        this.dealer = new Dealer();
    }

    public void createPlayerList() {
        TransferViewToModelDto transferViewToModelDto = new TransferViewToModelDto();
        transferViewToModelDto.transferPlayerList(inputBettingMoney(inputPlayers()));
        CreatePlayer createPlayer = new CreatePlayer();
        playerList = createPlayer.CreatePlayer(transferViewToModelDto.getPlayerList());
    }

    public List<String> inputPlayers() {
        return inputView.getPlayers();

    }

    public Map<String, Integer> inputBettingMoney(List<String> playerList){
        return inputView.getBetAmounts(playerList);
    }

}