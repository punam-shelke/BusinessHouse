package cell;

import org.junit.jupiter.api.Test;
import player.Player;

import static org.mockito.Mockito.*;

class LotteryTest {
    @Test
    void givenLottery_whenPlayerPlays_shouldTransferAmountToPlayer() {
        final Lottery lottery = new Lottery();
        final Player player = mock(Player.class);

        lottery.play(player);

        verify(player, times(1)).transferToPlayer(200);
    }
}
