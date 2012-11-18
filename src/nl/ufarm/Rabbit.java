/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.ufarm;

import javafx.animation.Animation;
import javafx.animation.ParallelTransition;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;

/**
 *
 * @author Maarten
 */
class Rabbit extends Sprite {

    public Rabbit(double x, double y) {

        vX = 1;
        vY = 1;
        node = new ImageView((new Image("nl/ufarm/killer_rabbit.png")));
        ((ImageView) node).setX(x);
        ((ImageView) node).setY(y);

//        Path path = new Path();
//        path.getElements().add(new MoveTo(850, 100));
////        path.getElements().add(new CubicCurveTo(380, 0, 380, 120, 200, 120));
////        path.getElements().add(new CubicCurveTo(0, 120, 0, 240, 380, 240));
//
//        MoveTo moveTo = new MoveTo();
//        moveTo.setX(248);
//        moveTo.setY(220);
//
//        CubicCurveTo cubicTo = new CubicCurveTo();
//        cubicTo.setControlX1(224);
//        cubicTo.setControlY1(180);
//        cubicTo.setControlX2(254);
//        cubicTo.setControlY2(132);
//        cubicTo.setX(288.0f);
//        cubicTo.setY(222.0f);
//
//        path.getElements().add(moveTo);
//        path.getElements().add(cubicTo);
//
//        PathTransition pathTransition = new PathTransition();
//        pathTransition.setDuration(Duration.millis(2000));
//        pathTransition.setPath(path);
//        pathTransition.setNode(this.node);
//        pathTransition.setOrientation(PathTransition.OrientationType.NONE);
//        pathTransition.setCycleCount(Timeline.INDEFINITE);
//        pathTransition.setAutoReverse(false);
////        pathTransition.play();


        


        Path movementPath = new Path();
        movementPath.getElements().add(new MoveTo(0, 430));
        movementPath.getElements().add(new LineTo(100, 400));
        movementPath.getElements().add(new LineTo(150, 430));
        movementPath.getElements().add(new LineTo(200, 400));
        movementPath.getElements().add(new LineTo(250, 430));
        movementPath.getElements().add(new LineTo(300, 400));
        movementPath.getElements().add(new LineTo(350, 430));
        movementPath.getElements().add(new LineTo(400, 400));
        movementPath.getElements().add(new LineTo(450, 430));
        movementPath.getElements().add(new LineTo(500, 400));
        movementPath.getElements().add(new LineTo(550, 430));
        movementPath.getElements().add(new LineTo(600, 400));
        movementPath.getElements().add(new LineTo(650, 430));
        movementPath.getElements().add(new LineTo(700, 400));
        movementPath.getElements().add(new LineTo(750, 430));
        movementPath.getElements().add(new LineTo(800, 400));
        movementPath.getElements().add(new LineTo(850, 430));
//        path.getElements().add(new CubicCurveTo(200, 100, 380, 120, 200, 400));
//        path.getElements().add(new CubicCurveTo(100, 120, 100, 240, 380, 440));
        PathTransition movementPathTransition = new PathTransition();
        movementPathTransition.setDuration(Duration.millis(20000));
        movementPathTransition.setPath(movementPath);
        movementPathTransition.setNode(this.node);
        movementPathTransition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        movementPathTransition.setCycleCount(Timeline.INDEFINITE);
        movementPathTransition.setAutoReverse(false);
//        movementPathTransition.play();
        
        
        Animation a = new ParallelTransition( movementPathTransition);
        a.play();
    }

    @Override
    double getCollisionSphereSize() {
        return 100.0d;
    }

    @Override
    public void handleCollisionWith(Sprite other) {
        if (other instanceof Farmer) {
            ((ImageView) node).setImage(new Image("nl/ufarm/LuckyTractorBloody.png"));
        }
    }

    @Override
    public void update() {
    }
}
