package Facturacion.InterfazGrafica.Panels;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Facturacion.InterfazGrafica.Botones.Botones;
import Facturacion.dataAccessLayer.CatClientes;
import Facturacion.dataAccessLayer.DBCatClientes;
import Facturacion.dataAccessLayer.DBFactEnca;
import Facturacion.dataAccessLayer.FactEnca;

public class PanelFactura extends PanelImp{

	private JComboBox<String> cmbStatus;
	private PanelTotal panelTotal;
	private PanelEncabezado panelEncabezado;
	private PanelDetalles panelDetalles;
	
	private String[] statusStrings;
	public PanelFactura(JFrame frame) {
		super(frame);
	}

	@Override
	public void initPanel() {
		statusStrings= new String[]{ "Activo", "Inactivo"};
		cmbStatus = new JComboBox<String>(statusStrings);
		this.setLayout(new BorderLayout());	
		
		panelTotal = new PanelTotal(this);
		panelEncabezado = new PanelEncabezado();
		panelDetalles = new PanelDetalles(panelTotal,this);
		
		this.add(panelTotal,BorderLayout.SOUTH);
		this.add(panelEncabezado,BorderLayout.NORTH);
		this.add(panelDetalles,BorderLayout.CENTER);
		
	}
	
	public void agregarProducto(){
		panelDetalles.agregarProducto();
	}
	public void cambiarTotal(){
		panelTotal.calcular(panelDetalles.getTable());
	}
	
	public void nuevoDetalle(){
		agregarProducto();
	}
	
	@Override
	public void leerRegistro(){
		int Clave = Integer.parseInt(panelEncabezado.getFolio().getValue());
		try {
			FactEnca encabezado = DBFactEnca.DBLeeRegistro(Clave);
			panelEncabezado.getFecha().getField().setText(encabezado.getFecha());
			panelTotal.getSubtotal().getField().setText(encabezado.getSubTotal()+"");
			panelEncabezado.getCveCliente().getField().setText(encabezado.getCveCte()+"");
			panelTotal.getTotal().getField().setText(encabezado.getTotal()+"");
			panelTotal.getImpuesto().getField().setText(encabezado.getImpuesto()+"");
			panelDetalles.leerDetalles();
//			setComboBox(encabezado.getStatus());
		} catch (Exception error) {
			System.out.println(error.getMessage());
		}
	}

	private void setComboBox(String str){
		for (int i=0;i<statusStrings.length;i++){
			if (statusStrings[i].equals(str)){
				cmbStatus.setSelectedIndex(i);
			}
		}
	}
	
	@Override
	public void actualizarRegistro() {
		int folio = Integer.parseInt(panelEncabezado.getFolio().getValue());
		String fecha = panelEncabezado.getFecha().getValue();
		int claveCliente = Integer.parseInt(panelEncabezado.getCveCliente().getValue());
		float subTotal = Float.parseFloat(panelTotal.getSubtotal().getField().getText());
		float impuesto = Float.parseFloat(panelTotal.getImpuesto().getField().getText());
		float total = Float.parseFloat(panelTotal.getTotal().getField().getText());
		panelDetalles.actualizarDetalles();
		FactEnca reg = new FactEnca(folio, fecha, claveCliente, subTotal,impuesto,total,"A");
		try {
			DBFactEnca.DBUpdate(reg);
			limpiarCampos();
		} catch (Exception error) {
			System.out.println(error.getMessage());
		}
		
	}

	@Override
	public
	void nuevoRegistro() {
		int folio = Integer.parseInt(panelEncabezado.getFolio().getValue());
		String fecha = panelEncabezado.getFecha().getValue();
		int claveCliente = Integer.parseInt(panelEncabezado.getCveCliente().getValue());
		float subTotal = Float.parseFloat(panelTotal.getSubtotal().getField().getText());
		float impuesto = Float.parseFloat(panelTotal.getImpuesto().getField().getText());
		float total = Float.parseFloat(panelTotal.getTotal().getField().getText());
		panelDetalles.actualizarDetalles();
		FactEnca reg = new FactEnca(folio, fecha, claveCliente, subTotal,impuesto,total,"A");
		try {
			DBFactEnca.DBInsert(reg);
			limpiarCampos();
		} catch (Exception error) {
			System.out.println(error.getMessage());
		}
	}

	@Override
	public void limpiarCampos() {
		panelEncabezado.limpiar();
		panelTotal.limpiar();
		panelDetalles.limpiar();
		
	}
	public String getFolio(){
		return panelEncabezado.getFolio().getValue();
	}
}

