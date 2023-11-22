package nextstep.blackjack.domain.judgement;

public class BlackJackHandler implements JudgementHandler {
    private JudgementHandler handler;

    @Override
    public void process(Judgement judgement) {
        if (judgement.getDealer().isBlackJack() && judgement.getParticipant().isBlackJack()) {
            // nothing
            return;
        }

        if (this.handler != null) {
            this.handler.process(judgement);
        }
    }

    @Override
    public JudgementHandler setNext(JudgementHandler handler) {
        this.handler = handler;
        return handler;
    }

}
