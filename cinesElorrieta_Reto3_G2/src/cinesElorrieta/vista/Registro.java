package cinesElorrieta.vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class Registro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textDni;
	private JTextField textNombre;
	private JTextField textApellido;
	private JTextField textUsuario;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registro frame = new Registro();
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
	public Registro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelRegistro = new JPanel();
		panelRegistro.setBounds(0, 0, 435, 260);
		contentPane.add(panelRegistro);
		panelRegistro.setLayout(null);
		
		JLabel lblDni = new JLabel("DNI");
		lblDni.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblDni.setBounds(60, 21, 86, 14);
		panelRegistro.add(lblDni);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNombre.setBounds(60, 51, 86, 14);
		panelRegistro.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblApellido.setBounds(60, 81, 86, 14);
		panelRegistro.add(lblApellido);
		
		JLabel lblGenero = new JLabel("Genero");
		lblGenero.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblGenero.setBounds(60, 111, 86, 14);
		panelRegistro.add(lblGenero);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblUsuario.setBounds(60, 141, 86, 14);
		panelRegistro.add(lblUsuario);
		
		JLabel lblContrasenna = new JLabel("Contraseña");
		lblContrasenna.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblContrasenna.setBounds(60, 171, 86, 14);
		panelRegistro.add(lblContrasenna);
		
		JRadioButton rdbtnMujer = new JRadioButton("Mujer");
		rdbtnMujer.setBounds(152, 102, 109, 23);
		panelRegistro.add(rdbtnMujer);
		
		JRadioButton rdbtnHombre = new JRadioButton("Hombre");
		rdbtnHombre.setBounds(262, 102, 109, 23);
		panelRegistro.add(rdbtnHombre);
		
		textDni = new JTextField();
		textDni.setBounds(163, 15, 122, 20);
		panelRegistro.add(textDni);
		textDni.setColumns(10);
		
		textNombre = new JTextField();
		textNombre.setColumns(10);
		textNombre.setBounds(163, 45, 122, 20);
		panelRegistro.add(textNombre);
		
		textApellido = new JTextField();
		textApellido.setColumns(10);
		textApellido.setBounds(163, 73, 122, 20);
		panelRegistro.add(textApellido);
		
		textUsuario = new JTextField();
		textUsuario.setColumns(10);
		textUsuario.setBounds(163, 135, 122, 20);
		panelRegistro.add(textUsuario);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(163, 168, 122, 20);
		panelRegistro.add(passwordField);
		
		JButton btnNewButton = new JButton("Crear usuario");
		btnNewButton.setBounds(163, 210, 122, 23);
		panelRegistro.add(btnNewButton);
	}
}