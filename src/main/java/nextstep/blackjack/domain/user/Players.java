package nextstep.blackjack.domain.user;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Players {
    private final List<Player> list;

    public Players() {
        list = new ArrayList<>();
    }

    public String getNames() {
        return list.stream().map(Player::getName).collect(Collectors.joining(", "));
    }

    public List<Player> getPlayers() {
        return list;
    }

    public void entry(Player player) {
        list.add(player);
    }

    public void entry(String player) {
        list.add(new Participant(player));
    }
}
