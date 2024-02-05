package cinesElorrieta.vista;

import java.awt.Color;

import javax.swing.JPanel;

import javax.swing.JLabel;
import javax.swing.JRadioButton;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
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
		lblDni.setBounds(92, 119, 22, 15);
		panel.add(lblDni);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNombre.setBounds(91, 150, 42, 15);
		panel.add(lblNombre);

		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblApellido.setBounds(92, 178, 44, 15);
		panel.add(lblApellido);

		JLabel lblGenero = new JLabel("Genero");
		lblGenero.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblGenero.setBounds(92, 204, 39, 15);
		panel.add(lblGenero);

		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblUsuario.setBounds(92, 235, 41, 15);
		panel.add(lblUsuario);

		JLabel lblContrasenna = new JLabel("Contraseña");
		lblContrasenna.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblContrasenna.setBounds(92, 273, 61, 15);
		panel.add(lblContrasenna);

		JRadioButton rdbtnMujer = new JRadioButton("Mujer");
		rdbtnMujer.setBounds(174, 200, 70, 23);
		panel.add(rdbtnMujer);

		JRadioButton rdbtnHombre = new JRadioButton("Hombre");
		rdbtnHombre.setBounds(266, 200, 86, 23);
		panel.add(rdbtnHombre);

		textDni = new JTextField();
		textDni.setBounds(174, 116, 86, 20);
		panel.add(textDni);
		textDni.setColumns(10);

		textNombre = new JTextField();
		textNombre.setColumns(10);
		textNombre.setBounds(174, 147, 86, 20);
		panel.add(textNombre);

		textApellido = new JTextField();
		textApellido.setColumns(10);
		textApellido.setBounds(174, 175, 86, 20);
		panel.add(textApellido);
		
				JButton btnNewButton = new JButton("Crear usuario");
				btnNewButton.setBounds(174, 325, 97, 23);
				panel.add(btnNewButton);

		textUsuario = new JTextField();
		textUsuario.setColumns(10);
		textUsuario.setBounds(174, 232, 86, 20);
		panel.add(textUsuario);

		passwordField = new JPasswordField();
		passwordField.setBounds(174, 270, 86, 20);
		panel.add(passwordField);
	}

	public JPanel getPanel() {
		return panel;
	}
}