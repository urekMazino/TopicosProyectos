package Paint.Logic.Files;

import java.util.ArrayList;

import Paint.Logic.Figures.Figure;

public class ImageFile {
	
	private ArrayList<Figure> figures = new ArrayList<>();
	
	public ImageFile(){
		
	}
	public ImageFile(ArrayList<Figure> figures){
		this.figures = figures;
	}
	public ArrayList<Figure> getFigures(){
		return figures;
	}
	public void setFigures(ArrayList<Figure> figures){
		this.figures = figures;
	}
	public void addFigure(Figure figure){
		figures.add(figure);
	}
	public void clearFile(){
		figures.clear();
	}
}
