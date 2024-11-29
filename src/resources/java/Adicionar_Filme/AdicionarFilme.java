package resources.java.Adicionar_Filme;

import Banco_de_Dados.requisicoes.AdicionarFilme.AddFilme;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import resources.java.Tela_de_Filmes.Filmes;

import java.util.Optional;

public class AdicionarFilme extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("THE HORROR");

        BorderPane AdicionarFilme = new BorderPane();
        AdicionarFilme.setId("body");

        VBox vbox = new VBox();
        vbox.setId("vbox");
        vbox.setSpacing(10);
        vbox.setPrefWidth(200);  // Largura preferencial
        vbox.setPrefHeight(500); // Altura preferencial
        vbox.setMaxWidth(500);   // Largura máxima
        vbox.setMaxHeight(400);  // Altura máxima
        vbox.setPadding(new Insets(30));

        Button voltar = new Button("VOLTAR");
        voltar.setId("button");
        voltar.setOnAction(e ->{
            Filmes filme = new Filmes();
            filme.start(primaryStage);
        });
        vbox.getChildren().add(voltar);

        Label titulofilme = new Label("Nome do Filme");
        titulofilme.setId("info-filme");
        TextField respostatitulofilme = new TextField("Informe o Nome do Filme");
        respostatitulofilme.setId("resp-filme");
        vbox.getChildren().add(titulofilme);
        vbox.getChildren().add(respostatitulofilme);

        Label diretorfilme = new Label("Diretor do Filme");
        diretorfilme.setId("info-filme");
        TextField respostadiretor = new TextField("Informe o Diretor do Filme'");
        respostadiretor.setId("resp-filme");
        vbox.getChildren().add(diretorfilme);
        vbox.getChildren().add(respostadiretor);

        Label anofilme = new Label("Ano do Filme");
        anofilme.setId("info-filme");
        TextField respostaanofilme = new TextField("Informe o Ano do Filme");
        respostaanofilme.setId("resp-filme");
        vbox.getChildren().add(anofilme);
        vbox.getChildren().add(respostaanofilme);

        Button adicionarFilme = new Button("Upload Image");
        adicionarFilme.setId("upload-filme");
        vbox.getChildren().add(adicionarFilme);

        Button enviarDados = new Button("Enviar Dados");
        enviarDados.setId("upload-filme");
        enviarDados.setOnAction(e->{
            AddFilme addFilme = new AddFilme(respostatitulofilme,
                    respostadiretor, respostaanofilme);
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("THE HORROR");
            alert.setHeaderText(null);
            alert.setContentText("FILME ADICIONADO COM SUCESSO!");
            Optional<ButtonType> result = alert.showAndWait();
        });
        vbox.getChildren().add(enviarDados);

        HBox footer = new HBox(10);
        footer.setAlignment(Pos.CENTER);
        footer.setPadding(new Insets(10));
        footer.setId("footer");

        Label rodapeLabel = new Label("By Matheus Ferreira");
        rodapeLabel.setId("rodape-label");
        footer.getChildren().addAll(rodapeLabel);

        AdicionarFilme.setCenter(vbox);
        AdicionarFilme.setBottom(footer);

        Scene scene = new Scene(AdicionarFilme, 900,540);
        scene.getStylesheets().add(getClass().getResource("/resources/Style/TelaAddFilme.css").toExternalForm());

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
