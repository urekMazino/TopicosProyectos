package Facturacion.dataAccessLayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Facturacion.dataAccessGral.DBConexion;

/**
 * @author Felipe Muñiz
 * Generado automaticamente por Java Code Generator.
 * 18/10/2017 14:12:17
 * Clase de negocios para la tabla FactDeta
 * 
 */

public class DBFactDeta extends DBConexion {

	public static FactDeta DBLeeRegistro(int clave) throws Exception {
		FactDeta reg = new FactDeta();
		Connection con = GetConnection();
		String Select = "SELECT * FROM `FactDeta` WHERE `Folio`='"+clave+"'";
		PreparedStatement st = con.prepareStatement(Select);
		ResultSet rs = st.executeQuery();
		if (!rs.wasNull()) {
			rs.next();
			reg.setFolio(rs.getInt(1));
			reg.setRenglon(rs.getInt(2));
			reg.setCantidad(rs.getInt(3));
			reg.setCveProd(rs.getInt(4));
			reg.setPrecio(rs.getFloat(5));
			reg.setImporte(rs.getFloat(6));
			reg.setDescripcion(rs.getString(7));
			reg.setStatus(rs.getString(8));
		}
		con.close();
		return reg;
	}
	public static ArrayList<FactDeta> DBLeeRegistros(int clave) throws Exception {
		ArrayList<FactDeta> registros = new ArrayList<>();
		Connection con = GetConnection();
		String Select = "SELECT * FROM `FactDeta` WHERE `Folio`='"+clave+"'";
		PreparedStatement st = con.prepareStatement(Select);
		ResultSet rs = st.executeQuery();
		while(rs.next()){
			FactDeta reg = new FactDeta();
			reg.setFolio(rs.getInt(1));
			reg.setRenglon(rs.getInt(2));
			reg.setCantidad(rs.getInt(3));
			reg.setCveProd(rs.getInt(4));
			reg.setPrecio(rs.getFloat(5));
			reg.setImporte(rs.getFloat(6));
			reg.setDescripcion(rs.getString(7));
			reg.setStatus(rs.getString(8));
			registros.add(reg);
		}
		con.close();
		return registros;
	}
	public static void DBInsert(FactDeta reg) throws Exception {
		Connection con = GetConnection();
		String Select = "INSERT INTO FactDeta ("+
			"`Folio`, `Renglon`, `Cantidad`, `CveProd`, `Precio`, `Importe`,`Descripcion`, `Status`) "+
			"VALUES ('"+
			reg.getFolio()+"', '" +
			reg.getRenglon()+"', '" +
			reg.getCantidad()+"', '" +
			reg.getCveProd()+"', '" +
			reg.getPrecio()+"', '" +
			reg.getImporte()+"', '" +
			reg.getDescripcion()+"', '" +
			reg.getStatus()+"')";
		PreparedStatement st = con.prepareStatement(Select);
		st.executeUpdate();
		con.close();
	}

	public static boolean DBUpdate(FactDeta reg) throws Exception {
		Connection con = GetConnection();
		int res;
		String Select = "UPDATE `FactDeta` SET "+
			"`Folio`='"+reg.getFolio()+"', " +
			"`Renglon`='"+reg.getRenglon()+"', " +
			"`Cantidad`='"+reg.getCantidad()+"', " +
			"`CveProd`='"+reg.getCveProd()+"', " +
			"`Precio`='"+reg.getPrecio()+"', " +
			"`Importe`='"+reg.getImporte()+"', " +
			"`Descripcion`='"+reg.getDescripcion()+"', " +
			"`Status`='"+reg.getStatus()+"' " +
			"WHERE `Folio`='"+reg.getFolio()+"' AND `Renglon`='"+reg.getRenglon()+"'";
		PreparedStatement st = con.prepareStatement(Select);
		res = st.executeUpdate();
		con.close();
		
		return (res==0)?false:true;
	}

	public static void DBDelete(int Folio, boolean borrar) throws Exception {
		Connection con = GetConnection();
		String Select = "UPDATE `FactDeta` SET "+
			"`Borrado`='"+(borrar?0:1)+"' WHERE `Folio`='"+Folio+"'";
		PreparedStatement st = con.prepareStatement(Select);
		st.executeUpdate();
		con.close();
	}


}
