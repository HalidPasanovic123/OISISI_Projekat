package View;

import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Main_Window extends JFrame {

	public Main_Window() {
		
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
		Menu_Bar meni = new Menu_Bar();
		this.setJMenuBar(meni);

		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	}
	
	
	
}
