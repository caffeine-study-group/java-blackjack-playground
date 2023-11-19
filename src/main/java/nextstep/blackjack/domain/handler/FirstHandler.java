package nextstep.blackjack.domain.handler;

public class FirstHandler implements Handler {
    private Handler handler;

    @Override
    public void process(Judgement judgement) {
        if (judgement.getDealer().isBlackJack() && judgement.getParticipant().isBlackJack()) {
            // nothing
        } else if (this.handler != null) {
            this.handler.process(judgement);
        }


    }

    @Override
    public Handler setNext(Handler handler) {
        this.handler = handler;
        return handler;
    }

}
