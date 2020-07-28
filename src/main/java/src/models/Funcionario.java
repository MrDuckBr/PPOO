package src.models;/*
Verificar se os funcionarios nao tem atributos propriose
*/

public class Funcionario {
    private String nome;
    private String cpf;
    private double tempoAtendimento;
    private int idade;
    private String dataAdmissao;

    public Funcionario(String nome, String cpf, double tempoAtendimento, int idade, String dataAdmissao) {
        this.nome=nome;
        this.cpf=cpf;
        this.tempoAtendimento = tempoAtendimento;
        this.idade = idade;
        this.dataAdmissao = dataAdmissao;
    }

    public String getDataAdmissao() {
        return dataAdmissao;
    }
    public int getIdade() {
        return idade;
    }
    public double getTempoAtendimento() {
        return tempoAtendimento;
    }
    public String getCpf() {
        return cpf;
    }
    public String getNome() {
        return nome;
    }

   
}