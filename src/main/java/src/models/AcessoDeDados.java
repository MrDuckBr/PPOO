package src.models;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
Codigo de base para saber mais ou menos oque fazer , mexer depois

Definir formato do TXT para que seja uma leitura mais padronizada

Definir

*/

public class AcessoDeDados {

    //Leitura do arquivo texto que fara a leitura aqui

    public void lerArquivoTXT(String nomeArquivo) {
        try {
            BufferedReader arq = new BufferedReader(new FileReader(nomeArquivo));
            String linha = arq.readLine();

            while (linha != null) {
                String[] campos = linha.split(",");
                // adicionarAluno(new Aluno(Integer.parseInt(campos[0]), campos[1], Double.parseDouble(campos[2])));
                linha = arq.readLine();
            }
            arq.close();
        } catch (FileNotFoundException e) {
            System.out.println("Impossível abrir o arquivo: " + nomeArquivo);

        } catch (IOException e) {
            System.out.println("Problema na leitura do arquivo");
        }
    }
    
}