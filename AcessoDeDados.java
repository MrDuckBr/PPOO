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

    //Leitura do arquivo texto que fara a leitura
    //Instanciação do Arraylist (temporario?)
    ArrayList<Funcionario> f = new ArrayList<>();
    ArrayList<Veiculo> v = new ArrayList<>();

    public void lerArquivoTXT(String nomeArquivo) {
        try {
            BufferedReader arq = new BufferedReader(new FileReader(nomeArquivo));
            String linha = arq.readLine();
            String[] campos = linha.split(",");

            int nuFuncGasolina = Integer.parseInt(campos[0]); //pega numero de funcionarios por tipo
            for (int i = 0; i < nuFuncGasolina; i++){
                new FuncGasolina(); //funcionarios nao terao mais parametros (dados nao entram no txt. Possuem apenas um identificador)
            }

            int nuFuncAlcool = Integer.parseInt(campos[1]);
            for (int i = 0; i < nuFuncAlcool; i++){
                new FuncAlcool();
            }

            int nuFuncDiesel = Integer.parseInt(campos[2]);
            for (int i = 0; i < nuFuncDiesel; i++){
                new FuncDiesel();
            }

            String estrategiaAtendimento = arq.readLine(); //pega string com estrategia de etendimento

            String entidade = arq.readLine();

            do {
                String[] divide = entidade.split(",");
                v.add(new Veiculo(Integer.parseInt(divide[2]), Integer.parseInt(divide[3]), divide[4], divide[5],  divide[6])); //capTanque, qtdPneus, modelo, ano, tipoCombustivel
                entidade = arq.readLine();
            }while(entidade != null);

            arq.close();
        } catch (FileNotFoundException e) {
            System.out.println("Impossível abrir o arquivo: " + nomeArquivo);

        } catch (IOException e) {
            System.out.println("Problema na leitura do arquivo");
        }
    }
    
}