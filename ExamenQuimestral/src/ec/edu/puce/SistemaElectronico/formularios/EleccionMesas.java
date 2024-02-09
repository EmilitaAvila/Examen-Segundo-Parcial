package ec.edu.puce.SistemaElectronico.formularios;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;

import ec.edu.puce.SistemaElectronico2.Estudiante;
import ec.edu.puce.SistemaElectronico2.Mesa;

import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.ImageIcon;

public class EleccionMesas extends JInternalFrame implements ActionListener {
	private List<Mesa> mesas;
	private PanelCrearMesa panelCrearMesa; 
	private List<Estudiante> estudiantes;
	private List <Estudiante> estudiantesDeMesa;

	private static final long serialVersionUID = 1L;

	public EleccionMesas( final List<Mesa> mesas, final List<Estudiante> estudiantes) {
		getContentPane().setBackground(new Color(128, 128, 128));
		setTitle("MESAS -ESCOGE UNA OPCIÓN-");
		this.mesas = mesas;
		this.estudiantes = estudiantes;
		
		setBounds(100, 100, 712, 491);
		getContentPane().setLayout(null);
		
		final JPanel panelChiquito = new JPanel();
		panelChiquito.setBackground(new Color(0, 128, 64));
		panelChiquito.setBounds(10, 11, 676, 439);
		getContentPane().add(panelChiquito);
		panelChiquito.setLayout(null);
		
		JButton btnCrearMesas = new JButton("Crear Mesa");
		btnCrearMesas.setIcon(new ImageIcon("C:\\Users\\navar\\Downloads\\tabla.png"));
		btnCrearMesas.setBounds(10, 11, 190, 29);
		panelChiquito.add(btnCrearMesas);
		btnCrearMesas.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JButton btnNewButton_1 = new JButton("Añadir Estudiante");
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\navar\\Downloads\\estudiantes (1).png"));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				PanelAñadirEstMesa panelAñadirEstMesa = new PanelAñadirEstMesa(mesas, estudiantes, estudiantesDeMesa );
		        panelChiquito.add(panelAñadirEstMesa);
		        panelAñadirEstMesa.setVisible(true);
				
			}
		});
		btnNewButton_1.setBounds(205, 11, 265, 29);
		panelChiquito.add(btnNewButton_1);
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JButton btnSalir = new JButton("Cerrar");
		btnSalir.setIcon(new ImageIcon("C:\\Users\\navar\\Downloads\\cerrar-sesion (2).png"));
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnSalir.setBounds(476, 11, 190, 29);
		panelChiquito.add(btnSalir);
		btnCrearMesas.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {

				 PanelCrearMesa panelCrearMesa = new PanelCrearMesa(mesas);
			        panelChiquito.add(panelCrearMesa);
			        panelCrearMesa.setVisible(true);
				 
				 
	            }
	        });
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
}
