package src.view.outputview;

import java.util.List;
import java.util.stream.Collectors;
import src.domain.card.Card;
import src.domain.user.Dealer;
import src.domain.user.Player;

public class OutputView {

    private static final String DEAL_MESSAGE = "딜러와 %s에게 2장을 나누었습니다.";

    private String getPlayerNames(List<Player> players) {
        return players.stream()
                .map(Player::getName)
                .collect(Collectors.joining(", "));
    }

    public void printCardList(List<Player> players, Dealer dealer) {

        System.out.printf(DEAL_MESSAGE, getPlayerNames(players));
        System.out.println();

        System.out.print("딜러:");
        Card cardDealer = dealer.getCards().get(0);
        int score = cardDealer.getSymbol().getScore();
        String type = cardDealer.getType().getTypeName();
        System.out.printf("%d%s", score, type);
        System.out.println();

        for (Player player : players) {
            System.out.print(player.getName() + ":");
            boolean firstCard = true;
            for (Card card : player.getCards()) {
                if (!firstCard) {
                    System.out.print(",");
                }
                int scoreDealer = card.getSymbol().getScore();
                String typeDealer = card.getType().getTypeName();
                System.out.printf("%d%s", scoreDealer, typeDealer);
                firstCard = false;
            }
            System.out.println();
        }
    }

    public void printOnePlayerCard(Player player) {

        System.out.print(player.getName() + ":");
        boolean firstCard = true;
        for (Card card : player.getCards()) {
            int score = card.getSymbol().getScore();
            String type = card.getType().getTypeName();

            if (!firstCard) {
                System.out.print(",");
            }
            System.out.printf("%d%s", score, type);
            firstCard = false;
        }
        System.out.println();
    }


    public void printDealerOneMoreCard() {
        System.out.println("딜러는 16이하라 한 장의 카드를 더 받았습니다.");
    }


    public void printDealerPlayerTotalCards(List<Player> players, Dealer dealer) {
        System.out.print("딜러카드: ");
        printCardsWithTotal(dealer.getCards(), dealer.totalScore());
        System.out.println();

        for (Player player : players) {
            System.out.print(player.getName() + "카드: ");
            printCardsWithTotal(player.getCards(), player.totalScore());
            System.out.println();
        }
    }

    private void printCardsWithTotal(List<Card> cards, int totalScore) {
        boolean firstCard = true;
        for (Card card : cards) {
            int score = card.getSymbol().getScore();
            String type = card.getType().getTypeName();

            // 출력 전에 쉼표를 추가하는 부분을 수정
            if (!firstCard) {
                System.out.print(",");
            }
            System.out.printf("%d%s", score, type);

            // 첫 번째 카드가 아니라면 firstCard 값을 false로 설정
            firstCard = false;
        }
        System.out.printf(" - 결과 %d", totalScore);
    }


}