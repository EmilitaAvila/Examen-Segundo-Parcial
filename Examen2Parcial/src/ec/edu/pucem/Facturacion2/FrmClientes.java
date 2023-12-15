package ec.edu.pucem.Facturacion2;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;

public class FrmClientes extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTextField txtCedula;
	private JTextField txtNombres;
	private JTextField txtApellidos;
	private JTextField txtTelefono;
	private JTextField txtEmail;
	private JTextField txtDireccion;
	private static ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	private JButton btnGuardar;
	private JTable table;
	private DefaultTableModel model;

	
	public FrmClientes() {
		getContentPane().setBackground(new Color(188, 188, 235));
		setTitle("Agregar Clientes");
		setBounds(100, 100, 450, 500);
		getContentPane().setLayout(null);
		
		JLabel lblCedula = new JLabel("Cédula");
		lblCedula.setIcon(new ImageIcon("C:\\Users\\navar\\Downloads\\tarjeta-de-identificacion (1).png"));
		lblCedula.setFont(new Font("MS PGothic", Font.ITALIC, 11));
		lblCedula.setBounds(39, 26, 118, 14);
		getContentPane().add(lblCedula);
		
		JLabel lblNombres = new JLabel("Nombres");
		lblNombres.setIcon(new ImageIcon("C:\\Users\\navar\\Downloads\\usuario (1).png"));
		lblNombres.setFont(new Font("MS PGothic", Font.ITALIC, 11));
		lblNombres.setBounds(39, 65, 88, 14);
		getContentPane().add(lblNombres);
		
		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setIcon(new ImageIcon("C:\\Users\\navar\\Downloads\\hombre.png"));
		lblApellidos.setFont(new Font("MS PGothic", Font.ITALIC, 11));
		lblApellidos.setBounds(39, 104, 88, 14);
		getContentPane().add(lblApellidos);
		
		JLabel lblTelefono = new JLabel("Télefono");
		lblTelefono.setIcon(new ImageIcon("C:\\Users\\navar\\Downloads\\telefono-inteligente.png"));
		lblTelefono.setFont(new Font("MS PGothic", Font.ITALIC, 11));
		lblTelefono.setBounds(39, 143, 88, 14);
		getContentPane().add(lblTelefono);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setIcon(new ImageIcon("C:\\Users\\navar\\Downloads\\gmail.png"));
		lblEmail.setFont(new Font("MS PGothic", Font.ITALIC, 11));
		lblEmail.setBounds(39, 182, 88, 14);
		getContentPane().add(lblEmail);
		
		JLabel lblDireccion = new JLabel("Dirección");
		lblDireccion.setIcon(new ImageIcon("C:\\Users\\navar\\Downloads\\localizacion.png"));
		lblDireccion.setFont(new Font("MS PGothic", Font.ITALIC, 11));
		lblDireccion.setBounds(39, 221, 103, 19);
		getContentPane().add(lblDireccion);
		
		txtCedula = new JTextField();
		txtCedula.setFont(new Font("Goudy Old Style", Font.ITALIC, 11));
		txtCedula.setBounds(119, 25, 260, 20);
		getContentPane().add(txtCedula);
		txtCedula.setColumns(10);
		
		txtNombres = new JTextField();
		txtNombres.setFont(new Font("Goudy Old Style", Font.ITALIC, 11));
		txtNombres.setColumns(10);
		txtNombres.setBounds(119, 64, 260, 20);
		getContentPane().add(txtNombres);
		
		txtApellidos = new JTextField();
		txtApellidos.setFont(new Font("Goudy Old Style", Font.ITALIC, 11));
		txtApellidos.setColumns(10);
		txtApellidos.setBounds(119, 103, 260, 20);
		getContentPane().add(txtApellidos);
		
		txtTelefono = new JTextField();
		txtTelefono.setFont(new Font("Goudy Old Style", Font.ITALIC, 11));
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(119, 142, 260, 20);
		getContentPane().add(txtTelefono);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Goudy Old Style", Font.ITALIC, 11));
		txtEmail.setColumns(10);
		txtEmail.setBounds(119, 181, 260, 20);
		getContentPane().add(txtEmail);
		
		txtDireccion = new JTextField();
		txtDireccion.setFont(new Font("Goudy Old Style", Font.ITALIC, 11));
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(119, 220, 260, 20);
		getContentPane().add(txtDireccion);
		
		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.setIcon(new ImageIcon("C:\\Users\\navar\\Downloads\\agregar-archivo.png"));
		btnNuevo.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 11));
		btnNuevo.setBackground(new Color(183, 240, 210));
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarCampos();
			}
		});
		btnNuevo.setBounds(45, 274, 90, 23);
		getContentPane().add(btnNuevo);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setIcon(new ImageIcon("C:\\Users\\navar\\Downloads\\salvar.png"));
		btnGuardar.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 11));
		btnGuardar.setBackground(new Color(183, 240, 210));
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crearCliente();
			}
		});
		btnGuardar.setBounds(161, 274, 111, 23);
		getContentPane().add(btnGuardar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setIcon(new ImageIcon("C:\\Users\\navar\\Downloads\\cerrar.png"));
		btnCancelar.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 11));
		btnCancelar.setBackground(new Color(183, 240, 210));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cerrarVentana();
			}
		});
		btnCancelar.setBounds(293, 274, 111, 23);
		getContentPane().add(btnCancelar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(45, 308, 359, 140);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Goudy Old Style", Font.ITALIC, 11));
		table.setBackground(new Color(251, 208, 241));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00E9dula", "Nombres", "Apellidos", "Tel\u00E9fono", "Email", "Direcci\u00F3n"
			}
		));
		scrollPane.setViewportView(table);
		model = (DefaultTableModel) table.getModel();

	}
	
	private void limpiarCampos() {
		this.txtCedula.setText("");
		this.txtNombres.setText("");
		this.txtApellidos.setText("");
		this.txtTelefono.setText("");
		this.txtEmail.setText("");
		this.txtDireccion.setText("");
	}
	
	private void cerrarVentana() {
		this.setVisible(false);
	}
	
	private void crearCliente() {
		Cliente cliente = new Cliente(
				this.txtCedula.getText(),
				this.txtNombres.getText(),
				this.txtApellidos.getText(),
				this.txtTelefono.getText(),
				this.txtEmail.getText(),
				this.txtDireccion.getText()
				);
		clientes.add(cliente);
		agregarFila();
	}
	
	private void agregarFila() {
		Object[] fila=new Object[6];
		fila[0]= clientes.get(clientes.size()-1).getCedula();
		fila[1]= clientes.get(clientes.size()-1).getNombres();
		fila[2]= clientes.get(clientes.size()-1).getApellidos();
		fila[3]= clientes.get(clientes.size()-1).getTelefono();
		fila[4]= clientes.get(clientes.size()-1).getEmail();
		fila[5]= clientes.get(clientes.size()-1).getDireccion();
		this.model.addRow(fila);
	}
	
	public static ArrayList<Cliente> getClientes() {
		return clientes;
	}
}