package Facturacion.InterfazGrafica.Panels;

import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableModel;

import Facturacion.InterfazGrafica.Botones.Botones;

public class PanelTotal extends JPanel{

	CampoEntradaChico subtotal,impuesto,total;
	
	public PanelTotal(PanelFactura panel){
		this.setLayout(new GridLayout(4,1));
		subtotal = new CampoEntradaChico("Subtotal");
		subtotal.changeValue("0");
		subtotal.setEditable(false);
		impuesto = new CampoEntradaChico("Impuesto");
		impuesto.changeValue("0");
		impuesto.setEditable(false);
		total = new CampoEntradaChico("Total");
		total.changeValue("0");
		total.setEditable(false);
		Botones botones = new Botones(panel);
		botones.agregarNuevoProd(panel);
		
		this.add(subtotal);
		this.add(impuesto);
		this.add(total);
		this.add(botones);	

	}
	
	public void calcular(JTable table){
		TableModel model = table.getModel();
		double subtotal=0,impuesto,total;
		
		for (int count = 0; count < model.getRowCount(); count++){
			double valor = 0;
			try{
				valor = Double.parseDouble(model.getValueAt(count, 5).toString());
			} catch (Exception e){
				
			}
		  subtotal += valor;
		}
		impuesto = subtotal*.16;
		total = subtotal+impuesto;
		this.subtotal.changeValue(subtotal+"");
		this.impuesto.changeValue(impuesto+"");
		this.total.changeValue(total+"");
	}
	public void limpiar(){
		subtotal.changeValue("0");
		impuesto.changeValue("0");
		total.changeValue("0");

	}

	public CampoEntradaChico getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(CampoEntradaChico subtotal) {
		this.subtotal = subtotal;
	}

	public CampoEntradaChico getImpuesto() {
		return impuesto;
	}

	public void setImpuesto(CampoEntradaChico impuesto) {
		this.impuesto = impuesto;
	}

	public CampoEntradaChico getTotal() {
		return total;
	}

	public void setTotal(CampoEntradaChico total) {
		this.total = total;
	}
	
}
