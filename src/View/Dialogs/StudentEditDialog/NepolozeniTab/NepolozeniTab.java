package View.Dialogs.StudentEditDialog.NepolozeniTab;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import View.Dialogs.StudentEditDialog.StudentEditTabbedPane;

public class NepolozeniTab extends JPanel {
	private StudentNepolozeniJTable nepolozeniJTable;

	public NepolozeniTab(int row, StudentEditTabbedPane parent) {
		super();
		
		JButton dodaj=new JButton("Dodaj");
		this.add(dodaj, BorderLayout.NORTH);
		
		JButton obrisi=new JButton("Obriši");
		this.add(obrisi,  BorderLayout.NORTH);
		
		JButton polaganje=new JButton("Polaganje");
		this.add(polaganje, BorderLayout.NORTH);
		
		JPanel jpanel=new JPanel();
		this.add(jpanel, BorderLayout.NORTH);
		
		nepolozeniJTable= new StudentNepolozeniJTable(row);
		JScrollPane scrollPane = new JScrollPane(nepolozeniJTable);
		this.add(scrollPane,BorderLayout.CENTER);
	}
}

