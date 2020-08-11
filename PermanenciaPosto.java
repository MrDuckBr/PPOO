import java.util.ArrayList;

    public class PermanenciaPosto extends Eventos{
        ArrayList<Veiculo> permanece = new ArrayList<>();


    public void setTempoPosto(){
        /*
         * Adiciona o tempo que o carro fica no posto , verificar como sera feita
         */

    }

        @Override
        public double calculaTempo() {
            return 0;
        }

        @Override
        public String tipoEvento() {
            return null;
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
