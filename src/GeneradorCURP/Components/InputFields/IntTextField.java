package GeneradorCURP.Components.InputFields;

import java.awt.Dimension;

import javax.swing.JTextField;
import javax.swing.text.PlainDocument;

import GeneradorCURP.Components.InputFilters.IntFilter;

public class IntTextField extends JTextField{

	public IntTextField(int size){
//		super(size);
		addIntFilter();
		defaultSize();
	}
	public IntTextField(){
		this(5);
	}
	private void addIntFilter(){
		PlainDocument document = (PlainDocument) this.getDocument();
		document.setDocumentFilter(new IntFilter());
	}
	private void defaultSize(){
		this.setPreferredSize(new Dimension(200,20));
		this.setMaximumSize(new Dimension(200,20));
	}
}
