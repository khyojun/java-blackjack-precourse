package src.controller;

import java.util.ArrayList;
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
        //플레이서 생성
        createPlayerList();

        //딜러 생성
        createDealer();

        //카드 생성
        createCards();

        //카드 서비스 호출
        BlackjackCardService blackjackCardService = new BlackjackCardService(cards);

        //딜러와 플레이어에게 2장씩 배급
        blackjackCardService.distributeTwoCard(playerList,dealer);

        //카드 내역 출력
        outputView.printCardList(playerList,dealer);

        //히트할건지 스탠드할건지
        for (Player player : playerList) {
            while (player.totalScore() <= 21) {
                boolean yesNo = inputView.askOneMoreCard(player);
                player.addCard(blackjackCardService.dealCard());
                outputView.printOnePlayerCard(player);
                if(!yesNo){break;}
            }
        }

        //딜러 카드의 합이 16이하면 한장 더
        if(dealer.totalScore() <=16) {
            dealer.addCard(blackjackCardService.dealCard());
            outputView.printDealerOneMoreCard();
        }

        //딜러와 플레이어 가 최종 으로 가지고있는 카드 내역
        outputView.printDealerPlayerTotalCards(playerList,dealer);



    }

    public void createCards() {
        this.cards = new ArrayList<>(CardFactory.create());
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