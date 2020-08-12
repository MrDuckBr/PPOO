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
    private static ChegadaPosto chegadaPosto;


    ControleSimulacao(){
        chegadaPosto = new ChegadaPosto();
        tempo_Global = 0;
        random = new Random();
        filaEventos = new ArrayList<>();
        funcionarios = new ArrayList<>();
        saida = new SaidaPosto();
        iniciaDadosSimulacao();

    }


    private void iniciaDadosSimulacao(){
        setArrayChegadaVeiculos();
        setArrayFuncionarios();
    }

    private void setTempo_Global(double valor){
        tempo_Global = valor;
    }

    public void setArrayChegadaVeiculos(){
        filaEventos.addAll(chegadaPosto.getListaveiculos());
    }

    public void setArrayFuncionarios(){
       funcionarios.addAll(chegadaPosto.getListaFuncionario());
    }


    public void atualizaTempoGlobal() { /* Se o primeiro for atendido ele tem que sair da fila , senao nao funciona*/
        Veiculo veiculo = filaEventos.get(0);
        if (filaEventos.size() >= 2 && disponibilidadeFuncionario() == null) {
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
    private void verFuncionarios(){
        for(Funcionario f : funcionarios) System.out.print(f.getOcupado() + " ");
        for(Veiculo v : filaEventos) System.out.print(v.getTempoChegadaVeiculo() + " ");
        System.out.println(" ");
    }

    public void geraTempoFuncionario(){
        Funcionario f = disponibilidadeFuncionario();
        if(f != null){
            f.setOcupado(true);
            //filaEventos.get(0).setTempoNoPosto(f.getTempoAtendimento() + random.nextDouble() * 10); // confirmar;
            filaEventos.get(0).setTempoNoPosto(10.0);
            verFuncionarios();
            atualizaTempoGlobal();
            f.setOcupado(false);
            terminaEvento();

        }else {
            System.out.println("Nao ha funcionarios disponiveis"); // adicionar tratamento de excecao
        }
    }

    public void terminaEvento(){
        saida.adicionaTempo(filaEventos.get(0).getTempoChegadaVeiculo() + filaEventos.get(0).getTempoNoPosto());
        filaEventos.remove(0);
        iniciaFilaEventos();
    }


    public boolean verificaFila(){
        return filaEventos.isEmpty();
    }


    public void iniciaFilaEventos(){
        if(!verificaFila()){
            System.out.println(tempo_Global);
            geraTempoFuncionario();
        }else{
            System.out.println("Fim da Simulacao");
        }
    }




}