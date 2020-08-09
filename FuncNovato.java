public class FuncNovato extends Funcionario {


    FuncNovato(String nome, String cpf, int idade, String dataAdmissao){
        super(nome, cpf, idade, dataAdmissao);
         //tempo para realizar uma ação
        // definir tempo geral ou de cada ação? ex: tempoAbastecer = 50, tempoTrocarOleo = 20.. etc
    }


    @Override
    public int getTempoAtendimento(){
        return 90;
    }

}