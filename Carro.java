

public class Carro extends Veiculo {
    private String categoria;/* utilitario ou passeio */

    Carro(int capTanque, int qtdPneu, String marca, String modelo, int anoFabricacao, String tipoCombustivel, String categoria, double combustivelNoTanque) {
        super(capTanque, qtdPneu, marca, modelo, anoFabricacao, tipoCombustivel, combustivelNoTanque);
        this.categoria = categoria;
    }
    
    public String getCategoria(){
        return categoria;
    }

}