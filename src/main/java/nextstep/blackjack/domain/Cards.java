package nextstep.blackjack.domain;

import java.util.List;

public class Cards {

    private final List<Card> list;

    public Cards(List<Card> list) {
        this.list = list;
    }

    public void addCard(Card card) {
        this.list.add(card);
    }

}
