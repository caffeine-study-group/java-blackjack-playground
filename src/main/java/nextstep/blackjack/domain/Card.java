package nextstep.blackjack.domain;

public class Card {

    private final CardSymbol symbol;
    private final CardNumber number;

    public Card(CardSymbol symbol, CardNumber number) {
        this.symbol = symbol;
        this.number = number;
    }

    public String getName() {
        return String.format("%s%s", number.getName(), symbol.getName());
    }
}
