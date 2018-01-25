package VerificadorCURP;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.PlainDocument;

import GeneradorCURP.Components.InputFilters.NameFilter;

public class VerificadorCURP extends JFrame{
	
	JPanel panel = new JPanel();
	JTextField textField = new JTextField(20);
	
	public VerificadorCURP(){
		this.setSize(300,50);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.setTitle("Comprobar CURP");
		
		this.add(panel,BorderLayout.CENTER);
//		textField.setTransferHandler(null);
		
		PlainDocument document = (PlainDocument) textField.getDocument();
		document.setDocumentFilter(new CURPFilter(textField));
		
		panel.add(new JLabel("CURP"));
		panel.add(textField);
	}

	public static void main(String[] args) {
		VerificadorCURP ver = new VerificadorCURP();
		ver.setVisible(true);

	}

}
