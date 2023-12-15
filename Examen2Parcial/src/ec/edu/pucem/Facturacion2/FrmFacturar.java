package ec.edu.pucem.Facturacion2;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;

import java.awt.Container;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import javax.swing.ImageIcon;

public class FrmFacturar extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JLabel lblCedula;
	private JLabel lblNombres;
	private JLabel lblTelfono;
	private JLabel lblApellidos;
	private JLabel lblEmail;
	private JLabel lblDireccin;
	private JTable table;
	private ArrayList<Productos> productos = new ArrayList<Productos>();
	private DefaultTableModel model;
	private JLabel lblIVA;
	private JLabel lblTotal;
	private JLabel lblSubtotal;


	public FrmFacturar() {
		getContentPane().setBackground(new Color(176, 216, 255));
		setTitle("Factura");
		setBounds(100, 100, 590, 498);
		getContentPane().setLayout(null);
		
		JLabel lblCliente = new JLabel("   CLIENTE");
		lblCliente.setIcon(new ImageIcon("C:\\Users\\navar\\Downloads\\clasificacion (1).png"));
		lblCliente.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		lblCliente.setBounds(22, 7, 111, 39);
		getContentPane().add(lblCliente);
		
		JButton btnSeleccionarCliente = new JButton("Seleccionar cliente");
		btnSeleccionarCliente.setBackground(new Color(231, 130, 63));
		btnSeleccionarCliente.setFont(new Font("MS PGothic", Font.BOLD | Font.ITALIC, 13));
		btnSeleccionarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pedirDatos();
			}
		});
		btnSeleccionarCliente.setBounds(296, 13, 156, 28);
		getContentPane().add(btnSeleccionarCliente);
		
		lblCedula = new JLabel("Cedula:");
		lblCedula.setFont(new Font("MS PGothic", Font.BOLD | Font.ITALIC, 11));
		lblCedula.setBounds(37, 53, 242, 27);
		getContentPane().add(lblCedula);
		
		lblNombres = new JLabel("Nombres:");
		lblNombres.setFont(new Font("MS PGothic", Font.BOLD | Font.ITALIC, 11));
		lblNombres.setBounds(306, 53, 242, 27);
		getContentPane().add(lblNombres);
		
		lblTelfono = new JLabel("Teléfono:");
		lblTelfono.setFont(new Font("MS PGothic", Font.BOLD | Font.ITALIC, 11));
		lblTelfono.setBounds(306, 93, 242, 27);
		getContentPane().add(lblTelfono);
		
		lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setFont(new Font("MS PGothic", Font.BOLD | Font.ITALIC, 11));
		lblApellidos.setBounds(37, 93, 242, 27);
		getContentPane().add(lblApellidos);
		
		lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("MS PGothic", Font.BOLD | Font.ITALIC, 11));
		lblEmail.setBounds(37, 127, 242, 27);
		getContentPane().add(lblEmail);
		
		lblDireccin = new JLabel("Dirección:");
		lblDireccin.setFont(new Font("MS PGothic", Font.BOLD | Font.ITALIC, 11));
		lblDireccin.setBounds(306, 127, 242, 27);
		getContentPane().add(lblDireccin);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBackground(new Color(198, 255, 198));
		btnCancelar.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 11));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(459, 435, 89, 23);
		getContentPane().add(btnCancelar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(37, 191, 511, 141);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "Descripci\u00F3n", "Precio", "Cantidad", "Total"
			}
		));
		scrollPane.setViewportView(table);
		model = (DefaultTableModel) table.getModel();
		
		lblSubtotal = new JLabel("Subtotal:");
		lblSubtotal.setIcon(new ImageIcon("C:\\Users\\navar\\Downloads\\billete-de-un-dolar.png"));
		lblSubtotal.setBackground(new Color(255, 255, 255));
		lblSubtotal.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 12));
		lblSubtotal.setBounds(175, 343, 169, 26);
		getContentPane().add(lblSubtotal);
		
		lblIVA = new JLabel("IVA: ");
		lblIVA.setIcon(new ImageIcon("C:\\Users\\navar\\Downloads\\impuesto.png"));
		lblIVA.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 12));
		lblIVA.setBounds(175, 378, 169, 35);
		getContentPane().add(lblIVA);
		
		lblTotal = new JLabel("Total: ");
		lblTotal.setIcon(new ImageIcon("C:\\Users\\navar\\Downloads\\bruto.png"));
		lblTotal.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 12));
		lblTotal.setBounds(175, 424, 169, 34);
		getContentPane().add(lblTotal);
		
		JButton btnEliminarProducto = new JButton("Eliminar Producto");
		btnEliminarProducto.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 11));
		btnEliminarProducto.setBackground(new Color(198, 255, 198));
		btnEliminarProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminarProducto();
			}
		});
		btnEliminarProducto.setBounds(397, 165, 151, 23);
		getContentPane().add(btnEliminarProducto);
		
		JButton btnAgregarProductos = new JButton("Agregar Producto");
		btnAgregarProductos.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 11));
		btnAgregarProductos.setBackground(new Color(198, 255, 198));
		btnAgregarProductos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agregarProducto();
			}
		});
		btnAgregarProductos.setBounds(242, 165, 145, 23);
		getContentPane().add(btnAgregarProductos);
		
		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.setBackground(new Color(198, 255, 198));
		btnNuevo.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 11));
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirDeNuevo();
			}
		});
		btnNuevo.setBounds(10, 435, 89, 23);
		getContentPane().add(btnNuevo);

	}
	private void pedirDatos() {
		ListaCliente listaCliente = new ListaCliente(new JDialog(), 
				true, lblCedula, 
				lblNombres, 
				lblApellidos, 
				lblTelfono, 
				lblEmail, 
				lblDireccin);
		listaCliente.setVisible(true);
	}
	
	private void agregarProducto() {
		
			ListaProductos listaProductos = new ListaProductos(new JDialog(), 
					true, this.model, 
					this.productos, 
					this.lblSubtotal, 
					this.lblIVA, 
					this.lblTotal);
			listaProductos.setVisible(true);
		}

	private void eliminarProducto() {
	    EliminarProductos eliminarProducto = new EliminarProductos(new JDialog(),
	            true, this.model,
	            this.productos,
	            this.lblSubtotal,
	            this.lblIVA,
	            this.lblTotal);
	    eliminarProducto.setVisible(true);
	}

	private void abrirDeNuevo() {
		Container menuPrincipal = this.getParent();
		this.dispose();
		FrmFacturar frmFacturar = new FrmFacturar();
		frmFacturar.setVisible(true);
		menuPrincipal.add(frmFacturar);
	}
}