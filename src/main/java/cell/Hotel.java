package cell;

import player.Player;

import static cell.HotelState.NEW;

public class Hotel implements Cell {
    private Player owner;
    private HotelState state;

    public Hotel() {
        state = NEW;
        owner = null;
    }

    @Override
    public void play(Player player) {
        if (owner == null) {
            state = state.getUpgradeState();
            owner = player;
            player.transferToBank(state.getValue());
        } else if (owner.equals(player)) {
            final int delta = state.getDelta();
            state = state.getUpgradeState();
            player.transferToBank(delta);
        } else {
            final int rent = state.getRent();
            player.payRent(owner, rent);
        }
    }

    public HotelState getState() {
        return state;
    }

    public Player getOwner() {
        return owner;
    }
}
