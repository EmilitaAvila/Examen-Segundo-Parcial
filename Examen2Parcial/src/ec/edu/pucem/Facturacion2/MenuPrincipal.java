package ec.edu.pucem.Facturacion2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JDesktopPane;
import java.awt.Font;
import java.awt.Color;
import java.awt.Window.Type;
import javax.swing.ImageIcon;

public class MenuPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private FrmClientes frmCliente;
	private FrmProductos frmProducto;
	private FrmFacturar frmFacturar;
	private JDesktopPane desktopPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal frame = new MenuPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MenuPrincipal() {
		setType(Type.POPUP);
		setBackground(new Color(255, 255, 255));
		setTitle("Sistema de facturación");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 675, 454);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		menuBar.setBackground(new Color(205, 137, 250));
		setJMenuBar(menuBar);
		
		JMenu mnArchivo = new JMenu("Archivo");
		mnArchivo.setIcon(new ImageIcon("C:\\Users\\navar\\Downloads\\carpeta.png"));
		mnArchivo.setBackground(new Color(255, 128, 192));
		mnArchivo.setFont(new Font("MS PGothic", Font.BOLD | Font.ITALIC, 11));
		menuBar.add(mnArchivo);
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.setBackground(new Color(255, 128, 192));
		mntmSalir.setFont(new Font("Goudy Old Style", Font.ITALIC, 10));
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cerrarVentana();
			}
		});
		mnArchivo.add(mntmSalir);
		
		JMenu mnClientes = new JMenu("Clientes");
		mnClientes.setIcon(new ImageIcon("C:\\Users\\navar\\Downloads\\compras.png"));
		mnClientes.setBackground(new Color(255, 128, 192));
		mnClientes.setFont(new Font("MS PGothic", Font.BOLD | Font.ITALIC, 11));
		menuBar.add(mnClientes);
		
		JMenuItem mntmNuevoCliente = new JMenuItem("Nuevo Cliente");
		mntmNuevoCliente.setBackground(new Color(255, 128, 192));
		mntmNuevoCliente.setFont(new Font("Goudy Old Style", Font.ITALIC, 10));
		mntmNuevoCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirFrmCliente();
			}
		});
		mnClientes.add(mntmNuevoCliente);
		
		JMenu mnProductos = new JMenu("Productos");
		mnProductos.setIcon(new ImageIcon("C:\\Users\\navar\\Downloads\\carrito-de-supermercado.png"));
		mnProductos.setBackground(new Color(255, 128, 192));
		mnProductos.setFont(new Font("MS PGothic", Font.BOLD | Font.ITALIC, 11));
		menuBar.add(mnProductos);
		
		JMenuItem mntmNuevoProducto = new JMenuItem("Nuevo Producto");
		mntmNuevoProducto.setBackground(new Color(255, 128, 192));
		mntmNuevoProducto.setFont(new Font("Goudy Old Style", Font.ITALIC, 10));
		mntmNuevoProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirFrmProducto();
			}
		});
		mnProductos.add(mntmNuevoProducto);
		
		JMenu mnFacturas = new JMenu("Facturas");
		mnFacturas.setBackground(new Color(255, 128, 192));
		mnFacturas.setFont(new Font("MS PGothic", Font.BOLD | Font.ITALIC, 11));
		menuBar.add(mnFacturas);
		
		JMenuItem mntmFacturar = new JMenuItem("Facturar");
		mntmFacturar.setBackground(new Color(255, 128, 192));
		mntmFacturar.setFont(new Font("Goudy Old Style", Font.ITALIC, 10));
		mntmFacturar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirFrmFacturar();
			}
		});
		mnFacturas.add(mntmFacturar);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(207, 158, 158));
		contentPane.add(desktopPane, "name_335641104678300");
	}
	
	private void cerrarVentana() {
		this.dispose();
	}
	
	private void abrirFrmCliente() {
		if (this.frmCliente == null) {
			this.frmCliente = new FrmClientes();
			this.desktopPane.add(frmCliente);
			this.frmCliente.setVisible(true);
		} else if (!this.frmCliente.isVisible()){
			this.frmCliente.setVisible(true);
		} else {
			this.frmCliente.toFront();
		}
	}
	
	private void abrirFrmProducto() {
		if (this.frmProducto == null) {
			this.frmProducto = new FrmProductos();
			this.desktopPane.add(frmProducto);
			this.frmProducto.setVisible(true);
		} else if (!this.frmProducto.isVisible()){
			this.frmProducto.setVisible(true);
		} else {
			this.frmProducto.toFront();
		}
	}
	
	private void abrirFrmFacturar() {
		if (this.frmFacturar == null || this.frmFacturar.isClosed()) {
			this.frmFacturar = new FrmFacturar();
			this.desktopPane.add(frmFacturar);
			this.frmFacturar.setVisible(true);
		}  else {
			this.frmFacturar.toFront();
		}
	}
}