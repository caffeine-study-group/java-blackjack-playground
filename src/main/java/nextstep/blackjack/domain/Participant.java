package nextstep.blackjack.domain;

import nextstep.blackjack.domain.interfaces.Player;

import java.util.ArrayList;

public class Participant implements Player {
    private String name;
    private int money;
    private Cards cards;
    private boolean died;

    public Participant(String name) {
        this.name = name;
        this.money = 0;
        this.died = false;
        this.cards = new Cards(new ArrayList<>());
    }

    @Override
    public int getMoney() {
        return money;
    }

    @Override
    public void takeCard(Card card) {
        this.cards.addCard(card);
    }

    @Override
    public void betting(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("배팅 금액은 0보다 작을 수 없습니다.");
        }
        this.money = this.money - amount;
    }

    @Override
    public void benefit(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("수익은 0보다 작을 수 없습니다.");
        }
        this.money = this.money + amount;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String showCardNames() {
        return this.cards.getCardNames();
    }

    @Override
    public String getGameResult() {
        return this.name + "카드: " + this.cards.getCardNames() + " - 결과: " + cards.getTotalScore();
    }

    @Override
    public void noMoreCard() {
        this.died = true;
    }

    @Override
    public boolean isPlayerDied() {
        return this.died;
    }
}
