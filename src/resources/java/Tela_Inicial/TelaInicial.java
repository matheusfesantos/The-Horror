package resources.java.Tela_Inicial;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import resources.java.Tela_de_Filmes.Filmes;

public class TelaInicial extends Application {

    @Override
    public void start(Stage primaryStage) {
        String String = "THE HORROR";
        primaryStage.setTitle(String);

        BorderPane folclore = new BorderPane();
        folclore.setId("body");

        VBox vbox = new VBox(10);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(20));

        Label tituloLabel = new Label("SEJA BEM VINDO(A)");
        tituloLabel.setId("titulo-label");
        vbox.getChildren().add(tituloLabel);

        Region space1 = new Region();
        space1.setPrefHeight(100);
        vbox.getChildren().add(space1);

        Button iniciar = new Button("INICIAR");
        iniciar.setId("iniciar-button");
        vbox.getChildren().add(iniciar);

        iniciar.setOnAction(e ->{
            Filmes filme = new Filmes();
            filme.start(primaryStage);
        });

        Button sobre = new Button("SOBRE NÓS");
        sobre.setId("sobre-button");
        vbox.getChildren().add(sobre);

        sobre.setOnAction(e -> {});

        folclore.setCenter(vbox);

        HBox footer = new HBox(10);
        footer.setAlignment(Pos.CENTER);
        footer.setPadding(new Insets(10));
        footer.setId("footer");

        Label rodapeLabel = new Label("By Matheus Ferreira");
        rodapeLabel.setId("rodape-label");

        footer.getChildren().addAll(rodapeLabel);
        folclore.setBottom(footer);

        Scene mainScene = new Scene(folclore, 900, 540);
        mainScene.getStylesheets().add(getClass().getResource("/resources/Style/TelaInicial.css").toExternalForm());

        primaryStage.setScene(mainScene);
        primaryStage.show();
    }
}
