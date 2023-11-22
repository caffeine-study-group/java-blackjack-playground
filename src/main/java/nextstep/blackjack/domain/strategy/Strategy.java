package nextstep.blackjack.domain.strategy;

import nextstep.blackjack.domain.card.Cards;

public interface Strategy {
    Cards generate();
}
