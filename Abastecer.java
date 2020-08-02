public class Abastecer { // verificar se precisa de uma classe para cada

    public static double precoGasolina = 4.20; //valores e implementações temporárias ( verificar coesao )
    public static double precoAlcool = 2.80;
    public static double precoDiesel = 3.15;

    public void abastecerVeiculo(Veiculo veiculo, double quantidade){

    }

    // abastecer por quantidade ex: 20 litros
    public double qtdAbastecer(double quantidade, String combustivel){
        if (quantidade < capTanque){
            abastecerVeiculo(quantidade, combustivel); //implementar
            // checar tanque cheio?
            // receber quantidade atual no tanque do carro?
            // quais entradas possiveis? E que tipo de informações temos do carro que está na fila?
        }
        else if(quantidade == tanque){
            encherTanque(combustivel); // somente se não houver tratamento da quantidade ja existente no tanque
        }
        else{
            System.out.println("Quantidade excede a capacidade do tanque!");
        }
    }

    public void precoAbastecer(double valor, String combustivel){
        private double conversao;
        if (combustivel == "Gasolina"){
            conversao = valor / precoGasolina;
            abastecerVeiculo(conversao, "Gasolina");
        }
        else if ( combustivel == "Alcool"){
            conversao = valor / precoAlcool;
            abastecerVeiculo(conversao, "Alcool");
        }else if (combustivel == "Diesel"){
            conversao = valor / precoDiesel;
        }else{
            System.out.println("Não foi possivel compeltar a ação");
        }

    }
    public double tempoAbastecer(String tipoCombustivel){ //tempo varia de funcionario e não de combustível
        if(tipoCombustivel == "Diesel"){
            return 75.0;
        }else if(tipoCombustivel == "Gasolina"){
            return 50.0;

        }else{
            return 40.0;
        }
    }

    

	
    
}