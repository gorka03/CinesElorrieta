package cinesElorrieta.vista;

import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JTextField;
import cinesElorrieta.controller.GestorRegistro;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;


 /**
 * The class Registro
 */ 
public class Registro {

	private JPanel panel = null;

	private JTextField textDni;
	private JTextField textNombre;
	private JTextField textApellido;
	private JTextField textUsuario;
	private JPasswordField passwordField;


/** 
 *
 * It is a constructor. 
 *
 * @param paneles  the paneles. 
 */
	public Registro(ArrayList<Object> paneles) { 

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

/** 
 *
 * Action performed
 *
 * @param e  the e. 
 */
			public void actionPerformed(ActionEvent e) { 


				String dni = textDni.getText();
				String nombre = textNombre.getText();
				String apellido = textApellido.getText();
				String genero = rdbtnMujer.isSelected() ? "M" : "H";
				String usuario = textUsuario.getText();
				String contrasenna = new String(passwordField.getPassword());

				GestorRegistro gestorRegistro = new GestorRegistro();
				boolean usuarioCreado = gestorRegistro.guardarUsuarioEnBaseDeDatos(dni, nombre, apellido, genero,
						usuario, contrasenna);

				if (usuarioCreado) {
					JOptionPane.showMessageDialog(panel, "Usuario creado correctamente", "Exito",
							JOptionPane.INFORMATION_MESSAGE);
					((Bienvenida) paneles.get(0)).getPanel().setVisible(false);
					((Cines) paneles.get(1)).getPanel().setVisible(false);
					((Sesion) paneles.get(2)).getPanel().setVisible(false);
					((Resumen) paneles.get(3)).getPanel().setVisible(false);
					((Login) paneles.get(4)).getPanel().setVisible(true);
					((Registro) paneles.get(5)).getPanel().setVisible(false);
					((GeneradorTicket) paneles.get(6)).getPanel().setVisible(false);

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
