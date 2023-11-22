package nextstep.blackjack.domain;

import nextstep.blackjack.domain.card.Card;
import nextstep.blackjack.domain.card.CardNumber;
import nextstep.blackjack.domain.card.CardSymbol;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardTest {

    @Test
    void 카드_이름_테스트() {
        Card card = new Card(CardSymbol.CLOVER, CardNumber.ACE);
        assertEquals("A클로버", card.getName());
    }
}
