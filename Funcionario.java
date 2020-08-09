/*
Verificar se os funcionarios nao tem atributos propriose
*/

public class Funcionario {
    private String nome;
    private String cpf;
    private int idade;
    private String dataAdmissao;
    /*Atributos simulacao*/
    private boolean ocupado;
    private double tempoFuncionario;


    public Funcionario(String nome, String cpf, int idade, String dataAdmissao) {
        this.nome=nome;
        this.cpf=cpf;
        this.idade = idade;
        this.dataAdmissao = dataAdmissao;
        ocupado = false;
        tempoFuncionario = 0;

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

    public boolean getOcupado(){
        return  ocupado;
    }

    public void setOcupado(boolean ocupado){
        this.ocupado = ocupado;
    }

    public int getTempoAtendimento(){
        return  0;
    }
}