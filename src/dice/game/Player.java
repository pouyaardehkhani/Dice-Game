package dice.game;

public class Player {

    private String id;
    private String name = null;
    Integer roundScore = 0;
    Integer totalScore;

    static Integer playerCounter = 0;
    static Integer anamBandProjectCounter = 0;

    Player(String name) {
        id = "P" + ++playerCounter;
        //this.name = name;

        setName(name);
        if (this.name == null) {
            final String anamName =  "Anonymous" + ++anamBandProjectCounter;
            this.name = anamName;
        }

        totalScore = 0;
    }

    public void incrementTotalScore() {
        totalScore++;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if (name != null &&
                !name.isEmpty() &&
                name.length() >= 2) {
            this.name = name.trim().toUpperCase();
        }
    }

    public Integer getRoundScore() {
        return roundScore;
    }

    public void setRoundScore(Integer roundScore) {
        if (roundScore != null && roundScore >= 0
                && roundScore <= 12 && roundScore != 1) {
            this.roundScore = roundScore;
        }
    }

    public Integer getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(Integer totalScore) {
        if (totalScore == null || totalScore < 0) {
            return;
        }
        this.totalScore = totalScore;
    }

    public String toString() {
        return "Player{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", roundScore=" + roundScore +
                ", totalScore=" + totalScore +
                '}';
    }
}
