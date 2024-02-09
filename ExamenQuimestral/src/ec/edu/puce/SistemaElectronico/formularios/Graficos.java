package ec.edu.puce.SistemaElectronico.formularios;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JInternalFrame;
import org.jfree.data.category.DefaultCategoryDataset;
import ec.edu.puce.SistemaElectronico2.Candidato;
import javax.swing.JInternalFrame;
import java.awt.Color;

public class Graficos extends JInternalFrame {

    private static final long serialVersionUID = 1L;

    public Graficos(List <Candidato> candidatos) {
    	setBackground(new Color(192, 192, 192));
    	getContentPane().setBackground(new Color(192, 192, 192));
    	setClosable(true);
        setTitle("RESULTADOS EN BARRAS");
        setBounds(100, 100, 450, 300);

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (Candidato candidato : candidatos) {
            dataset.addValue(candidato.getVotos(), "Votos", candidato.getNombreCandidato());
        }

        JFreeChart chart = ChartFactory.createBarChart(
                "Resultados de Votaciones", 
                "Candidatos", 
                "Votos",
                dataset 
        );

        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setBackground(new Color(192, 192, 192));
        getContentPane().add(chartPanel);
    }
}
