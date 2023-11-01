package nextstep.blackjack.domain;

import nextstep.blackjack.domain.interfaces.DeckCards;

import java.util.Arrays;
import java.util.stream.Collectors;

public class CardDeck {
    DeckCards cards;

    public CardDeck(Strategy strategy) {
        Arrays.stream(CardSymbol.values()).collect(Collectors.toList());
    }
}
