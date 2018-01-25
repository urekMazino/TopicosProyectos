package Facturacion.InterfazGrafica.Botones;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import Facturacion.InterfazGrafica.Panels.Panel;
import Facturacion.InterfazGrafica.Panels.PanelFactura;

public class Botones extends JPanel{
	
	public JButton btnAgregar,btnLeer,btnActualizar;
	
	public Botones(Panel panel){
		ActionListenerGenerator alg = new ActionListenerGenerator();
		this.setLayout(new FlowLayout());
		btnAgregar = new JButton("Agregar Registro");
		btnAgregar.addActionListener(alg.getWriteListener(panel));
		this.add(btnAgregar);
		btnLeer = new JButton("Lee Registro");
		btnLeer.addActionListener(alg.getReadListener(panel));
		this.add(btnLeer);
		btnActualizar = new JButton("Actualiza Registro");
		btnActualizar.addActionListener(alg.getUpdateListener(panel));
		this.add(btnActualizar);
	}
	public void agregarNuevoProd(PanelFactura factura){
		ActionListenerGenerator alg = new ActionListenerGenerator();
		JButton btnNuevoProd = new JButton("Agregar Producto");
		btnNuevoProd.addActionListener(alg.getAgregarProdListener(factura));
		this.add(btnNuevoProd);
	}
}
