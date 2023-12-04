package src.view.outputview;

import java.util.List;
import src.domain.card.Card;
import src.domain.user.Dealer;
import src.domain.user.Player;

public class OutputView {

    private static final String DEAL_MESSAGE = "딜러와 %s에게 2장을 나누었습니다.";


    public void printCardList(List<Player> players , Dealer dealer){
        System.out.println(DEAL_MESSAGE);

        System.out.print("딜러:");
        for(Card card : dealer.getCards()){

        }
        // Print dealer's cards
        System.out.printf("%s: %s%n", dealer.getName(), dealer.getCards());

        // Print each player's cards
        for (Player player : players) {
            System.out.printf("%s: %s%n", player.getName(), player.;);
        }

    }
}
