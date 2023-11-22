package nextstep.blackjack.domain.user;

import nextstep.blackjack.domain.card.Card;
import nextstep.blackjack.domain.card.Cards;

import java.util.ArrayList;

public class UserImpl implements User {
    protected static final int DEFAULT_CARD_SIZE = 2;
    private String name;
    private int money;
    protected Cards cards;
    protected boolean died;

    public UserImpl(String name) {
        this.name = name;
        this.money = 0;
        this.died = false;
        this.cards = new Cards(new ArrayList<>());
    }

    @Override
    public int getScore() {
        return cards.getTotalScore();
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
    public void win(int benefit) {
        this.money += benefit;
    }

    @Override
    public void lose(int loss) {
        this.money -= loss;
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
    public boolean isBlackJack() {
        return this.getScore() == Cards.BLACK_JACK_SCORE && cards.getCount() == 2;
    }
}
