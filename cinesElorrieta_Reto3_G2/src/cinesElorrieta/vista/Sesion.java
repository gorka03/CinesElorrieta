package cinesElorrieta.vista;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

public class Sesion extends JFrame {


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tableSesion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Resumen frame = new Resumen();
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
	public Sesion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 470);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 435, 260);
		contentPane.add(panel);
		panel.setLayout(null);
		
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

}
