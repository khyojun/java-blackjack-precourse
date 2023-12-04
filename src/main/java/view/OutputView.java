package view;


import domain.card.Card;
import domain.user.Dealer;
import domain.user.Player;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private static OutputView instance = new OutputView();


    private OutputView() {
    }

    public static OutputView getInstance() {
        return instance;
    }

    public void printError(String error) {
        print(error);
    }

    private void print(String output) {
        System.out.println(output);
    }

    public void printBatting(String name) {
        print(String.format("%s의 배팅 금액은?", name));
    }

    public void printPlayerName() {
        print("게임에 참여할 사람의 이름을 입렵하세요.(쉼표 기준으로 분리)");
    }

    public void printBeforeNotify(List<Player> players) {
        //print("딜러와 pobi, jason에게 2장을 나누었습니다.")
        String changeNameFormat = players.stream().map(Player::getName)
            .collect(Collectors.joining(", "));
        print(String.format("딜러와 %s에게 %d장을 나누었습니다.", changeNameFormat, 2));

    }

    public void printNowCardStatus(List<Player> players, Dealer dealer) {
        notifyDealerCard(dealer);
        for (Player player : players) {
            notifyPlayerCard(player);
        }
    }

    private void notifyDealerCard(Dealer dealer) {
        print(String.format("딜러카드: %s", dealer.buildConvertCardStatus()));
    }

    private void notifyPlayerCard(Player player) {
         print(String.format("%s카드: %s", player.getName(),player.buildConvertCardStatus()));
    }



}
