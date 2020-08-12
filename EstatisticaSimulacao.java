import java.util.ArrayList;
import java.util.Queue;

public class EstatisticaSimulacao {
//Classe que fara as estatisticas da simulacao para a averiguacao
   //cliente por tempo


    /*
    * intervalo de confianca
    *
    * tempo medio de atendimento para cada cliente
    *
    * tempo medio de atendimento para cada funcionario
    *
    * tempo medio para cada funcao especifica
    *
    *
    *
    * */

    private double tempoMedioCliente;
    private double tempoMedioFunc;

    public void calculaMediaClientes(Queue<Veiculo> lista){
        for (Veiculo f:lista) {
            tempoMedioCliente += f.getTempoNoPosto();
        }
        tempoMedioCliente = tempoMedioCliente / lista.size();

    }

    public void calculaTempoFunc(ArrayList<Funcionario> func){
        for (Funcionario f:func){
            tempoMedioFunc += f.getTempoFuncionario();
        }
    }

    /*Adicionar para cada funcionario ????*/




}