package nextstep.blackjack.domain.handler;

public class DealerWinHandler implements Handler {
    @Override
    public void process(Judgement judgement) {
        judgement.getParticipant().lose();
        judgement.getDealer().win(judgement.getParticipant().getBettingMoney());
    }

    @Override
    public Handler setNext(Handler handler) {
        throw new RuntimeException("next handler를 지정할 수 없습니다.");
    }
}
