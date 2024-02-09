package ec.edu.puce.SistemaElectronico.formularios;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import ec.edu.puce.SistemaElectronico2.Mesa;
import javax.swing.ImageIcon;

public class PanelCrearMesa extends JInternalFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
    private JTextField txtNombreMesa;
    private JTable table;
    private DefaultTableModel model;
    private List<Mesa> mesas;

    public PanelCrearMesa(List<Mesa> mesas) {
    	getContentPane().setBackground(new Color(0, 0, 160));
    	setClosable(true);
        this.mesas = mesas;
        initComponents();
    }

    private void initComponents() {
        setTitle("CREAR MESAS");
        setBounds(100, 100, 600, 400);
        getContentPane().setLayout(null);

        JLabel lblNombreMesa = new JLabel("Ingrese la Mesa");
        lblNombreMesa.setBounds(50, 36, 150, 20);
        getContentPane().add(lblNombreMesa);

        txtNombreMesa = new JTextField();
        txtNombreMesa.setBounds(147, 36, 150, 20);
        getContentPane().add(txtNombreMesa);
        txtNombreMesa.setColumns(10);

        JButton btnAgregarMesa = new JButton("Guardar");
        btnAgregarMesa.setBackground(new Color(64, 128, 128));
        btnAgregarMesa.setBounds(307, 35, 150, 23);
        btnAgregarMesa.addActionListener(this);
        getContentPane().add(btnAgregarMesa);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(147, 101, 381, 173);
        getContentPane().add(scrollPane);

        table = new JTable();
        model = new DefaultTableModel(new Object[][]{}, new String[]{"Mesa"});
        table.setModel(model);
        scrollPane.setViewportView(table);
        
        JButton btnNewButton = new JButton("Nuevo");
        btnNewButton.setIcon(new ImageIcon("C:\\Users\\navar\\Downloads\\agregar-archivo (1).png"));
        btnNewButton.setBackground(new Color(64, 128, 128));
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
				limpiarCampos();

        	}
        });
        btnNewButton.setBounds(474, 35, 89, 23);
        getContentPane().add(btnNewButton);

        // Mostrar las mesas ya guardadas en la tabla al inicializar el panel
        mostrarMesas();
    }

    private void mostrarMesas() {
        for (Mesa mesa : mesas) {
            Object[] row = {mesa.getnombreMesa()};
            model.addRow(row);
        }
    }

    private void limpiarCampos() {
		txtNombreMesa.setText("");
	}

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Agregar Mesa")) {
            String nombreMesa = txtNombreMesa.getText();
            Mesa nuevaMesa = new Mesa();
            nuevaMesa.setnombreMesa(nombreMesa);
            mesas.add(nuevaMesa);
            Object[] row = {nombreMesa};
            model.addRow(row);
            txtNombreMesa.setText("");
        }
    }
}


