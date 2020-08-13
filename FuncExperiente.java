import java.util.Random;

public class FuncExperiente extends Funcionario {
    /**
     * Gera um funcionário Experiente cujo tempo de realização de uma ação é um numero aleatório entre 25 (tempo minimo) e 70 (tempo maximo)
     * @return numeroAleatorio entre 25 e 70
     */
    public  int geraAleatorioExperiente() {
        int maxExperiente = 70;
        int minExperiente = 25;
        Random random = new Random();
        return (random.nextInt(maxExperiente - (minExperiente - 1)) + minExperiente);
    }
}