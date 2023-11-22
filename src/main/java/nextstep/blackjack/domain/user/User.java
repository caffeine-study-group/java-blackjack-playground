package nextstep.blackjack.domain.user;

import nextstep.blackjack.domain.card.Card;

public interface User {
    int getScore();
    int getMoney();
    void takeCard(Card card);

    void win(int benefit);

    void lose(int loss);
    String getName();
    String showCardNames();
    String getGameResult();
    void noMoreCard();
    boolean isBlackJack();
}
