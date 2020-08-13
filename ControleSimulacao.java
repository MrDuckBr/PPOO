

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
    private static EstatisticaSimulacao estatisticaSimulacao;
    private static ArrayList<Double> temposFuncionarios;


    ControleSimulacao(){
        chegadaPosto = new ChegadaPosto();
        estatisticaSimulacao = new EstatisticaSimulacao();
        tempo_Global = 0;
        random = new Random();
        filaEventos = new ArrayList<>();
        funcionarios = new ArrayList<>();
        temposFuncionarios = new ArrayList<>();
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
        if(!filaEventos.isEmpty()) {
            Veiculo veiculo = filaEventos.get(0);
            if (tempo_Global == 0) { // primeiro veiculo
                setTempo_Global(veiculo.getTempoChegadaVeiculo());
            } else if (veiculo.getTempoChegadaVeiculo() > tempo_Global && disponibilidadeFuncionario() != null) {
                setTempo_Global(veiculo.getTempoChegadaVeiculo());
            } else if (filaEventos.size() >= 1 && disponibilidadeFuncionario() == null) { // esperar na fila
                Funcionario f = gerenciaFuncionario();
                if (f.getOcupadoAte() > filaEventos.get(0).getTempoChegadaVeiculo()) {
                    setTempo_Global(f.getOcupadoAte());
                    filaEventos.get(0).setTempoNoPosto(f.getOcupadoAte() - filaEventos.get(0).getTempoChegadaVeiculo());
                    f.setOcupado(false);
                }else if(f.getOcupadoAte() < filaEventos.get(0).getTempoChegadaVeiculo()){
                    setTempo_Global(filaEventos.get(0).getTempoChegadaVeiculo());
                    f.setOcupado(false);
                }
            }
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
    /**
     * Atualiza o funcionario para ver se esta ocupado*/
    public Funcionario gerenciaFuncionario() {
        Funcionario menorTempoFunc = funcionarios.get(0);
        for (Funcionario p : funcionarios) {
            if (p.getOcupadoAte() <= menorTempoFunc.getOcupadoAte()) {
                menorTempoFunc = p;
            }
        }
        return menorTempoFunc;
    }

    private void verFuncionarios(){
        for(Funcionario f : funcionarios) System.out.println(f.getOcupado() + " ");
        for(Veiculo v : filaEventos) System.out.print(v.getTempoChegadaVeiculo() + " ");
        System.out.println(" ");
    }

    public void geraTempoFuncionario(){
        Funcionario f = disponibilidadeFuncionario();
        atualizaTempoGlobal();
        if(f != null){
            if(f instanceof FuncNovato){
                FuncNovato fn = (FuncNovato)f;
                f.setTempoFuncionario(random.nextDouble() * fn.geraAleatorioNovato());
            }else if(f instanceof FuncExperiente){
                FuncExperiente fe = (FuncExperiente) f;
                f.setTempoFuncionario(random.nextDouble() * fe.geraAleatorioExperiente());
            }

            f.setOcupadoAte( filaEventos.get(0).getTempoChegadaVeiculo()+(f.getTempoFuncionario()));//ate quando o func estara ocupado
            temposFuncionarios.add(f.getOcupadoAte());
            filaEventos.get(0).setTempoNoPosto(f.getTempoFuncionario());
            f.setOcupado(true);
            System.out.println("Tempo Func " + f.getTempoFuncionario() + " Indice do Func" + f.getIdFunc() );
           // verFuncionarios();

            terminaEvento(f);

        }else {
            System.out.println("Nao ha funcionarios disponiveis"); // adicionar tratamento de excecao

            }
             // vai comecar com o tempo de espera na fila7
        if(!filaEventos.isEmpty()) geraTempoFuncionario();
            //atualizaTempoGlobal();
            //iniciaFilaEventos();

        }


    public void terminaEvento(Funcionario f){
        saida.adicionaTempo( filaEventos.get(0).getTempoNoPosto());
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
            estatisticaSimulacao.criarGraficoCliente(saida.teste());
            estatisticaSimulacao.calculaMediaFuncionario(temposFuncionarios);
            estatisticaSimulacao.calculaMediaClientes(saida.teste());
            estatisticaSimulacao.mediasPosto();
           // System.exit(0);
        }
    }





}