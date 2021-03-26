package game;


import bank.Bank;
import org.junit.jupiter.api.Test;
import player.Player;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class GameIntegrationTest {
    @Test
    void givenInputSetOne_whenGameIsPlayed_thenShouldHaveFinalAmountOfPlayer() {
        String[] cells = {"J", "H", "L", "H", "E", "L", "H", "L", "H", "J"};
        final int[] diceOutputs = {2, 2, 1, 4, 4, 2, 4, 4, 2, 2, 2, 1, 4, 4, 2, 4, 4, 2, 2, 2, 1};
        final Bank bank = new Bank();
        final Player player1 = new Player(bank);
        final Player player2 = new Player(bank);
        final Player player3 = new Player(bank);
        final List<Player> players = List.of(player1, player2, player3);
        final Game game = new Game(cells, diceOutputs, players);

        game.start();

        assertThat(player1.getBalance(), is(1100));
        assertThat(player2.getBalance(), is(600));
        assertThat(player3.getBalance(), is(1150));
    }

    @Test
    void givenInputSetTwo_whenGameIsPlayed_thenShouldHaveFinalAmountOfPlayer() {
        String[] cells = {"J", "H", "L", "H", "E", "L", "H", "L", "H", "J"};
        final int[] diceOutputs = {2, 2, 1, 4, 2, 3, 4, 1, 3, 2, 2, 7, 4, 7, 2, 4, 4, 2, 2, 2, 2};
        final Bank bank = new Bank();
        final Player player1 = new Player(bank);
        final Player player2 = new Player(bank);
        final Player player3 = new Player(bank);
        final List<Player> players = List.of(player1, player2, player3);
        final Game game = new Game(cells, diceOutputs, players);
        game.start();

        assertThat(player1.getBalance(), is(650));
        assertThat(player2.getBalance(), is(750));
        assertThat(player3.getBalance(), is(850));
    }
}