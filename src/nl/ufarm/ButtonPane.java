/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.ufarm;

import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;

/**
 *
 * @author Timon Veenstra <monezz@gmail.com>
 */
public class ButtonPane extends StackPane {

    public ButtonPane() {
        setAlignment(Pos.TOP_LEFT);
        setStyle("-fx-background-color: white;");
        setOpacity(.5);
        setPrefSize(60, 200);

        WateringCan wateringCan = new WateringCan();
        getChildren().add(wateringCan);
    }
}
