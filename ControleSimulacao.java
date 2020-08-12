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

        }if(veiculo.getTempoChegadaVeiculo() >= tempo_Global){
                setTempo_Global(veiculo.getTempoChegadaVeiculo());
            }
    }

    public Funcionario disponibilidadeFuncionario(){
        gerenciaFuncionario();
        for(Funcionario f : funcionarios){
            if(!f.getOcupado()){
                return  f;
            }
        }
        return null;
    }
    /**
     * Atualiza o funcionario para ver se esta ocupado*/
    public void gerenciaFuncionario(){
        for(Funcionario f : funcionarios){
            f.setOcupado(!(tempo_Global >= f.getTempoFuncionario()));
        }
    }

    private void verFuncionarios(){
        for(Funcionario f : funcionarios) System.out.print(f.getOcupado() + " ");
        for(Veiculo v : filaEventos) System.out.print(v.getTempoChegadaVeiculo() + " ");
        System.out.println(" ");
    }

    public void geraTempoFuncionario(){
        Funcionario f = disponibilidadeFuncionario();
        if(f != null){
          /*  if(f instanceof FuncNovato){
                FuncNovato fn = (FuncNovato)f;
                f.setTempoFuncionario(random.nextDouble() * fn.geraAleatorioNovato());
            }else if(f instanceof FuncExperiente){
                FuncExperiente fe = (FuncExperiente) f;
                f.setTempoFuncionario(random.nextDouble() * fe.geraAleatorioExperiente());
            }
            */
           f.setTempoFuncionario(10);

            System.out.println("Tempo Func " + f.getTempoFuncionario() );
            filaEventos.get(0).setTempoNoPosto(f.getTempoFuncionario());
            verFuncionarios();
            atualizaTempoGlobal();

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
            System.out.println("Tempo global " + tempo_Global);
            geraTempoFuncionario();
        }else{
            System.out.println("Tempo global " + tempo_Global);
            System.out.println("Fim da Simulacao");
            System.exit(0);
        }
    }




}