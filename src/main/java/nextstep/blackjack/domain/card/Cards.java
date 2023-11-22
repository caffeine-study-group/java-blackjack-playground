package nextstep.blackjack.domain.card;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Cards implements PlayerCards, DeckCards {

    public static final int BLACK_JACK_SCORE = 21;

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
        if (list.size() == 0) {
            throw new NoSuchElementException("남아있는 카드가 없습니다.");
        }
        return list.remove(0);
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
