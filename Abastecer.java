public class Abastecer { // verificar se precisa de uma classe para cada

    public static double precoGasolina = 4.20; //valores e implementações temporárias ( verificar coesao )
    public static double precoAlcool = 2.80;
    public static double precoDiesel = 3.15;

    public float abastecerVeiculo(Veiculo veiculo, double quantidade) throws Exception {
        if(quantidade < veiculo.getCapTanque()) {
            double quantidadeAbastecida = qtdAbastecer(veiculo, quantidade);
            return precoAbastecer(veiculo, quantidadeAbastecida);
        }
        throw new RuntimeException("Veiculo com tanque cheio, impossível abastecer");
    }

    // abastecer por quantidade ex: 20 litros
    public double qtdAbastecer(Veiculo veiculo, double quantidade) {
        double combustivelResultante = veiculo.getCapTanque() - veiculo.getCombustivelNoTanque();
        double abastecer = combustivelResultante + quantidade;

        // aqui podemos atualizar o atributo do combustivel no tanque, ou deixar sem atualizar.
        if(abastecer <= veiculo.getCapTanque()) {
            if(abastecer == veiculo.getCapTanque()) {
                System.out.println("Veiculo abastecido completamente");
                return quantidade;
            }
            else {
                // podemos colocar a % restante para completar o tanque tmb
                System.out.println("Veiculo abastecido com sucesso");
                return quantidade;
            }
        }
        else { // aqui caso a quantidade exceda a capacidade do tanque. Podemos mostrar o valor excedido?
            double combustivelSobrou = abastecer - veiculo.getCapTanque();
            System.out.println("Não foi possível abastencer com a quantidade total");
            return combustivelResultante;
        }
    }

    // calculo do preço do combustivel por cada tipo
    public float precoAbastecer(Veiculo veiculo, double quantidadeAbastecida ){
        if(veiculo.getTipoCombustivel() == "Diesel") {
            return (float) (quantidadeAbastecida * precoDiesel);
        }
        else if(veiculo.getTipoCombustivel() == "Gasolina") {
            return (float) (quantidadeAbastecida * precoGasolina);
        }
        else if(veiculo.getTipoCombustivel() == "Alcool") {
            return (float) (quantidadeAbastecida * precoAlcool);
        }
        throw new RuntimeException("Tipo de combustivel não existe");
    }
}