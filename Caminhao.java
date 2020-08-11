public class Caminhao extends Veiculo {
    private int numEixos;
    Caminhao(int tempoChegadaVeiculo, int capTanque, int qtdPneu, String modelo, String anoFabricacao, String tipoCombustivel) {
        super(tempoChegadaVeiculo, capTanque, qtdPneu, modelo, anoFabricacao, tipoCombustivel);
    }
    
    public int getNumEixos(){
        return numEixos;
    }
}