package View.Dialogs.StudentEditDialog;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JScrollPane;



public class PolozeniTab extends JPanel
{
	
	private static JButton ponistiButton;
	private  PolozeniJTable polozeniJTable;
	
	
	public PolozeniTab(int row, StudentEditTabbedPane parent)
	{
		
				
		ponistiButton = new JButton("Poni�ti ocenu");
		ponistiButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int reply=JOptionPane.showOptionDialog(parent, 
			        "Da li ste sigurni da želite da ponistite ocenu?", 
			        "Ponistavanje ocene", 
			        JOptionPane.OK_CANCEL_OPTION, 
			        JOptionPane.INFORMATION_MESSAGE, 
			        null, 
			        new String[]{"Da", "Ne"}, 
			        "default");
			}

		});
		this.add(ponistiButton, BorderLayout.NORTH);
		
		polozeniJTable= parent.getPolozeniJTable();
		JScrollPane scrollPane = new JScrollPane(polozeniJTable);
		this.add(scrollPane, BorderLayout.CENTER);
	}
}
