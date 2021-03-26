package bank;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class BankTest {
    @Test
    void givenAmount_whenCalledCredit_thenShouldAddAmountToBalance() {
        final Bank bank = new Bank();

        bank.credit(100);

        assertThat(bank.getBalance(), is(5100));
    }

    @Test
    void givenAmount_whenCalledDebit_thenShouldSubtractAmountFromBalance() {
        final Bank bank = new Bank();

        bank.debit(100);

        assertThat(bank.getBalance(), is(4900));
    }
}