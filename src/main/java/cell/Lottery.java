package cell;

import player.Player;

public class Lottery implements Cell {

    public static final int LOTTERY_AMOUNT = 200;

    @Override
    public void play(Player player) {
        player.transferToPlayer(LOTTERY_AMOUNT);
    }
}
