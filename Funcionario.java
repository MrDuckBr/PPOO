/*
Verificar se os funcionarios nao tem atributos propriose
*/

public class Funcionario {
    private String nome;
    private String cpf;
    private int idade;
    private String dataAdmissao;

    public Funcionario(String nome, String cpf, int idade, String dataAdmissao) {
        this.nome=nome;
        this.cpf=cpf;
        this.idade = idade;
        this.dataAdmissao = dataAdmissao;
    }

    public String getDataAdmissao() {
        return dataAdmissao;
    }
    public int getIdade() {
        return idade;
    }
    public String getCpf() {
        return cpf;
    }
    public String getNome() {
        return nome;
    }

   
}