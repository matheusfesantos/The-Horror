package resources.java.Tela_sobre_Filme;

import Banco_de_Dados.requisicoes.Sobre_Filme.DadosFilmes;
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
import javafx.scene.text.Text;
import javafx.stage.Stage;
import resources.java.Tela_Inicial.TelaInicial;
import resources.java.Tela_de_Filmes.Filmes;

import java.io.File;

public class TelaSobreFilme extends Application {

    private String nome;

    private static final String CAMINHO_IMAGEM_ERRO = "C:\\Users\\matheus.fgs\\Desktop\\The-Horror\\Images\\Error\\error-image-generic.png";

    public TelaSobreFilme(String nome) {
        this.nome = nome;
    }

    @Override
    public void start(Stage primaryStage) {

        BorderPane sobreFilme = new BorderPane();
        sobreFilme.setId("body");

        VBox vbox = new VBox();
        vbox.setId("vbox");
        vbox.setMaxWidth(700);
        vbox.setMaxHeight(450);
        vbox.setPrefHeight(700);
        vbox.setPrefWidth(450);
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(10);

        Button voltar = new Button("VOLTAR");
        voltar.setId("button");
        voltar.setOnAction(e -> {
            primaryStage.close();
        });
        vbox.getChildren().add(voltar);

        DadosFilmes dadosFilmes = new DadosFilmes();
        String[] dadosFilme = dadosFilmes.obterFilmePorNome(nome);

        if (dadosFilme != null){
            String caminhoImagem = dadosFilme.length > 4 ? dadosFilme[4] : CAMINHO_IMAGEM_ERRO;

            File arquivoImagem = new File(caminhoImagem);
            if (!arquivoImagem.exists()) {
                caminhoImagem = CAMINHO_IMAGEM_ERRO;
            }

            Image imagemFilme = new Image("file:" + caminhoImagem);
            ImageView imagemView = new ImageView(imagemFilme);
            imagemView.setFitWidth(200);
            imagemView.setFitHeight(250);
            vbox.getChildren().add(imagemView);

            String nomeFilme = dadosFilme[1];
            String anoFilme = dadosFilme[2];
            String diretorFilme = dadosFilme[3];

            Text tituloFilme = new Text("Filme: " + nomeFilme);
            tituloFilme.setId("filme");
            Text ano = new Text("Ano: " + anoFilme);
            ano.setId("filme");
            Text diretor = new Text("Diretor: " + diretorFilme);
            diretor.setId("filme");

            vbox.getChildren().addAll(tituloFilme, ano, diretor);
        } else {
            Text erro = new Text("Filme não encontrado!");
            vbox.getChildren().add(erro);
        }

        sobreFilme.setCenter(vbox);

        HBox footer = new HBox(10);
        footer.setAlignment(Pos.CENTER);
        footer.setPadding(new Insets(10));
        footer.setId("footer");

        Label rodapeLabel = new Label("By Matheus Ferreira");
        rodapeLabel.setId("rodape-label");
        footer.getChildren().add(rodapeLabel);

        sobreFilme.setBottom(footer);

        Scene scene = new Scene(sobreFilme, 900, 540);
        scene.getStylesheets().add(getClass().getResource("/resources/Style/SobreFile.css").toExternalForm());
        primaryStage.setTitle("THE HORROR");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}