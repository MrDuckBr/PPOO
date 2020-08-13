/*
Verificar se os funcionarios nao tem atributos propriose
*/

public class Funcionario {
    static int contador = 0;
    /*Atributos simulacao*/
    private boolean ocupado;
    private double tempoFuncionario;
    int idFunc = 0;
    private double ocupadoAte;

    /**
     * Classe construtora
     * Inicializa o funcionário com atributos definidos como padrão (auxiliares para a simulação)
     */
    public Funcionario() {
        idFunc = contador;
        ocupado = false;
        tempoFuncionario = 0;
        contador++;
        ocupadoAte = 0;

    }

    /**
     * Obtém o ID (identificador único) de um funcionário
     * @return ID do funcionário
     */
    public int getIdFunc(){return idFunc;}

    /**
     * Retorna o status de um funcionário, ou seja, se o mesmo está atendendo algum veículo.
     * @return true ou false para ocupado.
     */
    public boolean getOcupado(){
        return  ocupado;
    }

    /**
     * Seta o estado do funcionário passando o booleano por parâmetro (true ou false)
     * @param ocupado status do funcionário (se está ou não realizando uma tarefa)
     */
    public void setOcupado(boolean ocupado){
        this.ocupado = ocupado;
    }

    /**
     * Retorna o tempo do funcionário (numero aleatório para cada tipo)
     * @return tempo do funcionário
     */
    public  double getTempoFuncionario(){
        return  tempoFuncionario;
    }

    /**
     * Atribui um tempo à um funcionário passando um valor por parâmetro (tempo para atendimento).
     * @param valor o tempo aleatório do funcionário
     */
    public void setTempoFuncionario(double valor){ tempoFuncionario = valor;}

    /**
     * Seta ao funcionário um tempo em que o mesmo ficará indisponível
     * @param valor o tempo em que ficará ocupado
     */
    public void setOcupadoAte(double valor){
        ocupadoAte = valor;
    }

    /**
     * Retorna o tempo de indisponibilidade do funcionário
     * @return tempo indisponível
     */
    public double getOcupadoAte(){
        return ocupadoAte;
    }

}