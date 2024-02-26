package cinesElorrieta.vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import cinesElorrieta.modelo.ResumenPojo;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


 /**
 * The class Resumen
 */ 
public class Resumen {

	private JPanel panel = null;
	private JTable tableResumen;


/** 
 *
 * It is a constructor. 
 *
 * @param paneles  the paneles. 
 */
	public Resumen(ArrayList<Object> paneles) { 

		panel = new JPanel();
		panel.setBounds(0, 0, 650, 470);
		panel.setBackground(new Color(255, 255, 255));
		panel.setLayout(null);

		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnConfirmar.addActionListener(new ActionListener() {

/** 
 *
 * Action performed
 *
 * @param e  the e. 
 */
			public void actionPerformed(ActionEvent e) { 

				int opcion = JOptionPane.showConfirmDialog(panel, "Mensaje", "Titulo del Dialogo",
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
					JOptionPane.showMessageDialog(panel, "Datos eliminados ");
					}

			}
		});
		btnConfirmar.setBounds(418, 364, 123, 23);
		panel.add(btnConfirmar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 15));
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


/** 
 *
 * Gets the panel
 *
 * @return the panel
 */
	public JPanel getPanel() { 

		return panel;
	}


/** 
 *
 * Cargar tabla resumen
 *
 * @param listaFinal  the lista final. 
 */
	public void cargarTablaResumen(ArrayList<ResumenPojo> listaFinal) { 

		
		String[] columnas = { "Cine ", "Pelicula ", "Duracion ", "Fecha ", "Horario ", "Sala ", "Precio " };

		DefaultTableModel modeloTabla = new DefaultTableModel(columnas, 0);

		for (int i = 0; i < listaFinal.size(); i++) {
			Object[] fila = { listaFinal.get(i).getCine(), listaFinal.get(i).getPelicula(),
					listaFinal.get(i).getDuracion(), listaFinal.get(i).getFecha(), listaFinal.get(i).getHorario(),
					listaFinal.get(i).getSala(), listaFinal.get(i).getPrecio() };
			modeloTabla.addRow(fila);
		}

		tableResumen.setModel(modeloTabla);
	}

}
