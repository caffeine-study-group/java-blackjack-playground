package nextstep.blackjack.domain;

import nextstep.blackjack.domain.interfaces.DeckCards;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class CardDeckTest {

    @Test
    void 일반_카드_분배_테스트() {
        Strategy normalDistributeStrategy = new NormalDistributeStrategy();
        CardDeck deck = new CardDeck(normalDistributeStrategy);
        deck.generate();

        assertEquals(new Card(CardSymbol.SPADE, CardNumber.ONE), deck.draw());
        assertEquals(new Card(CardSymbol.SPADE, CardNumber.TWO), deck.draw());
        assertEquals(new Card(CardSymbol.SPADE, CardNumber.THREE), deck.draw());
    }

    @Test
    void 랜덤_카드_분배_테스트() {
        Strategy randomDistributeStrategy = () -> {
            List<Card> list = new ArrayList<>();
            list.add( new Card(CardSymbol.SPADE, CardNumber.THREE));
            list.add( new Card(CardSymbol.HEART, CardNumber.ACE));
            list.add( new Card(CardSymbol.CLOVER, CardNumber.JACK));
            return new Cards(list);
        };

        CardDeck deck = new CardDeck(randomDistributeStrategy);
        deck.generate();

        assertEquals(new Card(CardSymbol.SPADE, CardNumber.THREE), deck.draw());
        assertNotEquals(new Card(CardSymbol.SPADE, CardNumber.TWO), deck.draw());
        assertEquals(new Card(CardSymbol.CLOVER, CardNumber.JACK), deck.draw());
    }
}
