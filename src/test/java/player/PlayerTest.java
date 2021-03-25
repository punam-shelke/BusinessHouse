package player;

import bank.Bank;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class PlayerTest {
    @Test
    void givenAmount_whenCalledCredit_thenShouldAddAmountToBalance() {
        final Bank bank = new Bank();
        final Player player = new Player(bank);

        player.credit(100);

        assertThat(player.getBalance(),is(1100));
    }

    @Test
    void givenAmount_whenCalledDebit_thenShouldSubtractAmountFromBalance() {
        final Bank bank = new Bank();
        final Player player = new Player(bank);

        player.debit(100);

        assertThat(player.getBalance(),is(900));
    }

    @Test
    void givenAmount_whenTransferToBank_thenShouldDebitAndCreditToBank() {
        final Bank bank = new Bank();
        final Player player = new Player(bank);

        player.transferToBank(100);

        assertThat(player.getBalance(),is(900));
        assertThat(bank.getBalance(),is(5100));
    }

    @Test
    void givenAmount_whenTransferToPlayer_thenShouldCreditAndDebitFromBank() {
        final Bank bank = new Bank();
        final Player player = new Player(bank);

        player.transferToPlayer(100);

        assertThat(player.getBalance(),is(1100));
        assertThat(bank.getBalance(),is(4900));
    }
}