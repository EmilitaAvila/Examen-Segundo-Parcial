package ec.edu.pucem.Facturacion2;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class FrmProductos extends JInternalFrame {

    private static final long serialVersionUID = 1L;
    private JTextField txtIdProducto;
    private JTextField txtDescripcion;
    private JTextField txtPrecio;
    private JTextField txtCantidad;
    private static ArrayList<Productos> productos = new ArrayList<Productos>();
    private JButton btnGuardar;
    private JTable table;
    private DefaultTableModel model;

    public FrmProductos() {
        getContentPane().setBackground(new Color(191, 191, 255));
        setTitle("Agregar Productos");
        setBounds(100, 100, 450, 500);
        getContentPane().setLayout(null);

        JLabel lblIdProducto = new JLabel("Id");
        lblIdProducto.setIcon(new ImageIcon("C:\\Users\\navar\\Downloads\\tarjeta-de-identificacion (1).png"));
        lblIdProducto.setFont(new Font("MS PGothic", Font.BOLD | Font.ITALIC, 11));
        lblIdProducto.setBounds(39, 21, 118, 27);
        getContentPane().add(lblIdProducto);

        JLabel lblDescripcion = new JLabel("Descripción");
        lblDescripcion.setIcon(new ImageIcon("C:\\Users\\navar\\Downloads\\reanudar.png"));
        lblDescripcion.setFont(new Font("MS PGothic", Font.BOLD | Font.ITALIC, 11));
        lblDescripcion.setBounds(39, 65, 88, 20);
        getContentPane().add(lblDescripcion);

        JLabel lblPrecio = new JLabel("Precio");
        lblPrecio.setIcon(new ImageIcon("C:\\Users\\navar\\Downloads\\etiqueta-del-precio.png"));
        lblPrecio.setFont(new Font("MS PGothic", Font.BOLD | Font.ITALIC, 11));
        lblPrecio.setBounds(39, 104, 88, 14);
        getContentPane().add(lblPrecio);

        JLabel lblCantidad = new JLabel("Cantidad");
        lblCantidad.setIcon(new ImageIcon("C:\\Users\\navar\\Downloads\\cajas.png"));
        lblCantidad.setFont(new Font("MS PGothic", Font.BOLD | Font.ITALIC, 11));
        lblCantidad.setBounds(39, 143, 88, 14);
        getContentPane().add(lblCantidad);

        txtIdProducto = new JTextField();
        txtIdProducto.setFont(new Font("Goudy Old Style", Font.ITALIC, 11));
        txtIdProducto.setBounds(119, 25, 260, 20);
        getContentPane().add(txtIdProducto);
        txtIdProducto.setColumns(10);

        txtDescripcion = new JTextField();
        txtDescripcion.setFont(new Font("Goudy Old Style", Font.ITALIC, 11));
        txtDescripcion.setColumns(10);
        txtDescripcion.setBounds(119, 64, 260, 20);
        getContentPane().add(txtDescripcion);

        txtPrecio = new JTextField();
        txtPrecio.setFont(new Font("Goudy Old Style", Font.ITALIC, 11));
        txtPrecio.setColumns(10);
        txtPrecio.setBounds(119, 103, 260, 20);
        getContentPane().add(txtPrecio);

        txtCantidad = new JTextField();
        txtCantidad.setFont(new Font("Goudy Old Style", Font.ITALIC, 11));
        txtCantidad.setColumns(10);
        txtCantidad.setBounds(119, 142, 260, 20);
        getContentPane().add(txtCantidad);

        JButton btnNuevo = new JButton("Nuevo");
        btnNuevo.setIcon(new ImageIcon("C:\\Users\\navar\\Downloads\\agregar-archivo.png"));
        btnNuevo.setBackground(new Color(202, 255, 202));
        btnNuevo.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 12));
        btnNuevo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                limpiarCampos();
            }
        });
        btnNuevo.setBounds(48, 190, 96, 23);
        getContentPane().add(btnNuevo);

        btnGuardar = new JButton("Guardar");
        btnGuardar.setIcon(new ImageIcon("C:\\Users\\navar\\Downloads\\salvar.png"));
        btnGuardar.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 11));
        btnGuardar.setBackground(new Color(202, 255, 202));
        btnGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                crearProducto();
            }
        });
        btnGuardar.setBounds(165, 191, 105, 23);
        getContentPane().add(btnGuardar);

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setIcon(new ImageIcon("C:\\Users\\navar\\Downloads\\cerrar.png"));
        btnCancelar.setBackground(new Color(202, 255, 202));
        btnCancelar.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 11));
        btnCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cerrarVentana();
            }
        });
        btnCancelar.setBounds(293, 191, 111, 23);
        getContentPane().add(btnCancelar);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(45, 224, 359, 218);
        getContentPane().add(scrollPane);

        table = new JTable();
        table.setBackground(new Color(192, 192, 192));
        table.setModel(new DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "Id", "Descripción", "Precio", "Cantidad", "Total"
                }
        ));
        scrollPane.setViewportView(table);
        model = (DefaultTableModel) table.getModel();
    }

    private void limpiarCampos() {
        txtIdProducto.setText("");
        txtDescripcion.setText("");
        txtPrecio.setText("");
        txtCantidad.setText("");
    }

    private void cerrarVentana() {
        setVisible(false);
    }

    private void crearProducto() {
        try {
            String idProducto = txtIdProducto.getText();
            String descripcion = txtDescripcion.getText();
            String precioText = txtPrecio.getText();
            String cantidadText = txtCantidad.getText();

            if (idProducto.isEmpty() || descripcion.isEmpty() || precioText.isEmpty() || cantidadText.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            double precio = Double.parseDouble(precioText);
            int cantidad = Integer.parseInt(cantidadText);

            Productos producto = new Productos(idProducto, descripcion, precio, cantidad);
            productos.add(producto);

            // Agregar la fila a la tabla
            agregarFila(producto);

            System.out.println("Producto creado y fila agregada correctamente.");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Error al convertir datos numéricos", "Error", JOptionPane.ERROR_MESSAGE);
            System.err.println("Error al convertir datos numéricos: " + ex.getMessage());
            ex.printStackTrace();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error durante la creación del producto", "Error", JOptionPane.ERROR_MESSAGE);
            System.err.println("Error durante la creación del producto: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    private void agregarFila(Productos producto) {
        try {
            Object[] fila = new Object[5];
            fila[0] = producto.getIdProducto();
            fila[1] = producto.getDescripcion();
            fila[2] = producto.getPrecio();
            fila[3] = producto.getCantidad();
            fila[4] = producto.getTotal();
            model.addRow(fila);

            // Refrescar la tabla
            table.repaint();
            table.revalidate();

            System.out.println("Fila agregada a la tabla correctamente.");
        } catch (Exception ex) {
            System.err.println("Error al agregar fila a la tabla: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    public static ArrayList<Productos> getProductos() {
        return productos;
    }
}
