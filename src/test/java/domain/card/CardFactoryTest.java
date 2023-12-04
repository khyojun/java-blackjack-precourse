package domain.card;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;
import src.domain.card.Card;
import src.domain.card.CardFactory;

public class CardFactoryTest {
    @Test
    void create() {
        List<Card> cards = CardFactory.create();
        assertThat(cards).hasSize(52);
        System.out.println(cards);
    }
}
