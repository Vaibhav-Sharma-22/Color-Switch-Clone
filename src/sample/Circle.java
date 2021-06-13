package sample;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;

public class Circle extends Obstacle {
    private Arc a1,a2,a3,a4;
    public Circle(){
        super();
        a1 = new Arc(50,50,100,100,0,90);
        a2 = new Arc(50,50,100,100,90,90);
        a3 = new Arc(50,50,100,100,180,90);
        a4 = new Arc(50,50,100,100,270,90);
        a1.setFill(null);
        a2.setFill(null);
        a3.setFill(null);
        a4.setFill(null);
        a1.setStroke(Color.YELLOW);
        a1.setId("y");
        a2.setStroke(Color.PURPLE);
        a2.setId("p");
        a3.setStroke(Color.AQUA);
        a3.setId("a");
        a4.setStroke(Color.RED);
        a4.setId("r");
        a1.setType(ArcType.OPEN);
        a2.setType(ArcType.OPEN);
        a3.setType(ArcType.OPEN);
        a4.setType(ArcType.OPEN);
        a1.setStrokeWidth(10);
        a2.setStrokeWidth(10);
        a3.setStrokeWidth(10);
        a4.setStrokeWidth(10);
        this.group.getChildren().addAll(a1,a2,a3,a4);

    }

    @Override
    public void setRotate() {
        super.setRotate();
    }

    @Override
    public Group getGroup() {
        this.setGroup();
        this.setRotate();
        return this.group;
    }

    @Override
    public void setGroup() {
    }

    @Override
    public float getSpeed() {
        return super.getSpeed();
    }

    @Override
    public void setSpeed(float speed) {
        super.setSpeed(speed);
    }

    @Override
    public void move() {
        this.group.setLayoutY(this.getGroup().getLayoutY()+100);

    }

    @Override
    public void start(Stage stage) throws Exception {

    }
}
