public class Motocicleta extends Veiculo {
    private int marcha;
    Motocicleta(int capTanque, int qtdPneu, String marca, String modelo, int anoFabricacao, String tipoCombustivel, int marcha, double combustivelNoTanque) {
        super(capTanque, qtdPneu, marca, modelo, anoFabricacao, tipoCombustivel, combustivelNoTanque);
        this.marcha = marcha;
    }
    
    public int getMarcha(){
        return marcha;
    }
}