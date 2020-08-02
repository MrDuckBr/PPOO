<<<<<<< Updated upstream:FuncExperiente.java
public class FuncExperiente {
    
=======
package src.models;

public class FuncExperiente extends Funcionario {
    private double tempoAtendimento;

    FuncExperiente(String nome, String cpf, int idade, String dataAdmissao){
        super(nome, cpf, idade, dataAdmissao);
        this.tempoAtendimento = 30; //tempo para realizar uma ação
    }
>>>>>>> Stashed changes:src/main/java/src/models/FuncExperiente.java
}