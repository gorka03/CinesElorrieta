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


 /**
 * The class Login
 */ 
public class Login {

	private JTextField textField = null;
	private JPasswordField passwordField = null;
	private JPanel panel = null;


/** 
 *
 * It is a constructor. 
 *
 * @param paneles  the paneles. 
 */
	public Login(ArrayList<Object> paneles) { 


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

/** 
 *
 * Action performed
 *
 * @param e  the e. 
 */
			public void actionPerformed(ActionEvent e) { 

				String usuario = textField.getText();
				String contrasenna = new String(passwordField.getPassword());

				GestorLogin gestorLogin = new GestorLogin();
				// Verificar las credenciales en la base de datos
				boolean credencialesValidas = gestorLogin.verificarCredenciales(usuario, contrasenna);

				if (credencialesValidas) {
					JOptionPane.showMessageDialog(panel, "Has inciado sesión correctamente ",
							"Inicio de sesión correcto", JOptionPane.INFORMATION_MESSAGE);
					((Bienvenida) paneles.get(0)).getPanel().setVisible(false);
					((Cines) paneles.get(1)).getPanel().setVisible(false);
					((Sesion) paneles.get(2)).getPanel().setVisible(false);
					((Resumen) paneles.get(3)).getPanel().setVisible(false);
					((Login) paneles.get(4)).getPanel().setVisible(false);
					((Registro) paneles.get(5)).getPanel().setVisible(false);
					((GeneradorTicket) paneles.get(6)).getPanel().setVisible(true);

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

/** 
 *
 * Action performed
 *
 * @param e  the e. 
 */
			public void actionPerformed(ActionEvent e) { 

				((Bienvenida) paneles.get(0)).getPanel().setVisible(false);
				((Cines) paneles.get(1)).getPanel().setVisible(false);
				((Sesion) paneles.get(2)).getPanel().setVisible(false);
				((Resumen) paneles.get(3)).getPanel().setVisible(false);
				((Login) paneles.get(4)).getPanel().setVisible(false);
				((Registro) paneles.get(5)).getPanel().setVisible(true);
				((GeneradorTicket) paneles.get(6)).getPanel().setVisible(false);

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

/** 
 *
 * Action performed
 *
 * @param e  the e. 
 */
			public void actionPerformed(ActionEvent e) { 

				((Bienvenida) paneles.get(0)).getPanel().setVisible(false);
				((Cines) paneles.get(1)).getPanel().setVisible(true);
				((Sesion) paneles.get(2)).getPanel().setVisible(false);
				((Resumen) paneles.get(3)).getPanel().setVisible(false);
				((Login) paneles.get(4)).getPanel().setVisible(false);
				((Registro) paneles.get(5)).getPanel().setVisible(false);
				((GeneradorTicket) paneles.get(6)).getPanel().setVisible(false);

			}
		});
		panel.add(btnCancelar);

	}


/** 
 *
 * Gets the panel
 *
 * @return the panel
 */
	public JPanel getPanel() { 

		return panel;
	}

}
