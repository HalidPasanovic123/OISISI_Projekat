package View.Dialogs.StudentEditDialog;

import javax.swing.JButton;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;



public class PolozeniTab extends JPanel
{
	
	private static JButton ponistiButton;
	private  PolozeniJTable polozeniJTable;
	
	
	public PolozeniTab(int row, StudentEditTabbedPane parent)
	{
		
				
		ponistiButton = new JButton("Poni�ti ocenu");
		this.add(ponistiButton, BorderLayout.NORTH);
		
		polozeniJTable= parent.getPolozeniJTable();
		JScrollPane scrollPane = new JScrollPane(polozeniJTable);
		this.add(scrollPane, BorderLayout.CENTER);
	}
}
