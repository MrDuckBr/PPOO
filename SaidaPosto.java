import java.util.ArrayList;

public class SaidaPosto extends Eventos {
    private ArrayList<Double> tempo;



    SaidaPosto(){
        tempo = new ArrayList<>();
    }

    public void adicionaTempo(double time){
       tempo.add(time);
    }

    public ArrayList<Double> teste(){
        return tempo;
    }

    @Override
    public double calculaTempo() { // chegada mais tempo atendimento
        return 0;
    }

    @Override
    public String eventoAtual() {
        return "Saida";
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
