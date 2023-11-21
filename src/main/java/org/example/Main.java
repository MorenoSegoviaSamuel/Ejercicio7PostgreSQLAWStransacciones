package org.example;

import java.sql.*;
import java.time.LocalDate;


public class Main {
    public static void main(String[] args) {

        String urlConexion = "jdbc:postgresql://database-1.ccgdo7eucjes.us-east-1.rds.amazonaws.com:5432/f12006";
        String usuario = "postgres";
        String password = "samseg2003";

        Constructor seat = new Constructor("seatf1","SeatF1","Spanish","http://en.wikipedia.org/wiki/McLaren");
        Piloto carlosSainz = new Piloto("SAI","Carlos","Sainz", LocalDate.of(1982,12,20),"Spanish","https://en.wikipedia.org/wiki/Carlos_Sainz_Jr.",seat);
        Piloto manuelAloma = new Piloto("ALO","Manuel","Alomá",LocalDate.of(1983, 2, 2),"Spanish","https://en.wikipedia.org/wiki/Carlos_Sainz_Jr.",seat);

        try (Connection conexion = DriverManager.getConnection(urlConexion, usuario, password)) {
            try {
                // Por defecto, el gestor de base de datos ejecuta una operación de confirmación después de la ejecución de cada sentencia de SQL.
                // Para desactivar la confirmación automática e iniciar así una transacción, invocamos el método Connection.setAutoCommit(false).
                conexion.setAutoCommit(false);

                String insercionConstructor = "INSERT INTO constructors (constructorref, name, nationality, url)" +
                        " VALUES (?, ?, ?, ?)";
                PreparedStatement insercion = conexion.prepareStatement(insercionConstructor);
                insercion.setString(1, seat.getConstructorRef());
                insercion.setString(2, seat.getName());
                insercion.setString(3, seat.getNationality());
                insercion.setString(4, seat.getUrl());

                //Ejecutamos la sentencia DML y recogemos el número de filas afectadas, si quisiéramos utilizarlo a posteriori
                insercion.executeUpdate();

                ResultSet rs = insercion.getGeneratedKeys();
                rs.next();
                int id = rs.getInt(1);

                System.out.println(id);rs.next();

                System.out.println("HOLA");


                String insercionDriver1 = "INSERT INTO drivers (code, forename, surname, dob, nationality, url, constructorId)" +
                        " VALUES (?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement insercion2 = conexion.prepareStatement(insercionDriver1);
                insercion.setString(1, carlosSainz.getCode());
                insercion.setString(2, carlosSainz.getForename());
                insercion.setString(3, carlosSainz.getSurname());
                insercion.setString(4, carlosSainz.getDob().toString());
                insercion.setString(5, carlosSainz.getNationality());
                insercion.setString(6, carlosSainz.getUrl());
                insercion.setObject(7, carlosSainz.getEquipo());

                //Ejecutamos la sentencia DML y recogemos el número de filas afectadas, si quisiéramos utilizarlo a posteriori
                insercion2.executeUpdate();

                String insercionDriver2 = "INSERT INTO drivers (code, forename, surname, dob, nationality, url, constructorId)" +
                        " VALUES (?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement insercion3 = conexion.prepareStatement(insercionDriver2);
                insercion.setString(1, manuelAloma.getCode());
                insercion.setString(2, manuelAloma.getForename());
                insercion.setString(3, manuelAloma.getSurname());
                insercion.setString(4, manuelAloma.getDob().toString());
                insercion.setString(5, manuelAloma.getNationality());
                insercion.setString(6, manuelAloma.getUrl());
                insercion.setObject(7, manuelAloma.getEquipo());

                //Ejecutamos la sentencia DML y recogemos el número de filas afectadas, si quisiéramos utilizarlo a posteriori
                insercion3.executeUpdate();

                // Finaliza la transacción, confirmando los cambios en la base de datos
                conexion.commit();
                // Es buena práctica volver a activar la confirmación automática
                conexion.setAutoCommit(true);

                insercion.close();
                insercion2.close();
                insercion3.close();

            } catch (SQLException ex1) {
                System.err.println(ex1.getClass().getName() + ": " + ex1.getMessage());
                try {
                    // Deshacemos las operaciones realizadas en la base de datos
                    conexion.rollback();
                    System.err.println("ROLLBACK ejecutado");
                } catch (SQLException ex2) {
                    System.err.println("Error haciendo ROLLBACK");
                }
            }
        } catch (SQLException ex) {
            System.err.println(ex.getClass().getName() + ": " + ex.getMessage());
        }
    }
}
