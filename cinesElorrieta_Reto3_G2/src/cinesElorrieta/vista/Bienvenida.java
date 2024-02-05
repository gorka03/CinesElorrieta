package cinesElorrieta.vista;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JLabel;
import java.awt.Color;

public class Bienvenida {

	private JPanel panel = null;

	public Bienvenida(ArrayList<JPanel> paneles) {

		panel = new JPanel();
		panel.setBounds(0, 0, 650, 470);

		panel.setBackground(new Color(255, 255, 255));
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					// Pausa el hilo actual durante 3 segundos
					Thread.sleep(3000);
				} catch (InterruptedException ex) {
					// Manejo de la excepción
					ex.printStackTrace();
				}
				paneles.get(0).setVisible(false);
				paneles.get(1).setVisible(true);
				paneles.get(2).setVisible(false);
				paneles.get(3).setVisible(false);

			}
		});
		panel.setBounds(0, 0, 634, 430);

		panel.setLayout(null);

		ImageIcon imageIcon = new ImageIcon(this.getClass().getResource("yh.png"));
		JLabel imgLabel = new JLabel("", imageIcon, JLabel.CENTER);
		imgLabel.setBackground(new Color(255, 255, 255));
		imgLabel.setBounds(77, 49, 432, 307);
		imgLabel.setIcon(imageIcon);
		panel.add(imgLabel);

	}

	public JPanel getPanel() {
		return panel;
	}
}