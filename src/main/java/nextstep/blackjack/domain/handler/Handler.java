package nextstep.blackjack.domain.handler;

public interface Handler {
    void process(Judgement judgement);
    Handler setNext(Handler handler);
}
