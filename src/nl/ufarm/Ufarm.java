/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.ufarm;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author Timon Veenstra <monezz@gmail.com>
 */
public class Ufarm extends Application {

    private final GameWorld gameWorld = new UFarmGameWorld();
    
    @Override
    public void start(Stage primaryStage) {
        // setup title, scene, stats, controls, and actors.
        gameWorld.initialize(primaryStage);

        // kick off the game loop
        gameWorld.beginGameLoop();

        // display window
        primaryStage.show();
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
