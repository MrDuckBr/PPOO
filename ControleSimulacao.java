import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class ControleSimulacao  {

    private static double tempo_Global;
    private final Random random;
    private ArrayList<Veiculo> filaEventos;
    private ArrayList<Funcionario> funcionarios;
    private  SaidaPosto saida;


    ControleSimulacao(){
        tempo_Global = 0;
        random = new Random();
        saida = new SaidaPosto((int)filaEventos.size());
    }



    private void setTempo_Global(double valor){
        tempo_Global = valor;
    }

    public void setArrayChegadaVeiculos(ArrayList<Veiculo> array){
        filaEventos = array;
    }

    public void getArrayFuncionarios(ArrayList<Funcionario> func){
        funcionarios = func;
    }


    public void atualizaTempoGlobal() { /* Se o primeiro for atendido ele tem que sair da fila , senao nao funciona*/
        Veiculo veiculo = filaEventos.get(0);
        if (filaEventos.get(2) != null && disponibilidadeFuncionario() == null) {
            Veiculo veiculo1 = filaEventos.get(1);
            if (veiculo.getTempoNoPosto() + veiculo.getTempoChegadaVeiculo() > veiculo1.getTempoChegadaVeiculo()) {
                //Ficar na espera de liberar um funcionario;
                //calcular tempo de espera na fila
                setTempo_Global(veiculo.getTempoNoPosto() + veiculo.getTempoChegadaVeiculo());
            }

        }if(veiculo.getTempoNoPosto() >= tempo_Global){
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


    public void geraTempoFuncionario(){
        Funcionario f = disponibilidadeFuncionario();
        if(f != null){
            f.setOcupado(true);
            filaEventos.get(0).setTempoNoPosto(f.getTempoAtendimento() + random.nextDouble() * 10); // confirmar;
            atualizaTempoGlobal();

        }else {
            System.out.println("Nao ha funcionarios disponiveis"); // adicionar tratamento de excecao
        }
    }

    public boolean verificaFila(){
        return filaEventos.isEmpty();
    }


    public void iniciaFilaEventos(){
        if(!verificaFila()){
            geraTempoFuncionario();

        }
    }




}