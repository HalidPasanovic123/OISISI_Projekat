package View.Dialogs.StudentEditDialog;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import java.awt.BorderLayout;

import View.MainWindowWithComponents.MainWindow;
import View.MainWindowWithComponents.TabPanel;
import View.MainWindowWithComponents.MainTabPanels.InformacijeTab;
import View.MainWindowWithComponents.MainTabPanels.NepolozeniJTable;
import View.MainWindowWithComponents.MainTabPanels.*;

public class StudentEditTabbedPane extends JTabbedPane {

	NepolozeniJTable NepolozeniPredmeti = new NepolozeniJTable();
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
	
	public NepolozeniJTable getNepolozeniJTable() {
		return NepolozeniPredmeti;
	}
	
	public PolozeniJTable getPolozeniJTable() {
		return PolozeniPredmeti;
	}
	
}
