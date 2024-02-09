package ec.edu.puce.SistemaElectronico.formularios;


import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JInternalFrame;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import ec.edu.puce.SistemaElectronico2.Candidato;

import java.awt.*;
import java.util.List;

public class ResultadosGenerales extends JInternalFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    private DefaultTableModel model;

    public ResultadosGenerales(List<Candidato> candidatos) {
    	getContentPane().setBackground(new Color(128, 128, 128));
    	setClosable(true);
        setTitle("RESULTADOS GENERALES");
        setBounds(100, 100, 547, 465);
        getContentPane().setLayout(null);

        JTable table = new JTable();
        model = new DefaultTableModel(new Object[][]{}, new String[]{"CANDIDATO", "VOTOS FINALES"});
        table.setModel(model);

        for (Candidato candidato : candidatos) {
            model.addRow(new Object[]{candidato.getNombreCandidato(), candidato.getVotos()});
        }

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 10, 511, 405);
        getContentPane().add(scrollPane);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}



