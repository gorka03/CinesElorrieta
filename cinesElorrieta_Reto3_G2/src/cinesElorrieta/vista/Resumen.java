package cinesElorrieta.vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;

import cinesElorrieta.modelo.ResumenPojo;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Resumen {

	private JPanel panel = null;
	private JTable tableResumen;

	public Resumen(ArrayList<Object> paneles) {
		panel = new JPanel();
		panel.setBounds(0, 0, 650, 470);
		panel.setBackground(new Color(255, 255, 255));
		panel.setLayout(null);

		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int opcion = JOptionPane.showConfirmDialog(panel, "Mensaje", "Titulo del Diálogo",
						JOptionPane.YES_NO_OPTION);
				if (opcion == JOptionPane.YES_OPTION) {

					JOptionPane.showMessageDialog(panel, "Guardado correctamente ");
					((Bienvenida) paneles.get(0)).getPanel().setVisible(false);
					((Cines) paneles.get(1)).getPanel().setVisible(false);
					((Sesion) paneles.get(2)).getPanel().setVisible(false);
					((Resumen) paneles.get(3)).getPanel().setVisible(false);
					((Login) paneles.get(4)).getPanel().setVisible(true);
					((Registro) paneles.get(5)).getPanel().setVisible(false);
					((GeneradorTicket) paneles.get(6)).getPanel().setVisible(false);
				} else {
					System.out.println("");
				}

			}
		});
		btnConfirmar.setBounds(418, 364, 123, 23);
		panel.add(btnConfirmar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCancelar.addActionListener(new ActionListener() {
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
		btnCancelar.setBounds(121, 364, 117, 23);
		panel.add(btnCancelar);

		ImageIcon imageLogo = new ImageIcon(this.getClass().getResource("logo.png"));
		JLabel imgLogo = new JLabel("", imageLogo, JLabel.CENTER);
		imgLogo.setBounds(10, 11, 198, 81);
		imgLogo.setIcon(imageLogo);
		panel.add(imgLogo);

		tableResumen = new JTable();
		tableResumen.setBounds(120, 116, 446, 258);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 103, 604, 250);
		scrollPane.setViewportView(tableResumen);
		panel.add(scrollPane);

	}

	public JPanel getPanel() {
		return panel;
	}

	public void cargarTablaResumen(ArrayList<ResumenPojo> listaResumen) {
		// Columnas de la tabla
		String[] columnas = { "Cine ", "Pelicula ", "Duracion ", "Fecha ", "Horario ", "Sala ", "Precio " };

		// Crear el modelo de tabla
		DefaultTableModel modeloTabla = new DefaultTableModel(columnas, 0);

		// Agregar los datos al modelo de tabla
		/*
		 * for (ResumenPojo resumenPojo : listaResumen) { Object[] fila =
		 * {resumenPojo.getCine(), resumenPojo.getPelicula(), resumenPojo.getDuracion(),
		 * resumenPojo.getFecha(), resumenPojo.getHorario(), resumenPojo.getSala(),
		 * resumenPojo.getPrecio()}; modeloTabla.addRow(fila); }
		 */

		for (int i = 0; i < listaResumen.size(); i++) {
			Object[] fila = { listaResumen.get(i).getCine(), listaResumen.get(i).getPelicula(),
					listaResumen.get(i).getDuracion(), listaResumen.get(i).getFecha(), listaResumen.get(i).getHorario(),
					listaResumen.get(i).getSala(), listaResumen.get(i).getPrecio() };
			modeloTabla.addRow(fila);
		}

		// Asignar el modelo de tabla al JTable
		tableResumen.setModel(modeloTabla);
	}

}
