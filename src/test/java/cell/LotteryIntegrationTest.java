package cell;

import bank.Bank;
import org.junit.jupiter.api.Test;
import player.Player;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


class LotteryIntegrationTest {
    @Test
    void givenLottery_whenPlayerPlays_shouldGetCreditedLotteryAmount() {
        final Lottery lottery = new Lottery();
        final Bank bank = new Bank();
        final Player player = new Player(bank);

        lottery.play(player);

        assertThat(player.getBalance(), is(1200));
        assertThat(bank.getBalance(), is(4800));
    }
}