package nextstep.blackjack.domain.judgement;

public class DealerMatchPointHandler implements JudgementHandler {
    private JudgementHandler handler;

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
    public JudgementHandler setNext(JudgementHandler handler) {
        this.handler = handler;
        return handler;
    }
}
