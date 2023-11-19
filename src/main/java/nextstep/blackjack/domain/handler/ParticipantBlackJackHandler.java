package nextstep.blackjack.domain.handler;

public class ParticipantBlackJackHandler implements Handler {
    private Handler handler;

    @Override
    public void process(Judgement judgement) {
        if (judgement.getParticipant().isBlackJack()) {
            judgement.getParticipant().win((int) Math.round(judgement.getParticipant().getBettingMoney() * 1.5));
            judgement.getDealer().lose((int) Math.round(judgement.getParticipant().getBettingMoney() * 1.5));
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
