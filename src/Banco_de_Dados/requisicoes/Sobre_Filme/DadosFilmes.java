package Banco_de_Dados.requisicoes.Sobre_Filme;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DadosFilmes {

    private String banco_de_Dados = "C:\\Users\\matheus.fgs\\Desktop\\The-Horror\\src\\Banco_de_Dados\\Info_Filmes.txt";

    public DadosFilmes() {}

    public String[] obterFilmePorNome(String nomeFilme) {
        try (BufferedReader br = new BufferedReader(new FileReader(banco_de_Dados))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                // Split da linha para separar os dados
                String[] dadosFilme = linha.split(";");

                if (dadosFilme.length > 1) {

                    if (dadosFilme[1].equalsIgnoreCase(nomeFilme)) {
                        return dadosFilme;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}