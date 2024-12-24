package basededatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {
    // Datos de la conexión
    private static final String URL = "jdbc:postgresql://localhost:5432/parquesalitre"; // URL de la base de datos
    private static final String USUARIO = "postgres"; // Usuario de la base de datos
    private static final String CONTRASENA = "123"; // Contraseña del usuario de la base de datos

    /**
     * Método para obtener una conexión a la base de datos.
     * @return Conexión a la base de datos.
     * @throws SQLException Si hay un error al establecer la conexión.
     */
    public static Connection getConexion() throws SQLException {
        // Intentar establecer la conexión con la base de datos
        return DriverManager.getConnection(URL, USUARIO, CONTRASENA);
    }
}
