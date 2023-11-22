package nextstep.blackjack.domain.judgement;

public class ParticipantBlackJackHandler implements JudgementHandler {
    private JudgementHandler handler;

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
    public JudgementHandler setNext(JudgementHandler handler) {
        this.handler = handler;
        return handler;
    }
}
