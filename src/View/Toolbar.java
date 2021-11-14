package View;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.plaf.DimensionUIResource;

public class Toolbar extends JToolBar {

	public Toolbar() {
		super(SwingConstants.HORIZONTAL);
		
		//Dugme za pravljenje entiteta
		JButton createButton = new JButton();
		createButton.setToolTipText("Napravi");
		createButton.setIcon(new ImageIcon("Images/Toolbar_Button_1.png"));
		add(createButton);
		
		addSeparator();
		
		//Dugme za menjanje oznacenog entiteta
		JButton changeButton = new JButton();
		changeButton.setToolTipText("Izmeni");
		changeButton.setIcon(new ImageIcon("Images/Toolbar_Button_2.png"));
		add(changeButton);
		
		addSeparator();
		
		//Dugme za brisanje oznacenog entiteta
		JButton removeButton = new JButton();
		removeButton.setToolTipText("Izbrisi");
		removeButton.setIcon(new ImageIcon("Images/Toolbar_Button_3.png"));
		add(removeButton);
		
		add(Box.createHorizontalGlue());
		
		//Polje za unos teksta za pretragu
		JTextField searchInput = new JTextField();
		Dimension temp = getMaximumSize();
		int height = temp.height;
		int width = temp.width;
		searchInput.setMaximumSize(new Dimension(width/6,height));
		add(searchInput);
		
		//Dugme za pretragu
		JButton searchButton = new JButton();
		searchButton.setToolTipText("Pretrazi");
		searchButton.setIcon(new ImageIcon("Images/Toolbar_Button_4.png"));
		add(searchButton);
		
		setFloatable(false);
		
		setBackground(new Color(208,208,208));
	}
	
	
}
