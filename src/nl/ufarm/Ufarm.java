/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.ufarm;

import java.awt.Color;
import javafx.application.Application;
import javafx.scene.paint.Paint;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.RectangleBuilder;
import javafx.stage.Stage;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

/**
 *
 * @author Timon Veenstra <monezz@gmail.com>
 */
public class Ufarm extends Application {

    private final GameWorld gameWorld = new UFarmGameWorld();
    
    public static final int NUMBER_OF_PATCHES = 18;

    @Override
    public void start(Stage primaryStage) {
        // setup title, scene, stats, controls, and actors.
        gameWorld.initialize(primaryStage);
        setUpPatches(root);
        farmer.setX(scene.getWidth() / 2);
        farmer.setY(scene.getHeight() / 2);

        tractor.setX(scene.getWidth() + 100);

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

    private Patch[] setUpPatches(Pane root) {
        Patch[] patches = new Patch[NUMBER_OF_PATCHES];
        Paint p = new javafx.scene.paint.Color(0, 0, 0, 1);

        for (int i = 0; i < NUMBER_OF_PATCHES; i++) {
            int xIndex = (i % 3);
            int yIndex = (i / 3);
            int minX = 7 + (xIndex * 48) + (yIndex * 30);
            int minY = 206 + (yIndex * 30) - (xIndex * 6);

            if (i > 8) {
                minX += 4;
                minY += 9;
            }

            Patch patch = new Patch(minX, minY, 73, 35);
            root.getChildren().add(patch);
        }


        //new Patch()

        return patches;
    }
}
