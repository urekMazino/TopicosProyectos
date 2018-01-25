package Facturacion.InterfazGrafica.Panels;

import java.awt.GridLayout;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import Facturacion.dataAccessLayer.CatClientes;
import Facturacion.dataAccessLayer.DBCatClientes;

public class PanelEncabezado extends JPanel{
	
	CampoEntrada folio,fecha,cveCliente,cliente,domicilio,rfc;
	
	public PanelEncabezado(){
		this.setLayout(new GridLayout(3,2));
		folio = new CampoEntrada("Folio");
		fecha = new CampoEntrada("Fecha");
		fecha.changeValue(new SimpleDateFormat("ddMMyyyy").format(new Date()));
		fecha.setEditable(false);
		cveCliente = new CampoEntrada("Clave Cliente");
		cliente = new CampoEntrada("Cliente");
		cliente.setEditable(false);
		domicilio = new CampoEntrada("Domicilio");
		domicilio.setEditable(false);
		rfc = new CampoEntrada("RFC");
		rfc.setEditable(false);
		
		addListenerCveCliente();
		
		this.add(folio);
		this.add(fecha);
		this.add(cveCliente);
		this.add(cliente);
		this.add(domicilio);
		this.add(rfc);
	}
	public void addListenerCveCliente(){
		cveCliente.getField().getDocument().addDocumentListener(new DocumentListener() {
			  public void changedUpdate(DocumentEvent e) {
			    checkCveCliente();
			  }
			  public void removeUpdate(DocumentEvent e) {
			   checkCveCliente();
			  }
			  public void insertUpdate(DocumentEvent e) {
			    checkCveCliente();
			  }
		});
	}
	public void checkCveCliente(){
		int Clave;
		try{
		 Clave = Integer.parseInt(cveCliente.getField().getText());
		}catch(Exception e){
			return;
		}
		try {
			CatClientes clienteCat = DBCatClientes.DBLeeRegistro(Clave);
			cliente.changeValue(clienteCat.getNombre());
			rfc.changeValue(clienteCat.getRFC());
			domicilio.changeValue(clienteCat.getDomicilio());
		} catch (Exception error) {
//			JOptionPane.showMessageDialog(this, "No se encontro el cliente");
			limpiarInfoCliente();
		}
	}
	public void limpiar(){
		folio.changeValue("");
		fecha.changeValue(new SimpleDateFormat("ddMMyyyy").format(new Date()));
		cveCliente.changeValue("");
		limpiarInfoCliente();
	}
	public void limpiarInfoCliente(){
		cliente.changeValue("");
		domicilio.changeValue("");
		rfc.changeValue("");
	}
	public CampoEntrada getFolio() {
		return folio;
	}
	public void setFolio(CampoEntrada folio) {
		this.folio = folio;
	}
	public CampoEntrada getFecha() {
		return fecha;
	}
	public void setFecha(CampoEntrada fecha) {
		this.fecha = fecha;
	}
	public CampoEntrada getCveCliente() {
		return cveCliente;
	}
	public void setCveCliente(CampoEntrada cveCliente) {
		this.cveCliente = cveCliente;
		checkCveCliente();
	}
	
}
