package Paint.Interface.StatusBar;

import java.awt.Color;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JLabel;

import Paint.Logic.Files.FileListener;
import Paint.Logic.Files.ImageFile;
import Paint.Logic.Tools.ColorListener;
import Paint.Logic.Tools.MouseTool;
import Paint.Logic.Tools.ToolListener;

public class StatusLabel extends JLabel implements ToolListener,ColorListener,FileListener{

	public StatusLabel(){
		super("Linea");
		this.setToolTipText("Informacion sobre el estado actual");
	}
	
	@Override
	public void toolChanged(MouseTool newTool) {
		changeStatus(newTool.getNombre());
	}
	
	@Override
	public void colorChanged(Color color) {
		String hex = String.format("#%02x%02x%02x", color.getRed(), color.getGreen(), color.getBlue());  
		changeStatus("Nuevo color: "+hex);
	}
	
	private void changeStatus(String newStatus){
		this.setText(newStatus);
		Timer t = new Timer();

		t.schedule(new TimerTask() {
			  @Override
			  public void run() {
				  StatusLabel.this.setText("Listo");
			  }
			}, 3000);
	}

	@Override
	public void fileChanged(ImageFile newFile) {
		
	}

	@Override
	public void newFile() {
		changeStatus("Nuevo archivo");
		
	}

	@Override
	public void savedFile(String name) {
		changeStatus("Archivo guardado: "+name);
		
	}

	@Override
	public void loadedFile(String name) {
		changeStatus("Archivo cargado: "+name);
		
	}
	
}
