/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.ufarm;

import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author Timon Veenstra <monezz@gmail.com>
 */
public class Farmer extends Sprite {

    @Override
    public void update() {
    }

    @Override
    double getCollisionSphereSize() {
        return 50.0d;
    }

    @Override
    public void handleCollisionWith(Sprite other) {
        if (other instanceof Tractor){
            //handle death
        }
    }

    boolean isWatering(){
        return MODE.WATERING.equals(this.mode);
    }
    
    enum MODE {

        NORMAL, WATERING;
    }
    private static final Image IMG_MODE_NORMAL = new Image("nl/ufarm/farmer1.png");
    private static final Image IMG_MODE_WATERING = new Image("nl/ufarm/farmer_watering.png");
    private MODE mode = MODE.NORMAL;

    public Farmer(double x, double y) {
        node = new ImageView(IMG_MODE_NORMAL);
        ((ImageView) node).setX(x);
        ((ImageView) node).setY(y);


        final DropShadow dropShadow = new DropShadow();
        final Glow glow = new Glow();
        node.setEffect(dropShadow);

        // allow the label to be dragged around.
        final Delta dragDelta = new Delta();
        node.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                // record a delta distance for the drag and drop operation.
                dragDelta.x = node.getLayoutX() - mouseEvent.getSceneX();
                dragDelta.y = node.getLayoutY() - mouseEvent.getSceneY();
                node.setCursor(Cursor.MOVE);
            }
        });
        node.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                node.setCursor(Cursor.HAND);
            }
        });
        node.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                node.setLayoutX(mouseEvent.getSceneX() + dragDelta.x);
                node.setLayoutY(mouseEvent.getSceneY() + dragDelta.y);
            }
        });
        node.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                node.setCursor(Cursor.HAND);
                dropShadow.setInput(glow);
            }
        });
        node.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                dropShadow.setInput(null);
            }
        });

    }

    void toggleWatering() {
        switch (mode) {
            case WATERING:
                setMode(MODE.NORMAL);
                break;
            default:
                setMode(MODE.WATERING);
                break;
        }
    }

    void setMode(MODE mode) {
        this.mode = mode;
        switch (mode) {
            case NORMAL:
                ((ImageView) node).setImage(IMG_MODE_NORMAL);
                break;
            case WATERING:
                ((ImageView) node).setImage(IMG_MODE_WATERING);
                break;
        }
    }



    // records relative x and y co-ordinates.
    class Delta {

        double x, y;
    }
}
