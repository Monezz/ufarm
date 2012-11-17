/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.ufarm;

import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBuilder;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBoxBuilder;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.VBoxBuilder;
import javafx.stage.Stage;

/**
 *
 * @author Timon Veenstra <monezz@gmail.com>
 */
public class UFarmGameWorld extends GameWorld {

    public UFarmGameWorld() {
        super(25, "UFarm");
    }

    @Override
    public void initialize(Stage primaryStage) {
        // Sets the window title
        primaryStage.setTitle(getWindowTitle());

        // Create the scene
        setSceneNodes(new Group());

        Scene surfaceScene = new Scene(getSceneNodes(), 800, 450);
        setGameSurface(surfaceScene);

        primaryStage.setScene(getGameSurface());

        getSceneNodes().getChildren().add(new ImageView("nl/ufarm/ufarm_800_450.jpg"));


        double farmerX = getGameSurface().getWidth() / 2;
        double farmerY = getGameSurface().getHeight() / 2;
        final Farmer farmer = new Farmer(farmerX,farmerY);

        final ButtonPane buttonPane = new ButtonPane();
        getSceneNodes().getChildren().add(buttonPane);

        final Tractor tractor = new Tractor(getGameSurface().getWidth() + 100,100);


        getSpriteManager().addSprites(farmer,tractor);
        
        getSceneNodes().getChildren().add(tractor.node);
        getSceneNodes().getChildren().add(farmer.node);


        buttonPane.addWateringActionHandler(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                farmer.toggleWatering();
            }
        });

    }
}
