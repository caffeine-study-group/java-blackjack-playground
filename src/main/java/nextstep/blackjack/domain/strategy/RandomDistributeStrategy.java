package nextstep.blackjack.domain.strategy;

import nextstep.blackjack.domain.card.Card;
import nextstep.blackjack.domain.card.CardNumber;
import nextstep.blackjack.domain.card.CardSymbol;
import nextstep.blackjack.domain.card.Cards;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RandomDistributeStrategy implements Strategy {

    @Override
    public Cards generate() {
        List<Card> list = Arrays.stream(CardSymbol.values())
                .flatMap(symbol -> Arrays.stream(CardNumber.values()).map(number -> new Card(symbol, number)))
                .collect(Collectors.toList());
        Collections.shuffle(list);
        return new Cards(list);
    }
}
