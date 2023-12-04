package src.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import src.domain.card.Card;
import src.domain.user.Dealer;
import src.domain.user.Player;

public class BlackjackCardService {

    private List<Card> cards;

    public void distributeTwoCard(List<Player> players, Dealer dealer){

        for(Player player : players){
            for(int  i=0; i<2; i++){
                player.addCard(dealCard());
            }
        }

        for(int  i=0; i<2; i++){
            dealer.addCard(dealCard());
        }

    }

    public BlackjackCardService(List<Card> cards){
        this.cards = cards;
        shuffleDeck();
    }

    void shuffleDeck() {
        Collections.shuffle(this.cards);
    }

    // 카드 한 장 뽑기
    public Card dealCard() {
        if (cards.isEmpty()) {
            throw new IllegalStateException("덱이 비어있습니다.");
        }
        return cards.remove(0);
    }

    // 카드 다수 뽑기
    public List<Card> dealCards(int numberOfCards) {
        if (numberOfCards > cards.size()) {
            throw new IllegalArgumentException("덱에 남은 카드 수보다 많이 요청되었습니다.");
        }

        List<Card> dealtCards = new ArrayList<>();
        for (int i = 0; i < numberOfCards; i++) {
            dealtCards.add(dealCard());
        }

        return dealtCards;
    }
}
