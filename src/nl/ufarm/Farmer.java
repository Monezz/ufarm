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
public class Farmer extends ImageView {
    
    enum MODE{
        NORMAL,WATERING;
    }
    
    private static final Image IMG_MODE_NORMAL = new Image("nl/ufarm/farmer1.png");
    private static final Image IMG_MODE_WATERING = new Image("nl/ufarm/farmer_watering.png");
    
    private MODE mode = MODE.NORMAL;

    public Farmer() {
        super(IMG_MODE_NORMAL);

        
      final DropShadow dropShadow = new DropShadow();
      final Glow glow = new Glow();
      setEffect(dropShadow);        

        // allow the label to be dragged around.
        final Delta dragDelta = new Delta();
        setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                // record a delta distance for the drag and drop operation.
                dragDelta.x = getLayoutX() - mouseEvent.getSceneX();
                dragDelta.y = getLayoutY() - mouseEvent.getSceneY();
                setCursor(Cursor.MOVE);
            }
        });
        setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                setCursor(Cursor.HAND);
            }
        });
        setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                setLayoutX(mouseEvent.getSceneX() + dragDelta.x);
                setLayoutY(mouseEvent.getSceneY() + dragDelta.y);
            }
        });
        setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                setCursor(Cursor.HAND);
                dropShadow.setInput(glow);
            }
        });
        setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                dropShadow.setInput(null);
            }
        });

    }
    
    void toggleWatering(){
        switch(mode){
            case WATERING:setMode(MODE.NORMAL);break;
            default:setMode(MODE.WATERING);break;
        }
    }

    void setMode(MODE mode) {
        this.mode = mode;
        switch(mode){
            case NORMAL:setImage(IMG_MODE_NORMAL);break;
            case WATERING:setImage(IMG_MODE_WATERING);break;
        }
    }
    
    
    

    // records relative x and y co-ordinates.
    class Delta {

        double x, y;
    }
}
