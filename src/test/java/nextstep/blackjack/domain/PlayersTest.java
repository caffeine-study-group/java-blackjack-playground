package nextstep.blackjack.domain;

import nextstep.blackjack.domain.user.Players;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PlayersTest {

    @Test
    void 이름_출력_테스트() {
        String nameStrings = "재한, 영훈, 소연";
        List<String> names = Arrays.asList("재한","영훈","소연");
        Players players = new Players();
        names.forEach(players::entry);

        assertEquals(nameStrings, players.getNames());
    }
}