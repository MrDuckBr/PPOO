import java.util.ArrayList;
import java.util.Collections;

public class ChegadaPosto extends Eventos {
    private final AcessoDeDados acessoDeDados;
    private final ArrayList<Veiculo> listaveiculos;
    private final ArrayList<Funcionario> listaFuncionario;
    private Veiculo veiculo;

    ChegadaPosto(){
        acessoDeDados = new AcessoDeDados();
        listaveiculos = acessoDeDados.acessaDadosVeiculo();
        listaFuncionario = acessoDeDados.acessaDadosFuncionario();
        ordenaLista(listaveiculos);

    }

    public ArrayList<Veiculo> getListaveiculos(){
        return listaveiculos;
    }

    public ArrayList<Funcionario> getListaFuncionario(){
        return listaFuncionario;
    }

    private void ordenaLista(ArrayList<Veiculo> listachegada){
        Collections.sort(listachegada);
    }

    public Veiculo getVeiculo(String tipoCombustivel){
        for(int i = 0 ; i < listaveiculos.size() ; i++){
            if(tipoCombustivel.equals(listaveiculos.get(i).getTipoCombustivel())){
                return listaveiculos.remove(i);
            }
        }
        return null;
    }


    @Override
    public double calculaTempo() { //calcula tempo de espera na fila do veiculo
        //tempo global - tempo chegada
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
}
