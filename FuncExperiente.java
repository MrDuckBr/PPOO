

/*
* Permissoes diferentes entres os funcionarios
*
* */


public class FuncExperiente extends Funcionario {
    FuncExperiente(String nome, String cpf, int idade, String dataAdmissao){
        super(nome, cpf, idade, dataAdmissao);
         //tempo para realizar uma ação
    }

    @Override
    public double getTempoAtendimento(){
        return 30;
    }
}