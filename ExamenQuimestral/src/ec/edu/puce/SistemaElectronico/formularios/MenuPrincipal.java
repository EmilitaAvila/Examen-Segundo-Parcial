package ec.edu.puce.SistemaElectronico.formularios;
import java.awt.EventQueue;
import javax.management.loading.PrivateClassLoader;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

import ec.edu.puce.SistemaElectronico2.Candidato;
import ec.edu.puce.SistemaElectronico2.Curso;
import ec.edu.puce.SistemaElectronico2.Estudiante;
import ec.edu.puce.SistemaElectronico2.Mesa;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;

public class MenuPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private List <Candidato> candidatos;
	private List <Curso> cursos;
	private List <Estudiante> estudiantes;
	private List<Estudiante> estudiantesMesa;
	private List <Mesa> mesas;
	
    private Map<Estudiante, Mesa> asignacionesDeMesa;
    private Estudiante estudiante;
    
    private Map<String, Candidato> votosPorEstudiante;


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

	
	public MenuPrincipal() {
		setBackground(new Color(128, 128, 128));
		
		candidatos = new ArrayList<>(); 
		cursos = new ArrayList<>(); 
		estudiantes = new ArrayList<>();
		mesas = new ArrayList<>(); 
		estudiantesMesa = new ArrayList<>();
        asignacionesDeMesa = new HashMap<>();

        this.votosPorEstudiante = new HashMap<>();

		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 872, 697);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(128, 128, 128));
		menuBar.setForeground(new Color(192, 192, 192));
		setJMenuBar(menuBar);
		
		JMenu mnArchivo = new JMenu("ARCHIVO");
		mnArchivo.setBackground(new Color(255, 128, 64));
		mnArchivo.setForeground(new Color(0, 0, 0));
		menuBar.add(mnArchivo);
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.setIcon(new ImageIcon("C:\\Users\\navar\\Downloads\\cerrar-sesion (2).png"));
		mntmSalir.setBackground(new Color(128, 128, 128));
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 dispose();
			}
		});
		mnArchivo.add(mntmSalir);
		
		JMenu mnAdministracion = new JMenu("ADMINISTRACIÓN");
		mnAdministracion.setBackground(new Color(255, 128, 64));
		mnAdministracion.setForeground(new Color(0, 0, 0));
		menuBar.add(mnAdministracion);
		
		JMenuItem mntmMesas = new JMenuItem("Mesas");
		mntmMesas.setIcon(new ImageIcon("C:\\Users\\navar\\Downloads\\tabla.png"));
		mntmMesas.setBackground(new Color(128, 128, 128));
		mntmMesas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				EleccionMesas EleccionMesas = new EleccionMesas(mesas, estudiantes);
		        contentPane.add(EleccionMesas);
		        EleccionMesas.setVisible(true);
				
			}
		});
		mnAdministracion.add(mntmMesas);
		
		JMenuItem mntmCursos = new JMenuItem("Cursos");
		mntmCursos.setIcon(new ImageIcon("C:\\Users\\navar\\Downloads\\elearning.png"));
		mntmCursos.setBackground(new Color(128, 128, 128));
		mntmCursos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 PanelCurso panelCurso = new PanelCurso(cursos);
			        contentPane.add(panelCurso);
			        panelCurso.setVisible(true);
			}
		});
		mnAdministracion.add(mntmCursos);
		
		JMenuItem mntmEstudiantes = new JMenuItem("Estudiantes");
		mntmEstudiantes.setIcon(new ImageIcon("C:\\Users\\navar\\Downloads\\estudiantes (1).png"));
		mntmEstudiantes.setBackground(new Color(128, 128, 128));
		mntmEstudiantes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				  CrearEstudiante CrearEstudiante = new CrearEstudiante(cursos , estudiantes);
			        contentPane.add(CrearEstudiante);
			        CrearEstudiante.setVisible(true);
				
			}
		});
		mnAdministracion.add(mntmEstudiantes);
		
		JMenuItem mntmCandidatos = new JMenuItem("Candidatos");
		mntmCandidatos.setIcon(new ImageIcon("C:\\Users\\navar\\Downloads\\tocon.png"));
		mntmCandidatos.setBackground(new Color(128, 128, 128));
		mntmCandidatos.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        PanelCandidatos_ panelCandidatos_ = new PanelCandidatos_(candidatos);
		        contentPane.add(panelCandidatos_);
		        panelCandidatos_.setVisible(true);
		    }
		});
		

		mnAdministracion.add(mntmCandidatos);
		
		
		mnAdministracion.add(mntmCandidatos);
		
		JMenu mnProceso = new JMenu("PROCESO");
		mnProceso.setBackground(new Color(255, 128, 64));
		mnProceso.setForeground(new Color(0, 0, 0));
		menuBar.add(mnProceso);
		
		JMenuItem mntmSufragar = new JMenuItem("Sufragar");
		mntmSufragar.setIcon(new ImageIcon("C:\\Users\\navar\\Downloads\\votar (2).png"));
		mntmSufragar.setBackground(new Color(128, 128, 128));
		mntmSufragar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				Sufragar sufragar = new Sufragar(MenuPrincipal.this);
		        contentPane.add(sufragar);
		        sufragar.setVisible(true);
				
			}
		});
		mnProceso.add(mntmSufragar);
		
				
		JMenu mnReportes = new JMenu("REPORTES");
		mnReportes.setForeground(new Color(0, 0, 0));
		menuBar.add(mnReportes);
		
		JMenuItem mntmPadron = new JMenuItem("Padrón Electoral");
		mntmPadron.setIcon(new ImageIcon("C:\\Users\\navar\\Downloads\\reporte-de-negocios (1).png"));
		mntmPadron.setBackground(new Color(128, 128, 128));
		mntmPadron.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PadronElectoral panelPadronElectoral = new PadronElectoral(
						mesas,
						estudiantes,
						estudiantesMesa);
				contentPane.add(panelPadronElectoral);
				panelPadronElectoral.setVisible(true);
			}
		});
		mnReportes.add(mntmPadron);
		
		JMenuItem mntmResultadosGenerales = new JMenuItem("Resultados Generales");
		mntmResultadosGenerales.setIcon(new ImageIcon("C:\\Users\\navar\\Downloads\\candidato (1).png"));
		mntmResultadosGenerales.setBackground(new Color(128, 128, 128));
		mntmResultadosGenerales.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ResultadosGenerales resultadosGenerales = new ResultadosGenerales(candidatos);
		        contentPane.add(resultadosGenerales);
		        resultadosGenerales.setVisible(true);
			}
		});
		mnReportes.add(mntmResultadosGenerales);
		
		JMenuItem mntmResultadosPorMesas = new JMenuItem("Resultados por Mesas");
		mntmResultadosPorMesas.setIcon(new ImageIcon("C:\\Users\\navar\\Downloads\\reunion.png"));
		mntmResultadosPorMesas.setBackground(new Color(128, 128, 128));
		mntmResultadosPorMesas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ResultadoMesa resultadosMesas = new ResultadoMesa(candidatos, mesas);
		        contentPane.add(resultadosMesas);
		        resultadosMesas.setVisible(true);
			}
		});
		mnReportes.add(mntmResultadosPorMesas);
		
		JMenuItem mntmResultadosEnGrfico = new JMenuItem("Resultados en Gráfico");
		mntmResultadosEnGrfico.setIcon(new ImageIcon("C:\\Users\\navar\\Downloads\\grafico-de-barras (2).png"));
		mntmResultadosEnGrfico.setBackground(new Color(255, 128, 64));
		mntmResultadosEnGrfico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Graficos Graficos = new Graficos(candidatos);
		        contentPane.add(Graficos);
		        Graficos.setVisible(true);
			}
		});
		mnReportes.add(mntmResultadosEnGrfico);
		
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 255, 64));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
	}

	
	void abrirSufragar1(String cedulaEstudiante) {
	    SufragarP1 sufragarP1 = new SufragarP1(this, cedulaEstudiante);
	    sufragarP1.setLocation(100, 100);
	    contentPane.add(sufragarP1);
	    sufragarP1.setVisible(true);
	}


void abrirSufragar2() {
    
    SufragarP2 sufragarP2 = new SufragarP2();

    sufragarP2.setLocation(100, 100);

    contentPane.add(sufragarP2);
    sufragarP2.setVisible(true);
}

public List<Estudiante> getEstudiantes() {
    return estudiantes;
}

public Mesa getMesaDeEstudiante(Estudiante estudiante) {
    return asignacionesDeMesa.get(estudiante);
}

public Mesa getMesaPorNombre(String nombreMesa) {
    for (Mesa mesa : mesas) {
        if (mesa.getnombreMesa().equals(nombreMesa)) {
            return mesa;
        }
    }
    return null; 
}

public void asignarMesaAEstudiante(Estudiante estudiante, Mesa mesa) {
    asignacionesDeMesa.put(estudiante, mesa);
}


public List<Candidato> getCandidatos() {
    return candidatos;
}

public void registrarVoto(String cedulaEstudiante, Candidato candidato) {
    votosPorEstudiante.put(cedulaEstudiante, candidato);
}

public boolean estudianteYaVoto(String cedulaEstudiante) {
    return votosPorEstudiante.containsKey(cedulaEstudiante);
}

public Candidato getCandidatoVotadoPorEstudiante(String cedulaEstudiante) {
    return votosPorEstudiante.get(cedulaEstudiante);
}

}

