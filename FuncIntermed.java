<<<<<<< Updated upstream:FuncIntermed.java
public class FuncIntermed {
    
=======
package src.models;

public class FuncIntermed extends Funcionario {
    private double tempoAtendimento;

    FuncIntermed(String nome, String cpf, int idade, String dataAdmissao){
        super(nome, cpf, idade, dataAdmissao);
        this.tempoAtendimento = 50; //tempo para realizar uma ação
    }
>>>>>>> Stashed changes:src/main/java/src/models/FuncIntermed.java
}