package cinesElorrieta.vista;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import cinesElorrieta.modelo.Cliente;
import cinesElorrieta.utils.DBUtils;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
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
				boolean credencialesValidas = verificarCredenciales(usuario, contrasenna);

				if (credencialesValidas) {
					JOptionPane.showMessageDialog(panel, "Has inciado sesión correctamente ",
							"Inicio de sesión correcto", JOptionPane.INFORMATION_MESSAGE);
					paneles.get(2).setVisible(false);
					paneles.get(6).setVisible(true);

				} else {
					JOptionPane.showMessageDialog(panel, "Usuario o contraseña incorrecta", "Error de inicio de sesión",
							JOptionPane.ERROR_MESSAGE);
				}
			}

			private boolean verificarCredenciales(String usuario, String contrasenna) {
				ArrayList<Cliente> clientes = obtenerDatosLogin();
				if (clientes != null) {
					for (Cliente cliente : clientes) {
						if (cliente.getUserName().equals(usuario) && cliente.getContrasenna().equals(contrasenna)) {
							return true; // Credenciales válidas
						}
					}
				}
				return false; // Credenciales inválidas
			}

		});

		panel.add(btnLogin);

		JButton btnRegistro = new JButton("Registrate !");
		btnRegistro.setBounds(293, 352, 124, 23);
		btnRegistro.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paneles.get(2).setVisible(false);
				paneles.get(3).setVisible(true);

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
				paneles.get(0).setVisible(true);
				paneles.get(2).setVisible(false);
			}
		});
		panel.add(btnCancelar);

	}

	public JPanel getPanel() {
		return panel;
	}

	private ArrayList<Cliente> obtenerDatosLogin() {
		ArrayList<Cliente> ret = null;

		// SQL que queremos lanzar
		String sql = "select * from cliente";

		// La conexion con BBDD
		Connection connection = null;

		// Vamos a lanzar una sentencia SQL contra la BBDD
		// Result set va a contener todo lo que devuelve la BBDD
		java.sql.Statement statement = null;
		ResultSet resultSet = null;

		try {
			// El Driver que vamos a usar
			Class.forName(DBUtils.DRIVER);

			// Abrimos la conexion con BBDD
			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

			// Vamos a lanzar la sentencia...
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);

			// No es posible saber cuantas cosas nos ha devuelto el resultSet.
			// Hay que ir 1 por 1 y guardandolo todo en su objeto Ejemplo correspondiente
			while (resultSet.next()) {

				// Si es necesario, inicializamos la lista
				if (null == ret)
					ret = new ArrayList<Cliente>();

				Cliente cliente = new Cliente();

				// Sacamos las columnas del RS
				String userName = resultSet.getString("userName");
				String contrasenna = resultSet.getString("contrasenna");

				// Metemos los datos a Ejemplo
				cliente.setUserName(userName);
				cliente.setContrasenna(contrasenna);

				// Lo guardamos en ret
				ret.add(cliente);
			}
		} catch (SQLException sqle) {
			System.out.println("Error con la BBDD - " + sqle.getMessage());
		} catch (Exception e) {
			System.out.println("Error generico - " + e.getMessage());
		} finally {
			// Cerramos al reves de como las abrimos
			try {
				if (resultSet != null)
					resultSet.close();
			} catch (Exception e) {
				// No hace falta
			}
			;
			try {
				if (statement != null)
					statement.close();
			} catch (Exception e) {
				// No hace falta
			}
			;
			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				// No hace falta
			}
			;
		}
		return ret;
	}
}