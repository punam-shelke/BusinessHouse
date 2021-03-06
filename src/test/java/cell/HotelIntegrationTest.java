package cell;

import bank.Bank;
import org.junit.jupiter.api.Test;
import player.Player;

import static cell.HotelState.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class HotelIntegrationTest {
    @Test
    void givenHotelWithNoOwner_whenPlayerComes_ThenShouldBuyHotelAsSilver() {
        final Hotel hotel = new Hotel();
        final Bank bank = new Bank();
        final Player player = new Player(bank);

        hotel.play(player);

        assertThat(hotel.getState(), is(SILVER));
        assertThat(hotel.getOwner(), is(player));
        assertThat(player.getBalance(), is(800));
        assertThat(bank.getBalance(), is(5200));
    }

    @Test
    void givenHotelWithSilverState_whenOwnerComes_thenShouldUpgradeHotelToGold() {
        final Hotel hotel = new Hotel();
        final Bank bank = new Bank();
        final Player player = new Player(bank);
        hotel.play(player);

        hotel.play(player);

        assertThat(hotel.getState(), is(GOLD));
        assertThat(hotel.getOwner(), is(player));
        assertThat(player.getBalance(), is(700));
        assertThat(bank.getBalance(), is(5300));
    }

    @Test
    void givenHotelWithGoldState_whenOwnerComes_thenShouldUpgradeHotelToPlatinum() {
        final Hotel hotel = new Hotel();
        final Bank bank = new Bank();
        final Player player = new Player(bank);
        hotel.play(player);
        hotel.play(player);

        hotel.play(player);

        assertThat(hotel.getState(), is(PLATINUM));
        assertThat(hotel.getOwner(), is(player));
        assertThat(player.getBalance(), is(500));
        assertThat(bank.getBalance(), is(5500));
    }

    @Test
    void givenSilverHotelOwner_whenAnotherPlayerComes_ThenShouldPayRent() {
        final Hotel hotel = new Hotel();
        final Bank bank = new Bank();
        final Player player = new Player(bank);
        final Player anotherPlayer = new Player(bank);

        hotel.play(player);
        hotel.play(anotherPlayer);

        assertThat(player.getBalance(), is(850));
        assertThat(anotherPlayer.getBalance(), is(950));
    }

    @Test
    void givenGoldHotelWithOwner_whenAnotherPlayerComes_ThenShouldPayRent() {
        final Hotel hotel = new Hotel();
        final Bank bank = new Bank();
        final Player player = new Player(bank);
        hotel.play(player);
        hotel.play(player);
        final Player anotherPlayer = new Player(bank);

        hotel.play(anotherPlayer);

        assertThat(player.getBalance(), is(850));
        assertThat(anotherPlayer.getBalance(), is(850));
    }

    @Test
    void givenPlatinumHotelWithOwner_whenAnotherPlayerComes_ThenShouldPayRent() {
        final Hotel hotel = new Hotel();
        final Bank bank = new Bank();
        final Player player = new Player(bank);
        hotel.play(player);
        hotel.play(player);
        hotel.play(player);
        final Player anotherPlayer = new Player(bank);

        hotel.play(anotherPlayer);


        assertThat(player.getBalance(), is(800));
        assertThat(anotherPlayer.getBalance(), is(700));
    }
}
