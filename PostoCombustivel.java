public class PostoCombustivel{
    private static ControleSimulacao controleSimulacao;

    public static void main(String[] args) {

        System.out.println("Bem vindo ao Posto Bomba!!");
        controleSimulacao = new ControleSimulacao();
        controleSimulacao.iniciaFilaEventos();
        /* 
        Toda o programa ira rodar em simulacao 
         */

    }
}