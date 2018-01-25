package Facturacion.InterfazGrafica.Botones;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Facturacion.InterfazGrafica.Panels.Panel;
import Facturacion.InterfazGrafica.Panels.PanelFactura;

public class ActionListenerGenerator {

	public ActionListener getUpdateListener(Panel panel){
		return new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				panel.actualizarRegistro();
			}
			
		};
	}
	
	public ActionListener getReadListener(Panel panel){
		return new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				panel.leerRegistro();
			}
			
		};
	}
	
	public ActionListener getWriteListener(Panel panel){
		return new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				panel.nuevoRegistro();
			}
			
		};
	}
	public ActionListener getAgregarProdListener(PanelFactura panel){
		return new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				panel.nuevoDetalle();
			}
			
		};
	}
}
