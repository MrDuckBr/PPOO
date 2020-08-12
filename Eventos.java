import java.util.ArrayList;

public abstract class Eventos {

    public abstract double calculaTempo();

    public abstract String eventoAtual(); // Para Impressao do EVENTO

    public abstract double getTempoEvento();

    public abstract Veiculo getVeiculo(String nome);

    // public abstract void permanenciaPosto();
    // public abstract void saidaPosto();


    @Override
    public String toString() {
        return "Tempo do Evento" + getTempoEvento();
    }
}