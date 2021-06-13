package sample1;

public class Player {
    private int score;
    public Player(){
        score = 0;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score+=score;
    }
}
