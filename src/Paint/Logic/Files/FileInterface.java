package Paint.Logic.Files;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import Paint.Exceptions.CancelException;
import Paint.Logic.Figures.Figure;
import Paint.Logic.Figures.FigureImp;

public class FileInterface 
{
	private static ObjectOutputStream outputStream = null;
	private static ObjectInputStream inputStream = null;
    
    public static void writeFigure(ArrayList<Figure> figures) {
    	
    	try{
    		outputStream.writeObject(figures);
    	} catch (IOException e ){
    		e.printStackTrace();
    	}
    	
    }
    private static String fileChooser(JComponent component) throws CancelException{
    	JFileChooser chooser=new JFileChooser();
        chooser.setDialogTitle("Elige el archivo");
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        chooser.setCurrentDirectory(new File("Directorio default"));
        chooser.setAcceptAllFileFilterUsed(true);
        FileNameExtensionFilter filter=new FileNameExtensionFilter("Images","mpp");
        chooser.setFileFilter(filter);
        if(chooser.showOpenDialog(component)==JFileChooser.APPROVE_OPTION)
        {
            return chooser.getSelectedFile().getPath();
        } else {
        	throw new CancelException();
        }
    }
    
    public static String openForWriting(JComponent component) throws FileNotFoundException,IOException,CancelException
    {
    	String fileName = fileChooser(component);
    	openForWriting(fileName);
    	return fileName;
    	
    }
    public static void openForWriting(String nombreArchivo) throws FileNotFoundException,IOException
    {
        outputStream = new ObjectOutputStream(new FileOutputStream(nombreArchivo));
        
    }
    public static void closeFile()
    {
        try {
            if (outputStream != null) {
                outputStream.flush();
                outputStream.close();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
   
    public static String openForReading(JComponent component) throws CancelException, FileNotFoundException, IOException{
    	String nombreArchivo = fileChooser(component);
	    inputStream = new ObjectInputStream (new FileInputStream(nombreArchivo));
	    return nombreArchivo;
    }
    
    public static ArrayList<Figure> readContent() throws ClassNotFoundException, IOException{
    	ArrayList<Figure> figuras = new ArrayList<>();
			
    	figuras = (ArrayList<Figure>)inputStream.readObject();

    	return figuras;
    }
}
