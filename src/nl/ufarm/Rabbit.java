/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.ufarm;

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

        node = new ImageView((new Image("nl/ufarm/killer_rabbit.png")));
        ((ImageView) node).setX(x);
        ((ImageView) node).setY(y);

        Path path = new Path();
        path.getElements().add(new MoveTo(850, 100));
//        path.getElements().add(new CubicCurveTo(380, 0, 380, 120, 200, 120));
//        path.getElements().add(new CubicCurveTo(0, 120, 0, 240, 380, 240));

        MoveTo moveTo = new MoveTo();
        moveTo.setX(248);
        moveTo.setY(220);

        CubicCurveTo cubicTo = new CubicCurveTo();
        cubicTo.setControlX1(224);
        cubicTo.setControlY1(180);
        cubicTo.setControlX2(254);
        cubicTo.setControlY2(132);
        cubicTo.setX(288.0f);
        cubicTo.setY(222.0f);

        path.getElements().add(moveTo);
        path.getElements().add(cubicTo);

        PathTransition pathTransition = new PathTransition();
        pathTransition.setDuration(Duration.millis(2000));
        pathTransition.setPath(path);
        pathTransition.setNode(this.node);
        pathTransition.setOrientation(PathTransition.OrientationType.NONE);
        pathTransition.setCycleCount(Timeline.INDEFINITE);
        pathTransition.setAutoReverse(false);
        pathTransition.play();
    }

    @Override
    public void update() {
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
}
