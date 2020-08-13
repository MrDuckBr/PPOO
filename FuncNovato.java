import java.util.Random;

public class FuncNovato extends Funcionario{
    /**
     * Gera um Funcionário Novato cujo tempo de realização de uma ação é um numero aleatório entre 65 (tempo minimo) e 100 (tempo maximo)
     * @return numeroAleatorio entre 65 e 100
     */
    public  int geraAleatorioNovato() {
        int maxNovato = 100;
        int minNovato = 65;
        Random random = new Random();
        return (random.nextInt(maxNovato - (minNovato - 1)) + minNovato);
    }
}
