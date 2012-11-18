/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.ufarm;

import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.ScaleTransitionBuilder;
import javafx.animation.SequentialTransition;
import javafx.animation.SequentialTransitionBuilder;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

/**
 *
 * @author Maarten
 */
class Patch extends Sprite {

//    private static final Image GRASS_STAGE_1 = new Image("nl/ufarm/grass_stage_01.png");
//    private static final Image GRASS_STAGE_2 = new Image("nl/ufarm/grass_stage_02.png");
//    private static final Image GRASS_STAGE_3 = new Image("nl/ufarm/grass_stage_03.png");
//    private static final Image GRASS_STAGE_4 = new Image("nl/ufarm/grass_stage_04.png");
//    private static final Image GRASS_STAGE_5 = new Image("nl/ufarm/grass_stage_05.png");
//    private static final Image GRASS_STAGE_6 = new Image("nl/ufarm/grass_stage_06.png");
//    private static final Image GRASS_STAGE_7 = new Image("nl/ufarm/grass_stage_07.png");
//    private static final Image GRASS_STAGE_8 = new Image("nl/ufarm/grass_stage_08.png");
//    private static final Image GRASS_STAGE_9 = new Image("nl/ufarm/grass_stage_09.png");
//    private static final Image GRASS_STAGE_10 = new Image("nl/ufarm/grass_stage_10.png");
//    private int currentStage = 1;
//    private int desiredStage = 1;
    public Patch(double minX, double minY, double width, double height) {
//        this.node = new ImageView(GRASS_STAGE_1);
        this.node = new ImageView(new Image("nl/ufarm/tall_grass.png"));
        ((ImageView) node).setX(minX);
        ((ImageView) node).setY(minY);

        ScaleTransition st = ScaleTransitionBuilder.create()
                .toY(2).node(node)
                .duration(Duration.millis(1)).build();
        st.play();

        ((ImageView)node).setFitHeight(1);
        ((ImageView)node).setFitWidth(100);
        node.setVisible(false);
    }

    private void growTallGrass() {

        node.setVisible(true);
        ScaleTransition st = ScaleTransitionBuilder.create()
                .byX(.5).byY(50).node(node)
                .duration(Duration.millis(5000)).build();
        st.play();
//                    ((ImageView)node).setFitHeight(150);
//                    ((ImageView)node).setFitWidth(150);//intrinsic height/width?
//                    ((ImageView)node).resize(150, 150);
    }

    private void grow() {
    }

    @Override
    double getCollisionSphereSize() {
        return 50.0d;
    }

    @Override
    public void update() {
//        if (desiredStage>currentStage){
//            createTransition(null, GRASS_STAGE_1)
//        }
    }

    @Override
    public void handleCollisionWith(Sprite other) {
        if (other instanceof Farmer) {
            Farmer farmer = (Farmer) other;
            if (farmer.isWatering()) {
//                desiredStage++;
                growTallGrass();
            }
        }
    }

    private SequentialTransition createTransition(final ImageView iv, final Image img) {
        FadeTransition fadeOutTransition = new FadeTransition(Duration.seconds(1), iv);
        fadeOutTransition.setFromValue(1.0);
        fadeOutTransition.setToValue(0.0);
        fadeOutTransition.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                iv.setImage(img);;
            }
        });

        FadeTransition fadeInTransition = new FadeTransition(Duration.seconds(1), iv);
        fadeInTransition.setFromValue(0.0);
        fadeInTransition.setToValue(1.0);
        SequentialTransition sequentialTransition = SequentialTransitionBuilder
                .create()
                .children(fadeOutTransition, fadeInTransition)
                .build();

        return sequentialTransition;
    }
}
