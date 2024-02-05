package cinesElorrieta.vista;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class App {

	private JFrame frame;
	private ArrayList<JPanel> panelesCine = null;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new App().frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.na
	 */
	public App() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 650, 470);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		// Lista que contiene los paneles
		panelesCine = new ArrayList<JPanel>();

		// Creamos los gestores y los paneles. Pasamos la lista por el constructor
		Bienvenida bienvenida = new Bienvenida(panelesCine);
		JPanel panel1 = bienvenida.getPanel();
		panel1.setVisible(true);

		// Lo metemos en la lista y en la ventana
		panelesCine.add(panel1);
		frame.getContentPane().add(panel1);

		// Creamos los gestores y los paneles. Pasamos la lista por el constructor
		Cines cines = new Cines(panelesCine);
		JPanel panel2 = cines.getPanel();
		panel2.setVisible(false);

		// Lo metemos en la lista y en la ventana
		panelesCine.add(panel2);
		frame.getContentPane().add(panel2);

		// Creamos los gestores y los paneles. Pasamos la lista por el constructor
		Login login = new Login(panelesCine);
		JPanel panel3 = login.getPanel();
		panel3.setVisible(false);

		// Lo metemos en la lista y en la ventana
		panelesCine.add(panel3);
		frame.getContentPane().add(panel3);

	}
}