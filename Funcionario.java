/*
Verificar se os funcionarios nao tem atributos propriose
*/

public class Funcionario {
    static int contador = 0;
    /*Atributos simulacao*/
    private boolean ocupado;
    private double tempoFuncionario;
    int idFunc = 0;


    public Funcionario() {
        idFunc = contador;
        ocupado = false;
        tempoFuncionario = 0;
        contador++;

    }

    public int getIdFunc(){return idFunc;}

    public boolean getOcupado(){
        return  ocupado;
    }

    public void setOcupado(boolean ocupado){
        this.ocupado = ocupado;
    }

    public  double getTempoAtendimento(){
        return  tempoFuncionario;
    }
}