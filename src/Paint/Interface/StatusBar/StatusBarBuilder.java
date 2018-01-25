package Paint.Interface.StatusBar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JToolBar;
import javax.swing.Timer;

import Paint.Interface.ToolBar.ColorSelector;
import Paint.Logic.Files.FileManager;
import Paint.Logic.Tools.ToolManager;

public class StatusBarBuilder {

	private JToolBar statusBar;
	private StatusLabel statusLabel;
	
	public void createStatusBar(){
		statusBar = new JToolBar("Status Bar");
	
		statusBar.setFloatable(false);
		statusBar.setToolTipText("Barra de Status");
		
		statusLabel = new StatusLabel();
		statusBar.add(statusLabel);
		
		statusBar.add(new JToolBar.Separator());
		statusBar.add(new JSeparator(JSeparator.VERTICAL));
		statusBar.add(new JToolBar.Separator());
		
		JLabel horaLabel = new JLabel(Fecha.now());
		horaLabel.setToolTipText("Fecha y Hora Actual");
		statusBar.add(horaLabel);
		

		Timer tiempo = new Timer(1000, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				horaLabel.setText(Fecha.now());
			}
		});
		tiempo.start();
	
	}

	public void setUpStatusLabel(ToolManager toolManager,FileManager fileManager){
		toolManager.addToolListener(statusLabel);
		toolManager.addColorListener(statusLabel);
		fileManager.addListener(statusLabel);
	}
	
	public JToolBar getStatusBar(){
		return statusBar;
	}
	
}
