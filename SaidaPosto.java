import java.util.ArrayList;

public class SaidaPosto extends Eventos {
    private double tempo[];
    private int cont= 0;


    SaidaPosto(int tam){
        tempo = new double[tam];
    }

    @Override
    public double calculaTempo() { // chegada mais tempo atendimento

    }

    @Override
    public String tipoEvento() {
        return "Saida";
    }

    @Override
    public double getTempoEvento() {

    }

    @Override
    public Veiculo getVeiculo(String nome) {
        return null;
    }
}
