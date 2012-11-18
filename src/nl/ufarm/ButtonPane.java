/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.ufarm;

import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.geometry.Pos;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;

/**
 *
 * @author Timon Veenstra <monezz@gmail.com>
 */
public class ButtonPane extends StackPane {
    
    private final WateringCan wateringCan = new WateringCan();
    
    public ButtonPane() {
        setAlignment(Pos.TOP_LEFT);
        setStyle("-fx-background-color: white;");
        setOpacity(.5);
        setPrefSize(60, 200);

        
        getChildren().add(wateringCan);
    }
    
    public void addWateringActionHandler(EventHandler<MouseEvent> handler){
        wateringCan.addEventHandler(MouseEvent.MOUSE_CLICKED, handler);
    }
   
}
