import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.security.PublicKey;
import java.util.ArrayList;

/*
Codigo de base para saber mais ou menos oque fazer , mexer depois

Definir formato do TXT para que seja uma leitura mais padronizada

Definir

*/

public class AcessoDeDados {

    //Leitura do arquivo texto que fara a leitura
    //Instanciação do Arraylist (temporario?)
    private ArrayList<Funcionario> f = new ArrayList<>();
    private ArrayList<Veiculo> v = new ArrayList<>();

    public void lerArquivoTXT(String nomeArquivo) {
        try {
            BufferedReader arq = new BufferedReader(new FileReader(nomeArquivo));
            String linha = arq.readLine();
            String[] campos = linha.split(",");

            int nuFuncsExperientes = Integer.parseInt(campos[0]); //pega numero de funcionarios por tipo
            for (int i = 0; i < nuFuncsExperientes; i++){
                new FuncExperiente(); //funcionarios nao terao mais parametros (dados nao entram no txt. Possuem apenas um identificador)
            }

            int nuFuncsNovatos = Integer.parseInt(campos[1]);
            for (int i = 0; i < nuFuncsNovatos; i++){
                new FuncNovato();
            }


            String estrategiaAtendimento = arq.readLine(); //pega string com estrategia de etendimento

            String entidade = arq.readLine();
            //valores inseridos corretamente em suas devidas classes (Carro, Motocicleta e Caminhao)!!!!!!!
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
            System.out.println("Impossível abrir o arquivo: " + nomeArquivo);

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