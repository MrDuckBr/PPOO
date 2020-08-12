import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Queue;

public class EstatisticaSimulacao extends JFrame {

    private double tempoMedioCliente;
    private double tempoMedioFunc;
    private DefaultCategoryDataset barra;



    EstatisticaSimulacao(){
        barra = new DefaultCategoryDataset();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Posto De Combustivel");
        setSize(700,500);
        setLocationRelativeTo(null);
        setVisible(true);

    }


    public void calculaMediaClientes(Queue<Veiculo> lista){
        for (Veiculo f:lista) {
            tempoMedioCliente += f.getTempoNoPosto();
        }
        tempoMedioCliente = tempoMedioCliente / lista.size();

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
        add(painel);


    }




    /*Adicionar para cada funcionario ????*/




}