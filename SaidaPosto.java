import java.util.ArrayList;

public class SaidaPosto extends Eventos {
    private ArrayList<Double> tempo;


    /**
     * Construtor da classe
     * Inicializa um ArrayList para armazenar o tempo de saida dos veículos que ja passaram pelo posto
     */
    SaidaPosto(){
        tempo = new ArrayList<>();
    }

    /**
     * Adiciona no ArrayList o tempo de saída de cada veículo
     * @param time tempo que demorou para completar as tarefas
     */
    public void adicionaTempo(double time){
       tempo.add(time);
    }

    /**
     * Array para obter o tempo de permanência (em atendimento) dos veículos
     * @return tempo de permanência dos veículos
     */
    public ArrayList<Double> permenciaVeiculos(){
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
