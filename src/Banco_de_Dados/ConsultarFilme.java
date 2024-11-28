package Banco_de_Dados;

import java.io.*;
import java.util.*;

public class ConsultarFilme {

    String Banco_de_Dados = "File: C:\\Users\\matheus.fgs\\Desktop\\The-Horror\\src\\Banco_de_Dados\\Info_Filmes.txt";

    public static void main(String[] args) {
        ConsultarFilme consulta = new ConsultarFilme();
        consulta.interagirComUsuario();
    }

    public void interagirComUsuario() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo ao sistema de consulta de filmes!");
        System.out.println("Escolha uma opção:");
        System.out.println("1 - Ver todos os filmes");
        System.out.println("2 - Procurar um filme específico");

        int escolha = scanner.nextInt();
        scanner.nextLine();

        switch (escolha) {
            case 1:
                retornarTodosOsFilmes();
                break;
            case 2:
                System.out.println("Pode Informar o ID ou nome do Filme");
                String nomeOuId = scanner.nextLine();
                procurarFilme(nomeOuId);
                break;
            default:
                System.out.println("Opção inválida.");
                break;
        }
    }

    public void retornarTodosOsFilmes() {
        List<Filme> filmes = carregarFilmes();
        if (filmes.isEmpty()) {
            System.out.println("Nenhum filme encontrado.");
            return;
        }
        System.out.println("Lista de todos os filmes:");
        for (Filme filme : filmes) {
            System.out.println(filme);
        }
    }

    public void procurarFilme(String nomeOuId) {
        List<Filme> filmes = carregarFilmes();
        Filme filmeEncontrado = null;

        try {
            int id = Integer.parseInt(nomeOuId);
            filmeEncontrado = filmes.stream().filter(f -> f.getId() == id).findFirst().orElse(null);
        } catch (NumberFormatException e) {
            filmeEncontrado = filmes.stream().filter(f -> f.getNome().equalsIgnoreCase(nomeOuId)).findFirst().orElse(null);
        }

        if (filmeEncontrado != null) {
            System.out.println(filmeEncontrado);
        } else {
            System.out.println("Filme não encontrado.");
        }
    }

    private List<Filme> carregarFilmes() {
        List<Filme> filmes = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(Banco_de_Dados.substring(6)))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                linha = linha.trim();
                if (linha.isEmpty()) {
                    continue;
                }

                String[] partes = linha.split(";");
                if (partes.length < 4) {
                    continue;
                }

                try {
                    int id = Integer.parseInt(partes[0]);
                    String nome = partes[1];
                    int ano = Integer.parseInt(partes[2]);
                    String diretor = partes[3];
                    String imagem = (partes.length > 4) ? partes[4] : null;
                    filmes.add(new Filme(id, nome, ano, diretor, imagem));
                } catch (NumberFormatException e) {
                }
            }
        } catch (IOException e) {
        }
        return filmes;
    }
}

class Filme {
    private int id;
    private String nome;
    private int ano;
    private String diretor;
    private String imagem;

    public Filme(int id, String nome, int ano, String diretor, String imagem) {
        this.id = id;
        this.nome = nome;
        this.ano = ano;
        this.diretor = diretor;
        this.imagem = imagem;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Nome: " + nome + ", Ano: " + ano + ", Diretor: " + diretor +
                (imagem != null ? ", Imagem: " + imagem : "");
    }
}