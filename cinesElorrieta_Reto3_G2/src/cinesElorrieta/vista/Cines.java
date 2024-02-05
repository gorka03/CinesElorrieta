package cinesElorrieta.vista;

import javax.swing.JPanel;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

import javax.swing.ImageIcon;

import java.awt.Font;
import java.awt.Color;
import javax.swing.border.LineBorder;

public class Cines {

	private JTable tablePeliculas;
	private JPanel panel = null;

	public Cines(ArrayList<JPanel> paneles) {

		panel = new JPanel();
		panel.setBounds(0, 0, 650, 470);
		panel.setBackground(new Color(255, 255, 255));
		panel.setLayout(null);

		JComboBox comboBoxCines = new JComboBox();
		comboBoxCines.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBoxCines.setBounds(40, 167, 142, 27);
		panel.add(comboBoxCines);

		JButton btnInicioSesion = new JButton("Login");
		btnInicioSesion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnInicioSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paneles.get(0).setVisible(false);
				paneles.get(1).setVisible(false);
				paneles.get(2).setVisible(true);
				paneles.get(3).setVisible(false);
				paneles.get(4).setVisible(false);
				paneles.get(5).setVisible(false);
			}
		});
		btnInicioSesion.setBounds(64, 374, 121, 27);
		panel.add(btnInicioSesion);

		JButton btnFin = new JButton("Finalizar");
		btnFin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paneles.get(0).setVisible(false);
				paneles.get(1).setVisible(false);
				paneles.get(2).setVisible(false);
				paneles.get(3).setVisible(false);
				paneles.get(4).setVisible(false);
				paneles.get(5).setVisible(false);

			}
		});
		btnFin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnFin.setBounds(487, 374, 106, 27);
		panel.add(btnFin);

		tablePeliculas = new JTable();
		tablePeliculas.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		tablePeliculas.setBounds(316, 106, 255, 190);
		panel.add(tablePeliculas);

		JButton btnVolver = new JButton("Volver ");
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Go to bienvenida ");
				panel.setVisible(false);

				paneles.get(0).setVisible(true);
				paneles.get(1).setVisible(false);
				paneles.get(2).setVisible(false);
				paneles.get(3).setVisible(false);
				paneles.get(4).setVisible(false);
				paneles.get(5).setVisible(false);

			}
		});
		btnVolver.setBounds(267, 378, 106, 27);
		panel.add(btnVolver);

		JLabel lblCarrito = new JLabel("New label");
		lblCarrito.setBounds(559, 23, 46, 14);
		panel.add(lblCarrito);

		ImageIcon imageIcon = new ImageIcon(this.getClass().getResource("h.png"));
		JLabel imgLabel = new JLabel("", imageIcon, JLabel.CENTER);
		imgLabel.setBounds(10, 11, 198, 81);
		imgLabel.setIcon(imageIcon);
		panel.add(imgLabel);

	}

	public JPanel getPanel() {
		return panel;
	}
}
