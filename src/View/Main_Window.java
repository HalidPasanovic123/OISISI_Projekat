package View;

import java.awt.BorderLayout;
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
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		
		Toolbar toolbar = new Toolbar();
		
		add(toolbar, BorderLayout.NORTH);
	}
	
	
	
}
