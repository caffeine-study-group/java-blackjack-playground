package nextstep.blackjack.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CardsTest {

    private Cards cards;

    @BeforeEach
    void before() {
        cards = new Cards(new ArrayList<>());
    }

    @Test
    void 가지고_있는_카드의_목록을_출력() {
        Card cloverOne = new Card(CardSymbol.CLOVER, CardNumber.ONE);

        cards.addCard(cloverOne);
        assertEquals("1클로버", cards.getCardNames());

        cards.addCard(new Card(CardSymbol.HEART, CardNumber.KING));
        assertEquals("1클로버, K하트", cards.getCardNames());
    }

    @Test
    void 가지고_있는_카드의_총합을_출력() {
        cards.addCard(new Card(CardSymbol.HEART, CardNumber.KING));
        assertEquals(10, cards.getTotalScore());

        cards.addCard(new Card(CardSymbol.CLOVER, CardNumber.ACE));
        assertEquals(21, cards.getTotalScore());

        cards.addCard(new Card(CardSymbol.SPADE, CardNumber.FIVE));
        assertEquals(16, cards.getTotalScore());
    }

    @Test
    void ACE_네장() {
        cards.addCard(new Card(CardSymbol.HEART, CardNumber.ACE));
        assertEquals(11, cards.getTotalScore());
        cards.addCard(new Card(CardSymbol.SPADE, CardNumber.ACE));
        assertEquals(12, cards.getTotalScore());
        cards.addCard(new Card(CardSymbol.CLOVER, CardNumber.ACE));
        assertEquals(13, cards.getTotalScore());
        cards.addCard(new Card(CardSymbol.DIAMOND, CardNumber.ACE));
        assertEquals(14, cards.getTotalScore());
    }

    @Test
    void test() {
        List<Card> list = Arrays.stream(CardSymbol.values())
                .flatMap(symbol -> Arrays.stream(CardNumber.values()).map(number -> new Card(symbol, number)))
                .collect(Collectors.toList());
        System.out.println(new Cards(list).getCardNames());
        assertEquals(56, list.size());
    }


    @AfterEach
    void after() {
        cards = null;
    }
}
