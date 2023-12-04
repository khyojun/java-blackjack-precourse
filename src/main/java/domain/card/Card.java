package domain.card;

import static domain.card.Symbol.ACE;
import static domain.card.Symbol.JACK;
import static domain.card.Symbol.KING;
import static domain.card.Symbol.QUEEN;

import java.util.Objects;

/**
 * 카드 한장을 의미하는 객체
 */
public class Card {
    private final Symbol symbol;

    private final Type type;

    public Card(Symbol symbol, Type type) {
        this.symbol = symbol;
        this.type = type;
    }

    // TODO Card 관련 추가 기능 구현

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return symbol == card.symbol &&
                type == card.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(symbol, type);
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public Type getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Card{" +
                "symbol=" + symbol +
                ", type=" + type +
                '}';
    }

    public String convertSpecialNumber(){
        if(this.symbol== JACK)
            return "J";
        if(this.symbol==QUEEN)
            return "Q";
        if(this.symbol==KING)
            return "K";
        if(this.symbol==ACE)
            return "A";
        return this.symbol.toString();
    }

    public boolean checkSpecialSymbol(){
        return symbol == JACK || symbol == QUEEN || symbol == KING
            || symbol == ACE;
    }

    public String specialSymbol(){
        return convertSpecialNumber() + getType().toString();
    }

    public String normalSymbol(){
        return symbol.getScore() + getType().toString();
    }

}
