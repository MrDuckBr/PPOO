public class Caminhao extends Veiculo {
    /**
     * Cria um veículo do tipo Caminhão
     * @param tempoChegadaVeiculo tempo em que o veiculo chegará ao posto
     * @param capTanque capacidade do tanque de combustível do veículo
     * @param qtdPneu quantidade de pneus do veículo
     * @param modelo modelo do veículo
     * @param anoFabricacao ano de fabricação do veículo
     * @param tipoCombustivel tipo de combustível usado pelo veículo
     */
    Caminhao(int tempoChegadaVeiculo, int capTanque, int qtdPneu, String modelo, String anoFabricacao, String tipoCombustivel) {
        super(tempoChegadaVeiculo, capTanque, qtdPneu, modelo, anoFabricacao, tipoCombustivel);
    }
}