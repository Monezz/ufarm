/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.ufarm;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author Timon Veenstra <monezz@gmail.com>
 */
public class Ufarm extends Application {

    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });

        Pane root = new Pane();
        root.setId("pane");

        String image = this.getClass().getResource("ufarm_800_450.jpg").toExternalForm();
        root.setStyle("-fx-background-image: url('" + image + "'); -fx-background-position: center center;  -fx-background-repeat: stretch;");

        Scene scene = new Scene(root, 800, 450);

        final Farmer farmer = new Farmer();
        farmer.setX(scene.getWidth()/2);
        farmer.setY(scene.getHeight()/2);
        
        final ButtonPane buttonPane = new ButtonPane();
        root.getChildren().add(buttonPane);
        
        final Tractor tractor = new Tractor();
        tractor.setX(scene.getWidth()+100);
        tractor.setY(100);
        
        root.getChildren().add(tractor);
        root.getChildren().add(farmer);
        
        
        buttonPane.addWateringActionHandler(new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent t) {
                farmer.toggleWatering();
            }
            
        });
        

//        scene.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
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
