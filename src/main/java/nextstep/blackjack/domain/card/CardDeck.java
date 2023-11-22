package nextstep.blackjack.domain.card;

import nextstep.blackjack.domain.strategy.Strategy;

public class CardDeck {
    DeckCards cards;
    Strategy strategy;

    public CardDeck(Strategy strategy) {
        this.strategy = strategy;
    }

    public void generate() {
        cards = strategy.generate();
    }

    public Card draw() {
        return cards.draw();
    }
}
