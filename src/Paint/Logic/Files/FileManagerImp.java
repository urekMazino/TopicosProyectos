package Paint.Logic.Files;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JOptionPane;

import Paint.Exceptions.CancelException;


public class FileManagerImp implements FileManager {

	private ArrayList<FileListener> listeners = new ArrayList<>();
	private ImageFile currentFile;
	private String fileName;
	
	public FileManagerImp(){
		newFile();
	}
	
	
	public void newFile(){
		currentFile = new ImageFile();
		fileName = null;
		notifyListeners();
		notifyListenersNew();
	}
	
	public void loadFile(JComponent component){
		try {
			fileName = FileInterface.openForReading(component);
			currentFile.setFigures(FileInterface.readContent());
			notifyListeners();
			notifyListenersLoad();
		} catch (CancelException e) {
			
		} catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al abrir el archivo","Aviso del sistema",JOptionPane.OK_OPTION);
		} catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar el archivo, archivo no valido","Aviso del sistema",JOptionPane.OK_OPTION);
		}
	}
	
	public void saveFile(JComponent component){
		try{
			if (fileName!=null){
				FileInterface.openForWriting(fileName);
			} else {
				fileName = FileInterface.openForWriting(component);
			}
			FileInterface.writeFigure(currentFile.getFigures());
			FileInterface.closeFile();
			notifyListenersSave();
		} catch (IOException e){
            JOptionPane.showMessageDialog(null, "Error al guardar el archivo","Aviso del sistema",JOptionPane.OK_OPTION);
		} catch (CancelException e) {
		
		}
	}
	public void saveFileAs(JComponent component){
		try{
			fileName = FileInterface.openForWriting(component);
			FileInterface.writeFigure(currentFile.getFigures());
			FileInterface.closeFile();
			notifyListenersSave();
		} catch (IOException e){
            JOptionPane.showMessageDialog(null, "Error al guardar el archivo","Aviso del sistema",JOptionPane.OK_OPTION);
		} catch (CancelException e) {
		
		}
	}
	@Override
	public void notifyListeners() {
		for (FileListener listener:listeners){
			listener.fileChanged(currentFile);
		}
	}
	public void notifyListenersLoad() {
		for (FileListener listener:listeners){
			listener.loadedFile(fileName);
		}
	}
	public void notifyListenersSave() {
		for (FileListener listener:listeners){
			listener.savedFile(fileName);
		}
	}
	public void notifyListenersNew() {
		for (FileListener listener:listeners){
			listener.newFile();
		}
	}
	@Override
	public void addListener(FileListener newListener) {
		listeners.add(newListener);		
		newListener.fileChanged(currentFile);
	}
	
	@Override
	public ActionListener getNewFileImp() {
		return new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				newFile();
			}
		};
	}
	@Override
	public ActionListener getSaveFileImp(JComponent component) {
		
		return new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				saveFile(component);
			}
			
		};
	}
	@Override
	public ActionListener getLoadFileImp(JComponent component) {
		return new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				loadFile(component);
			}
			
		};
	}
	@Override
	public ActionListener getSaveFileAsImp(JComponent component) {
		
		return new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				saveFileAs(component);
			}
			
		};
	}
}
