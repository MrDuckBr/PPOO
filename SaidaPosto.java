import java.util.ArrayList;

public class SaidaPosto extends Eventos {
    private ArrayList<Veiculo> sairam;


    SaidaPosto(){
        sairam = new ArrayList<>();
    }

    public void saidaPostoValores(Veiculo v){
        sairam.add(v);
    }

    public double mediaTempo(){
        double media=0;
        for (Veiculo v:sairam) {
            media += v.getTempoNoPosto();
        }
        return  media;
    }

    @Override
    public void calculaTempo() {

    }
}
