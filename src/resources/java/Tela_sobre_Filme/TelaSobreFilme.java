package resources.java.Tela_sobre_Filme;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class TelaSobreFilme extends Application {
    @Override
    public void start(Stage primaryStage){

           BorderPane root = new BorderPane();

           Scene scene = new Scene(root);
           primaryStage.setTitle("Sobre Filme");
           primaryStage.setScene(scene);
           primaryStage.show();
    }
}
