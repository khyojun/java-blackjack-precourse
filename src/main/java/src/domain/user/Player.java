package src.domain.user;

import src.domain.card.Card;

import java.util.ArrayList;
import java.util.List;

/**
 * 게임 참여자를 의미하는 객체
 */
public class Player {
    private final String name; //플레이어 이름
    private final double bettingMoney; // 배팅 금액
    private final List<Card> cards = new ArrayList<>(); //플레이어가 가진 카드

    public Player(String name, double bettingMoney) {
        this.name = name;
        this.bettingMoney = bettingMoney;
    }

    public void addCard(Card card) {
        cards.add(card);
    }


    public String getName(){
        return name;
    }

    public double getBettingMoney() {
        return bettingMoney;
    }

    // TODO 추가 기능 구현

}
