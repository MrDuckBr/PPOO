import java.util.ArrayList;

public class SaidaPosto extends Eventos {
    private double tempo[];
    private int cont= 0;


    SaidaPosto(int tam){
        tempo = new double[tam];
    }

    public void adicionaTempo(double time){
        tempo[cont] = time;
        cont++;
    }



    @Override
    public double calculaTempo() { // chegada mais tempo atendimento
        return 0;
    }

    @Override
    public String eventoAtual() {
        return null;
    }



    @Override
    public double getTempoEvento() {
        return 0;
    }

    @Override
    public Veiculo getVeiculo(String nome) {
        return null;
    }
}
