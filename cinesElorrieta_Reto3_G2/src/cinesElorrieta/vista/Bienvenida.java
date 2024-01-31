package cinesElorrieta.vista;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;

public class Bienvenida extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bienvenida frame = new Bienvenida();
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
	public Bienvenida() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 666, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelBienvenida = new JPanel();
		panelBienvenida.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelBienvenida.setVisible(false);
				//panelLogin.setVisible(true);
				//esperar();
			}
		});
		panelBienvenida.setBounds(0, 0, 650, 391);
		
		contentPane.add(panelBienvenida);
		panelBienvenida.setLayout(null);
		
		JLabel lblBienvenida = new JLabel("");
		lblBienvenida.setIcon(new ImageIcon("C:\\Users\\in1dm3-v\\eclipse-workspace\\retos\\src\\reto2\\cine-logo2.png"));
		lblBienvenida.setBounds(0, 5, 650, 386);
		panelBienvenida.add(lblBienvenida);
	}
	
	
	public void initialize () {
		
	}
}
