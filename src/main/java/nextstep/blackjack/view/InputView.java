package nextstep.blackjack.view;

import nextstep.blackjack.domain.user.Players;
import nextstep.blackjack.domain.user.Player;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final String DELIMITER_COMMA = ",";

    private static final String ENTREE_USER_INPUT_MESSAGE = "게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)";
    private static final String BETTING_MONEY_INPUT_MESSAGE = "%s의 베팅 금액은?\n";

    private final Scanner scanner;
    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public List<String> entreeUsersNames() {
        System.out.println(ENTREE_USER_INPUT_MESSAGE);
        String userNames = this.scanner.nextLine();
        return Arrays.stream(userNames.split(DELIMITER_COMMA)).collect(Collectors.toList());
    }

    public void bettingMoney(Players players) {
        for (Player player : players.getPlayers()) {
            System.out.printf(BETTING_MONEY_INPUT_MESSAGE, player.getName());
            player.betting(Integer.parseInt(this.scanner.nextLine()));
        }
    }

    public boolean isPlayingGamingMessage(Player player) {
        System.out.printf("%s는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)", player.getName());

        String input = this.scanner.nextLine();
        if ("y".equals(input)) {
            return true;
        }
        player.noMoreCard();
        return false;
    }
}
