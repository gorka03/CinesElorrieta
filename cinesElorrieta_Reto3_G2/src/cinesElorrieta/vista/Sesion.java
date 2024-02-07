package cinesElorrieta.vista;

import java.awt.Color;

import java.util.ArrayList;

import javax.swing.JButton;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.LineBorder;

public class Sesion {

	private JTable tableSesion;
	private JPanel panel = null;
	private JTable table;

	public Sesion(ArrayList<JPanel> panelesCine) {
		panel = new JPanel();
		panel.setBounds(0, 0, 650, 470);

		panel.setBackground(new Color(255, 255, 255));
		panel.setLayout(null);

		tableSesion = new JTable();
		tableSesion.setBounds(194, 16, 0, 0);
		panel.add(tableSesion);

		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(96, 381, 63, 23);
		panel.add(btnVolver);

		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBounds(467, 381, 79, 23);
		panel.add(btnConfirmar);

		JLabel lblLogo = new JLabel("Logo");
		lblLogo.setBounds(21, 16, 23, 14);
		panel.add(lblLogo);
		
		table = new JTable();
		table.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		table.setBounds(96, 85, 450, 266);
		panel.add(table);
	}

	public JPanel getPanel() {
		// TODO Auto-generated method stub
		return panel;
	}
}
