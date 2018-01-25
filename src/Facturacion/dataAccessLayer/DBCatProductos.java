package Facturacion.dataAccessLayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Facturacion.dataAccessGral.DBConexion;

/**
 * @author Felipe Muñiz
 * Generado automaticamente por Java Code Generator.
 * 18/10/2017 14:06:27
 * Clase de negocios para la tabla CatProductos
 * 
 */

public class DBCatProductos extends DBConexion {

	public static CatProductos DBLeeRegistro(int clave) throws Exception {
		CatProductos reg = new CatProductos();
		Connection con = GetConnection();
		String Select = "SELECT * FROM `CatProductos` WHERE `CveProd`='"+clave+"'";
		PreparedStatement st = con.prepareStatement(Select);
		ResultSet rs = st.executeQuery();
		if (!rs.wasNull()) {
			rs.next();
			reg.setCveProd(rs.getInt(1));
			reg.setDescripcion(rs.getString(2));
			reg.setPrecio(rs.getFloat(3));
			reg.setExistencia(rs.getInt(4));
			reg.setStatus(rs.getString(5));
		}
		con.close();
		return reg;
	}

	public static void DBInsert(CatProductos reg) throws Exception {
		Connection con = GetConnection();
		String Select = "INSERT INTO CatProductos ("+
			"`CveProd`, `Descripcion`, `Precio`, `Existencia`, `Status`) "+
			"VALUES ('"+
			reg.getCveProd()+"', '" +
			reg.getDescripcion()+"', '" +
			reg.getPrecio()+"', '" +
			reg.getExistencia()+"', '" +
			reg.getStatus()+"')";
		PreparedStatement st = con.prepareStatement(Select);
		st.executeUpdate();
		con.close();
	}

	public static void DBUpdate(CatProductos reg) throws Exception {
		Connection con = GetConnection();
		String Select = "UPDATE `CatProductos` SET "+
			"`CveProd`='"+reg.getCveProd()+"', " +
			"`Descripcion`='"+reg.getDescripcion()+"', " +
			"`Precio`='"+reg.getPrecio()+"', " +
			"`Existencia`='"+reg.getExistencia()+"', " +
			"`Status`='"+reg.getStatus()+"' " +
			"WHERE `CveProd`='"+reg.getCveProd()+"'";
		PreparedStatement st = con.prepareStatement(Select);
		st.executeUpdate();
		con.close();
	}

	public static void DBDelete(int CveProd, boolean borrar) throws Exception {
		Connection con = GetConnection();
		String Select = "UPDATE `CatProductos` SET "+
			"`Borrado`='"+(borrar?0:1)+"' WHERE `CveProd`='"+CveProd+"'";
		PreparedStatement st = con.prepareStatement(Select);
		st.executeUpdate();
		con.close();
	}


}
