package nextstep.blackjack.domain;

import nextstep.blackjack.domain.card.CardDeck;
import nextstep.blackjack.domain.judgement.*;
import nextstep.blackjack.domain.user.*;
import nextstep.blackjack.domain.strategy.Strategy;
import nextstep.blackjack.view.InputView;
import nextstep.blackjack.view.OutputView;

public class BlackJack {
    private final CardDeck cardDeck;
    private final Dealer dealer;
    private final Players participants;
    private final InputView inputView;
    private final OutputView outputView;
    private final JudgementHandler firstHandler;

    public BlackJack(Strategy strategy) {
        cardDeck = new CardDeck(strategy);
        dealer = new DealerImpl("딜러");
        participants = new Players();
        inputView = new InputView();
        outputView = new OutputView();

        this.firstHandler = new BlackJackHandler();
        firstHandler.setNext(new ParticipantMatchPointHandler())
                .setNext(new ParticipantBlackJackHandler())
                .setNext(new DealerMatchPointHandler())
                .setNext(new CompareUserHandler())
                .setNext(new DealerWinHandler());
    }

    public void play() {
        cardDeck.generate();
        this.inputView.entreeUsersNames().forEach(this.participants::entry);
        inputView.bettingMoney(this.participants);
        this.startRound();
        this.playRound();
        this.gameResult();
        this.finalBettingMoney();
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
        if (player.isPlayerDied() || player.moreThenMatchPoint())
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
        this.firstHandler.process(new Judgement(dealer, participant));
    }
}
