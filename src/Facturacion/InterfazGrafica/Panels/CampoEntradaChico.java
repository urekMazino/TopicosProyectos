package Facturacion.InterfazGrafica.Panels;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Facturacion.InterfazGrafica.Botones.Botones;

public class CampoEntradaChico extends JPanel{
	
	JTextField field;
	JLabel label,label2; 
	
	public CampoEntradaChico(String str){
		this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weightx = 1;
        gbc.insets = new Insets(5,5,5,5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        GridBagConstraints gbc2 = new GridBagConstraints();
        gbc2.insets = new Insets(5,5,5,5);
        
        field = new JTextField(15);
        label = new JLabel(str);
        label2 = new JLabel("");
        this.add(label2,gbc);
		this.add(label,gbc2);
		this.add(field,gbc2);
		
	}
	
	public void setEditable(boolean b){
		field.setEditable(b);
	}
	public void changeLabel(String str){
		label.setText(str);
	}
	public void changeValue(String str){
		field.setText(str);
	}
	public JTextField getField(){
		return field;
	}
	public String getValue(){
		return field.getText();
	}

}
