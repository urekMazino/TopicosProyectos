package Facturacion;

import javax.swing.JFrame;

import Facturacion.InterfazGrafica.MenuBar.MenuBarBuilder;
import Facturacion.InterfazGrafica.Panels.PanelClientes;

public class VentanaPrincipal extends JFrame{

	public VentanaPrincipal(){
		initFrame();
		initMenuBar();
		initMainScreen();
	}
	private void initFrame(){
		this.setSize(800,600);
		this.setTitle("Systema de facturacion");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	private void initMenuBar(){
		MenuBarBuilder menuBarBuilder = new MenuBarBuilder();
		menuBarBuilder.createMenuBar();
		menuBarBuilder.createMenus(this);
		this.setJMenuBar(menuBarBuilder.getMenuBar());
	}
	private void initMainScreen(){
//		this.add(new PanelClientes(this));
	}
	public static void main(String[] args){
		new VentanaPrincipal().setVisible(true);
	}
}
