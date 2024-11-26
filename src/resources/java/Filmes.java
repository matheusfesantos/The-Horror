package resources.java;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Filmes extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("THE HORROR");

        BorderPane filme = new BorderPane();

        Scene scene = new Scene(filme, 900, 540);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
