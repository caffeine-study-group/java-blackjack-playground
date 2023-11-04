package nextstep.blackjack.domain;

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
