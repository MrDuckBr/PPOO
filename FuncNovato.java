import java.util.Random;

public class FuncNovato extends Funcionario{

    public  int geraAleatorioNovato() {
        int maxNovato = 100;
        int minNovato = 65;
        Random random = new Random();
        return (random.nextInt(maxNovato - (minNovato - 1)) + minNovato);
        }

        }
