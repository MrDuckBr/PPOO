/**
 * @author Walisson Mendes Ferreira
 * @author Tales Ribeiro
 *
 * @version 1.0.0
 */


public class PostoCombustivel{
    private static ControleSimulacao controleSimulacao;
/**Classe Principal que inicia a simulacao do programa
 *
 *
 * */
    public static void main(String[] args) {

        System.out.println("Bem vindo ao Posto Rapidex!!");
        System.out.println("A simulação está sendo iniciada ...");

        controleSimulacao = new ControleSimulacao();
        System.out.println("Calculando valores da simulacao..");
        controleSimulacao.iniciaFilaEventos();


    }
}