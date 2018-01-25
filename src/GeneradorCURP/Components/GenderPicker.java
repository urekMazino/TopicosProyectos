package GeneradorCURP.Components;
import java.awt.Dimension;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class GenderPicker extends JPanel{

		ButtonGroup bG;
		JRadioButton male,female;
		
	public GenderPicker(){
	     male = new JRadioButton("HOMBRE");
	     female = new JRadioButton("MUJER");
	     bG = new ButtonGroup();
	     bG.add(male);
	     bG.add(female);
	     this.add(male);
	     this.add(female);
	     this.setMaximumSize(new Dimension(220,40));
	}
	
	public String getGender() throws Exception{
		if (bG.getSelection()==null){
			throw new Exception("Selecciona la opcion de Sexo");
		}
		return (male.isSelected())?"H":"M";
	}
	
}
