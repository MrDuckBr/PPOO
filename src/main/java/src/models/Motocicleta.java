package src.models;

public class Motocicleta extends Veiculo {
    private int marcha;
    Motocicleta(int capTanque, int qtdPneu, String marca, String modelo, int anoFabricacao, String tipoCombustivel, int marcha) {
        super(capTanque, qtdPneu, marca, modelo, anoFabricacao, tipoCombustivel);
        this.marcha = marcha;
    }
    
    public int getMarcha(){
        return marcha;
    }
}