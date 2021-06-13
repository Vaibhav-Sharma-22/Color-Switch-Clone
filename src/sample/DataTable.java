package sample;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DataTable implements Serializable {
    private static final long serialVersionUID=42L;
    private int score;
    protected int HIGHSCORE;
    private Ball ball;
    private List<Obstacle> obs = new ArrayList<Obstacle>();
    private Obstacle circle,cross,barwave,rectangle;

    public DataTable(){
        score = 0;
        circle = new Circle();
        cross = new Cross();
        barwave = new BarWave();
        rectangle = new Rectangle();
    }
    public void saveGame(){
        Main.getDatabase().getDatabaseFiles().add(this);
        try{
            Main.serialize();
        } catch (IOException e){

        }
    }
    public void update(int score, Ball ball, List<Obstacle> obs, Obstacle circle, Obstacle rectangle, Obstacle cross, Obstacle barwave ){
        this.score = score;
        this.ball = ball;
        this.obs = obs;
        this.circle = circle;
        this.rectangle = rectangle;
        this.cross = cross;
        this.barwave = barwave;
    }
    public void savegame(){
        Main.getDatabase().getDatabaseFiles().add(this);
        try {
            Main.serialize();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getScore(){
        return score;
    }
    public double getBallx(Ball b){
        return b.getC1().getCenterX();
    }
    public double getBally(Ball b){
        return b.getC1().getCenterY();
    }


}
