package nextstep.blackjack.domain.judgement;

public interface JudgementHandler {
    void process(Judgement judgement);
    JudgementHandler setNext(JudgementHandler handler);
}
