public abstract class Eventos {
    /**
     * Retorna o tempo atual do evento
     * @return tempo do evento
     */
    public abstract double getTempoEvento();

    @Override
    public String toString() {
        return "Tempo do Evento" + getTempoEvento();
    }
}