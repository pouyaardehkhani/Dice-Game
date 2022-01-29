package dice.game;

import java.util.ArrayList;

public class Game {

    private ArrayList<Player> players;
    private Player winner;
    private Integer numberOfRounds;
    private ArrayList<GameRound> rounds;

    public static final Integer DEFAULT_NUMBER_OF_ROUNDS = 1;

    public Game(ArrayList<Player> players, Integer numberOfRounds) {
        this.players = players;

        this.numberOfRounds = numberOfRounds >= 1
                ? numberOfRounds
                : DEFAULT_NUMBER_OF_ROUNDS;
//        if (numberOfRounds >= 1) {
//            this.numberOfRounds = numberOfRounds;
//        } else {
//            this.numberOfRounds = 1;
//        }

        rounds = new ArrayList<>();
        for (Integer i = 0; i < this.numberOfRounds; ++i) {
            rounds.add(new GameRound(this.players));
        }
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public Player getWinner() {
        return winner;
    }

    public Integer getNumberOfRounds() {
        return numberOfRounds;
    }

    public ArrayList<GameRound> getRounds() {
        return rounds;
    }

    @Override
    public String toString() {
        String s = "International Professional Mapsa Dice Game!\n\n";

        s += "Player name: ";
        for (Player p : players) {
            s += p.getName() + "\t";
        }
        s += "\n----------------------------------------------\n";
        s += String.format("Game held in %d rounds.\n\n", numberOfRounds);
        for (Integer roundCounter = 0;
             roundCounter < this.numberOfRounds;
             ++roundCounter) {
            s += String.format("Round #%d\t:\tWinner -> %s!\n",
                    roundCounter + 1,
                    rounds.get(roundCounter).getWinner().getName());
        }

        s += "\n----------------------------------------------\n";
        s += "The winner is -> " + winner.getName();
        return s;
    }

    public void play() {

        for (GameRound round : this.rounds) {
            round.play();
            Player roundWinner = round.getWinner();

            roundWinner.incrementTotalScore();
        }

        findWinner();
    }

    // you should find ultimate winner
    // compare totalScore of each player find the maximum and initialize to winner variable
    private void findWinner() {
        Player max=players.get(0);
        for (int i=1;i<players.size();i++){
            if (max.getTotalScore() < players.get(i).getTotalScore()){
                max=players.get(i);
            }
        }
        winner=max;
    }
}
