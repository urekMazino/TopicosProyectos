package GeneradorCURP.Components.InputFields;

import java.awt.Dimension;

import javax.swing.JTextField;
import javax.swing.text.PlainDocument;

import GeneradorCURP.Components.InputFilters.IntFilter;
import GeneradorCURP.Components.InputFilters.NameFilter;

public class NameField extends JTextField{
	
	private String name;
	
	public NameField(int size,String name){
//		super(size);
		addNombreFilter();
		defaultSize();
		this.name = name;
	}
	public NameField(String name){
		this(5,name);
	}
	private void addNombreFilter(){
		PlainDocument document = (PlainDocument) this.getDocument();
		document.setDocumentFilter(new NameFilter());
	}
	private void defaultSize(){
		this.setPreferredSize(new Dimension(200,20));
		this.setMaximumSize(new Dimension(200,20));
	}
	public String getNombre() throws Exception{
		if (this.getText().equals("")){
			throw new Exception("Ingresa un "+name);
		}
		return this.getText();
	}
}
