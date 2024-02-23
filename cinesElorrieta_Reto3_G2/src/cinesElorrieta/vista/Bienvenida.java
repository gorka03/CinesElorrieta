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

	public Bienvenida(ArrayList<Object> paneles) {

		panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, 650, 470);
		panel.setBackground(new Color(255, 255, 255));
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					// Pausa el hilo actual durante 3 segundos
					Thread.sleep(3000);
				} catch (InterruptedException ex) {
					// Nothing
				}
				((Bienvenida) paneles.get(0)).getPanel().setVisible(false);
				((Cines) paneles.get(1)).getPanel().setVisible(true);
				((Sesion) paneles.get(2)).getPanel().setVisible(false);
				((Resumen) paneles.get(3)).getPanel().setVisible(false);
				((Login) paneles.get(4)).getPanel().setVisible(false);
				((Registro) paneles.get(5)).getPanel().setVisible(false);
				((GeneradorTicket) paneles.get(6)).getPanel().setVisible(false);
			}
		});

		ImageIcon imageIcon = new ImageIcon(this.getClass().getResource("logoBienvenida.png"));
		JLabel imgLabel = new JLabel("", imageIcon, JLabel.CENTER);
		imgLabel.setBackground(new Color(255, 255, 255));
		imgLabel.setBounds(0, 0, 650, 470);
		imgLabel.setIcon(imageIcon);
		panel.add(imgLabel);
	}

	public JPanel getPanel() {
		return panel;
	}
}