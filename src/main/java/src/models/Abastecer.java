package src.models;

public class Abastecer { // verificar se precisa de uma classe para cada

    public double tempoAbastecer(String tipoCombustivel){
        if(tipoCombustivel == "Diesel"){
            return 75.0;
        }else if(tipoCombustivel == "Gasolina"){
            return 50.0;

        }else{
            return 40.0;
        }
    }

    

	
    
}