public abstract class Eventos {

    public abstract double getTempoEvento();

    @Override
    public String toString() {
        return "Tempo do Evento" + getTempoEvento();
    }
}