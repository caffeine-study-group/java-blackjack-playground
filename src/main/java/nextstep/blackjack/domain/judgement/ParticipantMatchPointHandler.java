package nextstep.blackjack.domain.judgement;

public class ParticipantMatchPointHandler implements JudgementHandler {
    private JudgementHandler handler;

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
    public JudgementHandler setNext(JudgementHandler handler) {
        this.handler = handler;
        return handler;
    }
}
