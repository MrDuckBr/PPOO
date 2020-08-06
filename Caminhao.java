public class Caminhao extends Veiculo {
    private int numEixos;
    Caminhao(int capTanque, int qtdPneu, String marca, String modelo, int anoFabricacao, String tipoCombustivel, int numEixos, double combustivelNoTanque) {
        super(capTanque, qtdPneu, marca, modelo, anoFabricacao, tipoCombustivel, combustivelNoTanque);
        // TODO Auto-generated constructor stub
    }
    
    public int getNumEixos(){
        return numEixos;
    }
}