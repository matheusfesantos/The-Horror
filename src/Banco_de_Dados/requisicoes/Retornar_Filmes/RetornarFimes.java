package Banco_de_Dados.requisicoes.Retornar_Filmes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RetornarFimes{

    String banco_de_Dados = "C:\\Users\\matheus.fgs\\Desktop\\" +
            "The-Horror\\src\\Banco_de_Dados\\Info_Filmes.txt";

    public List<Filme> carregarFilmes() {
        List<Filme> filmes = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(banco_de_Dados))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] campos = linha.split(";");
                try {
                    int id = Integer.parseInt(campos[0]);
                    String nome = campos[1];
                    int ano = Integer.parseInt(campos[2]);
                    String diretor = campos[3];
                    String caminhoImagem = (campos.length > 4) ? campos[4] : null;

                    Filme filme = new Filme(id, nome, ano, diretor, caminhoImagem);
                    filmes.add(filme);
                } catch (Exception e){}
            }
        } catch (IOException e) {
            System.err.println("Erro ao carregar banco de dados: " + e.getMessage());
        }

        return filmes;
    }

    public static void main(String[] args) {
        RetornarFimes retornarFilmes = new RetornarFimes();
        List<Filme> filmes = retornarFilmes.carregarFilmes();

        for (Filme filme : filmes) {
            System.out.println(filme);
        }
    }
}