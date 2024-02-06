package cinesElorrieta.vista;

import java.awt.Color;

import java.util.ArrayList;

import javax.swing.JButton;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

public class Sesion {

	private JTable tableSesion;
	private JPanel panel = null;

	public Sesion(ArrayList<JPanel> panelesCine) {
		panel = new JPanel();
		panel.setBounds(0, 0, 650, 470);

		panel.setBackground(new Color(255, 255, 255));

		tableSesion = new JTable();
		tableSesion.setBounds(92, 86, 246, 91);
		panel.add(tableSesion);

		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(96, 209, 89, 23);
		panel.add(btnVolver);

		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBounds(249, 209, 89, 23);
		panel.add(btnConfirmar);

		JLabel lblLogo = new JLabel("Logo");
		lblLogo.setBounds(10, 11, 46, 14);
		panel.add(lblLogo);

		JLabel lblFoto = new JLabel("Foto");
		lblFoto.setBounds(379, 11, 46, 14);
		panel.add(lblFoto);

		JLabel lblNombrePeli = new JLabel("Peli nombre");
		lblNombrePeli.setBounds(132, 40, 160, 14);
		panel.add(lblNombrePeli);
	}

	public JPanel getPanel() {
		// TODO Auto-generated method stub
		return panel;
	}

}
