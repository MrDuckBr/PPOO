public class FuncDiesel extends Funcionario {


    FuncDiesel(String nome, String cpf, int idade, String dataAdmissao){
        super(nome, cpf, idade, dataAdmissao);
         //tempo para realizar uma ação
        // definir tempo geral ou de cada ação? ex: tempoAbastecer = 50, tempoTrocarOleo = 20.. etc
    }


    @Override
    public double getTempoAtendimento(){
        return super().toString +  90;
    }

}