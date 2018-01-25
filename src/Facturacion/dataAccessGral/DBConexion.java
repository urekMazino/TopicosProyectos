package Facturacion.dataAccessGral;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class DBConexion {

	@SuppressWarnings("finally")
	public static Connection GetConnection() {
		Connection conexion = null;
		try {
//			Class.forName("com.mysql.jdbc.Driver");

			conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/Facturacion");
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, ex, "Error en la Conexión con la BD: " + ex.getMessage(),
					JOptionPane.ERROR_MESSAGE);
			conexion = null;
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex, "Error del programa: " + ex.getMessage(),
					JOptionPane.ERROR_MESSAGE);
			conexion = null;
		} finally {
			return conexion;
		}
	}

	public static LinkedList<String> DatosCombo(int Opcion) throws Exception {
		LinkedList<String> lista = new LinkedList<String>();
		String SELECT = "";
		Connection con = GetConnection();
		switch (Opcion) {
		case 1:
			SELECT = "select distinct campo1 from tabla order by campo1";
			break;
		case 2:
			SELECT = "select distinct campo2 from tabla order by campo2";
			break;
		case 3:
			SELECT = "select distinct campo3 from tabla order by campo3";
			break;
		case 6:
			lista.add("Todas");
		case 4:
			SELECT = "select distinct campo4 from tabla order by campo4";
			break;
		}
		PreparedStatement st = con.prepareStatement(SELECT);
		ResultSet rs = st.executeQuery();
		while (rs.next())
			lista.add(rs.getString(1));
		con.close();
		return lista;
	}
}
