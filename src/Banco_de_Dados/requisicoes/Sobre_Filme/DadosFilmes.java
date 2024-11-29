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

                // Verifica se a linha contém pelo menos dois elementos
                if (dadosFilme.length > 1) {
                    // Compara o nome do filme
                    if (dadosFilme[1].equalsIgnoreCase(nomeFilme)) {
                        return dadosFilme;
                    }
                } else {
                    // Caso a linha não tenha os dados necessários, imprima um alerta
                    System.out.println("Linha malformada: " + linha);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Retorna null caso o filme não seja encontrado
        return null;
    }
}