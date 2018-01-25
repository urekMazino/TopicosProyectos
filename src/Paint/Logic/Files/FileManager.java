package Paint.Logic.Files;

import java.awt.event.ActionListener;
import java.io.Serializable;

import javax.swing.JComponent;

public interface FileManager{
	
	public ActionListener getNewFileImp();
	public ActionListener getSaveFileImp(JComponent component);
	public ActionListener getSaveFileAsImp(JComponent component);
	public ActionListener getLoadFileImp(JComponent component);
	public void notifyListeners();
	public void addListener(FileListener newListener);
	
}
