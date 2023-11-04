package nextstep.blackjack.domain;

import nextstep.blackjack.domain.interfaces.DeckCards;

import java.util.Arrays;
import java.util.stream.Collectors;

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
