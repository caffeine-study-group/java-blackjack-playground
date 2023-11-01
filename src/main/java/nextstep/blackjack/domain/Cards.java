package nextstep.blackjack.domain;

import nextstep.blackjack.domain.interfaces.DeckCards;
import nextstep.blackjack.domain.interfaces.PlayerCards;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Cards implements PlayerCards, DeckCards {

    private final List<Card> list;

    public Cards(List<Card> list) {
        this.list = list;
    }

    public void addCard(Card card) {
        this.list.add(card);
    }

    public String getCardNames() {
        return list.stream().map(Card::getName).collect(Collectors.joining(", "));
    }

    public int getTotalScore() {
        return list.stream()
                .sorted(Comparator.comparing(Card::getScore))
                .reduce(0, (total, card) -> {
                    if (total > 10 && card.isAce()) {
                        return total + 1;
                    }
                    return total + card.getScore();
                }, Integer::sum);
    }

    public Card draw() {
        return list.remove(list.size() - 1);
    }
}
