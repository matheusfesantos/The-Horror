package resources.java;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import requisições.DadosFilmes.DadosFilmes;

import java.util.concurrent.atomic.AtomicBoolean;

public class Filmes extends Application {

    public Filmes(){}

    String filme;
    public Filmes(String filme){
        this.filme = filme;
    }

    @Override
    public void start(Stage primaryStage){

        BorderPane Telafilme = new BorderPane();

        boolean enviarfilmes = true;
        if (enviarfilmes){
            DadosFilmes dados = new DadosFilmes(enviarfilmes);
        }
        primaryStage.setTitle("THE HORROR");

        VBox vbox = new VBox();
        vbox.setSpacing(10);
        vbox.setAlignment(Pos.CENTER);

        AtomicBoolean teste = new AtomicBoolean(false);
        Button testar = new Button("Testar Filmes");
        testar.setId("testar");
        testar.setOnAction(e ->{
            System.out.println(filme);
        });

        vbox.getChildren().add(testar);

        Telafilme.setCenter(vbox);

        Scene scene = new Scene(Telafilme, 900, 540);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
