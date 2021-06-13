package sample;

public class Player {
    private static Player obj = new Player();
    private int score;
    public Player(){
        score = 0;
    }

    public int getScore() {
        return score;
    }
    public static Player getObj() {
        return obj;
    }

    public void setScore(int score) {
        this.score+=score;
    }
}
