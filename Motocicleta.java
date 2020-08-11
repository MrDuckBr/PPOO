public class Motocicleta extends Veiculo {
    private int marcha;
    Motocicleta(int tempoChegadaVeiculo, int capTanque, int qtdPneu, String modelo, String anoFabricacao, String tipoCombustivel) {
        super(tempoChegadaVeiculo, capTanque, qtdPneu, modelo, anoFabricacao, tipoCombustivel);
    }
    
    public int getMarcha(){
        return marcha;
    }
}