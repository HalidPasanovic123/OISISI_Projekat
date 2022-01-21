package View.MainWindowWithComponents;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import AbstractTableModels.AbstractModelPredmeta;
import AbstractTableModels.AbstractModelProfesori;
import AbstractTableModels.AbstractTableModelStudent;

public class MainWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static MainWindow instance = null;

	public static MainWindow getInstance() {
		if (instance == null) {
			instance = new MainWindow();
		}
		return instance;
	}
	
	private TabPanel tabs; 

	public MainWindow() {
		super();
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();

		setVisible(true);
		
		//Dobijanje dimenzija ekrana korisnika
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		
		//Postavljanje velicine prozora na 3/4 velicine ekrana
		setSize(screenWidth * 3 / 4,screenHeight * 3 / 4);
		
		//Naslov prozora
		setTitle("Studentska služba");
		
		//Centriranje prozora
        setLocation(screenWidth/2 - screenWidth * 3/8, screenHeight/2 - screenHeight*3/8);
        
		//Dodavanje MenuBara na prozor
		MenuBar meni = new MenuBar(this);
		this.setJMenuBar(meni);

		tabs = new TabPanel();
		add(tabs, BorderLayout.CENTER);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		
		Toolbar toolbar = new Toolbar(this);
		add(toolbar, BorderLayout.NORTH);
		
		//Dodavanje StatusBara na prozor
		StatusBar statusBar = new StatusBar();
		this.add(statusBar,BorderLayout.SOUTH);
		validate(); 
		

	}
	
	public TabPanel getTabs() {
		return tabs;
	}

	public void updateShowingsOfProfesors() {
		AbstractModelProfesori model = (AbstractModelProfesori) tabs.getTabelProfesori().getModel();
		model.fireTableDataChanged();
		validate();
	}
	
	public void updateShowingOfStudent(String akcija, int vrednost) {
		AbstractTableModelStudent model = (AbstractTableModelStudent) tabs.getTableStudent().getModel();
		model.fireTableDataChanged();
		validate();
	}

	public void updateShowingsOfPredmet() {
		AbstractModelPredmeta model = (AbstractModelPredmeta) tabs.getTabelPredmeti().getModel();
		model.fireTableDataChanged();
		validate();
	}
	
	public void setStatusBar(String s)
	{
		StatusBar statusBar = new StatusBar(s);
		this.add(statusBar,BorderLayout.SOUTH);
		validate(); 
	}

}
