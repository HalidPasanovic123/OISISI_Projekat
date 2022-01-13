package View.Dialogs.StudentEditDialog;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import View.Dialogs.StudentEditDialog.NepolozeniTab.NepolozeniTab;
import View.MainWindowWithComponents.MainWindow;
import View.MainWindowWithComponents.TabPanel;

import java.awt.BorderLayout;

public class StudentEditTabbedPane extends JTabbedPane {

	PolozeniJTable PolozeniPredmeti = new PolozeniJTable();
	
	public StudentEditTabbedPane() {
		JPanel Informacije = new JPanel();
		JPanel Polozeni = new JPanel();
		JPanel Nepolozeni = new JPanel();
		
		int row=TabPanel.getInstance().getTableStudent().convertRowIndexToModel(MainWindow.getInstance().getTabs().getTableStudent().getSelectedRow());

		Informacije.setLayout(new BorderLayout());
		this.add(Informacije, "Informacije");
		Informacije.add(new InformacijeTab(row));
		
		Polozeni.setLayout(new BorderLayout());
		this.add(Polozeni, "Polo�eni");
		Polozeni.add(new PolozeniTab(row, this));
		
		NepolozeniTab nepolozeniTab=new NepolozeniTab(row, this);
		Nepolozeni.setLayout(new BorderLayout());
		this.add(nepolozeniTab, "Nepolo�eni");
	
	}
	
	public PolozeniJTable getPolozeniJTable() {
		return PolozeniPredmeti;
	}
	
}
