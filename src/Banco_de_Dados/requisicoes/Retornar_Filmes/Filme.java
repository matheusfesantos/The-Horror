package Banco_de_Dados.requisicoes.Retornar_Filmes;

public class Filme {
    private int id;
    private String nome;
    private int ano;
    private String diretor;
    private String caminhoImagem;

    public Filme(int id, String nome, int ano, String diretor, String caminhoImagem) {
        this.id = id;
        this.nome = nome;
        this.ano = ano;
        this.diretor = diretor;
        this.caminhoImagem = caminhoImagem;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getAno() {
        return ano;
    }

    public String getDiretor() {
        return diretor;
    }

    public String getCaminhoImagem() {
        return caminhoImagem;
    }

    @Override
    public String toString() {
        return "Filme{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", ano=" + ano +
                ", diretor='" + diretor;
}
}