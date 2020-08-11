import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class ControleSimulacao  {

    private static double tempo_Global;
    private final Random random;
    private ArrayList<Veiculo> filaEventos;
    private ArrayList<Funcionario> funcionarios;
    // private ArrayList<Funcionario> funcionarios; /*precisa de alguma lista pra guardar cada atendimento do funcionario*/

    ControleSimulacao(){
        tempo_Global = 0;
        random = new Random();

        // funcionarios = new ArrayList<>();
    }

/*

 0 - Array list ordenado da chegada     OK

* 1 - Pega o primeirop e atualiza o tempo global ACHO QUE OK
*
* 2 - Verifica disponibilidade dos funcionarios ok
* Novato  - experiente
*
* 3 - gera o tempo aleatorio do funcionario
*
* 4 - Adiciono o tempoo no veiculo (PERMANENCIA achooooo)
*
*
*  5- Movo para a saida
* */

    private void setTempo_Global(double valor){
        tempo_Global = valor;
    }

    public void setArrayChegadaVeiculos(ArrayList<Veiculo> array){
        filaEventos = array;
    }

    public void getArrayFuncionarios(ArrayList<Funcionario> func){
        funcionarios = func;
    }


    public void atualizaTempoGlobal(){ /* Se o primeiro for atendido ele tem que sair da fila , senao nao funciona*/
        Veiculo veiculo = filaEventos.get(0);
        if(veiculo.getTempoNoPosto() >= tempo_Global){
            setTempo_Global(veiculo.getTempoNoPosto());
        }
    }

    public Funcionario disponibilidadeFuncionario(){
        for(Funcionario f : funcionarios){
            if(!f.getOcupado()){
                return  f;
            }
        }
        return null;
    }


    public double geraTempoFuncionario(){
        Funcionario f = disponibilidadeFuncionario();
        if(f != null){
            return f.getTempoAtendimento() + random.nextDouble() * 10; // confirmar;
        }else {
            System.out.println("Nao ha funcionarios disponiveis"); // adicionar tratamento de excecao
        }
    }







}
