package resources.java.Tela_de_Filmes;

import resources.java.Adicionar_Filme.AdicionarFilme;
import resources.java.Tela_Inicial.TelaInicial;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;

public class Filmes extends Application {

    @Override
    public void start(Stage primaryStage){
        primaryStage.setTitle("THE HORROR");

        BorderPane Telafilme = new BorderPane();
        Telafilme.setId("body");

        VBox vbox = new VBox();
        vbox.setId("vbox");
        vbox.setSpacing(200);

        Button voltar = new Button("VOLTAR");
        voltar.setId("button");
        voltar.setOnAction(e ->{
            TelaInicial telaInicial = new TelaInicial();
            telaInicial.start(primaryStage);
        });
        vbox.getChildren().add(voltar);

        //FILMES FICARÃO AQUI

        Button adicionarFilme = new Button("Adicionar Filme");
        adicionarFilme.setId("button");
        adicionarFilme.setOnAction(e -> {
            AdicionarFilme adicionarFilmeTela = new AdicionarFilme();
            adicionarFilmeTela.start(new Stage());
            primaryStage.close();
        });
        vbox.getChildren().add(adicionarFilme);

        HBox footer = new HBox(10);
        footer.setAlignment(Pos.CENTER);
        footer.setPadding(new Insets(10));
        footer.setId("footer");

        Label rodapeLabel = new Label("By Matheus Ferreira");
        rodapeLabel.setId("rodape-label");
        footer.getChildren().addAll(rodapeLabel);

        Telafilme.setCenter(vbox);
        Telafilme.setBottom(footer);

        Scene scene = new Scene(Telafilme, 900, 540);
        scene.getStylesheets().add(getClass().getResource("/resources/Style/TelaFilme.css").toExternalForm());

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}