package Facturacion.InterfazGrafica.MenuBar;

import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class MenuBuilder {

	private JMenu menu;
	
	public void newMenu(String nombre,char mnemonic){
		menu = new JMenu(nombre);
		menu.setMnemonic(mnemonic);
	}
	
	public void newMenuItem(String name,char mnemonic,ActionListener actionListener){
		JMenuItem menuItem = new JMenuItem(name);
		menuItem.setMnemonic(mnemonic);
		menuItem.addActionListener(actionListener);
		menu.add(menuItem);
	}
	
	public JMenu getMenu(){
		return menu;
	}
}
