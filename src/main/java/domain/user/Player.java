package domain.user;

import domain.card.Card;

import domain.card.CardFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 게임 참여자를 의미하는 객체
 */
public class Player {
    private final String name;
    private final double bettingMoney;
    private final List<Card> cards = new ArrayList<>();

    public Player(String name, double bettingMoney) {
        this.name = name;
        this.bettingMoney = bettingMoney;
    }

    public void addCard(Card card) {
        cards.add(card);
    }


    public String getName() {
        return name;
    }

    public void pickCards(List<Card> cards) {
        Random random = new Random();
        for (int i = 0; i < 2; i++) {
            this.addCard(cards.get(random.nextInt(cards.size()-1)));
        }
    }

    public List<Card> getCards() {
        return cards;
    }

// TODO 추가 기능 구현

}
