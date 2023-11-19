package nextstep.blackjack.domain;

import nextstep.blackjack.domain.interfaces.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Players {
    private final List<Player> list;

    public Players(List<String> names) {
        list = new ArrayList<>();
        names.forEach(m -> list.add(new Participant(m)));
    }

    public String getNames() {
        return list.stream().map(Player::getName).collect(Collectors.joining(", "));
    }

    public List<Player> getPlayers() {
        return list;
    }
}
