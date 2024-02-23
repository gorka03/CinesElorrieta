package cinesElorrieta.vista;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import cinesElorrieta.controller.GestorSesion;
import cinesElorrieta.modelo.ResumenPojo;
import cinesElorrieta.modelo.SesionPojo;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JScrollPane;

public class Sesion {

	private JTable tableSesion;
	private JPanel panel = null;


	private String cineSeleccionado = null;
	private String nombrePelicula = null;
	private String datosSesion = "";
	private int lineaSesion;
	private String duracion = null;
	private String fecha = null;
	private String horario = null;
	private String sala = null;
	private String precio = null;

	private ArrayList<ResumenPojo> listaResumen = null;

	public Sesion(ArrayList<Object> paneles) {
		listaResumen = new ArrayList<ResumenPojo>();
		
		panel = new JPanel();
		panel.setBounds(0, 0, 650, 470);

		panel.setBackground(new Color(255, 255, 255));
		panel.setLayout(null);

		JButton btnVolver = new JButton("Volver");
		btnVolver.setBackground(Color.WHITE);
		btnVolver.addActionListener(new ActionListener() {
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
		btnVolver.setBounds(25, 373, 143, 23);
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(btnVolver);

		ImageIcon imageLogo = new ImageIcon(this.getClass().getResource("logo.png"));
		JLabel imgLogo = new JLabel("", imageLogo, JLabel.CENTER);
		imgLogo.setBounds(10, 11, 198, 81);
		imgLogo.setIcon(imageLogo);
		panel.add(imgLogo);

		tableSesion = new JTable();
		tableSesion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				int opcion = JOptionPane.showConfirmDialog(panel, "Confirmacion", "¿Desea confirmar la sesion?",
						JOptionPane.YES_NO_OPTION);
				if (opcion == JOptionPane.YES_OPTION) {

					JOptionPane.showMessageDialog(panel, "Datos guardado correctamente ");
					((Bienvenida) paneles.get(0)).getPanel().setVisible(false);
					((Cines) paneles.get(1)).getPanel().setVisible(true);
					((Sesion) paneles.get(2)).getPanel().setVisible(false);
					((Resumen) paneles.get(3)).getPanel().setVisible(false);
					((Login) paneles.get(4)).getPanel().setVisible(false);
					((Registro) paneles.get(5)).getPanel().setVisible(false);
					((GeneradorTicket) paneles.get(6)).getPanel().setVisible(false);

					DefaultTableModel modelSesion = (DefaultTableModel) tableSesion.getModel();
					lineaSesion = tableSesion.getSelectedRow();

					if (lineaSesion != -1) {
						int numColumnas = modelSesion.getColumnCount();

						for (int i = 0; i < numColumnas; i++) {
							Object valorColumna = modelSesion.getValueAt(lineaSesion, i);
							datosSesion += valorColumna.toString();
							if (i < numColumnas - 1) {
								datosSesion += ", ";
							}
						}

						String[] datosSeparados = datosSesion.split(", ");
						// no entra en el if 
						if (datosSeparados.length == numColumnas) {
							duracion = datosSeparados[0];
							fecha = datosSeparados[1];
							horario = datosSeparados[2];
							sala = datosSeparados[3];
							precio = datosSeparados[4];
						}
					}

					guardarDatosSesion(cineSeleccionado, nombrePelicula);

					Resumen resumen =((Resumen) paneles.get(3));
					resumen.cargarTablaResumen(listaResumen);
					
					GeneradorTicket generadorTicket=((GeneradorTicket) paneles.get(6));
					generadorTicket.cargarTablaGeneradorTicket(listaResumen);

					
				} else {

					cineSeleccionado = null;
					nombrePelicula = null;

					JOptionPane.showMessageDialog(panel, "No se han guardado los datos correctamente ");

					((Bienvenida) paneles.get(0)).getPanel().setVisible(false);
					((Cines) paneles.get(1)).getPanel().setVisible(true);
					((Sesion) paneles.get(2)).getPanel().setVisible(false);
					((Resumen) paneles.get(3)).getPanel().setVisible(false);
					((Login) paneles.get(4)).getPanel().setVisible(false);
					((Registro) paneles.get(5)).getPanel().setVisible(false);
					((GeneradorTicket) paneles.get(6)).getPanel().setVisible(false);
				}

			}

		});
		tableSesion.setBounds(113, 104, 450, 266);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(238, 131, 355, 234);
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (tableSesion.getSelectedRows() != null) { //
					JOptionPane.showMessageDialog(panel, "No hay sesion seleccionado", "Error",
							JOptionPane.INFORMATION_MESSAGE);
					return; // No hace nada
				}
			}
		});
		scrollPane.setViewportView(tableSesion);
		panel.add(scrollPane);

	}

	public JPanel getPanel() {
		return panel;
	}

	public void guardarDatosSesion(String cineSeleccionado, String nombrePelicula) {

		ResumenPojo resumenPojo = new ResumenPojo(cineSeleccionado, nombrePelicula, duracion, fecha, horario, sala,
				precio);
		listaResumen.add(resumenPojo);
		System.out.println(listaResumen);
	}

	public void cargarTableSesion(String cineSeleccionado, String nombrePelicula) {

		this.cineSeleccionado = cineSeleccionado;
		this.nombrePelicula = nombrePelicula;

		System.out.println(cineSeleccionado + nombrePelicula);

		String[] columnas = { "Duracion", "Fecha", "Horario", "Sala", "Precio" };
		DefaultTableModel modeloTabla = new DefaultTableModel(null, columnas);

		GestorSesion gestorSesion = new GestorSesion();
		ArrayList<SesionPojo> sesiones = gestorSesion.obtenerSesionesPelicula(cineSeleccionado, nombrePelicula);

		for (SesionPojo sesionActual : sesiones) {

			modeloTabla.addRow(new Object[] { sesionActual.getDuracion(), sesionActual.getFecha(),
					sesionActual.getHorario(), sesionActual.getNombreSala(), sesionActual.getPrecio() });
		}

		tableSesion.setModel(modeloTabla);

	}



}