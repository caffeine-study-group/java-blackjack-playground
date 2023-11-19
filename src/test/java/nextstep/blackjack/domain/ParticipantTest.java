package nextstep.blackjack.domain;

import nextstep.blackjack.domain.interfaces.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

public class ParticipantTest {
    Player participant;

    @BeforeEach
    void setUp() {
        participant = new Participant("pobi");
    }

    @Test
    void 참가자_생성() {
        Participant participant = new Participant("jaehan");
        participant.betting(10);

        assertNotNull(participant);

    }

    @Test
    void 카드받기_및_이름_테스트() {
        participant.takeCard(new Card(CardSymbol.CLOVER, CardNumber.ACE));
        participant.takeCard(new Card(CardSymbol.HEART, CardNumber.TEN));
        participant.takeCard(new Card(CardSymbol.DIAMOND, CardNumber.SEVEN));
        assertEquals("A클로버, 10하트, 7다이아몬드", participant.showCardNames());
    }

    @Test
    void 배팅_0원이하_테스트() {
        assertThatThrownBy(() -> {
            participant.betting(0);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 배팅_테스트() {
        participant.betting(1);
        assertEquals(1, participant.getBettingMoney());
        participant.betting(99999);
        assertEquals(100000, participant.getBettingMoney());
    }

    @Test
    void 플레이어_이름_테스트() {
        assertEquals("pobi", participant.getName());
    }

    @Test
    void 게임_결과_테스트() {
        participant.takeCard(new Card(CardSymbol.SPADE, CardNumber.FIVE));
        participant.takeCard(new Card(CardSymbol.HEART, CardNumber.ACE));
        assertEquals("pobi카드: 5스페이드, A하트 - 결과: 16", participant.getGameResult());
    }

    @Test
    void 더_이상_카드가_필요없을_경우를_테스트() {
        assertFalse(participant.isPlayerDied());
        participant.noMoreCard();
        assertTrue(participant.isPlayerDied());
    }
}
