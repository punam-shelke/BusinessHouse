package player;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class PlayerTest {
    @Test
    void givenAmount_whenCalledCredit_thenShouldAddAmountToBalance() {
        final Player player = new Player();

        player.credit(100);

        assertThat(player.getBalance(),is(1100));
    }

    @Test
    void givenAmount_whenCalledDebit_thenShouldSubtractAmountFromBalance() {
        final Player player = new Player();

        player.debit(100);

        assertThat(player.getBalance(),is(900));
    }
}