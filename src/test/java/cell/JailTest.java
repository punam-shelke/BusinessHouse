package cell;

import org.junit.jupiter.api.Test;
import player.Player;

import static org.mockito.Mockito.*;

class JailTest {
    @Test
    void givenJail_whenPlayerPlays_shouldTransferJailFineToBank() {
        final Jail jail = new Jail();
        final Player player = mock(Player.class);

        jail.play(player);

        verify(player, times(1)).transferToBank(150);
    }
}
