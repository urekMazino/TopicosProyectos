package Facturacion.InterfazGrafica.MenuBar;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import Facturacion.InterfazGrafica.Panels.PanelClientes;
import Facturacion.InterfazGrafica.Panels.PanelFactura;
import Facturacion.InterfazGrafica.Panels.PanelProductos;

public class MenuBarActionListeners {

	public ActionListener clientesPanel(JFrame frame){
		return new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();
				frame.getContentPane().add(new PanelClientes(frame),BorderLayout.CENTER);
				frame.revalidate();
			}
		};
	}
	public ActionListener productosPanel(JFrame frame){
		return new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();
				frame.getContentPane().add(new PanelProductos(frame),BorderLayout.CENTER);
				frame.revalidate();
			}
		};
	}
	
	
	public ActionListener facturaPanel(JFrame frame){
		return new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();
				frame.getContentPane().add(new PanelFactura(frame),BorderLayout.CENTER);
				frame.revalidate();
			}
		};
	}
}
