package nextstep.blackjack.domain;

public enum CardSymbol {
    SPADE("스페이드")
    , HEART("하트")
    , DIAMOND("다이아몬드")
    , CLOVER("클로버");

    CardSymbol(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }
}
