package cell;

import bank.Bank;
import org.junit.jupiter.api.Test;
import player.Player;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class JailIntegrationTest {
    @Test
    void givenJail_whenPlayerPlays_shouldTransferJailFineToBank() {
        final Jail jail = new Jail();
        final Bank bank = new Bank();
        final Player player = new Player(bank);

        jail.play(player);

        assertThat(player.getBalance(), is(850));
        assertThat(bank.getBalance(), is(5150));
    }
}