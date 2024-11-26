package requisições.DadosFilmes;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class DadosFilmes {
    public static void main(String[] args) {
        String caminhoDoArquivo = "C:\\Users\\matheus.fgs\\Desktop\\The-Horror\\src" +
                "\\Banco_de_Dados\\Info_Filmes.txt";

        boolean filmeEncontrado = false;

        try (BufferedReader br = new BufferedReader(new FileReader(caminhoDoArquivo))) {
            String linha;
            String diretor = "";
            String filme = "";
            String descricao = "";
            String ano_filme = "";
            String caminho_imagem = "";

            while ((linha = br.readLine()) != null){

                if (linha.startsWith("- Diretor:")) {
                    diretor = linha.substring(9).trim();

                } else if (linha.startsWith("- Filme:")) {
                    filme = linha.substring(7).trim();

                } else if (linha.startsWith("- Descrição:")) {
                    descricao = linha.substring(11).trim();

                }else if (linha.startsWith("- Imagem:")){
                    caminho_imagem = linha.substring(11).trim();

                }else if (linha.startsWith("- Ano:")){
                    caminho_imagem = linha.substring(4).trim();{

                    System.out.println("Diretor: " + diretor);
                    System.out.println("Filme: " + filme);
                    System.out.println("Descrição: " + descricao);
                    System.out.println("Imagem : " + caminho_imagem);
                    System.out.println("Ano : " + ano_filme);
                    System.out.println("-------------");
                }
            }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}