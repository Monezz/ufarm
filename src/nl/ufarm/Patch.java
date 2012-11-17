/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.ufarm;

import javafx.animation.ScaleTransition;
import javafx.animation.ScaleTransitionBuilder;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

/**
 *
 * @author Maarten
 */
class Patch extends ImageView {
    final Rectangle region;
    
    public Patch(double minX, double minY, double width, double height) {
        super("nl/ufarm/tall_grass.png");
        setX(minX-getLayoutBounds().getWidth()/1.5);
        setY(minY-getLayoutBounds().getHeight()/1.5);
        region = new Rectangle(minX, minY, width, height);
    }

    public void growTallGrass() {
        ScaleTransition st = ScaleTransitionBuilder.create()
                            .byX(2).byY(2).node(this)
                            .duration(Duration.millis(500)).build();
                    st.play();
                    setFitHeight(150);
                    setFitWidth(150);//intrinsic height/width?
                    resize(150, 150);
    }
}
