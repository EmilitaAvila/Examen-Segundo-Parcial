package ec.edu.puce.SistemaElectronico.formularios;
import javax.swing.*;

import ec.edu.puce.SistemaElectronico2.Estudiante;

import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class Sufragar extends JInternalFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    private JTextField textFieldCedula;
    private MenuPrincipal menuprincipal;

    public Sufragar(final MenuPrincipal menuprincipal) {
    	getContentPane().setBackground(new Color(0, 0, 160));
    	setClosable(true);
        this.menuprincipal = menuprincipal;

        setTitle("INGRESE CEDULA");
        setBounds(100, 100, 450, 300);
        getContentPane().setLayout(null);

        JLabel lblIngreseCedula = new JLabel("Estudiante, ingrese su cédula");
        lblIngreseCedula.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblIngreseCedula.setBounds(93, 41, 240, 22);
        getContentPane().add(lblIngreseCedula);

        textFieldCedula = new JTextField();
        textFieldCedula.setBackground(new Color(192, 192, 192));
        textFieldCedula.setFont(new Font("Tahoma", Font.PLAIN, 18));
        textFieldCedula.setBounds(93, 106, 258, 36);
        getContentPane().add(textFieldCedula);
        textFieldCedula.setColumns(10);

        JButton btnENTRAR = new JButton("ENTRAR");
        btnENTRAR.setBackground(new Color(0, 255, 255));
        btnENTRAR.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	    String cedulaIngresada = textFieldCedula.getText().trim();
        	    List<Estudiante> estudiantes = menuprincipal.getEstudiantes();
        	    Estudiante estudianteEncontrado = null;
        	    for (Estudiante estudiante : estudiantes) {
        	        if (estudiante.getCedulaEstudiante().equals(cedulaIngresada)) {
        	            estudianteEncontrado = estudiante;
        	            break;
        	        }
        	    }
        	    if (estudianteEncontrado != null) {
        	        dispose();
        	        menuprincipal.abrirSufragar1(cedulaIngresada);
        	    } else {
        	        JOptionPane.showMessageDialog(null, "ERROR, CEDULA NO ENCONTRADA", "Error", JOptionPane.ERROR_MESSAGE);
        	    }
        	}

        });
        btnENTRAR.setFont(new Font("Tahoma", Font.PLAIN, 19));
        btnENTRAR.setBounds(142, 182, 133, 23);
        getContentPane().add(btnENTRAR);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
   
    }
}
