package Datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BaseDeDatos {

    private String servidor;
    private String password;
    private String usuario;
    private String nombreBD;

    public BaseDeDatos(String servidor, String nombreBD, String password, String usuario) {
        this.servidor = servidor;
        this.password = password;
        this.usuario = usuario;
        this.nombreBD = nombreBD;

        try {
            DriverManager.registerDriver(new org.gjt.mm.mysql.Driver());
        } catch (SQLException e) {
            
            throw new RuntimeException("Error al registrar el controlador de la base de datos", e);
        }
    }

    public boolean ejecutarConsulta(String consulta) throws Exception {
        Connection conexion = null;
        PreparedStatement statement = null;

        try {
            conexion = DriverManager.getConnection("jdbc:mysql://" + this.servidor + "/" + this.nombreBD, this.usuario, this.password);
            statement = conexion.prepareStatement(consulta);
            return statement.execute();
        } catch (SQLException e) {
            
            throw new Exception("Error al ejecutar la consulta: " + e.getMessage(), e);
        } finally {
            // Cierre recursos en el orden adecuado
            if (statement != null) {
                statement.close();
            }
            if (conexion != null) {
                conexion.close();
            }
        }
    }

    
}
