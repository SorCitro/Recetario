package Datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Domain.Receta;
import Domain.Usuario;

public class UsuarioDAO {

    // Definici�n de consultas SQL
    private static final String SQL_SELECT_ALL = "SELECT id, nombre, password FROM usuarios";
    private static final String SQL_INSERT = "INSERT INTO usuarios (nombre, password) VALUES (?, ?)";
    private static final String SQL_UPDATE = "UPDATE usuarios SET nombre=?, password=? WHERE id=?";
    private static final String SQL_DELETE = "DELETE FROM usuarios WHERE id=?";

    private BaseDeDatos baseDeDatos;

    public UsuarioDAO(BaseDeDatos baseDeDatos) {
        this.baseDeDatos = baseDeDatos;
    }

    public List<Usuario> seleccionarTodos() throws Exception {
        List<Usuario> usuarios = new ArrayList<Usuario>();
        Connection conexion = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            conexion = ((Statement) baseDeDatos).getConnection();
            statement = conexion.prepareStatement(SQL_SELECT_ALL);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String userName = resultSet.getString("nombre");
                String userPass = resultSet.getString("password");
                Usuario usuario = new Usuario(id, userName, userPass);
                usuarios.add(usuario);
            }
        } catch (SQLException e) {
           
            throw new Exception("Error al seleccionar usuarios: " + e.getMessage(), e);
        } finally {
            try {
	            resultSet.close();
	            statement.close();
	            conexion.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
        }

        return usuarios;
    }
    
    

    public int insertar(Usuario usuario) throws Exception {
        Connection conexion = null;
        PreparedStatement statement = null;
        int registrosInsertados = 0;

        try {
            conexion = ((Statement) baseDeDatos).getConnection();
            statement = conexion.prepareStatement(SQL_INSERT);
            statement.setString(1, usuario.getUserName());
            statement.setString(2, usuario.getUserPass());
            registrosInsertados = statement.executeUpdate();
        } catch (SQLException e) {
            
            throw new Exception("Error al insertar usuario: " + e.getMessage(), e);
        } finally {
        	statement.close();
        	conexion.close();
        }

        return registrosInsertados;
    }

    public int actualizar(Usuario usuario) throws Exception {
        Connection conexion = null;
        PreparedStatement statement = null;
        int registrosActualizados = 0;

        try {
            conexion = ((Statement) baseDeDatos).getConnection();
            statement = conexion.prepareStatement(SQL_UPDATE);
            statement.setString(1, usuario.getUserName());
            statement.setString(2, usuario.getUserPass());
            statement.setInt(3, usuario.getId());
            registrosActualizados = statement.executeUpdate();
        } catch (SQLException e) {
            
            throw new Exception("Error al actualizar usuario: " + e.getMessage(), e);
        } finally {
        	statement.close();
        	conexion.close();
        }

        return registrosActualizados;
    }

    public int eliminar(Usuario usuario) throws Exception {
        Connection conexion = null;
        PreparedStatement statement = null;
        int registrosEliminados = 0;

        try {
            conexion = ((Statement) baseDeDatos).getConnection();
            statement = conexion.prepareStatement(SQL_DELETE);
            statement.setInt(1, usuario.getId());
            registrosEliminados = statement.executeUpdate();
        } catch (SQLException e) {
            // Puedes manejar la excepci�n o lanzar una excepci�n personalizada aqu�
            throw new Exception("Error al eliminar usuario: " + e.getMessage(), e);
        } finally {
        	statement.close();
        	conexion.close();
        }

        return registrosEliminados;
    }
    
    
    public List<Receta> seleccionarReceta() throws Exception {
        List<Receta> recetas = new ArrayList<Receta>();
        Connection conexion = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            conexion = ((Statement) baseDeDatos).getConnection();
            statement = conexion.prepareStatement(SQL_SELECT_ALL);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nombre = resultSet.getString("nombre");
                String ingredientes = resultSet.getString("ingredientes");
                String descripcion = resultSet.getString("descripcion");
                String ingredientePrincipal = resultSet.getString("ingrediente principal");
                Receta receta = new Receta(id, nombre, ingredientes, descripcion, ingredientePrincipal);
                recetas.add(receta);
            }
        } catch (SQLException e) {
           
            throw new Exception("Error al seleccionar usuarios: " + e.getMessage(), e);
        } finally {
            try {
	            resultSet.close();
	            statement.close();
	            conexion.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
        }

        return recetas;
    }
    
    
    public int insertarReceta(Receta receta) {
        Connection conexion = null;
        PreparedStatement ps = null;
        int registrosInsertados = 0;

        try {
            conexion = Conexion.getConnection();
            String query = "INSERT INTO recetas (nombre, ingredientes, descripcion,ingredientePrincipal) VALUES (?, ?, ?,?)";
            ps = conexion.prepareStatement(query);
            ps.setString(1, receta.getNombre());
            ps.setString(2, receta.getIngredientes());
            ps.setString(3, receta.getDescripcion());
            ps.setString(4, receta.getIngredientePrincipal());

            registrosInsertados = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                	ps.close();
                }
                if (conexion != null) {
                    conexion.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return registrosInsertados;
    }
    
    public int actualizarReceta(Receta receta) throws Exception {
        Connection conexion = null;
        PreparedStatement statement = null;
        int registrosActualizados = 0;

        try {
            conexion = ((Statement) baseDeDatos).getConnection();
            statement = conexion.prepareStatement(SQL_UPDATE);
            statement.setString(1, receta.getNombre());
            statement.setInt(2, receta.getId());
            registrosActualizados = statement.executeUpdate();
        } catch (SQLException e) {
            
            throw new Exception("Error al actualizar usuario: " + e.getMessage(), e);
        } finally {
        	statement.close();
        	conexion.close();
        }

        return registrosActualizados;
    }

    public int eliminarReceta(Receta receta) throws Exception {
        Connection conexion = null;
        PreparedStatement statement = null;
        int registrosEliminados = 0;

        try {
            conexion = ((Statement) baseDeDatos).getConnection();
            statement = conexion.prepareStatement(SQL_DELETE);
            statement.setInt(1, receta.getId());
            registrosEliminados = statement.executeUpdate();
        } catch (SQLException e) {
            // Puedes manejar la excepci�n o lanzar una excepci�n personalizada aqu�
            throw new Exception("Error al eliminar receta: " + e.getMessage(), e);
        } finally {
        	statement.close();
        	conexion.close();
        }

        return registrosEliminados;
    }

}

