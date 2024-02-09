package cinesElorrieta.vista;

import java.awt.Color;

import javax.swing.JPanel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JTextField;
import cinesElorrieta.utils.DBUtils;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Registro {

	private JPanel panel = null;

	private JTextField textDni;
	private JTextField textNombre;
	private JTextField textApellido;
	private JTextField textUsuario;
	private JPasswordField passwordField;

	public Registro(ArrayList<JPanel> paneles) {
		panel = new JPanel();
		panel.setBounds(0, 0, 650, 470);

		panel.setBackground(new Color(255, 255, 255));
		panel.setLayout(null);

		JLabel lblDni = new JLabel("DNI");
		lblDni.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblDni.setBounds(178, 198, 22, 15);
		panel.add(lblDni);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNombre.setBounds(178, 224, 42, 15);
		panel.add(lblNombre);

		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblApellido.setBounds(178, 250, 44, 15);
		panel.add(lblApellido);

		JLabel lblGenero = new JLabel("Genero");
		lblGenero.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblGenero.setBounds(178, 276, 39, 15);
		panel.add(lblGenero);

		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblUsuario.setBounds(178, 302, 41, 15);
		panel.add(lblUsuario);

		JLabel lblContrasenna = new JLabel("Contraseña");
		lblContrasenna.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblContrasenna.setBounds(178, 328, 61, 15);
		panel.add(lblContrasenna);

		JRadioButton rdbtnMujer = new JRadioButton("Mujer");
		rdbtnMujer.setBounds(263, 269, 70, 23);
		panel.add(rdbtnMujer);

		JRadioButton rdbtnHombre = new JRadioButton("Hombre");
		rdbtnHombre.setBounds(354, 269, 86, 23);
		panel.add(rdbtnHombre);

		textDni = new JTextField();
		textDni.setBounds(263, 195, 86, 20);
		panel.add(textDni);
		textDni.setColumns(10);

		textNombre = new JTextField();
		textNombre.setColumns(10);
		textNombre.setBounds(263, 221, 86, 20);
		panel.add(textNombre);

		textApellido = new JTextField();
		textApellido.setColumns(10);
		textApellido.setBounds(263, 247, 86, 20);
		panel.add(textApellido);

		JButton btnCrearUsuario = new JButton("Crear usuario");
		btnCrearUsuario.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCrearUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String dni = textDni.getText();
				String nombre = textNombre.getText();
				String apellido = textApellido.getText();
				String genero = rdbtnMujer.isSelected() ? "M" : "H";
				String usuario = textUsuario.getText();
				String contrasenna = new String(passwordField.getPassword());

				boolean usuarioCreado = guardarUsuarioEnBaseDeDatos(dni, nombre, apellido, genero, usuario,
						contrasenna);

				if (usuarioCreado) {
					JOptionPane.showMessageDialog(panel, "Usuario creado correctamente", "Éxito",
							JOptionPane.INFORMATION_MESSAGE);
					paneles.get(0).setVisible(false);
					paneles.get(4).setVisible(true);
					paneles.get(5).setVisible(false);

				} else {

					JOptionPane.showMessageDialog(panel, "Error al crear el usuario", "Error",
							JOptionPane.ERROR_MESSAGE);
					textDni.setText("");
					textNombre.setText("");
					textApellido.setText("");
					rdbtnMujer.setSelected(false);
					textUsuario.setText("");
					passwordField.setText("");

				}
			}

			private boolean guardarUsuarioEnBaseDeDatos(String dni, String nombre, String apellido, String genero,
					String usuario, String contrasenna) {

				boolean insercionExitosa = false;
				Connection connection = null;
				PreparedStatement stm = null;

				try {
					// El Driver que vamos a usar
					Class.forName(DBUtils.DRIVER);
					// Abrimos la conexion con BBDD
					connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

					// Crear la consulta SQL
					String sql = "INSERT INTO cliente (dni, nombre, apellidos, sexo, contrasenna, userName) VALUES (?, ?, ?, ?, ?, ?)";
					stm = connection.prepareStatement(sql);
					stm.setString(1, dni);
					stm.setString(2, nombre);
					stm.setString(3, apellido);
					stm.setString(4, genero);
					stm.setString(5, contrasenna);
					stm.setString(6, usuario);

					// Ejecutar la consulta SQL
					int filasAfectadas = stm.executeUpdate();

					// Verificar si ha insertado
					if (filasAfectadas > 0) {
						insercionExitosa = true;
					}
				} catch (SQLException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} finally {
					// Cerramos al reves de como las abrimos
					try {
						if (stm != null)
							stm.close();
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
				}

				return insercionExitosa;
			}

		});
		btnCrearUsuario.setBounds(231, 364, 144, 23);
		panel.add(btnCrearUsuario);

		textUsuario = new JTextField();
		textUsuario.setColumns(10);
		textUsuario.setBounds(263, 299, 86, 20);
		panel.add(textUsuario);

		passwordField = new JPasswordField();
		passwordField.setBounds(263, 325, 86, 20);
		panel.add(passwordField);

		ImageIcon imageLogo = new ImageIcon(this.getClass().getResource("logo.png"));
		JLabel imgLogo = new JLabel("", imageLogo, JLabel.CENTER);
		imgLogo.setBounds(10, 11, 198, 81);
		imgLogo.setIcon(imageLogo);
		panel.add(imgLogo);
	}

	public JPanel getPanel() {
		return panel;
	}
}