package nextstep.blackjack.domain;

import nextstep.blackjack.domain.interfaces.Dealer;

public class DealerImpl extends UserImpl implements Dealer {

    private static final int DEALER_POINT = 16;

    public DealerImpl(String name) {
        super(name);
    }

    @Override
    public boolean lessThenDealerPoint() {
        return this.getScore() <= DEALER_POINT;
    }
}
