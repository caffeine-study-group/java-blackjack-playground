package nextstep.blackjack.domain.interfaces;

import nextstep.blackjack.domain.Card;

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
