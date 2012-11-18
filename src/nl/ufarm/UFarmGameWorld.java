/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.ufarm;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 *
 * @author Timon Veenstra <monezz@gmail.com>
 */
public class UFarmGameWorld extends GameWorld {

    public static final int NUMBER_OF_PATCHES = 18;

    public UFarmGameWorld() {
        super(1, "UFarm");
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
        final Farmer farmer = new Farmer(farmerX, farmerY);



        final Tractor tractor = new Tractor(getGameSurface().getWidth() + 100, 100);


        getSpriteManager().addSprites(farmer, tractor);

        getSceneNodes().getChildren().add(tractor.node);
        getSceneNodes().getChildren().add(farmer.node);

        setUpPatches();


        final ButtonPane buttonPane = new ButtonPane();
        getSceneNodes().getChildren().add(buttonPane);
        buttonPane.addWateringActionHandler(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                farmer.toggleWatering();
            }
        });
    }

    @Override
    protected boolean handleCollision(Sprite spriteA, Sprite spriteB) {
        boolean collision = spriteA.collide(spriteB);
        if (collision) {
            spriteA.handleCollisionWith(spriteB);
            spriteB.handleCollisionWith(spriteA);
        }

        return collision;
    }

    private void setUpPatches() {
        Patch[] patches = new Patch[NUMBER_OF_PATCHES];

        for (int i = 0; i < NUMBER_OF_PATCHES; i++) {
            int xIndex = (i % 3);
            int yIndex = (i / 3);
            int minX = 20 + (xIndex * 48) + (yIndex * 30);
            int minY = 206 + (yIndex * 30) - (xIndex * 6);

            if (i > 8) {
                minX += 4;
                minY += 9;
            }

            Patch patch = new Patch(minX, minY, 73, 35);
            getSceneNodes().getChildren().add(patch.node);
            patches[i] = patch;

        }
        getSpriteManager().addSprites(patches);
    }
}
