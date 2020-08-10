import java.util.ArrayList;
import java.util.Collections;

public class ChegadaPosto  {
    private ArrayList<Veiculo> listachegada;
    private Veiculo veiculo;

    ChegadaPosto(){
        listachegada = new ArrayList<>();
    }

    public void adicionaListaChegada(Veiculo veiculo){
        listachegada.add(veiculo);
        Collections.sort(listachegada);
    }

    public Veiculo getVeiculo(){
        return listachegada.get(0);
    }



}
