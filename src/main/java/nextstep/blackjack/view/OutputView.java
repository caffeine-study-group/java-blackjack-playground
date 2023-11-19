package nextstep.blackjack.view;

import nextstep.blackjack.domain.Players;
import nextstep.blackjack.domain.interfaces.Dealer;
import nextstep.blackjack.domain.interfaces.Player;
import nextstep.blackjack.domain.interfaces.User;

public class OutputView {

    private static final String FIRST_CARD_DIVIDE_MESSAGE = "딜러와 %s 에게 2장의 카드를 나누어줬습니다.\n";
    private static final String PLAYER_NAME_AND_CARD_MESSAGE = "%s: %s\n";
    private static final String CHOOSE_GAME_GO_OR_END_MESSAGE = "%s는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)";

    private static final String DEALER_TAKE_CARD_MESSAGE = "딜러는 %d이하라 한장의 카드를 더 받았습니다.";

    private static final String FINAL_BETTING_MONEY_MESSAGE = "## 최종 수익\n";

    public OutputView() {

    }

    public void printFirstCardDivideMessage(Players players) {
        System.out.printf(FIRST_CARD_DIVIDE_MESSAGE, players.getNames());
    }

    public void printPlayerCardList(User user) {
        System.out.printf(PLAYER_NAME_AND_CARD_MESSAGE, user.getName(), user.showCardNames());
    }

    public void printDealerTakeCard() {
        System.out.printf(DEALER_TAKE_CARD_MESSAGE, 16);
    }

    public void printGameResult(User user) {
        System.out.println(user.getName() + "카드: " + user.showCardNames() + " - 결과: " + user.getScore());
    }

    public void endGameMessage(Dealer dealer, Players players) {
        System.out.printf(FINAL_BETTING_MONEY_MESSAGE);
        System.out.printf(PLAYER_NAME_AND_CARD_MESSAGE, dealer.getName(), dealer.getMoney());
        for (Player player : players.getPlayers()) {
            System.out.printf(PLAYER_NAME_AND_CARD_MESSAGE, player.getName(), player.getMoney());
        }
    }
}
