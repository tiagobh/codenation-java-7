package challenge;


import java.util.*;

public class Motorista {

    private final String nome;

    private final int idade;

    private final int pontos;

    private final String habilitacao;

    private Motorista(String nome, int idade, int pontos, String habilitacao) {
        validarTudo(nome, idade, pontos, habilitacao);
        this.nome = nome;
        this.idade = idade;
        this.pontos = pontos;
        this.habilitacao = habilitacao;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public int getPontos() {
        return pontos;
    }

    public String getHabilitacao() {
        return habilitacao;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Motorista motorista = (Motorista) o;
        return Objects.equals(habilitacao, motorista.habilitacao);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(habilitacao);
    }

    @Override
    public String toString() {
        return "Motorista{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", pontos=" + pontos +
                ", habilitacao='" + habilitacao + '\'' +
                '}';
    }

    public static MotoristaBuilder builder() {
        return new MotoristaBuilder();
    }


    public static class MotoristaBuilder {

        private String nome;

        private int idade;

        private int pontos;

        private String habilitacao;

        private MotoristaBuilder() {
        }

        public MotoristaBuilder withNome(String nome) {
            validarNome(nome);
            this.nome = nome;
            return this;
        }

        public MotoristaBuilder withIdade(int idade) {
            validarIdade(idade);
            this.idade = idade;
            return this;
        }

        public MotoristaBuilder withPontos(int pontos) {
            validarPontos(pontos);
            this.pontos = pontos;
            return this;
        }

        public MotoristaBuilder withHabilitacao(String habilitacao) {
            validarHabilitacao(habilitacao);
            this.habilitacao = habilitacao;
            return this;
        }


        public Motorista build() {
            return new Motorista(nome, idade, pontos, habilitacao);
        }
    }

    private static void validarNome(String nome){
        if(Objects.isNull(nome)) throw new NullPointerException("Nome nulo");
        if(nome.isEmpty()) throw new IllegalArgumentException("Nome vasio");
    }

    private static void validarIdade(int idade){
        if(Objects.isNull(idade)) throw new NullPointerException("Idade nula");
        if(idade <= 0 || idade < 18) throw new IllegalArgumentException("Menor de idade");
    }

    private static void validarPontos(int pontos){
        if(Objects.isNull(pontos)) throw new NullPointerException("Pontos nulo");
        if(pontos < 0 || pontos > 20) throw new IllegalArgumentException("Pontos invalidos");
    }

    private static void validarHabilitacao(String habilitacao){
        if(Objects.isNull(habilitacao)) throw new NullPointerException("Habilitação nula");
        if(habilitacao.isEmpty()) throw new IllegalArgumentException("Menor de idade");
    }

    private static void validarTudo(String nome, int idade, int pontos, String habilitacao){
        validarNome(nome);
        validarIdade(idade);
        validarPontos(pontos);
        validarHabilitacao(habilitacao);
    }
}
