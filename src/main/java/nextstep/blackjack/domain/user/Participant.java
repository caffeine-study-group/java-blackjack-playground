package nextstep.blackjack.domain.user;

import nextstep.blackjack.domain.card.Cards;

public class Participant extends UserImpl implements Player {
    private int bettingMoney;

    public Participant(String name) {
        super(name);
        this.bettingMoney = 0;
    }


    @Override
    public void betting(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("배팅 금액은 0보다 작을 수 없습니다.");
        }
        this.bettingMoney = this.bettingMoney + amount;
    }

    @Override
    public int getBettingMoney() {
        return this.bettingMoney;
    }

    @Override
    public void win() {
        this.win(this.bettingMoney);
    }

    @Override
    public void lose() {
        this.lose(this.bettingMoney);
    }

    @Override
    public boolean isPlayerDied() {
        return this.died;
    }

    @Override
    public boolean moreThenMatchPoint() {
        return this.getScore() >= Cards.BLACK_JACK_SCORE;
    }

    @Override
    public boolean isDrawCard() {
        return cards.getCount() > DEFAULT_CARD_SIZE;
    }
}
