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
	
	public StudentEditTabbedPane() {
		JPanel Informacije = new JPanel();
		JPanel Polozeni = new JPanel();
		JPanel Nepolozeni = new JPanel();
		
		int row=TabPanel.getInstance().getTableStudent().convertRowIndexToModel(MainWindow.getInstance().getTabs().getTableStudent().getSelectedRow());

		Informacije.setLayout(new BorderLayout());
		this.add(Informacije, "Informacije");
		Informacije.add(new InformacijeTab(row));
		
		Polozeni.setLayout(new BorderLayout());
		this.add(Polozeni, "Položeni");
		Polozeni.add(new PolozeniTab(row, this));
		
		
		NepolozeniTab nepolozeniTab=new NepolozeniTab(row, this);
		Nepolozeni.setLayout(new BorderLayout());
		this.add(nepolozeniTab, "Nepoloženi");
	
	}
	
	public NepolozeniJTable getNepolozeniJTable() {
		return NepolozeniPredmeti;
	}
	
}
