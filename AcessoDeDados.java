import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/*
Codigo de base para saber mais ou menos oque fazer , mexer depois

Definir formato do TXT para que seja uma leitura mais padronizada

Definir

*/

public class AcessoDeDados {

    private ArrayList<Funcionario> f = new ArrayList<>();
    private ArrayList<Veiculo> v = new ArrayList<>();

    public AcessoDeDados(){
        lerArquivoTXT();
    }

    /**
     * Faz a leitura do arquivo texto.
     *
     * A primeira linha recebe a quantidade de Funcionarios Experientes e Funcionarios Novatos (separados por virgula)
     * Estes valores são utilizados para criar X,Y objetos de cada tipo de funcionario
     *
     * A segunda linha armazena o método de atendimento utilizado (FIFO)
     *
     * A partir da terceira linha, recebemos dados dos objetos, separados por virgula e armazenamos estes dados em um ArrayList com seus devidos tipos (Carro, Motocicletat, Caminhao)
     * As informações para os veículos são: int tempoChegadaVeiculo, int capTanque, int qtdPneu, String modelo, String anoFabricacao, String tipoCombustivel
     */
    public void lerArquivoTXT() {
        try {
            BufferedReader arq = new BufferedReader(new FileReader("entradas.txt"));
            String linha = arq.readLine();
            String[] campos = linha.split(",");

            int nuFuncsExperientes = Integer.parseInt(campos[0]);
            for (int i = 0; i < nuFuncsExperientes; i++){
                f.add(new FuncExperiente());
            }

            int nuFuncsNovatos = Integer.parseInt(campos[1]);
            for (int i = 0; i < nuFuncsNovatos; i++){
                f.add(new FuncNovato());
            }

            String estrategiaAtendimento = arq.readLine();

            String entidade = arq.readLine();
            do {
                String[] divide = entidade.split(",");
                switch (divide[1]) {
                    case "Carro":
                        v.add(new Carro(Integer.parseInt(divide[0]), Integer.parseInt(divide[2]), Integer.parseInt(divide[3]), divide[4], divide[5], divide[6])); //tempoChegada, capTanque, qtdPneus, modelo, ano, tipoCombustivel
                        break;
                    case "Motocicleta":
                        v.add(new Motocicleta(Integer.parseInt(divide[0]), Integer.parseInt(divide[2]), Integer.parseInt(divide[3]), divide[4], divide[5], divide[6]));
                        break;
                    case "Caminhao":
                        v.add(new Caminhao(Integer.parseInt(divide[0]), Integer.parseInt(divide[2]), Integer.parseInt(divide[3]), divide[4], divide[5], divide[6]));
                        break;
                    default:
                        System.out.println("Não foi possível identificar o tipo de veículo");
                        break;
                }
                entidade = arq.readLine();
            }while(entidade != null);

            arq.close();
        } catch (FileNotFoundException e) {
            System.out.println("Impossível abrir o arquivo!" );

        } catch (IOException e) {
            System.out.println("Problema na leitura do arquivo");
        }
    }

    public ArrayList<Funcionario> acessaDadosFuncionario(){
        return f;
    }

    public ArrayList<Veiculo> acessaDadosVeiculo(){
        return v;
    }
    
}