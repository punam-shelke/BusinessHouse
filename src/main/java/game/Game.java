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

    private ArrayList<Cell> getCells(String[] cells) {
        final ArrayList<Cell> board = new ArrayList<>();
        for (String cell : cells) {
            final InputCell inputCell = InputCell.valueOf(cell);
            board.add(inputCell.getCell());
        }
        return board;
    }
}
