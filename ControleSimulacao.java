/**Classe controle simulacao que controla toda a simulacao do programa
 *
 */

import java.util.ArrayList;
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

/**Construtor da classe Controle simulacao, inicializa as variaves das classes a qual ela tera acesso
 *
 */
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

    /**Metodo que inicializa os arrayList lidos a partir do arquivo ,
     * usada para ter um controle do que esta sendo realizado
     *
     */
    private void iniciaDadosSimulacao(){
        setArrayChegadaVeiculos();
        setArrayFuncionarios();
    }

    /**
     * Metodo que altera o valor global , este que no para se ter o controle do tempo de evento discreto ,
     * chamado de tempo_Global atualizado sempre que ocorrer algum evento na Simulacao
     * @param valor valor recebido atualiza o tempo global da aplicacao
     */
    private void setTempo_Global(double valor){
        tempo_Global = valor;
    }

    /**Método que recebe da classe ChegadaPosto os valores dos Veiculos do arquivo
     *
     */
    public void setArrayChegadaVeiculos(){
        filaEventos.addAll(chegadaPosto.getListaveiculos());
    }

    /**Método que recebe da classe ChegadaPosto os funcionarios lidos a partir do arquivo
     *
     */
    public void setArrayFuncionarios(){
       funcionarios.addAll(chegadaPosto.getListaFuncionario());
    }

    /**Método que controla a lógica do programa em que verifica se o proximo objeto da lista a ser
     * atendido é atendido logo em seguida ou se está a espera de um funcionario que o atenda
     * Os casos de tratados são se há funcionarios para atender , se não ha funcionarios
     * se o veiculo chegou ao Posto quando todos os funcionarios estavam atendendo ou se chegou quando
     * havia funcionarios livres
     * Esse método também atualiza o tempo global para quando acontece um novo evento
     *
     */
    public void atualizaTempoGlobal() {
        if(!filaEventos.isEmpty()) {
            Veiculo veiculo = filaEventos.get(0);
            if (tempo_Global == 0) {
                setTempo_Global(veiculo.getTempoChegadaVeiculo());
            } else if (veiculo.getTempoChegadaVeiculo() > tempo_Global && disponibilidadeFuncionario() != null) {
                setTempo_Global(veiculo.getTempoChegadaVeiculo());
            } else if (filaEventos.size() >= 1 && disponibilidadeFuncionario() == null) {
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

    /**Método que verifica se há funcionarios disponiveis para atender novos Veiculos
     *
     * @return Retorna o funcionario livre para atendimento , ou , null se não houver funcionarios livres
     */
    public Funcionario disponibilidadeFuncionario(){
        for(Funcionario f : funcionarios){
            if(!f.getOcupado()){
                return  f;
            }
        }
        return null;
    }

    /**Método que verifica o funcionario que terminara a tarefa mais rapidamente para atender o proximo da fila
     *
     * @return menorTempoFunc retorna o funcionario com o tempo de atendimento mais proximo do fim
     */
    public Funcionario gerenciaFuncionario() {
        Funcionario menorTempoFunc = funcionarios.get(0);
        for (Funcionario p : funcionarios) {
            if (p.getOcupadoAte() <= menorTempoFunc.getOcupadoAte()) {
                menorTempoFunc = p;
            }
        }
        return menorTempoFunc;
    }

    /**Método que atribui um tempo randomico com base a um Multiplicador para o tipo de funcionario que foi selecionado
     * para atender o Veiculo, é feito polimorfimo para saber qual o tipo do funcionario
     * @param func Recebe o funcionario para saber qual o multiplicador deve ser aplicado
     */
    public void defineTempoFuncionario(Funcionario func){
        if(func instanceof FuncNovato){
            FuncNovato fn = (FuncNovato)func;
            func.setTempoFuncionario(random.nextDouble() * fn.geraAleatorioNovato());
        }else if(func instanceof FuncExperiente){
            FuncExperiente fe = (FuncExperiente) func;
            func.setTempoFuncionario(random.nextDouble() * fe.geraAleatorioExperiente());
        }
    }

    /**Método que atribui o funcionario para atender o veiculo e para cada Veiculo novo atendido atualiza
     * o tempo da simulacao decorrido , salva o tempo de atendimento de todos os funcionarios para a geracao
     * dos graficos
     *
     */
    public void geraTempoFuncionario(){
        Funcionario f = disponibilidadeFuncionario();
        atualizaTempoGlobal();
        if(f != null){
           defineTempoFuncionario(f);
           f.setOcupadoAte( filaEventos.get(0).getTempoChegadaVeiculo()+(f.getTempoFuncionario()));//ate quando o func estara ocupado
            temposFuncionarios.add(f.getOcupadoAte());
            filaEventos.get(0).setTempoNoPosto(f.getTempoFuncionario());
            f.setOcupado(true);
            terminaEvento();
        }else {
            System.out.println("Nao ha funcionarios disponiveis");
            }
        if(!filaEventos.isEmpty()) geraTempoFuncionario();
        }

    /**Método que remove o Veiculo da fila após ser atendido
     * e adiciona ele ao evento saida e chama novamente o evento para um novo evento
     */
    public void terminaEvento(){
        saida.adicionaTempo( filaEventos.get(0).getTempoNoPosto());
        filaEventos.remove(0);
        System.out.println("Tempo global " + tempo_Global);
        iniciaFilaEventos();
    }


    /**Método que verifica se há veiculos na fila
     *
     * @return Retorna um booleano onde true a lista esta vazia e false a lista contem Veiculos
     */
    public boolean verificaFila(){
        return filaEventos.isEmpty();
    }

    /**Método que e chamado no construtor para iniciar a simulacao dos dados
     * Verifica se contem itens a ser atendidos , se não houver ela gera os graficos
     * com as estatisticas da simulacao
     *
     */
    public void iniciaFilaEventos(){
        if(!verificaFila()){
            geraTempoFuncionario();

        }else{
            System.out.println("Fim da Simulacao");
            geraDadosEstatiticos();
        }
    }

    /**Método que gera os graficos da simulacao após seu termino
     *
     */
    public void geraDadosEstatiticos(){
        estatisticaSimulacao.criarGraficoCliente(saida.teste());
        estatisticaSimulacao.calculaMediaFuncionario(temposFuncionarios);
        estatisticaSimulacao.calculaMediaClientes(saida.teste());
        estatisticaSimulacao.mediasPosto();
    }




}