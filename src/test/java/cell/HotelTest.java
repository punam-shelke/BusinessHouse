package cell;

import org.junit.jupiter.api.Test;
import player.Player;

import static cell.HotelState.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;

class HotelTest {
    @Test
    void givenHotelWithNoOwner_whenPlayerComes_ThenShouldBuyHotelAsSilver() {
        final Hotel hotel = new Hotel();
        final Player player = mock(Player.class);

        hotel.play(player);

        assertThat(hotel.getState(), is(SILVER));
        assertThat(hotel.getOwner(), is(player));
        verify(player, times(1)).transferToBank(200);
    }

    @Test
    void givenHotelWithSilverState_whenOwnerComes_thenShouldUpgradeHotelToGold() {
        final Hotel hotel = new Hotel();
        final Player player = mock(Player.class);
        hotel.play(player);

        hotel.play(player);

        assertThat(hotel.getState(), is(GOLD));
        assertThat(hotel.getOwner(), is(player));
        verify(player, times(1)).transferToBank(100);
    }

    @Test
    void givenHotelWithGoldState_whenOwnerComes_thenShouldUpgradeHotelToPlatinum() {
        final Hotel hotel = new Hotel();
        final Player player = mock(Player.class);
        hotel.play(player);
        hotel.play(player);

        hotel.play(player);

        assertThat(hotel.getState(), is(PLATINUM));
        assertThat(hotel.getOwner(), is(player));
        verify(player, times(2)).transferToBank(200);
    }

    @Test
    void givenSilverHotelOwner_whenAnotherPlayerComes_ThenShouldPayRent() {
        final Hotel hotel = new Hotel();
        final Player player = mock(Player.class);
        final Player anotherPlayer = mock(Player.class);

        hotel.play(player);
        hotel.play(anotherPlayer);

        verify(anotherPlayer, times(1)).payRent(player, 50);
    }

    @Test
    void givenGoldHotelWithOwner_whenAnotherPlayerComes_ThenShouldPayRent() {
        final Hotel hotel = new Hotel();
        final Player player = mock(Player.class);
        final Player anotherPlayer = mock(Player.class);
        hotel.play(player);
        hotel.play(player);


        hotel.play(anotherPlayer);

        verify(anotherPlayer, times(1)).payRent(player, 150);
    }

    @Test
    void givenPlatinumHotelWithOwner_whenAnotherPlayerComes_ThenShouldPayRent() {
        final Hotel hotel = new Hotel();
        final Player player = mock(Player.class);
        final Player anotherPlayer = mock(Player.class);
        hotel.play(player);
        hotel.play(player);
        hotel.play(player);

        hotel.play(anotherPlayer);


        verify(anotherPlayer, times(1)).payRent(player, 300);
    }
}
