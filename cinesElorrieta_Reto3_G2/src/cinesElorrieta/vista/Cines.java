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

import cinesElorrieta.modelo.Cine;
import cinesElorrieta.utils.DBUtils;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Cines {

	private JTable tablePeliculas;
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
		
		ArrayList<Cine> cines = obtenerDatosCines();  

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
		panel.add(tablePeliculas);
		
		comboBoxCines.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String cineSeleccionado = (String) comboBoxCines.getSelectedItem();
                cargarDatosCineEnTabla(cineSeleccionado);
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
	
	private ArrayList <Cine> obtenerDatosCines (){
		ArrayList <Cine> ret = null;
		
		// SQL que queremos lanzar
		String sql = "select * from cine";
		
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
			while(resultSet.next()) {
				
				// Si es necesario, inicializamos la lista
				if (null == ret)
					ret = new  ArrayList<Cine> ();
				
				Cine cine = new Cine ();
				
				// Sacamos las columnas del RS
				int idCine = resultSet.getInt("idCine");
                String nombre = resultSet.getString("nombre");
                String direccion = resultSet.getString("direccion");
                
                // Metemos los datos a Ejemplo
                cine.setIdCine(idCine);
                cine.setNombre(nombre);
                cine.setDireccion(direccion);
                
                // Lo guardamos en ret
                ret.add(cine);
			}
		} catch (SQLException sqle) {  
			System.out.println("Error con la BBDD - " + sqle.getMessage());
		} catch(Exception e){ 
			System.out.println("Error generico - " + e.getMessage());
		} finally {
			// Cerramos al reves de como las abrimos
			try {
				if (resultSet != null) 
					resultSet.close(); 
			} catch(Exception e){ 
				// No hace falta 
			};
			try {
				if (statement != null) 
					statement.close(); 
			} catch(Exception e){ 
				// No hace falta				
			};
			try {
				if (connection != null) 
					connection.close(); 
			} catch(Exception e){ 
				// No hace falta
			};					
		}
		return ret;
}

	private void cargarDatosCineEnTabla(String nombreCine) {

    String[] columnas = {"ID Película", "Título", "Duración"};


    DefaultTableModel modeloTabla = new DefaultTableModel(null, columnas);

    String sql = "SELECT idPelicula, titulo, duracion FROM pelicula WHERE idCine = (SELECT idCine FROM cine WHERE nombre = ?)";

    try (Connection connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);
         PreparedStatement statement = connection.prepareStatement(sql)) {

        statement.setString(1, nombreCine);

        try (ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Object[] fila = {
                        resultSet.getInt("idPelicula"),
                        resultSet.getString("titulo"),
                        resultSet.getString("duracion")
                };
                modeloTabla.addRow(fila);
            }
        }
    } catch (SQLException sqle) {
        System.out.println("Error al cargar datos en la tabla: " + sqle.getMessage());
    }

    tablePeliculas.setModel(modeloTabla);
}
}