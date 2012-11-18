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
public class Tractor extends Sprite {
    
    private static final Image[] IMG_TRACTOR_BLOODY = new Image[]{new Image("nl/ufarm/LuckyTractorBloody_1.png"),new Image("nl/ufarm/LuckyTractorBloody_2.png"),new Image("nl/ufarm/LuckyTractorBloody_3.png")};
    private static final Image[] IMG_TRACTOR_NORMAL = new Image[]{new Image("nl/ufarm/LuckyTractor_1.png"),new Image("nl/ufarm/LuckyTractor_2.png"),new Image("nl/ufarm/LuckyTractor_3.png")};

    private int current_image = 0;
    private boolean bloody = false;
    
    public Tractor(double x, double y) {
     
        node = new ImageView((IMG_TRACTOR_NORMAL[current_image]));
        ((ImageView) node).setX(x);
        ((ImageView) node).setY(y);        

        Path path = new Path();
        path.getElements().add(new MoveTo(850, 100));
        path.getElements().add(new LineTo(-50, 160));
//                path.getElements().add(new CubicCurveTo(380, 0, 380, 120, 200, 120));
//                path.getElements().add(new CubicCurveTo(0, 120, 0, 240, 380, 240));
        PathTransition pathTransition = new PathTransition();
        pathTransition.setDuration(Duration.millis(20000));
        pathTransition.setPath(path);
        pathTransition.setNode(this.node);
        pathTransition.setOrientation(PathTransition.OrientationType.NONE);
        pathTransition.setCycleCount(Timeline.INDEFINITE);
        pathTransition.setAutoReverse(false);
        pathTransition.play();
    }

    @Override
    public void update() {
        ((ImageView)node).setImage(nextImage());
    }

    private Image nextImage(){
        current_image = (current_image == 2)?0:current_image+1;
        if (bloody){
            return IMG_TRACTOR_BLOODY[current_image];
        }else{
            return IMG_TRACTOR_NORMAL[current_image];
        }
    }
    
    @Override
    double getCollisionSphereSize() {
        return 100.0d;
    }

    @Override
    public void handleCollisionWith(Sprite other) {
        if (other instanceof Farmer){
            ((ImageView)node).setImage(IMG_TRACTOR_BLOODY[0]);
            bloody = true;
            current_image = 0;
        }
    }

}
