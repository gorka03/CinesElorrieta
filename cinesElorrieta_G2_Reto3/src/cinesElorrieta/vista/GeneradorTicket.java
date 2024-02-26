package cinesElorrieta.vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import cinesElorrieta.modelo.ResumenPojo;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;


 /**
 * The class Generador ticket
 */ 
public class GeneradorTicket {
	private JPanel panel = null;
	private JTable tableTicket;


/** 
 *
 * It is a constructor. 
 *
 * @param paneles  the paneles. 
 */
	public GeneradorTicket(ArrayList<Object> paneles) { 

		panel = new JPanel();
		panel.setBounds(0, 0, 650, 470);
		panel.setBackground(new Color(255, 255, 255));

		ImageIcon imageLogo = new ImageIcon(this.getClass().getResource("logo.png"));
		panel.setLayout(null);
		JLabel imgLogo = new JLabel("", imageLogo, JLabel.CENTER);
		imgLogo.setBounds(10, 11, 198, 81);
		imgLogo.setIcon(imageLogo);
		panel.add(imgLogo);

		tableTicket= new JTable();
		tableTicket.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		tableTicket.setBounds(120, 116, 446, 258);
		panel.add(tableTicket);

		JButton btnConfirmar = new JButton("Imprimir ticket");
		btnConfirmar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnConfirmar.addActionListener(new ActionListener() {

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
			}
		});
		btnConfirmar.setBounds(269, 403, 152, 23);
		panel.add(btnConfirmar);


		JLabel lblAgradecimiento = new JLabel("\"Gracias por su compra\"");
		lblAgradecimiento.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAgradecimiento.setBounds(334, 49, 198, 54);
		panel.add(lblAgradecimiento);
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
 * Cargar tabla generador ticket
 *
 * @param listaFinal  the lista final. 
 */
		public void cargarTablaGeneradorTicket(ArrayList<ResumenPojo> listaFinal) { 

			String[] columnas = { "Cine ", "Pelicula ", "Duracion ", "Fecha ", "Horario ", "Sala ", "Precio " };

			DefaultTableModel modeloTabla = new DefaultTableModel(columnas, 0);

			for (int i = 0; i < listaFinal.size(); i++) {
				Object[] fila = { listaFinal.get(i).getCine(), listaFinal.get(i).getPelicula(),
						listaFinal.get(i).getDuracion(), listaFinal.get(i).getFecha(), listaFinal.get(i).getHorario(),
						listaFinal.get(i).getSala(), listaFinal.get(i).getPrecio() };
				modeloTabla.addRow(fila);
			}

			tableTicket.setModel(modeloTabla);
		}

	}
