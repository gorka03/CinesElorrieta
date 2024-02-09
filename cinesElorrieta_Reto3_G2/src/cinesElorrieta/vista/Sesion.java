package cinesElorrieta.vista;

import java.awt.Color;

import java.util.ArrayList;

import javax.swing.JButton;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import cinesElorrieta.gestores.GestorDeSesiones;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Sesion {
	private JPanel panel = null;
	private JTable tableSesion;

	public Sesion(ArrayList<JPanel> paneles) {
		panel = new JPanel();
		panel.setBounds(0, 0, 650, 470);

		panel.setBackground(new Color(255, 255, 255));
		panel.setLayout(null);

		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				paneles.get(1).setVisible(true);
				paneles.get(2).setVisible(false);

			}
		});
		btnVolver.setBounds(96, 381, 63, 23);
		panel.add(btnVolver);

		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int opcion = JOptionPane.showConfirmDialog(null, "Mensaje", "Titulo del Diálogo", JOptionPane.YES_NO_OPTION);
				if (opcion == JOptionPane.YES_OPTION) {
					
					String loSeleccionado;
					String lodelaotrapantall = null;
					
				//	GestorDeSesiones gestorDeSesiones = new GestorDeSesiones();
					//gestorDeSesiones.insert (loSeleccionado, lodelaotrapantall);
					
					JOptionPane.showMessageDialog(null, "Guardado correctamente ");
					paneles.get(2).setVisible(false);
					paneles.get(1).setVisible(true);
				}else {
					System.out.println("");
				}

			}
		});
		btnConfirmar.setBounds(467, 381, 79, 23);
		panel.add(btnConfirmar);

		JLabel lblLogo = new JLabel("Logo");
		lblLogo.setBounds(21, 16, 23, 14);
		panel.add(lblLogo);

		tableSesion = new JTable();
		tableSesion.setModel(new DefaultTableModel(
				new Object[][] { { null, null }, { null, null }, { null, null }, { null, null }, },
				new String[] { "Sesion", "Hora" }));
		tableSesion.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		tableSesion.setBounds(96, 85, 450, 266);
		panel.add(tableSesion);

	}

	public JPanel getPanel() {
		// TODO Auto-generated method stub
		return panel;
	}
}
