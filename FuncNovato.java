<<<<<<< Updated upstream:FuncNovato.java
public class FuncNovato {
    
=======
package src.models;

public class FuncNovato extends Funcionario {
    private double tempoAtendimento;

    FuncNovato(String nome, String cpf, int idade, String dataAdmissao){
        super(nome, cpf, idade, dataAdmissao);
        this.tempoAtendimento = 90; //tempo para realizar uma ação
        // definir tempo geral ou de cada ação? ex: tempoAbastecer = 50, tempoTrocarOleo = 20.. etc
    }
>>>>>>> Stashed changes:src/main/java/src/models/FuncNovato.java
}