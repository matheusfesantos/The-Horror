package requisições.DadosFilmes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class DadosFilmes {
    public static void main(String[] args) {
        String caminhoDoArquivo = "C:\\Users\\matheus.fgs\\Desktop\\The-Horror\\src" +
                "\\Banco_de_Dados\\Info_Filmes.txt";

        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o nome do filme que deseja buscar: ");
        String nomeDoFilme = scanner.nextLine();
        scanner.close();

        boolean filmeEncontrado = false;

        try (BufferedReader br = new BufferedReader(new FileReader(caminhoDoArquivo))) {
            String linha;
            System.out.println("\nBuscando por: " + nomeDoFilme + "...\n");

            while ((linha = br.readLine()) != null) {
                if (linha.toLowerCase().contains(nomeDoFilme.toLowerCase())) {
                    System.out.println("Filme encontrado:");
                    System.out.println(linha);
                    filmeEncontrado = true;

                    for (int i = 0; i < 3; i++) {
                        linha = br.readLine();
                        if (linha != null) {
                            System.out.println(linha);
                        }
                    }
                    break;                }
            }
            if (!filmeEncontrado) {
                System.out.println("O filme" + nomeDoFilme + " não foi encontrado no arquivo");
            }
        }catch (IOException e) {
            System.out.println("Erro ao acessar o arquivo: " + e.getMessage());
        }
    }
}