import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class ControleSimulacao  {
    /*
    * Controlar a simulacao de evento discreto
    * -adicao na fila
    * -calculo aleatorio de tempo
    * -saida da fila
    * -insercao com base no tempo em que esta acontecendo tudo
    *
    * */
    private static double tempo_Global;
    private final Random random;
    private Queue<Veiculo> filaEventos;
    private ArrayList<Funcionario> funcionarios; /*precisa de alguma lista pra guardar cada atendimento do funcionario*/

    ControleSimulacao(){
            tempo_Global = 0;
            random = new Random();
            filaEventos = new LinkedList<>();
            funcionarios = new ArrayList<>();
    }

    /*
    * O Veiculo chega ao posto , tempo de chegada adicionado, verifica se ha
    * frentistas disponiveis , se tiver , vou a ele, se nao tiver , aguardo, quando liberar a acao que ele esta
    * desejando eu vou a ela , adicionando um tempo aleatorio de espera para o usuario, por fim quando terminar
    * adiciono o tempo de saida e entao finalizo o programa para aquele objeto
    *
    * */

    public double getTempo_Global(){
        return tempo_Global;
    }

    /*Retorna o tempo de algo usando o multiplicador*/
    public double geraValorRandom(double multiplicador){
        return random.nextDouble() * multiplicador;
    }
     /*Adiciona o tempo em que o objeto chegou ao posto , aleatorio pois nao se sabe exatamente a hora da chegada*/
    public void tempoDeChegadaPosto(Veiculo veiculo){
        veiculo.setTempoChegadaVeiculo(random.nextInt());
    }
    /*Adiciona o tempo gasto em cada acao , para cada objeto*/
    public void setTempoObjeto(Veiculo veiculo){
        //veiculo.setTempoNoPosto(????);
    }


    public Funcionario funcionarioLivre(){
        for (Funcionario f:funcionarios ) {
            if (!f.getOcupado()) {// verificar se funcionario esta disponivel
                return f;
            }
        }
        return null;
    }
    /*Assumir que ja esta na ponta da fila*/

    public void realizaAcao(){
        if(!filaEventos.isEmpty()){
            Veiculo atendendo = filaEventos.peek();
            Funcionario funcAux = funcionarioLivre(); /*Verificando se ha funcionario livre*/
            if(funcAux != null){
                atendendo.setTempoNoPosto(geraValorRandom(funcAux.getTempoAtendimento()));
                funcAux.setOcupado(true);
            /*Faz o restante do Atendimento*/
            }else{
                //aguarda
            }

        }else{
            System.out.println("Simulacao Finalizada");
        }
    }


    p








}
