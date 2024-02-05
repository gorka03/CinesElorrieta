package cinesElorrieta.vista;

import java.awt.EventQueue;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JLabel;
import java.awt.Color;

public class Bienvenida extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel panel = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bienvenida frame = new Bienvenida(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Bienvenida(ArrayList<JPanel> paneles) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 470);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panelBienvenida = new JPanel();
		panelBienvenida.setBackground(new Color(255, 255, 255));
		panelBienvenida.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					// Pausa el hilo actual durante 3 segundos
					Thread.sleep(3000);
				} catch (InterruptedException ex) {
					// Manejo de la excepción
					ex.printStackTrace();
				}

				System.out.println("Go to cines ");
				panelBienvenida.setVisible(false);
				
				paneles.get(0).setVisible(false);
				paneles.get(1).setVisible(true);
				paneles.get(2).setVisible(false);
				
			}
		});
		panelBienvenida.setBounds(0, 0, 634, 430);

		contentPane.add(panelBienvenida);
		panelBienvenida.setLayout(null);

		ImageIcon imageIcon = new ImageIcon(this.getClass().getResource("yh.png"));
		JLabel imgLabel = new JLabel("", imageIcon, JLabel.CENTER);
		imgLabel.setBackground(new Color(255, 255, 255));
		imgLabel.setBounds(77, 49, 432, 307);
		imgLabel.setIcon(imageIcon);
		panelBienvenida.add(imgLabel);
	}
	
	public JPanel getPanel (){
		return panel ;
	}
}