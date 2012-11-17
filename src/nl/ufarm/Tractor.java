/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.ufarm;

import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;

/**
 *
 * @author Timon Veenstra <monezz@gmail.com>
 */
public class Tractor extends ImageView {

    public Tractor() {
        super(new Image("nl/ufarm/LuckyTractor.png"));


        Path path = new Path();
        path.getElements().add(new MoveTo(850, 100));
        path.getElements().add(new LineTo(-50, 160));
//                path.getElements().add(new CubicCurveTo(380, 0, 380, 120, 200, 120));
//                path.getElements().add(new CubicCurveTo(0, 120, 0, 240, 380, 240));
        PathTransition pathTransition = new PathTransition();
        pathTransition.setDuration(Duration.millis(20000));
        pathTransition.setPath(path);
        pathTransition.setNode(this);
        pathTransition.setOrientation(PathTransition.OrientationType.NONE);
        pathTransition.setCycleCount(Timeline.INDEFINITE);
        pathTransition.setAutoReverse(false);
        pathTransition.play();
    }
}
