package dice.game;

import javax.swing.*;
import java.util.ArrayList;

public class DiceGame {
    ArrayList<Player> players = new ArrayList<>();
    private Game game;

    DiceGame() {

        //Input
        String numberOfRoundsString =
                JOptionPane.showInputDialog(
                        "Enter number of rounds:");
        final Integer numberOfRounds = Integer.parseInt(numberOfRoundsString);

        final String playerNamesString = JOptionPane.showInputDialog(
                "Enter player names:");
        String[] playerNames = playerNamesString.split(" ");
        for (String name : playerNames) {
            players.add(new Player(name));
        }

        //Logic
        game = new Game(players, numberOfRounds);

        game.play();

        //Output
        JOptionPane.showMessageDialog(null, game.toString());
    }

    public static void main(String[] args) {
        new DiceGame();
    }
}
