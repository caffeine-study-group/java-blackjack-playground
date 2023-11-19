package nextstep.blackjack.domain.handler;

public class ParticipantMatchPointHandler implements Handler {
    private Handler handler;

    @Override
    public void process(Judgement judgement) {
        if (judgement.getParticipant().getScore() > 21) {
            judgement.getParticipant().lose();
            judgement.getDealer().win(judgement.getParticipant().getBettingMoney());
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
