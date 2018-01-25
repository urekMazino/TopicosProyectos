package Facturacion.dataAccessLayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import Facturacion.dataAccessGral.DBConexion;

/**
 * @author Felipe Muñiz Generado automaticamente por Java Code Generator.
 *         18/10/2017 13:31:32 Clase de negocios para la tabla CatClientes
 * 
 */

public class DBCatClientes extends DBConexion {

	public static CatClientes DBLeeRegistro(int clave) throws Exception {
		CatClientes reg = new CatClientes();
		Connection con = GetConnection();
		String Select = "SELECT * FROM `CatClientes` WHERE `CveCte`='" + clave + "'";
		PreparedStatement st = con.prepareStatement(Select);
		ResultSet rs = st.executeQuery();
		if (!rs.wasNull()) {
			rs.next();
			reg.setCveCte(rs.getInt(1));
			reg.setNombre(rs.getString(2));
			reg.setRFC(rs.getString(3));
			reg.setDomicilio(rs.getString(4));
			reg.setStatus(rs.getString(5));
		}
		con.close();
		return reg;
	}

	public static void DBInsert(CatClientes reg) throws Exception {
		Connection con = GetConnection();
		String Select = "INSERT INTO CatClientes (" + "`CveCte`, `Nombre`, `RFC`, `Domicilio`, `Status`) " + "VALUES ('"
				+ reg.getCveCte() + "', '" + reg.getNombre() + "', '" + reg.getRFC() + "', '" + reg.getDomicilio()
				+ "', '" + reg.getStatus() + "')";
		PreparedStatement st = con.prepareStatement(Select);
		st.executeUpdate();
		con.close();
	}

	public static void DBUpdate(CatClientes reg) throws Exception {
		Connection con = GetConnection();
		String Select = "UPDATE `CatClientes` SET " + "`CveCte`='" + reg.getCveCte() + "', " + "`Nombre`='"
				+ reg.getNombre() + "', " + "`RFC`='" + reg.getRFC() + "', " + "`Domicilio`='" + reg.getDomicilio()
				+ "', " + "`Status`='" + reg.getStatus() + "' " + "WHERE `CveCte`='" + reg.getCveCte() + "'";
		PreparedStatement st = con.prepareStatement(Select);
		st.executeUpdate();
		con.close();
	}

	public static void DBDelete(int CveCte, boolean borrar) throws Exception {
		Connection con = GetConnection();
		String Select = "UPDATE `CatClientes` SET " + "`Borrado`='" + (borrar ? 0 : 1) + "' WHERE `CveCte`='" + CveCte
				+ "'";
		PreparedStatement st = con.prepareStatement(Select);
		st.executeUpdate();
		con.close();
	}

	public static void CargarCombo(JComboBox<String> combo, int Opcion) {
		combo.removeAllItems();
		// combo.addItem("Activo");
		// combo.addItem("Inactivo");
		try {
			LinkedList<String> datos = DBConexion.DatosCombo(Opcion);
			while (!datos.isEmpty())
				combo.addItem(datos.pop());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e, "Error al cargar combo: " + e.getMessage(),
					JOptionPane.ERROR_MESSAGE);
		}
	}

}
