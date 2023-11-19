package nextstep.blackjack.domain.handler;

public class DealerMatchPointHandler implements Handler {
    private Handler handler;

    @Override
    public void process(Judgement judgement) {
        if (judgement.getDealer().getScore() > 21) {
            judgement.getParticipant().win();
            judgement.getDealer().lose(judgement.getParticipant().getBettingMoney());
            return;
        }
        if (this.handler != null) {
            handler.process(judgement);
        }
    }

    @Override
    public Handler setNext(Handler handler) {
        this.handler = handler;
        return handler;
    }
}
