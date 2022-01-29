package dice.game;

import java.util.ArrayList;
import java.util.Collections;

public class GameRound {

    public static final Integer DEFAULT_WIN_SCORE = 7;

    private Dice dice = new Dice();

    private ArrayList<Player> players;

    private Player winner ;

    public GameRound(ArrayList<Player> players) {
        Collections.shuffle(players);
        this.players = players;

    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public Player getWinner() {
        return winner;
    }

    // overloading of play() method ( bottom method )
    // you should play for one round in this method & determine the winner
    // suggest : create a doWhile() until find winner ( before that winner is null ) in this loop create another loop around the players that each player
    //going to " play " method ( overloading ) after that check if his/her roundScore is equal with "DEFAULT_WIN_SCORE" then winner initialize with that player
    public void play() {
        boolean op=false;
        while (!op) {
            for (Player p : players){
                play(p);
                if ( p.roundScore == DEFAULT_WIN_SCORE ){
                    winner=p;
                    op=true;
                    break;
                }
            }
        }
    }

    // use dice object to determine score for player p
    // You should roll dice twice & set sum the rolls & save to to roundScore of player
    private void play(Player p) {
        int points=0;
        dice.roll();
        points+=dice.getFace();
        dice.roll();
        points+=dice.getFace();
        p.setRoundScore(points);
    }
}

