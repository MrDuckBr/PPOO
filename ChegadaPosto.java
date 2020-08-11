import java.util.ArrayList;
import java.util.Collections;

public class ChegadaPosto extends Eventos {
    private final ArrayList<Veiculo> listachegada;
    private final int[] vetorTempo;
    private Veiculo veiculo;

    ChegadaPosto(ArrayList<Veiculo> array, int[] vetor){
        listachegada = array;
        this.vetorTempo = vetor;
        ordenaLista(listachegada);
    }

    private void ordenaLista(ArrayList<Veiculo> listachegada){
        Collections.sort(listachegada);
    }

    public Veiculo getVeiculo(String tipoCombustivel){
        for(int i = 0 ; i < listachegada.size() ; i++){
            if(tipoCombustivel.equals(listachegada.get(i).getTipoCombustivel())){
                return listachegada.remove(i);
            }
        }
        return null;
    }


    @Override
    public double calculaTempo() { // NAO SEI SE FUNCIONA
        int cont =0;
        for(Veiculo v: listachegada){
            v.setTempoChegadaVeiculo(vetorTempo[cont]);
            cont++;
        }
        return 0;
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
