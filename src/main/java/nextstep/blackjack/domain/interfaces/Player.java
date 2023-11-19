package nextstep.blackjack.domain.interfaces;

import nextstep.blackjack.domain.Card;

public interface Player extends User {

    int getBettingMoney();
    void win();

    boolean isPlayerDied();

    boolean moreThenMatchPoint();

    void betting(int amount);

    void lose();

    boolean isDrawCard();
}
