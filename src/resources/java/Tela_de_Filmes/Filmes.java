package resources.java.Tela_de_Filmes;

import Banco_de_Dados.requisicoes.Retornar_Filmes.Filme;
import Banco_de_Dados.requisicoes.Retornar_Filmes.RetornarFimes;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import resources.java.Adicionar_Filme.AdicionarFilme;
import resources.java.Tela_Inicial.TelaInicial;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

public class Filmes extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("THE HORROR");

        BorderPane telaFilme = new BorderPane();
        telaFilme.setId("body");

        RetornarFimes retornarFimes = new RetornarFimes();
        List<Filme> filmes = retornarFimes.carregarFilmes();

        VBox vbox = new VBox();
        vbox.setId("vbox");
        vbox.setSpacing(30);
        vbox.setPrefWidth(800);
        vbox.setPrefHeight(450);

        Button voltar = new Button("VOLTAR");
        voltar.setId("button");
        voltar.setOnAction(e -> {
            TelaInicial telaInicial = new TelaInicial();
            telaInicial.start(primaryStage);
        });
        vbox.getChildren().add(voltar);

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(25));
        grid.setHgap(20);
        grid.setVgap(20);

        int row = 0;
        int col = 0;

        for (Filme filme : filmes) {
            VBox filmeBox = criarBoxFilme(filme);
            grid.add(filmeBox, col, row);

            col++;
            if (col > 2) {
                col = 0;
                row++;
            }
        }

        ScrollPane scrollPane = new ScrollPane(grid);
        scrollPane.setFitToWidth(true);
        scrollPane.setId("scroll-pane");
        scrollPane.setPadding(new Insets(10));
        vbox.getChildren().add(scrollPane);

        Button adicionarFilme = new Button("Adicionar Filme");
        adicionarFilme.setId("button");
        adicionarFilme.setOnAction(e -> {
            AdicionarFilme adicionarFilmeTela = new AdicionarFilme();
            adicionarFilmeTela.start(primaryStage);
        });
        vbox.getChildren().add(adicionarFilme);

        HBox footer = new HBox(10);
        footer.setAlignment(Pos.CENTER);
        footer.setPadding(new Insets(10));
        footer.setId("footer");

        Label rodapeLabel = new Label("By Matheus Ferreira");
        rodapeLabel.setId("rodape-label");
        footer.getChildren().add(rodapeLabel);

        telaFilme.setCenter(vbox);
        telaFilme.setBottom(footer);

        Scene scene = new Scene(telaFilme, 900, 540);
        scene.getStylesheets().add(getClass().getResource("/resources/Style/TelaFilme.css").toExternalForm());

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private VBox criarBoxFilme(Filme filme) {
        VBox vbox = new VBox(10);
        vbox.setAlignment(Pos.CENTER);

        Label diretor = new Label("Diretor: " + filme.getDiretor());
        Label ano = new Label("Ano: " + filme.getAno());

        Button filmes = new Button(filme.getNome());
        filmes.setOnAction(e -> {
            System.out.println(filme.getNome());
        });

        vbox.getChildren().addAll(filmes, diretor, ano);
        vbox.setStyle("-fx-border-color: black; -fx-padding: 10; -fx-alignment: center;");
        return vbox;
    }
}