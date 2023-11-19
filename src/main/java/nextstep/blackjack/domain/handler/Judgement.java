package nextstep.blackjack.domain.handler;

import nextstep.blackjack.domain.interfaces.Dealer;
import nextstep.blackjack.domain.interfaces.Player;

public class Judgement {
    private Dealer dealer;
    private Player participant;

    public Judgement(Dealer dealer, Player participant) {
        this.dealer = dealer;
        this.participant = participant;
    }


    public Dealer getDealer() {
        return dealer;
    }

    public Player getParticipant() {
        return participant;
    }
}
