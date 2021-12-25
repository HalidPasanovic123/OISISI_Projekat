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

	
	public StudentEditTabbedPane() {
		JPanel informacije = new JPanel();
		
		int row=TabPanel.getInstance().getTableStudent().convertRowIndexToModel(MainWindow.getInstance().getTabs().getTableStudent().getSelectedRow());

		informacije.setLayout(new BorderLayout());
		this.add(informacije, "Informacije");
		informacije.add(new InformacijeTab(row));
	
	
	}
	
}
