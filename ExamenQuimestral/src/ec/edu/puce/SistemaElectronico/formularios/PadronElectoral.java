package ec.edu.puce.SistemaElectronico.formularios;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.table.DefaultTableModel;

import ec.edu.puce.SistemaElectronico2.Estudiante;
import ec.edu.puce.SistemaElectronico2.Mesa;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.ImageIcon;

public class PadronElectoral extends JInternalFrame implements ActionListener {

    private static final long serialVersionUID = 1L;

    private JTable table;
    private DefaultTableModel model;
    private List<Mesa> mesas;
    private List<Estudiante> estudiantes;
    private List<Estudiante> estudiantesDeMesa;

    public PadronElectoral(List<Mesa> mesas, List<Estudiante> estudiantes, List<Estudiante> estudiantesDeMesa) {
    	getContentPane().setBackground(new Color(255, 0, 255));
        this.mesas = mesas;
        this.estudiantes = estudiantes;
        this.estudiantesDeMesa = estudiantesDeMesa;

        setTitle("PADRÓN ELECTORAL");
        setBounds(100, 100, 600, 400);
        getContentPane().setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 50, 560, 300);
        getContentPane().add(scrollPane);

        table = new JTable();
        table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Estudiante", "Mesa", "Cédula", "Curso" }));
        scrollPane.setViewportView(table);
        
        JLabel lblPadronGeneral = new JLabel("PADRÓN ELECTORAL");
        lblPadronGeneral.setIcon(new ImageIcon("C:\\Users\\navar\\Downloads\\candidato (1).png"));
        lblPadronGeneral.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblPadronGeneral.setBounds(10, 11, 176, 22);
        getContentPane().add(lblPadronGeneral);
        
        JButton btnNewButton = new JButton("salir");
        btnNewButton.setBackground(new Color(0, 0, 64));
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        	}
        });
        btnNewButton.setBounds(481, 11, 89, 23);
        getContentPane().add(btnNewButton);
        model = (DefaultTableModel) table.getModel();

        addInternalFrameListener(new InternalFrameAdapter() {
            @Override
            public void internalFrameClosing(InternalFrameEvent e) {         
                System.out.println("PanelPadronElectoral cerrado");
            }
        });

        cargarDatosEnTabla();
    }

    private void cargarDatosEnTabla() {
        model.setRowCount(0);

        Set<String> combinacionesUnicas = new HashSet<>();

        for (Mesa mesa : mesas) {
            for (Estudiante estudiante : mesa.getEstudiantesDeMesa()) {
                String combinacion = estudiante.getNombreEstudiante() + mesa.getnombreMesa();
                if (combinacionesUnicas.add(combinacion)) {
                    agregarFila(estudiante.getNombreEstudiante(), 
                    		mesa.getnombreMesa(), 
                    		estudiante.getCedulaEstudiante(), 
                    		estudiante.getCurso().getNombreCurso());
                }
            }
        }
    }


    private void agregarFila(String nombreEstudiante, String nombreMesa, String cedulaEstudiante, String curso) {
        model.addRow(new Object[]{nombreEstudiante, nombreMesa, cedulaEstudiante, curso});
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
