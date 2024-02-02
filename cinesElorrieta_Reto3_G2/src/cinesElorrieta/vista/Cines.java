package cinesElorrieta.vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class Cines extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tablePeliculas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cines frame = new Cines();
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
	public Cines() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelCines = new JPanel();
		panelCines.setBounds(0, 0, 435, 260);
		contentPane.add(panelCines);
		panelCines.setLayout(null);
		
		JComboBox comboBoxCines = new JComboBox();
		comboBoxCines.setBounds(27, 77, 114, 22);
		panelCines.add(comboBoxCines);
		
		JLabel lblCarrito = new JLabel("Foto");
		lblCarrito.setBounds(392, 11, 33, 22);
		panelCines.add(lblCarrito);
		
		JLabel lblLogo = new JLabel("Foto");
		lblLogo.setBounds(10, 227, 33, 22);
		panelCines.add(lblLogo);
		
		JButton btnInicioSesion = new JButton("Iniciar sesion");
		btnInicioSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnInicioSesion.setBounds(10, 11, 114, 23);
		panelCines.add(btnInicioSesion);
		
		JButton btnFin = new JButton("Finalizar");
		btnFin.setBounds(336, 227, 89, 23);
		panelCines.add(btnFin);
		
		tablePeliculas = new JTable();
		tablePeliculas.setBounds(218, 77, 190, 115);
		panelCines.add(tablePeliculas);
		
		JButton btnVolver = new JButton("Volver ???");
		btnVolver.setBounds(220, 227, 89, 23);
		panelCines.add(btnVolver);
	}
}
