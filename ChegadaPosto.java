import java.util.ArrayList;
import java.util.Collections;

public class ChegadaPosto extends Eventos {
    private ArrayList<Veiculo> listachegada;
    private int vetorTempo[];
    private Veiculo veiculo;

    ChegadaPosto(ArrayList<Veiculo> array, int[] vetor){
        listachegada = array;
        this.vetorTempo = vetor;
        ordenaLista(listachegada);
    }

    private void ordenaLista(ArrayList<Veiculo> listachegada){
        Collections.sort(listachegada);
    }

    public Veiculo getVeiculo(){
        return listachegada.remove(0);
    }


    @Override
    public double calculaTempo() { // NAO SEI SE FUNCIONA
        int cont =0;
        for(Veiculo v: listachegada){
            v.setTempoChegadaVeiculo(vetorTempo[cont]);
            cont++;
        }
    }

    @Override
    public String tipoEvento() {
        return "Chegada";
    }

    @Override
    public double getTempoEvento() {
        return 0;
    }
}
