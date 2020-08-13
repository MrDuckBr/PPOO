import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.*;
import java.util.ArrayList;


/**
 * Classe que calcula as estatisticas do programa , estas que plotam um grafico e imprimem no console a media de
 * atendimento do veiculo e do funcionario;
 */
public class EstatisticaSimulacao  {


    private double tempoMedioCliente;
    private double tempoMedioFunc;
    private DefaultCategoryDataset barra;
    private JFrame janela = new JFrame();
    private double mediaCliente ;
    private double mediafuncionario;

    EstatisticaSimulacao(){
        mediaCliente = 0;
        mediafuncionario = 0;

        barra = new DefaultCategoryDataset();
        janela.setDefaultCloseOperation(EXIT_ON_CLOSE);
        janela.setTitle("Posto De Combustivel");
        janela.setSize(700,500);
        janela.setLocationRelativeTo(null);
        janela.setVisible(true);
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
        System.out.printf("\n Media do Tempo de Atendimento dos Funcionarios: %.2f " , mediafuncionario);
        System.out.printf("\n Media do Tempo de Atendimento Para cada Cliente: %.2f " , mediaCliente);
    }



    public void criarGraficoCliente(ArrayList<Double> veiculos ){
       for(int i = 0; i < veiculos.size() ; i++) {
           barra.setValue(veiculos.get(i), Integer.toString(i+1), "");
       }
        JFreeChart grafico = ChartFactory.createBarChart("Posto Combustivel","Veiculos" , "Tempo no posto",barra, PlotOrientation.VERTICAL,true,true,false);
        ChartPanel painel = new ChartPanel(grafico);
        janela.add(painel);
    }








}