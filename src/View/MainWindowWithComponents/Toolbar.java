package View.MainWindowWithComponents;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

import AbstractActions.CreateAction;
import AbstractActions.DeleteAction;
import AbstractActions.ModifyAction;
import AbstractActions.SearchAction;

public class Toolbar extends JToolBar {

	public Toolbar(final JFrame parent) {
		super(SwingConstants.HORIZONTAL);
		
		//Dugme za pravljenje entiteta
		CreateAction create = new CreateAction();
		JButton createButton = new JButton(create);
		add(createButton);
		
		addSeparator();
		
		//Dugme za menjanje oznacenog entiteta
		ModifyAction modify = new ModifyAction(parent);
		JButton changeButton = new JButton(modify);
		add(changeButton);
		
		addSeparator();
		
		//Dugme za brisanje oznacenog entiteta
		DeleteAction delete = new DeleteAction(parent);
		JButton removeButton = new JButton(delete);
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
		SearchAction search = new SearchAction();
		JButton searchButton = new JButton(search);
		add(searchButton);
		
		setFloatable(false);
		
		setBackground(new Color(208,208,208));
	}
	
	
}