import java.util.ArrayList;
import java.util.Collections;

public class ChegadaPosto extends Eventos {
    private final ArrayList<Veiculo> listaveiculos;
    private final ArrayList<Funcionario> listaFuncionario;
    private Veiculo veiculo;

    /**
     * Inicializa os dados iniciais da simulação a partir dos dados obtidos no arquivo txt
     *
     */
    ChegadaPosto(){
        AcessoDeDados acessoDeDados = new AcessoDeDados();
        listaveiculos = acessoDeDados.acessaDadosVeiculo();
        listaFuncionario = acessoDeDados.acessaDadosFuncionario();
        ordenaLista(listaveiculos);

    }

    /**
     * Obtem a lista de veículos utilizadas na simulação.
     * @return lista de veículos
     */
    public ArrayList<Veiculo> getListaveiculos(){
        return listaveiculos;
    }

    /**
     * Obtem a lista de funcionários utilizados na simulação.
     * @return lsita de funcionários
     */
    public ArrayList<Funcionario> getListaFuncionario(){
        return listaFuncionario;
    }

    /**
     * A partir da lista de veículos obtidas no arquivo, ordena-se por tempo de chegada (tempoChegadaVeiculo).
     * @param listachegada o ArrayList contendo os dados de entrada (linha 3 em diante)
     */
    private void ordenaLista(ArrayList<Veiculo> listachegada){
        Collections.sort(listachegada);
    }

    @Override
    public double getTempoEvento() {
        return 0;
    }
}
