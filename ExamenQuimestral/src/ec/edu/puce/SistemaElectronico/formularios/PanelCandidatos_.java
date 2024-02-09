package ec.edu.puce.SistemaElectronico.formularios;


import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import ec.edu.puce.SistemaElectronico2.Candidato;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;

public class PanelCandidatos_ extends JInternalFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JTextField txtNombresCandidatos;
	private JTable table;
	private DefaultTableModel model;
	private JTextField txtPartido;
	
	private Candidato candidato;
	private List <Candidato> candidatos;

	public PanelCandidatos_( List <Candidato> candidatos) {
		getContentPane().setBackground(new Color(255, 0, 0));
		
		this.candidatos = candidatos;
		
		setTitle("AÑADE CANDIDATOS");
		setBounds(100, 100, 564, 392);
		getContentPane().setLayout(null);
		
		JLabel lblNombres = new JLabel("Nombres:");
		lblNombres.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNombres.setBounds(30, 12, 71, 16);
		getContentPane().add(lblNombres);
		
		txtNombresCandidatos = new JTextField();
		txtNombresCandidatos.setBounds(105, 11, 414, 20);
		getContentPane().add(txtNombresCandidatos);
		txtNombresCandidatos.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(144, 127, 339, 150);
		getContentPane().add(scrollPane);

		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println(model.getValueAt(0, 0));
			}
		});
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Candidato", "Partido" }));
		scrollPane.setViewportView(table);
		
		JLabel lblPartido = new JLabel("Partido:");
		lblPartido.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPartido.setBounds(30, 40, 71, 16);
		getContentPane().add(lblPartido);
		
		txtPartido = new JTextField();
		txtPartido.setColumns(10);
		txtPartido.setBounds(105, 39, 414, 20);
		getContentPane().add(txtPartido);
		
		JButton btnAnadirCandidato = new JButton("Añadir");
		btnAnadirCandidato.setIcon(new ImageIcon("C:\\Users\\navar\\Downloads\\agregar-contacto.png"));
		btnAnadirCandidato.setBackground(new Color(64, 0, 128));
		btnAnadirCandidato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agregarCandidato();
			}
		});
		btnAnadirCandidato.setBounds(214, 81, 120, 23);
		getContentPane().add(btnAnadirCandidato);
		
		JButton btnLimpiarCandidato = new JButton("Limpiar");
		btnLimpiarCandidato.setIcon(new ImageIcon("C:\\Users\\navar\\Downloads\\limpieza-de-datos.png"));
		btnLimpiarCandidato.setBackground(new Color(64, 0, 128));
		btnLimpiarCandidato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarCampos();
			}
		});
		btnLimpiarCandidato.setBounds(67, 81, 120, 23);
		getContentPane().add(btnLimpiarCandidato);
		
		JButton btnSalirCandidato = new JButton("Salir");
		btnSalirCandidato.setIcon(new ImageIcon("C:\\Users\\navar\\Downloads\\cerrar-sesion (2).png"));
		btnSalirCandidato.setBackground(new Color(64, 0, 128));
		btnSalirCandidato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();	
			}
		});
		btnSalirCandidato.setBounds(363, 81, 120, 23);
		getContentPane().add(btnSalirCandidato);
		
		model = (DefaultTableModel) table.getModel();
		agregarFila();
	}
	
	
	
	private void agregarCandidato() {
		candidato = new Candidato();
		candidato.setNombreCandidato(txtNombresCandidatos.getText());
		candidato.setPartido(txtPartido.getText());

		
		candidatos.add(candidato);
		agregarFila();
		txtNombresCandidatos.setText("");
		txtPartido.setText("");
	}
	
	private void limpiarCampos() {
		txtNombresCandidatos.setText("");
		txtPartido.setText("");
	}

	
	private void agregarFila() {
		model.setRowCount(0);
		for (Candidato candidato : candidatos) {
			Object[] fila = new Object[2];
			fila[0] = candidato.getNombreCandidato();
			fila[1] = candidato.getPartido();
			model.addRow(fila);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
