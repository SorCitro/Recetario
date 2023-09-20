package Domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import Datos.BaseDeDatos;
import Datos.Conexion;

public class MetodosBD {

	Conexion conexion = new Conexion();
	DefaultTableModel modeloTabla;

	public void Buscar(String valor, String filtro, JTable tabla) {

		String[] columnas = { "id","nombre", "ingredientes","ingredientePrincipal"};
		String[] registros = new String[4];
		modeloTabla = new DefaultTableModel(null, columnas);

		String SSQL;
		Connection conect = null;

		if (filtro.equals("id")) {System.out.println("if id");
			SSQL = "SELECT * FROM recetas WHERE id LIKE '%" + valor + "%'";

		} else if (filtro.equals("nombre")) {System.out.println("else if nombre");
			SSQL = "SELECT * FROM recetas WHERE nombre LIKE '%" + valor + "%'";
					
		} else if (filtro.equals("ingredientes")) {System.out.println("else if ingredientes");
			SSQL = "SELECT * FROM recetas WHERE ingredientes LIKE '%" + valor + "%'";
					
		} 	else {
			System.out.println("else ingredientePrincipal");
			SSQL = "SELECT * FROM recetas WHERE ingredientePrincipal LIKE '%" + valor + "%'";

		}

		try {
			
			System.out.println("Inicio conecion");
			System.out.println("getConnection");
			conect = conexion.getConnection();
			
			System.out.println("ps");
			PreparedStatement st = conect.prepareStatement(SSQL);
			
			System.out.println("rs");
			ResultSet rs = st.executeQuery();
			
			System.out.println("bucle while");
			while (rs.next()) {
				
				System.out.println("registro 0");
				registros[0] = rs.getString("id");
				
				System.out.println("registro 1");
				registros[1] = rs.getString("nombre");
				
				System.out.println("registro 2");
				registros[2] = rs.getString("ingredientes");
				
				System.out.println("registro 3");
				registros[3] = rs.getString("ingredientePrincipal");
				

				System.out.println("almacena datos");
				modeloTabla.addRow(registros);

			}

			System.out.println("set tabla");
			tabla.setModel(modeloTabla);

		} catch (SQLException e) {
			
			System.out.println("catch");

			JOptionPane.showMessageDialog(null, e, "Error durante el procesamiento", JOptionPane.ERROR_MESSAGE);

		} finally {
			
			System.out.println("finaly");

			if (conect != null) {

				try {
					System.out.println("close");
					conect.close();
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, e, "Error durante el cierre", JOptionPane.ERROR_MESSAGE);
					;
				}
			}

		}

	}

}
