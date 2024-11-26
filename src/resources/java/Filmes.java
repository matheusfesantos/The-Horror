package resources.java;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;

import java.util.concurrent.atomic.AtomicBoolean;

public class Filmes extends Application {

    String filme;
    public Filmes(String filme){
        this.filme = filme;
    }

    @Override
    public void start(Stage primaryStage){

        BorderPane Telafilme = new BorderPane();

        primaryStage.setTitle("THE HORROR");

        VBox vbox = new VBox();
        vbox.setSpacing(10);
        vbox.setAlignment(Pos.CENTER);

        AtomicBoolean teste = new AtomicBoolean(false);
        Button testar = new Button("Testar Filmes");
        testar.setId("testar");
        testar.setOnAction(e ->{
        });

        Label nomefilmes = new Label(filme);
        nomefilmes.setId("nomefilmes");


        vbox.getChildren().add(testar);
        vbox.getChildren().add(nomefilmes);

        Telafilme.setCenter(vbox);

        Scene scene = new Scene(Telafilme, 900, 540);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
