import java.util.Random;

public class FuncExperiente extends Funcionario {

    public  int geraAleatorioExperiente() {
        int maxExperiente = 70;
        int minExperiente = 25;
        Random random = new Random();
        return (random.nextInt(maxExperiente - (minExperiente - 1)) + minExperiente);
    }
}