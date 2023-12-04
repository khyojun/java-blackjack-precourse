package domain.user;

import domain.card.Card;

import domain.card.Symbol;
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


    public String showOneCard() {
        List<String> convertCards = new ArrayList<>();
        for (Card card : cards) {
            if (card.checkSpecialSymbol()) {
                convertCards.add(card.specialSymbol());
                break;
            }
            convertCards.add(card.normalSymbol());
            break;
        }
        return String.join(", ", convertCards);
    }

    public boolean judgeOverLimitNumber() {
        return cards.stream()
            .map(Card::getSymbol)
            .map(Symbol::getScore)
            .mapToInt(Integer::intValue)
            .sum() > 17;
    }

    public void pickOneCards(List<Card> entireCards) {
        Random random = new Random();
        for (int i = 0; i < 1; i++) {
            this.addCard(cards.get(random.nextInt(cards.size() - 1)));
        }
    }
}
