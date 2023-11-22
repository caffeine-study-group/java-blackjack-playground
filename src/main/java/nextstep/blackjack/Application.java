package nextstep.blackjack;

import nextstep.blackjack.domain.BlackJack;
import nextstep.blackjack.domain.strategy.RandomDistributeStrategy;

public class Application {
    public static void main(String[] args) {
        BlackJack blackJack = new BlackJack(new RandomDistributeStrategy());
//        BlackJack blackJack = new BlackJack(new NormalDistributeStrategy());
        blackJack.play();
    }
}
