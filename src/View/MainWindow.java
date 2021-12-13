package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.border.Border;

public class MainWindow extends JFrame {

	private static MainWindow instance = null;

	public static MainWindow getInstance() {
		if (instance == null) {
			instance = new MainWindow();
		}
		return instance;
	}

	public MainWindow() {
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		
		//Dobijanje dimenzija ekrana korisnika
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		
		//Postavljanje velicine prozora na 3/4 velicine ekrana
		setSize(screenWidth * 3 / 4,screenHeight * 3 / 4);
		
		//Naslov prozora
		setTitle("Studentska sluzba");
		
		//Centriranje prozora
        setLocation(screenWidth/2 - screenWidth * 3/8, screenHeight/2 - screenHeight*3/8);
        
		//Dodavanje MenuBara na prozor
		MenuBar meni = new MenuBar();
		this.setJMenuBar(meni);

		TabPanel tabs = new TabPanel();
		add(tabs, BorderLayout.CENTER);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		
		Toolbar toolbar = new Toolbar();
		add(toolbar, BorderLayout.NORTH);
		
		//Dodavanje StatusBara na prozor
		StatusBar statusBar = new StatusBar();
		this.add(statusBar,BorderLayout.SOUTH);
	}
	
	
	
}
