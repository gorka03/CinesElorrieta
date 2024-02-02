package cinesElorrieta.vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JPasswordField;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelLogin = new JPanel();
		panelLogin.setBounds(0, 0, 435, 260);
		contentPane.add(panelLogin);
		panelLogin.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblUsuario.setBounds(68, 67, 89, 17);
		panelLogin.add(lblUsuario);
		
		JLabel lblContrasenna = new JLabel("Contraseña");
		lblContrasenna.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblContrasenna.setBounds(68, 118, 89, 17);
		panelLogin.add(lblContrasenna);
		
		textField = new JTextField();
		textField.setBounds(184, 61, 161, 30);
		panelLogin.add(textField);
		textField.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLogin.setBounds(194, 169, 140, 30);
		panelLogin.add(btnLogin);
		
		JButton btnRegistro = new JButton("Registrate !");
		btnRegistro.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnRegistro.setBounds(204, 210, 124, 23);
		panelLogin.add(btnRegistro);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(184, 116, 161, 30);
		panelLogin.add(passwordField);
		
		JLabel lblLogo = new JLabel("Logo");
		lblLogo.setBounds(10, 11, 46, 14);
		panelLogin.add(lblLogo);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(10, 226, 89, 23);
		panelLogin.add(btnCancelar);
	}
}