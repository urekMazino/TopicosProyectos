package GeneradorCURP.Components;
import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainBuilder {

	private JFrame mainFrame;
	
	public JFrame build(){
		mainFrame = new JFrame();
		
		configFrame(mainFrame);
		buildInputFields();
		
		return mainFrame;
		
		
	}
	private void configFrame(JFrame frame){
		frame.setSize(300,600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		frame.setTitle("Creador de curp");
	}
	private void buildInputFields(){
		InputPanelBuilder inputPanelBuilder = new InputPanelBuilder();
		mainFrame.add(inputPanelBuilder.build(),BorderLayout.WEST);
		
	}
	
}
