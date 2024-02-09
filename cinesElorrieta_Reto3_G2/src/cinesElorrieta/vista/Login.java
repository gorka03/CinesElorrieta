package cinesElorrieta.vista;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import cinesElorrieta.controller.GestorLogin;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JPasswordField;

public class Login {

	private JTextField textField = null;
	private JPasswordField passwordField = null;
	private JPanel panel = null;

	public Login(ArrayList<JPanel> paneles) {

		panel = new JPanel();
		panel.setBounds(0, 0, 650, 470);
		panel.setBackground(new Color(255, 255, 255));
		panel.setLayout(null);

		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(151, 176, 89, 17);
		lblUsuario.setFont(new Font("Times New Roman", Font.BOLD, 12));
		panel.add(lblUsuario);

		JLabel lblContrasenna = new JLabel("Contraseña");
		lblContrasenna.setBounds(151, 231, 89, 17);
		lblContrasenna.setFont(new Font("Times New Roman", Font.BOLD, 12));
		panel.add(lblContrasenna);

		textField = new JTextField();
		textField.setBounds(280, 169, 161, 30);
		panel.add(textField);
		textField.setColumns(10);

		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(288, 284, 140, 30);
		btnLogin.setFont(new Font("Times New Roman", Font.BOLD, 12));

		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String usuario = textField.getText();
				String contrasenna = new String(passwordField.getPassword());

				// Verificar las credenciales en la base de datos
				boolean credencialesValidas = GestorLogin.verificarCredenciales(usuario, contrasenna);

				if (credencialesValidas) {
					JOptionPane.showMessageDialog(panel, "Has inciado sesión correctamente ",
							"Inicio de sesión correcto", JOptionPane.INFORMATION_MESSAGE);
					paneles.get(4).setVisible(false);
					paneles.get(6).setVisible(true);

				} else {
					JOptionPane.showMessageDialog(panel, "Usuario o contraseña incorrecta", "Error de inicio de sesión",
							JOptionPane.ERROR_MESSAGE);
					// Limpiar los campos de texto
					textField.setText("");
					passwordField.setText("");
				}

			}
		});

		panel.add(btnLogin);

		JButton btnRegistro = new JButton("Registrate !");
		btnRegistro.setBounds(293, 352, 124, 23);
		btnRegistro.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paneles.get(4).setVisible(false);
				paneles.get(5).setVisible(true);

			}
		});
		panel.add(btnRegistro);

		passwordField = new JPasswordField();
		passwordField.setBounds(280, 224, 161, 30);
		panel.add(passwordField);

		ImageIcon imageLogo = new ImageIcon(this.getClass().getResource("logo.png"));
		JLabel imgLogo = new JLabel("", imageLogo, JLabel.CENTER);
		imgLogo.setBounds(10, 11, 198, 81);
		imgLogo.setIcon(imageLogo);
		panel.add(imgLogo);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(151, 352, 89, 23);
		btnCancelar.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paneles.get(1).setVisible(true);
				paneles.get(4).setVisible(false);
			}
		});
		panel.add(btnCancelar);

	}

	public JPanel getPanel() {
		return panel;
	}

}