package nextstep.blackjack.domain;

import java.util.Arrays;
import java.util.stream.Collectors;

public class NormalDistributeStrategy implements Strategy {

    @Override
    public Cards generate() {
        return new Cards(Arrays.stream(CardSymbol.values())
                .flatMap(symbol -> Arrays.stream(CardNumber.values()).map(number -> new Card(symbol, number)))
                .collect(Collectors.toList()));
    }
}
