package nextstep.blackjack.domain.interfaces;

import nextstep.blackjack.domain.Card;

public interface PlayerCards {
    void addCard(Card card);

    String getCardNames();

    int getTotalScore();
}
