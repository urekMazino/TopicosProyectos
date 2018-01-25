package Facturacion.InterfazGrafica.Panels;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public abstract class PanelImp extends JPanel implements Panel{

	JFrame frame;
	
	public PanelImp(JFrame frame){
		this.frame = frame;
		initPanel();
	}
}
