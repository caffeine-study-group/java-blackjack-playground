package nextstep.blackjack.domain;

import java.util.Objects;

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

    public int getScore() {
        return number.getScore();
    }

    public boolean isAce() {
        return number.isAce();
    }

    @Override
    public String toString() {
        return "Card{" +
                "symbol=" + symbol +
                ", number=" + number +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return symbol == card.symbol && number == card.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(symbol, number);
    }
}
