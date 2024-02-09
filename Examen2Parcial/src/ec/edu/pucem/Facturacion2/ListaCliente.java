package ec.edu.pucem.Facturacion2;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class ListaCliente extends JDialog {

    private static final long serialVersionUID = 1L;
    private final JPanel contentPanel = new JPanel();
    private JTable table;
    private DefaultTableModel model;
    private int indiceCliente = -1;

    public ListaCliente(Dialog owner, boolean modal, ArrayList<Cliente> clientes, JLabel lblCedula, JLabel lblNombres, JLabel lblApellidos, JLabel lblTelefono, JLabel lblEmail, JLabel lblDireccion) {
        super(owner, modal);
        getContentPane().setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 11));
        getContentPane().setBackground(new Color(239, 109, 78));
        setBounds(100, 100, 572, 300);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBackground(new Color(198, 255, 198));
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 11, 416, 208);
        contentPanel.add(scrollPane);

        table = new JTable();
        table.setBackground(new Color(255, 255, 128));
        table.setModel(new DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "Cedula", "Nombres", "Apellidos", "Tel\u00E9fono", "Email", "Direcci\u00F3n"
                }
        ));
        scrollPane.setViewportView(table);
        model = (DefaultTableModel) table.getModel();

        if (!clientes.isEmpty()) {
            agregarClientes(clientes);
        }

        JPanel buttonPane = new JPanel();
        buttonPane.setBackground(new Color(251, 220, 157));
        buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
        getContentPane().add(buttonPane, BorderLayout.SOUTH);

        JButton okButton = new JButton("OK");
        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                enviarCliente(lblCedula, lblNombres, lblApellidos, lblTelefono, lblEmail, lblDireccion);
            }
        });
        okButton.setActionCommand("OK");
        buttonPane.add(okButton);

        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        cancelButton.setActionCommand("Cancel");
        buttonPane.add(cancelButton);
    }

    private void agregarClientes(ArrayList<Cliente> clientes) {
        for (Cliente cliente : clientes) {
            Object[] fila = new Object[6];
            fila[0] = cliente.getCedula();
            fila[1] = cliente.getNombres();
            fila[2] = cliente.getApellidos();
            fila[3] = cliente.getTelefono();
            fila[4] = cliente.getEmail();
            fila[5] = cliente.getDireccion();
            this.model.addRow(fila);
        }
    }

    private void enviarCliente(JLabel lblCedula, JLabel lblNombres, JLabel lblApellidos, JLabel lblTelefono, JLabel lblEmail, JLabel lblDireccion) {
        if (this.indiceCliente == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione un cliente", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        lblCedula.setText("Cédula: " + model.getValueAt(indiceCliente, 0).toString());
        lblNombres.setText("Nombres: " + model.getValueAt(indiceCliente, 1).toString());
        lblApellidos.setText("Apellidos: " + model.getValueAt(indiceCliente, 2).toString());
        lblTelefono.setText("Teléfono: " + model.getValueAt(indiceCliente, 3).toString());
        lblEmail.setText("Email: " + model.getValueAt(indiceCliente, 4).toString());
        lblDireccion.setText("Dirección: " + model.getValueAt(indiceCliente, 5).toString());
        dispose();
    }
}
