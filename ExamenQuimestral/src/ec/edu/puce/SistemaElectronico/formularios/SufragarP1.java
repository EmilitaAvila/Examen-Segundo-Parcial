package ec.edu.puce.SistemaElectronico.formularios;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

import ec.edu.puce.SistemaElectronico2.Candidato;
import ec.edu.puce.SistemaElectronico2.Estudiante;

import java.awt.Color;


public class SufragarP1 extends JInternalFrame {
    
    private static final long serialVersionUID = 1L;
    private MenuPrincipal menuprincipal;
    private Estudiante estudiante;
    
    public SufragarP1(final MenuPrincipal menuprincipal, final String cedulaEstudiante) {
    	getContentPane().setBackground(new Color(128, 0, 255));
    	setClosable(true);
        this. menuprincipal = menuprincipal;
        this.estudiante = buscarEstudiantePorCedula(cedulaEstudiante);
        
        setTitle("BIENVENIDO");
        setBounds(100, 100, 626, 389);
        getContentPane().setLayout(null);
        
        JLabel lblHolaEstudiante = new JLabel("Hola "+estudiante.getNombreEstudiante());
        lblHolaEstudiante.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblHolaEstudiante.setBounds(25, 11, 219, 30);
        getContentPane().add(lblHolaEstudiante);
        
        JLabel lblMesa = new JLabel("Tu mesa es "+estudiante.getMesaDelEstudiante().getnombreMesa());
        lblMesa.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblMesa.setBounds(381, 11, 219, 30);
        getContentPane().add(lblMesa);
        
        JLabel lblEscoga = new JLabel("Escoge tu candidato.");
        lblEscoga.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblEscoga.setBounds(25, 39, 219, 30);
        getContentPane().add(lblEscoga);
        
        int y = 80;
        for (final Candidato candidato : menuprincipal.getCandidatos()) {
            if (!menuprincipal.estudianteYaVoto(cedulaEstudiante)) { 
                JButton btnCandidato = new JButton(candidato.getNombreCandidato());
                btnCandidato.setBounds(25, y, 200, 30);
                getContentPane().add(btnCandidato);
                y += 40;
                
                btnCandidato.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        menuprincipal.registrarVoto(cedulaEstudiante, candidato);
                       
                        estudiante.setCandidatoVotado(candidato);

                        candidato.aumentarVotos();

                        JOptionPane.showMessageDialog(null, "¡Voto registrado para " + candidato.getNombreCandidato() + "!");
                        dispose();
                        menuprincipal.abrirSufragar2();
                    }
                });
                
               

            } else {
                JLabel lblYaVoto = new JLabel("Usted ya ha votado");
                lblYaVoto.setBounds(25, y, 200, 30);
                getContentPane().add(lblYaVoto);
            }
        }
    }
    
    private Estudiante buscarEstudiantePorCedula(String cedulaEstudiante) {
        for (Estudiante estudiante : menuprincipal.getEstudiantes()) {
            if (estudiante.getCedulaEstudiante().equals(cedulaEstudiante)) {
                return estudiante;
            }
        }
        return null; 
    }
}




