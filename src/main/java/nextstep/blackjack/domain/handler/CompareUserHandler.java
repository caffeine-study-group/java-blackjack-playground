package nextstep.blackjack.domain.handler;

public class CompareUserHandler implements Handler {
    private Handler handler;

    @Override
    public void process(Judgement judgement) {
        if (judgement.getParticipant().getScore() > judgement.getDealer().getScore()) {
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
