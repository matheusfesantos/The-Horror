package Banco_de_Dados.requisicoes.AdicionarFilme;

import javafx.scene.control.TextField;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class AddFilme{

     String CAMINHO_ARQUIVO = "C:\\Users\\matheus.fgs\\Desktop" +
            "\\The-Horror\\src\\Banco_de_Dados\\Info_Filmes.txt";

    public AddFilme(TextField respostaanofilme, TextField respostadiretor,
                    TextField respostatitulofilme){

        String titulo = respostatitulofilme.getText();
        String diretor = respostadiretor.getText();
        String ano = respostaanofilme.getText();

        boolean sucesso = adicionarFilme(titulo, ano, diretor);
        if (sucesso) {
            System.out.println("Filme adicionado com sucesso.");
        } else {
            System.out.println("Erro ao adicionar o filme.");
        }
    }

    private Set<String> lerFilmesExistentes() throws IOException {
        Set<String> filmesExistentes = new HashSet<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(CAMINHO_ARQUIVO))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                filmesExistentes.add(linha);
            }
        }
        return filmesExistentes;
    }

    public boolean adicionarFilme(String titulo, String ano, String diretor) {
        String filme = titulo + ";" + ano + ";" + diretor;

        try {
            Set<String> filmesExistentes = lerFilmesExistentes();

            if (!filmesExistentes.contains(filme)) {
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(CAMINHO_ARQUIVO, true))) {
                    writer.write(filme);
                    writer.newLine();
                    writer.newLine();
                }
                return true;
            } else {
                System.out.println("Filme já existente: " + filme);
                return false;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}