package cinesElorrieta.vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.Font;
import java.awt.Color;
import javax.swing.border.LineBorder;

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
					Cines frame = new Cines(null);
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
	public Cines(ArrayList<JPanel> paneles) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 470);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelCines = new JPanel();
		panelCines.setBackground(new Color(255, 255, 255));
		panelCines.setBounds(0, 0, 634, 430);
		contentPane.add(panelCines);
		panelCines.setLayout(null);
		
		JComboBox comboBoxCines = new JComboBox();
		comboBoxCines.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBoxCines.setBounds(42, 138, 198, 35);
		panelCines.add(comboBoxCines);
		
		JButton btnInicioSesion = new JButton("Login");
		btnInicioSesion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnInicioSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnInicioSesion.setBounds(64, 349, 115, 27);
		panelCines.add(btnInicioSesion);
		
		JButton btnFin = new JButton("Finalizar");
		btnFin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Resumen().setVisible(true);
			}
		});
		btnFin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnFin.setBounds(482, 345, 97, 35);
		panelCines.add(btnFin);
		
		tablePeliculas = new JTable();
		tablePeliculas.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		tablePeliculas.setBounds(316, 106, 255, 190);
		panelCines.add(tablePeliculas);
		
		JButton btnVolver = new JButton("Volver ");
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Go to bienvenida ");
				panelCines.setVisible(false);
				
				paneles.get(0).setVisible(true);
				paneles.get(1).setVisible(false);
				paneles.get(2).setVisible(false);
			
			}
		});
		btnVolver.setBounds(283, 345, 89, 35);
		panelCines.add(btnVolver);
		
		JLabel lblCarrito = new JLabel("New label");
		lblCarrito.setBounds(559, 23, 46, 14);
		panelCines.add(lblCarrito);
		
		

		ImageIcon imageIcon = new ImageIcon(this.getClass().getResource("h.png"));
		JLabel imgLabel = new JLabel("", imageIcon, JLabel.CENTER);
		imgLabel.setBounds(10, 11, 198, 81);
		imgLabel.setIcon(imageIcon);
		panelCines.add(imgLabel);
	}
}
