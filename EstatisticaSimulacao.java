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

    /**Construtor da classe que inicializa uma janela em branco do java Swing , para que nela seja
     * feita o grafico
     *
     */
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


    /**Método que calcula o tempo medio para atender cada veiculo
     *
     * @param funcionario recebe um array list que contem o tempo de servico de todos os funcionarios
     */
    public void calculaMediaFuncionario(ArrayList<Double> funcionario){
        for (Double func : funcionario) {
            mediafuncionario += func;
        }
        mediafuncionario = mediafuncionario/funcionario.size();

    }

    /**Método que calcula o tempo medio de atendimento dos veiculos
     *
     * @param veiculos recebe como parametro um array list que contem o tempo de permanencia no posto de cada veiculo
     */
    public void calculaMediaClientes(ArrayList<Double> veiculos){
        for (Double veiculo : veiculos) {
            mediaCliente += veiculo;
        }
        mediaCliente = mediaCliente / veiculos.size();
    }

    /**Metodo que imprime as medias dos funcionarios
     *
     */
    public void mediasPosto(){
        System.out.printf("\n Media do Tempo de Atendimento dos Funcionarios: %.2f " , mediafuncionario);
        System.out.printf("\n Media do Tempo de Atendimento Para cada Cliente: %.2f " , mediaCliente);
    }


    /**Método que adiciona as informacoes no grafico e o plota
     *
     * @param veiculos array list com o tempo de atendimento dos veiculos
     */
    public void criarGraficoCliente(ArrayList<Double> veiculos ){
       for(int i = 0; i < veiculos.size() ; i++) {
           barra.setValue(veiculos.get(i), Integer.toString(i+1), "");
       }
        JFreeChart grafico = ChartFactory.createBarChart("Posto Combustivel","Veiculos" , "Tempo no posto",barra, PlotOrientation.VERTICAL,true,true,false);
        ChartPanel painel = new ChartPanel(grafico);
        janela.add(painel);
    }








}