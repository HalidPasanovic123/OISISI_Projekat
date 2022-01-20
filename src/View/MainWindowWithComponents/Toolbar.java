package View.MainWindowWithComponents;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

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
		searchInput.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                checker();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                checker();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                checker();
            }

            public void checker() {
                if(searchInput.getText().length() == 0){
                    MainWindow.getInstance().getTabs().getTabelProfesori().getSorter().setRowFilter(null);
					MainWindow.getInstance().getTabs().getTableStudent().getSorter().setRowFilter(null);
					MainWindow.getInstance().getTabs().getTabelPredmeti().getSorter().setRowFilter(null);
                }
            }
        });
		add(searchInput);
		
		//Dugme za pretragu
		SearchAction search = new SearchAction(searchInput);
		JButton searchButton = new JButton(search);
		add(searchButton);
		
		setFloatable(false);
		
		setBackground(new Color(208,208,208));
	}
	
	
}
