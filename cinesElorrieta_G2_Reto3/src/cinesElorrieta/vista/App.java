package cinesElorrieta.vista;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class App {

	private JFrame frame;
	private ArrayList <Object> panelesCine = null;

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

		panelesCine = new ArrayList<Object>();

		Bienvenida bienvenida = new Bienvenida(panelesCine);
		JPanel panelBienvenida = bienvenida.getPanel();
		panelBienvenida.setVisible(true);
		panelesCine.add(bienvenida);
		frame.getContentPane().add(panelBienvenida);

		Cines cines = new Cines(panelesCine);
		JPanel panelCine = cines.getPanel();
		panelCine.setVisible(false);
		panelesCine.add(cines);
		frame.getContentPane().add(panelCine);

		// Creamos los gestores y los paneles. Pasamos la lista por el constructor
		Sesion sesion = new Sesion(panelesCine);
		JPanel panel2 = sesion.getPanel();
		panel2.setVisible(false);

		// Lo metemos en la lista y en la ventana
		panelesCine.add(sesion);
		frame.getContentPane().add(panel2);

		// Creamos los gestores y los paneles. Pasamos la lista por el constructor
		Resumen resumen = new Resumen(panelesCine);
		JPanel panel3 = resumen.getPanel();
		panel3.setVisible(false);

		// Lo metemos en la lista y en la ventana
		panelesCine.add(resumen);
		frame.getContentPane().add(panel3);

		// Creamos los gestores y los paneles. Pasamos la lista por el constructor
		Login login = new Login(panelesCine);
		JPanel panel4 = login.getPanel();
		panel4.setVisible(false);

		// Lo metemos en la lista y en la ventana
		panelesCine.add(login);
		frame.getContentPane().add(panel4);

		// Creamos los gestores y los paneles. Pasamos la lista por el constructor
		Registro registro = new Registro(panelesCine);
		JPanel panel5 = registro.getPanel();
		panel5.setVisible(false);

		// Lo metemos en la lista y en la ventana
		panelesCine.add(registro);
		frame.getContentPane().add(panel5);

		// Creamos los gestores y los paneles. Pasamos la lista por el constructor
		GeneradorTicket generadorTicket = new GeneradorTicket(panelesCine);
		JPanel panel6 = generadorTicket.getPanel();
		panel6.setVisible(false);

		// Lo metemos en la lista y en la ventana
		panelesCine.add(generadorTicket);
		frame.getContentPane().add(panel6);
	}
}