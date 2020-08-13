public class Motocicleta extends Veiculo {
    /**
     * Cria um veículo do tipo Motocicleta
     * @param tempoChegadaVeiculo tempo em que o veiculo chegará ao posto
     * @param capTanque capacidade do tanque de combustível do veículo
     * @param qtdPneu quantidade de pneus do veículo
     * @param modelo modelo do veículo
     * @param anoFabricacao ano de fabricação do veículo
     * @param tipoCombustivel tipo de combustível usado pelo veículo
     */
    Motocicleta(int tempoChegadaVeiculo, int capTanque, int qtdPneu, String modelo, String anoFabricacao, String tipoCombustivel) {
        super(tempoChegadaVeiculo, capTanque, qtdPneu, modelo, anoFabricacao, tipoCombustivel);
    }
}