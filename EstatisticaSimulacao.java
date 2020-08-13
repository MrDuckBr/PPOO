import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Queue;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class EstatisticaSimulacao  {


    private double tempoMedioCliente;
    private double tempoMedioFunc;
    private DefaultCategoryDataset barra;
    private DefaultCategoryDataset barra2;
    private JFrame janela = new JFrame();
    private JFrame janela2 = new JFrame();
    private double mediaCliente ;
    private double mediafuncionario;

    EstatisticaSimulacao(){
        mediaCliente = 0;
        mediafuncionario = 0;

        barra = new DefaultCategoryDataset();
        barra2 = new DefaultCategoryDataset();
        janela.setDefaultCloseOperation(EXIT_ON_CLOSE);
        janela.setTitle("Posto De Combustivel");
        janela.setSize(700,500);
        janela.setLocationRelativeTo(null);
        janela.setVisible(true);

        janela2.setDefaultCloseOperation(EXIT_ON_CLOSE);
        janela2.setTitle("Posto De Combustivel");
        janela2.setSize(700,500);
        janela2.setLocationRelativeTo(null);
        janela2.setVisible(true);


    }



    public void calculaMediaFuncionario(ArrayList<Double> funcionario){

        for (Double func : funcionario) {
            mediafuncionario += func;
        }
        mediafuncionario = mediafuncionario/funcionario.size();
    }



    public void calculaMediaClientes(ArrayList<Double> veiculos){

        for (Double veiculo : veiculos) {
            mediaCliente += veiculo;
        }
        mediaCliente = mediaCliente / veiculos.size();
    }

    public void mediasPosto(){


        barra2.clear();
        barra2.setValue((Double)tempoMedioCliente,"Tempo Medio Cliente" , " " );
        barra2.setValue((Double)tempoMedioFunc,"Tempo Medio Funcionario" , " " );
        JFreeChart grafico = ChartFactory.createBarChart("Posto Combustivel","Veiculos" , "Tempo no posto",barra2, PlotOrientation.VERTICAL,true,true,false);
        ChartPanel painel = new ChartPanel(grafico);
        janela2.add(painel);
    }

    public void calculaTempoFunc(ArrayList<Funcionario> func){
        for (Funcionario f:func){
            tempoMedioFunc += f.getTempoFuncionario();
        }
    }

    public void criarGraficoCliente(ArrayList<Double> veiculos ){
       for(int i = 0; i < veiculos.size() ; i++) {
           barra.setValue(veiculos.get(i), Integer.toString(i+1), "");
       }
        JFreeChart grafico = ChartFactory.createBarChart("Posto Combustivel","Veiculos" , "Tempo no posto",barra, PlotOrientation.VERTICAL,true,true,false);
        ChartPanel painel = new ChartPanel(grafico);
        janela.add(painel);
    }




    /*Adicionar para cada funcionario ????*/




}