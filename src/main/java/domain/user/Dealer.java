package domain.user;

import domain.card.Card;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 게임 딜러를 의미하는 객체
 */
public class Dealer {
    private final List<Card> cards = new ArrayList<>();

    public Dealer() {}

    public void addCard(Card card) {
        cards.add(card);
    }

    // TODO 추가 기능 구현
    public void pickCards(List<Card> entireCards){
        Random random = new Random();
        for (int i = 0; i < 2; i++) {
            this.addCard(entireCards.get(random.nextInt(entireCards.size()-1)));
        }
    }

    public List<Card> getCards() {
        return cards;
    }
}
