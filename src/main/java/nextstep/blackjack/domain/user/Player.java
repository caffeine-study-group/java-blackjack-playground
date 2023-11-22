package nextstep.blackjack.domain.user;

public interface Player extends User {

    int getBettingMoney();
    void win();

    boolean isPlayerDied();

    boolean moreThenMatchPoint();

    void betting(int amount);

    void lose();

    boolean isDrawCard();
}
