package nextstep.blackjack.domain.card;

import nextstep.blackjack.domain.card.Card;

public interface PlayerCards {
    void addCard(Card card);

    String getCardNames();

    int getTotalScore();

    int getCount();
}
