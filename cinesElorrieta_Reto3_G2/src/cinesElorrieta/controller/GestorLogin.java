package cinesElorrieta.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import cinesElorrieta.modelo.Cliente;
import cinesElorrieta.utils.DBUtils;

public class GestorLogin  {

	public void inicioSesion(String usuario, String contrasenna) {
		
		
	}
	public static boolean verificarCredenciales(String usuario, String contrasenna) {
		ArrayList<Cliente> clientes = obtenerDatosLogin();
		if (clientes != null) {
			for (Cliente cliente : clientes) {
				if (cliente.getUserName().equals(usuario) && cliente.getContrasenna().equals(contrasenna)) {
					return true; // Credenciales válidas
				}
			}
		}
		return false; // Credenciales inválidas
	}
	private static ArrayList<Cliente> obtenerDatosLogin() {
		ArrayList<Cliente> ret = null;

		// SQL que queremos lanzar
		String sql = "select * from cliente";

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
			while (resultSet.next()) {

				// Si es necesario, inicializamos la lista
				if (null == ret)
					ret = new ArrayList<Cliente>();

				Cliente cliente = new Cliente();

				// Sacamos las columnas del RS
				String userName = resultSet.getString("userName");
				String contrasenna = resultSet.getString("contrasenna");

				// Metemos los datos a Ejemplo
				cliente.setUserName(userName);
				cliente.setContrasenna(contrasenna);

				// Lo guardamos en ret
				ret.add(cliente);
			}
		} catch (SQLException sqle) {
			System.out.println("Error con la BBDD - " + sqle.getMessage());
		} catch (Exception e) {
			System.out.println("Error generico - " + e.getMessage());
		} finally {
			// Cerramos al reves de como las abrimos
			try {
				if (resultSet != null)
					resultSet.close();
			} catch (Exception e) {
				// No hace falta
			}
			;
			try {
				if (statement != null)
					statement.close();
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
			;
		}
		return ret;
	}

}
