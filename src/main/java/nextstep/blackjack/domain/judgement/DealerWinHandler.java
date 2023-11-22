package nextstep.blackjack.domain.judgement;

public class DealerWinHandler implements JudgementHandler {
    @Override
    public void process(Judgement judgement) {
        judgement.getParticipant().lose();
        judgement.getDealer().win(judgement.getParticipant().getBettingMoney());
    }

    @Override
    public JudgementHandler setNext(JudgementHandler handler) {
        throw new RuntimeException("next handler를 지정할 수 없습니다.");
    }
}
