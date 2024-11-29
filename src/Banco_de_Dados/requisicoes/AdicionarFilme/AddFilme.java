package Banco_de_Dados.requisicoes.AdicionarFilme;

import javafx.scene.control.TextField;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class AddFilme {

    private static final String CAMINHO_ARQUIVO = "C:\\Users\\matheus.fgs\\Desktop" +
            "\\The-Horror\\src\\Banco_de_Dados\\Info_Filmes.txt";

    public AddFilme(TextField respostaanofilme, TextField respostadiretor, TextField respostatitulofilme) {
        String titulo = respostatitulofilme.getText().trim();
        String diretor = respostadiretor.getText().trim();
        String ano = respostaanofilme.getText().trim();

        if (titulo.isEmpty() || diretor.isEmpty() || ano.isEmpty()) {
            System.out.println("Erro: Todos os campos devem ser preenchidos.");
            return;
        }

        int idFilme = calcularNovoId();
        boolean sucesso = adicionarFilme(idFilme, titulo, ano, diretor);
        if (sucesso){
            System.out.println("Filme adicionado com sucesso: " + titulo);
        } else {
            System.out.println("Erro ao adicionar o filme: " + titulo);
        }
    }

    private Set<String> lerFilmesExistentes() throws IOException {
        Set<String> filmesExistentes = new HashSet<>();
        File arquivo = new File(CAMINHO_ARQUIVO);
        if (!arquivo.exists()) {
            return filmesExistentes;
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                if (!linha.trim().isEmpty()) {
                    filmesExistentes.add(linha.trim());
                }
            }
        }
        return filmesExistentes;
    }

    private int calcularNovoId() {
        int maxId = 0;
        File arquivo = new File(CAMINHO_ARQUIVO);
        if (!arquivo.exists()) {
            return 1;
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                if (!linha.trim().isEmpty()) {
                    String[] partes = linha.split(";");
                    if (partes.length > 0) {
                        try {
                            int id = Integer.parseInt(partes[0]);
                            maxId = Math.max(maxId, id);
                        } catch (NumberFormatException e){
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao calcular o ID: " + e.getMessage());
        }
        return maxId + 1;
    }

    public boolean adicionarFilme(int id, String titulo, String ano, String diretor) {
        String filme = id + ";" + titulo + ";" + ano + ";" + diretor; // Ordem correta

        try {
            Set<String> filmesExistentes = lerFilmesExistentes();

            if (!filmesExistentes.contains(filme)) {
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(CAMINHO_ARQUIVO, true))) {
                    writer.newLine();
                    writer.newLine();
                    writer.write(filme);
                }
                return true;
            } else {
                System.out.println(titulo + "já existente");
                return false;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}