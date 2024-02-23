package cinesElorrieta.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import cinesElorrieta.modelo.SesionPojo;
import cinesElorrieta.utils.DBUtils;

public class GestorSesion {

    public ArrayList<SesionPojo> obtenerSesionesPelicula(String cineSeleccionado , String nombrePelicula) {
        ArrayList<SesionPojo> datosPelicula = new ArrayList<>();
        

        String sql = "SELECT p.duracion, p.precio, se.fecha, se.horario, s.nombre AS nombre_sala " +
                "FROM pelicula p " +
                "JOIN sesion se ON p.idPelicula = se.idPelicula " +
                "JOIN sala s ON se.idSala = s.idSala " +
                "JOIN cine c ON s.idCine = c.idCine " +
                "WHERE p.nombre = '" + nombrePelicula + "' AND c.nombre = '" + cineSeleccionado + "'";
        
        Connection connection = null;

        java.sql.Statement statement = null;

        ResultSet resultSet = null;
        try {

            Class.forName(DBUtils.DRIVER);

            connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

            statement = connection.createStatement();

            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                String duracion = resultSet.getString("duracion");
                double precio = resultSet.getDouble("precio");
                String fecha = resultSet.getString("fecha");
                String horario = resultSet.getString("horario");
                String nombreSala = resultSet.getString("nombre_sala");

                SesionPojo sesion = new SesionPojo(duracion, precio, fecha, horario, nombreSala);
                datosPelicula.add(sesion);
            }

        } catch (SQLException sqle) {

            System.out.println("Error con la BBDD - " + sqle.getMessage());

        } catch (Exception e) {

            System.out.println("Error generico - " + e.getMessage());

        } finally {

            try {

                if (resultSet != null)

                    resultSet.close();

            } catch (Exception e) {

            }

            ;

            try {

                if (statement != null)

                    statement.close();

            } catch (Exception e) {

            }

            ;

            try {

                if (connection != null)

                    connection.close();

            } catch (Exception e) {

            }

            ;

        }
        return datosPelicula;
    }

  
}