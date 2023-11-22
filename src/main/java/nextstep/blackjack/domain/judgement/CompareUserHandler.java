package nextstep.blackjack.domain.judgement;

public class CompareUserHandler implements JudgementHandler {
    private JudgementHandler handler;

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
    public JudgementHandler setNext(JudgementHandler handler) {
        this.handler = handler;
        return handler;
    }
}
