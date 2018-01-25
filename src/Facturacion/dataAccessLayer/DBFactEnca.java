package Facturacion.dataAccessLayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Facturacion.dataAccessGral.DBConexion;

/**
 * @author Felipe Muñiz
 * Generado automaticamente por Java Code Generator.
 * 18/10/2017 14:09:12
 * Clase de negocios para la tabla FactEnca
 * 
 */

public class DBFactEnca extends DBConexion {

	public static FactEnca DBLeeRegistro(int clave) throws Exception {
		FactEnca reg = new FactEnca();
		Connection con = GetConnection();
		String Select = "SELECT * FROM `FactEnca` WHERE `Folio`='"+clave+"'";
		PreparedStatement st = con.prepareStatement(Select);
		ResultSet rs = st.executeQuery();
		if (!rs.wasNull()) {
			rs.next();
			reg.setFolio(rs.getInt(1));
			reg.setFecha(rs.getString(2));
			reg.setCveCte(rs.getInt(3));
			reg.setSubTotal(rs.getFloat(4));
			reg.setImpuesto(rs.getFloat(5));
			reg.setTotal(rs.getFloat(6));
			reg.setStatus(rs.getString(7));
		}
		con.close();
		return reg;
	}

	public static void DBInsert(FactEnca reg) throws Exception {
		Connection con = GetConnection();
		String Select = "INSERT INTO FactEnca ("+
			"`Folio`, `Fecha`, `CveCte`, `SubTotal`, `Impuesto`, `Total`, `Status`) "+
			"VALUES ('"+
			reg.getFolio()+"', '" +
			reg.getFecha()+"', '" +
			reg.getCveCte()+"', '" +
			reg.getSubTotal()+"', '" +
			reg.getImpuesto()+"', '" +
			reg.getTotal()+"', '" +
			reg.getStatus()+"')";
		PreparedStatement st = con.prepareStatement(Select);
		st.executeUpdate();
		con.close();
	}

	public static void DBUpdate(FactEnca reg) throws Exception {
		Connection con = GetConnection();
		String Select = "UPDATE `FactEnca` SET "+
			"`Folio`='"+reg.getFolio()+"', " +
			"`Fecha`='"+reg.getFecha()+"', " +
			"`CveCte`='"+reg.getCveCte()+"', " +
			"`SubTotal`='"+reg.getSubTotal()+"', " +
			"`Impuesto`='"+reg.getImpuesto()+"', " +
			"`Total`='"+reg.getTotal()+"', " +
			"`Status`='"+reg.getStatus()+"' " +
			"WHERE `Folio`='"+reg.getFolio()+"'";
		PreparedStatement st = con.prepareStatement(Select);
		st.executeUpdate();
		con.close();
	}

	public static void DBDelete(int Folio, boolean borrar) throws Exception {
		Connection con = GetConnection();
		String Select = "UPDATE `FactEnca` SET "+
			"`Borrado`='"+(borrar?0:1)+"' WHERE `Folio`='"+Folio+"'";
		PreparedStatement st = con.prepareStatement(Select);
		st.executeUpdate();
		con.close();
	}


}
