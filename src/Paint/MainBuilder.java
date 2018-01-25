package Paint;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JComponent;
import javax.swing.JFrame;

import Paint.Interface.Canvas.Canvas;
import Paint.Interface.KeyboardListener.KeyboardManager;
import Paint.Interface.MenuBar.MenuBarBuilder;
import Paint.Interface.StatusBar.StatusBarBuilder;
import Paint.Interface.ToolBar.ToolBarBuilder;
import Paint.Interface.TopBar.TopBarBuilder;
import Paint.Logic.Files.FileManager;
import Paint.Logic.Files.FileManagerImp;
import Paint.Logic.Tools.ToolManager;
import Paint.Logic.Tools.ToolManagerImp;

public class MainBuilder {
	
	private JFrame mainFrame;
	private FileManager fileManager;
	private ToolManager toolManager;
	private KeyboardManager keyboardManager;
	
	private void startManagers(){
		fileManager = new FileManagerImp();
		toolManager = new ToolManagerImp();

		
	}
	
	public JFrame buildUI(){
		mainFrame = new JFrame();
		
		startManagers();
		configFrame(mainFrame);
		setUpMenuBar();
		setUpStatusBar();
		setUpToolBar();
		setUpCanvas();
		setUpTopBar();
		
		keyboardManager = new KeyboardManager(mainFrame);
		keyboardManager.setUpKey(KeyEvent.VK_F1, (FileManagerImp)fileManager);
		return mainFrame;
	}
	private void setUpTopBar(){
		TopBarBuilder topBarBuilder = new TopBarBuilder();
		topBarBuilder.createToolBar();
		topBarBuilder.setUpButtons(fileManager);
		mainFrame.add(topBarBuilder.getTopBar(),BorderLayout.NORTH);
	}
	private void setUpCanvas(){
		Canvas canvas = new Canvas();
		toolManager.addColorListener(canvas);
		toolManager.addToolListener(canvas);
		fileManager.addListener(canvas);
		mainFrame.add(canvas,BorderLayout.CENTER);
	}
	private void setUpMenuBar(){
		MenuBarBuilder menuBarBuilder = new MenuBarBuilder();
		menuBarBuilder.createMenuBar();
		menuBarBuilder.createFileMenu(fileManager);
		menuBarBuilder.createHelpMenu();
		mainFrame.setJMenuBar(menuBarBuilder.getMenuBar());
	}
	
	private void setUpStatusBar(){
		StatusBarBuilder statusBarBuilder = new StatusBarBuilder();
		statusBarBuilder.createStatusBar();
		statusBarBuilder.setUpStatusLabel(toolManager,fileManager);
		mainFrame.add(statusBarBuilder.getStatusBar(),BorderLayout.SOUTH);
	}
	private void setUpToolBar(){
		ToolBarBuilder toolBarBuilder = new ToolBarBuilder();
		toolBarBuilder.createToolBar();
		toolBarBuilder.setUpToolButtons(toolManager);
		mainFrame.add(toolBarBuilder.getToolBar(),BorderLayout.WEST);
	}
	
	public void configFrame(JFrame frame){
		frame.setSize(800,600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		frame.setTitle("Editor Grafico de Figuras");
	}
	public void startUI(){
		mainFrame.setVisible(true);
	}
	
	public static void main(String[] args){
		MainBuilder uib = new MainBuilder();
		uib.buildUI();
		uib.startUI();
	}
}
