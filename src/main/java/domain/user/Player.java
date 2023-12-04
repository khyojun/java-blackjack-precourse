package domain.user;

import domain.card.Card;

import domain.card.Symbol;
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
            this.addCard(cards.get(random.nextInt(cards.size() - 1)));
        }
    }

    public List<Card> getCards() {
        return cards;
    }

// TODO 추가 기능 구현


    public String buildConvertCardStatus() {
        List<String> convertCards = new ArrayList<>();
        for (Card card : cards) {
            if (card.checkSpecialSymbol()) {
                convertCards.add(card.specialSymbol());
                continue;
            }
            convertCards.add(card.normalSymbol());
        }
        return String.join(", ", convertCards);
    }


    public boolean judgeOverLimitNumber() {
        return cards.stream()
            .map(Card::getSymbol)
            .map(Symbol::getScore)
            .mapToInt(Integer::intValue)
            .sum() >= 21;
    }

    public void pickOneCards(List<Card> entireCards) {
        Random random = new Random();
        for (int i = 0; i < 1; i++) {
            this.addCard(cards.get(random.nextInt(cards.size() - 1)));
        }
    }
}
