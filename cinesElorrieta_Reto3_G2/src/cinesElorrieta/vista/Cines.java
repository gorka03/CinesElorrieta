package cinesElorrieta.vista;

import javax.swing.JPanel;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

import javax.swing.ImageIcon;

import java.awt.Font;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import cinesElorrieta.controller.GestorCines;
import cinesElorrieta.controller.GestorPeliculas;
import cinesElorrieta.modelo.Cine;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Cines {

	private static JTable tablePeliculas;
	private JPanel panel = null;

	public Cines(ArrayList<JPanel> paneles) {

		panel = new JPanel();
		panel.setBounds(0, 0, 650, 470);
		panel.setBackground(new Color(255, 255, 255));
		panel.setLayout(null);

		JComboBox<String> comboBoxCines = new JComboBox<String>();
		comboBoxCines.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBoxCines.setBounds(21, 166, 235, 27);
		panel.add(comboBoxCines);
		
        comboBoxCines.addItem("Seleccionar cine...");

		ArrayList<Cine> cines = GestorCines.obtenerDatosCines();

		if (cines != null) {
			for (Cine cine : cines) {
				comboBoxCines.addItem(cine.getNombre());
			}
		}

		JButton btnInicioSesion = new JButton("Login");
		btnInicioSesion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnInicioSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paneles.get(1).setVisible(false);
				paneles.get(4).setVisible(true);
			}
		});
		btnInicioSesion.setBounds(285, 374, 121, 27);
		panel.add(btnInicioSesion);

		tablePeliculas = new JTable();
		
		tablePeliculas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				paneles.get(1).setVisible(false);
				paneles.get(2).setVisible(true);
			}
		});
		
		tablePeliculas.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		tablePeliculas.setBounds(284, 106, 287, 213);
		tablePeliculas.setDefaultEditor(Object.class, null);
		panel.add(tablePeliculas);

		comboBoxCines.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cineSeleccionado = (String) comboBoxCines.getSelectedItem();
				cargarPeliculasCineEnTabla(cineSeleccionado);
			}
		});

		JButton btnVolver = new JButton("Volver ");
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paneles.get(0).setVisible(true);
				paneles.get(1).setVisible(false);
			}
		});
		btnVolver.setBounds(465, 374, 106, 27);
		panel.add(btnVolver);

		ImageIcon imageLogo = new ImageIcon(this.getClass().getResource("logo.png"));
		JLabel imgLogo = new JLabel("", imageLogo, JLabel.CENTER);
		imgLogo.setBounds(10, 11, 198, 81);
		imgLogo.setIcon(imageLogo);
		panel.add(imgLogo);

		ImageIcon imageCarrito = new ImageIcon(this.getClass().getResource("carrito.png"));
		JLabel imgCarrito = new JLabel("", imageCarrito, JLabel.CENTER);
		imgCarrito.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				paneles.get(1).setVisible(false);
				paneles.get(3).setVisible(true);
			}
		});
		imgCarrito.setBounds(544, 0, 106, 93);
		imgCarrito.setIcon(imageCarrito);
		panel.add(imgCarrito);

	}

	public JPanel getPanel() {
		return panel;
	}
	 public static void cargarPeliculasCineEnTabla(String nombreCine) {
	        String[] columnas = {"Título"};
	        DefaultTableModel modeloTabla = new DefaultTableModel(null, columnas);
	        
	        ArrayList<String> nombresPeliculas = GestorPeliculas.obtenerPeliculasDelCine(nombreCine);
	        
	        for (String nombrePelicula : nombresPeliculas) {
	            modeloTabla.addRow(new Object[] {nombrePelicula});
	        }
	        
	        tablePeliculas.setModel(modeloTabla);
	    }

}