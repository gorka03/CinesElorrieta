package cinesElorrieta.vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Resumen extends JFrame {

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
	public Resumen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
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
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(291, 209, 89, 23);
		panel.add(btnCancelar);
		
		JLabel lblLogo = new JLabel("Logo");
		lblLogo.setBounds(10, 11, 46, 14);
		panel.add(lblLogo);
		
		JButton btnPagar = new JButton("Pagar");
		btnPagar.setBounds(37, 209, 89, 23);
		panel.add(btnPagar);
	}

}
