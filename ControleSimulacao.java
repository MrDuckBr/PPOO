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
                setTempo_Global( tempo_Global + veiculo1.getTempoChegadaVeiculo());
            }

        }if(veiculo.getTempoChegadaVeiculo() <= tempo_Global){
                setTempo_Global(tempo_Global + veiculo.getTempoNoPosto());
        }if(veiculo.getTempoChegadaVeiculo() > tempo_Global){
            setTempo_Global(tempo_Global + veiculo.getTempoChegadaVeiculo());
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
        for(Funcionario f : funcionarios) System.out.println(f.getOcupado() + " ");
        for(Veiculo v : filaEventos) System.out.print(v.getTempoChegadaVeiculo() + " ");
        System.out.println(" ");
    }

    public void geraTempoFuncionario(){
        Funcionario f = disponibilidadeFuncionario();
        if(f != null){
            if(f instanceof FuncNovato){
                FuncNovato fn = (FuncNovato)f;
                f.setTempoFuncionario(random.nextDouble() * fn.geraAleatorioNovato());
            }else if(f instanceof FuncExperiente){
                FuncExperiente fe = (FuncExperiente) f;
                f.setTempoFuncionario(random.nextDouble() * fe.geraAleatorioExperiente());
            }
            System.out.println("Tempo Func " + f.getTempoFuncionario() + " Indice do Func" + f.getIdFunc() );
            f.setOcupadoAte( filaEventos.get(0).getTempoChegadaVeiculo()+(f.getTempoFuncionario()));//ate quando o func estara ocupado
            filaEventos.get(0).setTempoNoPosto(f.getTempoFuncionario());
            f.setOcupado(true);
            verFuncionarios();
            atualizaTempoGlobal();

            terminaEvento();

        }else {
            System.out.println("Nao ha funcionarios disponiveis"); // adicionar tratamento de excecao
            Funcionario menorTempoFunc = funcionarios.get(0);
            for(Funcionario p : funcionarios){
                if(p.getOcupadoAte() <= menorTempoFunc.getOcupadoAte()){
                    menorTempoFunc = p;
                }
            }
            filaEventos.get(0).setTempoNoPosto(menorTempoFunc.getOcupadoAte() - filaEventos.get(0).getTempoChegadaVeiculo()); // vai comecar com o tempo de espera na fila7
            menorTempoFunc.setOcupado(false);
            atualizaTempoGlobal();
            iniciaFilaEventos();

        }
    }

    public void terminaEvento(){
        saida.adicionaTempo(filaEventos.get(0).getTempoChegadaVeiculo() + filaEventos.get(0).getTempoNoPosto());
        filaEventos.remove(0);
        System.out.println("Tempo global " + tempo_Global);
        iniciaFilaEventos();
    }




    public boolean verificaFila(){
        return filaEventos.isEmpty();
    }


    public void iniciaFilaEventos(){
        if(!verificaFila()){
            geraTempoFuncionario();

        }else{
            //System.out.println("Tempo global " + tempo_Global);
            System.out.println("Fim da Simulacao");
            System.exit(0);
        }
    }




}