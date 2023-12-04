package src.domain.user;

import src.domain.card.Card;

import java.util.ArrayList;
import java.util.List;

/**
 * 게임 딜러를 의미하는 객체
 */
public class Dealer {
    private final List<Card> cards = new ArrayList<>();

    public Dealer() {}

    public void addCard(Card card) {
        cards.add(card);
    }


    public String getName(){
        return "딜러";
    }

    public List<Card> getCards(){
        return cards;
    }

    // TODO 추가 기능 구현
}
