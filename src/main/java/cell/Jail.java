package cell;

import player.Player;

public class Jail implements Cell {

    public static final int JAIL_FINE = 150;

    @Override
    public void play(Player player) {
        player.transferToBank(JAIL_FINE);
    }
}
