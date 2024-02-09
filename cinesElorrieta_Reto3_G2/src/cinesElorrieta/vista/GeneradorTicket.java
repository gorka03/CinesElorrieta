package cinesElorrieta.vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class GeneradorTicket {
	private JPanel panel = null;
	private JTable table;

	public GeneradorTicket(ArrayList<JPanel> paneles) {
		panel = new JPanel();
		panel.setBounds(0, 0, 650, 470);
		panel.setBackground(new Color(255, 255, 255));

		ImageIcon imageLogo = new ImageIcon(this.getClass().getResource("logo.png"));
		panel.setLayout(null);
		JLabel imgLogo = new JLabel("", imageLogo, JLabel.CENTER);
		imgLogo.setBounds(10, 11, 198, 81);
		imgLogo.setIcon(imageLogo);
		panel.add(imgLogo);

		table = new JTable();
		table.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		table.setBounds(120, 116, 446, 258);
		panel.add(table);

		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paneles.get(6).setVisible(false);
				paneles.get(0).setVisible(true);
			}
		});
		btnConfirmar.setBounds(443, 398, 123, 23);
		panel.add(btnConfirmar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paneles.get(1).setVisible(true);
				paneles.get(4).setVisible(false);
			}
		});
		btnCancelar.setBounds(120, 398, 117, 23);
		panel.add(btnCancelar);

		JLabel lblAgradecimiento = new JLabel("\"Gracias por su compra\"");
		lblAgradecimiento.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAgradecimiento.setBounds(334, 49, 198, 54);
		panel.add(lblAgradecimiento);
	}

	public JPanel getPanel() {
		return panel;
	}
}