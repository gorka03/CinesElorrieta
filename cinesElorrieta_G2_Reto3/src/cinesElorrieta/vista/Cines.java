package cinesElorrieta.vista;

import javax.swing.JPanel;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

import javax.swing.ImageIcon;

import java.awt.Font;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;

import cinesElorrieta.controller.GestorCines;
import cinesElorrieta.controller.GestorPeliculas;
import cinesElorrieta.modelo.Cine;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;


/**
* The class Cines
*/ 

public class Cines {

	private JTable tablePeliculas;

	private JPanel panel = null;

	private String cineSeleccionado = null;
	private String nombrePelicula = null;

/** 
*
* It is a constructor. 
*
* @param paneles  the paneles. 
*/
	
	public Cines(ArrayList<Object> paneles) {

		panel = new JPanel();
		panel.setBounds(0, 0, 650, 470);
		panel.setBackground(new Color(255, 255, 255));
		panel.setLayout(null);


		JComboBox<String> comboBoxCines = new JComboBox<String>();
		comboBoxCines.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBoxCines.setBounds(21, 166, 235, 27);
		comboBoxCines.addItem("Seleccionar cine...");
		comboBoxCines.addActionListener(new ActionListener() {
/** 
*
* Action performed
*
* @param e  the e. 
*/
			public void actionPerformed(ActionEvent e) {
				cineSeleccionado = (String) comboBoxCines.getSelectedItem();
				cargarPeliculasCineEnTabla(cineSeleccionado);
			}
		});
		panel.add(comboBoxCines);

		GestorCines gestorCines = new GestorCines();
		ArrayList<Cine> cines = gestorCines.obtenerDatosCines();
		if (cines != null) {
			for (Cine cine : cines) {
				comboBoxCines.addItem(cine.getNombre());
			}
		}

		tablePeliculas = new JTable();
		tablePeliculas.addMouseListener(new MouseAdapter() {
			@Override
/** 
*
* Mouse clicked
*
* @param e  the e. 
*/
			public void mouseClicked(MouseEvent e) {
				if (comboBoxCines.getSelectedIndex() != 0) {
					((Bienvenida) paneles.get(0)).getPanel().setVisible(false);
					((Cines) paneles.get(1)).getPanel().setVisible(false);
					((Sesion) paneles.get(2)).getPanel().setVisible(true);
					((Resumen) paneles.get(3)).getPanel().setVisible(false);
					((Login) paneles.get(4)).getPanel().setVisible(false);
					((Registro) paneles.get(5)).getPanel().setVisible(false);
					((GeneradorTicket) paneles.get(6)).getPanel().setVisible(false);
					
					DefaultTableModel model = (DefaultTableModel) tablePeliculas.getModel();
					int selectedRowIndex = tablePeliculas.getSelectedRow();
					nombrePelicula = (String) model.getValueAt(selectedRowIndex, 0);
					
					Sesion sesion = ((Sesion) paneles.get(2));
					sesion.cargarTableSesion(cineSeleccionado, nombrePelicula);

					comboBoxCines.setSelectedIndex(0);
				}
			}
		});

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(284, 106, 287, 213);
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
/** 
*
* Mouse clicked
*
* @param e  the e. 
*/
			public void mouseClicked(MouseEvent e) {
				if (comboBoxCines.getSelectedIndex() == 0) { 
					JOptionPane.showMessageDialog(panel, "No hay cine seleccionado", "Error",
							JOptionPane.INFORMATION_MESSAGE);
					return; 
				} else {
					JOptionPane.showMessageDialog(panel, "No hay pelicula seleccionada", "Error",
							JOptionPane.INFORMATION_MESSAGE);
					return; 
				}

			}
		});
		scrollPane.setViewportView(tablePeliculas);
		panel.add(scrollPane);

		JButton btnVolver = new JButton("Volver ");
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnVolver.addActionListener(new ActionListener() {
/** 
 *
 * Action performed
 *
 * @param e  the e. 
 */			
			public void actionPerformed(ActionEvent e) {
				((Bienvenida) paneles.get(0)).getPanel().setVisible(true);
				((Cines) paneles.get(1)).getPanel().setVisible(false);
				((Sesion) paneles.get(2)).getPanel().setVisible(false);
				((Resumen) paneles.get(3)).getPanel().setVisible(false);
				((Login) paneles.get(4)).getPanel().setVisible(false);
				((Registro) paneles.get(5)).getPanel().setVisible(false);
				((GeneradorTicket) paneles.get(6)).getPanel().setVisible(false);

				comboBoxCines.setSelectedIndex(0);
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
/** 
*
* Mouse clicked
*
* @param e  the e. 
*/

			public void mouseClicked(MouseEvent e) {
				((Bienvenida) paneles.get(0)).getPanel().setVisible(false);
				((Cines) paneles.get(1)).getPanel().setVisible(false);
				((Sesion) paneles.get(2)).getPanel().setVisible(false);
				((Resumen) paneles.get(3)).getPanel().setVisible(true);
				((Login) paneles.get(4)).getPanel().setVisible(false);
				((Registro) paneles.get(5)).getPanel().setVisible(false);
				((GeneradorTicket) paneles.get(6)).getPanel().setVisible(false);

				comboBoxCines.setSelectedIndex(0);
			}
		});
		imgCarrito.setBounds(544, 0, 106, 93);
		imgCarrito.setIcon(imageCarrito);
		panel.add(imgCarrito);
	}

	public JPanel getPanel() {
		return panel;
	}

	/**
	 * Carga en la tabla las peliculas dado el nombre del cine
	 * 
	 * @param nombreCine
	 */
	public void cargarPeliculasCineEnTabla(String nombreCine) {
		String[] columnas = { "Título" };
		DefaultTableModel modeloTabla = new DefaultTableModel(null, columnas);

		GestorPeliculas gestorPeliculas = new GestorPeliculas();
		ArrayList<String> nombresPeliculas = gestorPeliculas.obtenerPeliculasDelCine(nombreCine);

		for (String nombrePelicula : nombresPeliculas) {
			modeloTabla.addRow(new Object[] { nombrePelicula });
		}

		tablePeliculas.setModel(modeloTabla);
	}
}