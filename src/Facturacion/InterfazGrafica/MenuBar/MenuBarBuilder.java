package Facturacion.InterfazGrafica.MenuBar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;

import Facturacion.InterfazGrafica.Panels.PanelClientes;
import Facturacion.InterfazGrafica.Panels.PanelImp;
import Facturacion.InterfazGrafica.Panels.PanelProductos;

public class MenuBarBuilder {

	private JMenuBar menuBar;
	
	public void createMenuBar(){
		menuBar = new JMenuBar();
	}
	public void createMenus(JFrame frame){
		MenuBarActionListeners mbal = new MenuBarActionListeners();
		MenuBuilder menuBuilder = new MenuBuilder();
		menuBuilder.newMenu("Registros", 'R');
		menuBuilder.newMenuItem("Clientes", 'C', mbal.clientesPanel(frame));
		menuBuilder.newMenuItem("Productos", 'P', mbal.productosPanel(frame));
		menuBuilder.newMenuItem("Facturacion", 'D', mbal.facturaPanel(frame));
		menuBar.add(menuBuilder.getMenu());
	}
	
	public JMenuBar getMenuBar(){
		return menuBar;
	}
	
}
