package Paint.Logic.Files;

public interface FileListener {

	public void fileChanged(ImageFile newFile);
	public void newFile();
	public void savedFile(String name);
	public void loadedFile(String name);
	
}
