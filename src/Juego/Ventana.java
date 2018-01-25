package Juego;
import java.awt.BorderLayout;

import javax.swing.JFrame;

public class Ventana extends JFrame{
	
	LogicaJuego logica;
	PanelJuego panel;
	
	public Ventana(){
		this.setSize(600,1000);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Road Fighters");
		this.setResizable(false);
		
		logica = new LogicaJuego();
		panel = new PanelJuego();
		
		this.add(panel,BorderLayout.CENTER);
		logica.ini(panel);
		
	}
	
	public static void main(String args[]){
		new Ventana().setVisible(true);
	}
	
}
