package cinesElorrieta.vista;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JPasswordField;

public class Login {

	private JTextField textField= null;
	private JPasswordField passwordField= null;
	private JPanel panel = null;

	public Login(ArrayList<JPanel> paneles) {

		panel = new JPanel();
		panel.setBounds(0, 0, 650, 470);
		panel.setBackground(new Color(255, 255, 255));
		panel.setLayout(null);

		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblUsuario.setBounds(151, 104, 89, 17);
		panel.add(lblUsuario);

		JLabel lblContrasenna = new JLabel("Contraseña");
		lblContrasenna.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblContrasenna.setBounds(151, 155, 89, 17);
		panel.add(lblContrasenna);

		textField = new JTextField();
		textField.setBounds(267, 98, 161, 30);
		panel.add(textField);
		textField.setColumns(10);

		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLogin.setBounds(277, 206, 140, 30);
		panel.add(btnLogin);

		JButton btnRegistro = new JButton("Registrate !");
		btnRegistro.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnRegistro.setBounds(287, 247, 124, 23);
		panel.add(btnRegistro);

		passwordField = new JPasswordField();
		passwordField.setBounds(267, 153, 161, 30);
		panel.add(passwordField);

		JLabel lblLogo = new JLabel("Logo");
		lblLogo.setBounds(10, 11, 46, 14);
		panel.add(lblLogo);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(93, 263, 89, 23);
		panel.add(btnCancelar);

	}

	public JPanel getPanel() {
		return panel;
	}
}