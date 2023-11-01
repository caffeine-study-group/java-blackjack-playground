package nextstep.blackjack.domain;

public enum CardNumber {
    ONE(1, "1"),
    TWO(2, "2"),
    THREE(3, "3"),
    FOUR(4, "4"),
    FIVE(5, "5"),
    SIX(6, "6"),
    SEVEN(7, "7"),
    EIGHT(8, "8"),
    NINE(9, "9"),
    TEN(10, "10"),
    KING(10, "K"),
    QUEEN(10, "Q"),
    JACK(10, "J"),
    ACE(11, "A");


    CardNumber(int score, String name) {
        this.score = score;
        this.name = name;
    }
    private int score;
    private String name;

    public int getScore() {
        return score;
    }

    public String getName() {
        return name;
    }

    public boolean isAce() {
        return this.equals(ACE);
    }
}
