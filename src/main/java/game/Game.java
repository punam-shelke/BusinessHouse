package game;

import cell.*;
import player.Player;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final int[] diceOutputs;
    private final List<Player> players;
    private final List<Cell> grid;


    public Game(String[] cells, int[] diceOutputs, List<Player> players) {
        grid = getCells(cells);
        this.diceOutputs = diceOutputs;
        this.players = players;
    }

    private ArrayList<Cell> getCells(String[] cells) {
        final ArrayList<Cell> board = new ArrayList<>();
        for (String cell : cells) {
            switch (cell) {
                case "J":
                    board.add(new Jail());
                    break;
                case "H":
                    board.add(new Hotel());
                    break;
                case "L":
                    board.add(new Lottery());
                    break;
                case "E":
                    board.add(new Empty());
                    break;
                default:
            }
        }
        return board;
    }

    public void start() {
        final int gridSize = grid.size();
        final int totalPlayers = players.size();
        final int totalOutcomes = diceOutputs.length;
        for (int i = 0; i < totalOutcomes; i++) {
            final Player player = players.get(i % totalPlayers);
            final int diceOutput = diceOutputs[i];
            final int position = player.getPosition();
            final int newPosition = (position + diceOutput) % gridSize;
            player.setPosition(newPosition);
            final Cell cell = grid.get(newPosition);
            cell.play(player);
        }
    }
}
