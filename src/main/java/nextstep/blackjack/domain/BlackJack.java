package nextstep.blackjack.domain;

import nextstep.blackjack.domain.interfaces.Dealer;
import nextstep.blackjack.domain.interfaces.Player;
import nextstep.blackjack.view.InputView;
import nextstep.blackjack.view.OutputView;

public class BlackJack {
    private final CardDeck cardDeck;
    private final Dealer dealer;
    private Players participants;
    private InputView inputView;
    private OutputView outputView;

    public BlackJack(Strategy strategy) {
        cardDeck = new CardDeck(strategy);
        dealer = new DealerImpl("딜러");
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void play() {
        cardDeck.generate();
        this.participants = new Players(this.inputView.entreeUsersNames());
        inputView.bettingMoney(this.participants);
        this.startRound();
        this.playRound();
        this.gameResult();
        this.finalBettingMoney();;
    }

    public void startRound() {

        dealer.takeCard(cardDeck.draw());
        dealer.takeCard(cardDeck.draw());

        for (Player player : this.participants.getPlayers()) {
            player.takeCard(cardDeck.draw());
            player.takeCard(cardDeck.draw());
        }
        outputView.printFirstCardDivideMessage(this.participants);
        outputView.printPlayerCardList(dealer);
        for (Player player : this.participants.getPlayers()) {
            outputView.printPlayerCardList(player);
        }
    }

    public void playRound() {
        for (Player player : this.participants.getPlayers()) {
            this.chooseMoreCard(player);
        }

        if (dealer.lessThenDealerPoint()) {
            dealer.takeCard(cardDeck.draw());
            outputView.printDealerTakeCard();
        }
    }

    private void chooseMoreCard(Player player) {
        if (player.isPlayerDied())
            return;
        if (player.moreThenMatchPoint())
            return;
        if (inputView.isPlayingGamingMessage(player)) {
            player.takeCard(cardDeck.draw());
            outputView.printPlayerCardList(player);
            chooseMoreCard(player);
        }
        if (!player.isDrawCard()) {
            outputView.printPlayerCardList(player);
        }
    }

    public void gameResult() {
        outputView.printGameResult(dealer);
        for (Player player : this.participants.getPlayers()) {
            outputView.printGameResult(player);
            vs(dealer, player);
        }
    }

    public void finalBettingMoney() {
        outputView.endGameMessage(dealer, participants);
    }

    private void vs(Dealer dealer, Player participant) {
        if (dealer.isBlackJack() && participant.isBlackJack()) {
            // nothing
        } else if (participant.getScore() > 21) {
            participant.lose();
            dealer.win(participant.getBettingMoney());
        } else if (participant.isBlackJack()) {
            participant.win((int) Math.round(participant.getBettingMoney() * 1.5));
            dealer.lose((int) Math.round(participant.getBettingMoney() * 1.5));
        } else if (dealer.getScore() > 21) {
            participant.win();
            dealer.lose(participant.getBettingMoney());
        } else if (participant.getScore() > dealer.getScore()) {
            participant.win();
            dealer.lose(participant.getBettingMoney());
        } else {
            participant.lose();
            dealer.win(participant.getBettingMoney());
        }
    }
}
