package nextstep.blackjack.domain.interfaces;

import nextstep.blackjack.domain.Card;

public interface Player {
    int getMoney();
    void takeCard(Card card);
    void betting(int amount);
    void benefit(int amount);
    String getName();
    String showCardNames();
    String getGameResult();
    void noMoreCard();
    boolean isPlayerDied();
}
