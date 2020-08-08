import java.util.Random;

public class ControleSimulacao {
    /*
    * Controlar a simulacao de evento discreto
    * -adicao na fila
    * -calculo aleatorio de tempo
    * -saida da fila
    * -insercao com base no tempo em que esta acontecendo tudo
    *
    * */
    private static double tempo_Global;
    private Random random;

    ControleSimulacao(){
            tempo_Global = 0;
            random = new Random();
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







}
