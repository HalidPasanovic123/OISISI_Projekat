package View.Dialogs.StudentEditDialog;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import Controllers.StudentController;
import Model.Student;
import View.Dialogs.StudentEditDialog.NepolozeniTab.NepolozeniTab;
import View.Dialogs.StudentEditDialog.NepolozeniTab.StudentNepolozeniJTable;
import View.MainWindowWithComponents.MainWindow;
import View.MainWindowWithComponents.TabPanel;

import java.awt.BorderLayout;

public class StudentEditTabbedPane extends JTabbedPane {

	PolozeniJTable PolozeniPredmeti = new PolozeniJTable();
	StudentNepolozeniJTable NepolozeniPredmeti;

	private NepolozeniTab nepolozeniTab;
	private PolozeniTab polozeniTab;
	private int row;
	
	public StudentEditTabbedPane(JDialog parent) {

		row=TabPanel.getInstance().getTableStudent().convertRowIndexToModel(MainWindow.getInstance().getTabs().getTableStudent().getSelectedRow());

		NepolozeniPredmeti = new StudentNepolozeniJTable(row);

		JPanel Informacije = new JPanel();
		JPanel Polozeni = new JPanel();
		
		Informacije.setLayout(new BorderLayout());
		this.add(Informacije, "Informacije");
		Informacije.add(new InformacijeTab(row));
		
		Polozeni.setLayout(new BorderLayout());
		this.add(Polozeni, "Polo�eni");
		polozeniTab = new PolozeniTab(row, this);
		Polozeni.add(polozeniTab);
		
		nepolozeniTab=new NepolozeniTab(row, this);
		this.add(nepolozeniTab, "Nepolo�eni");
	
	}
	
	public PolozeniJTable getPolozeniJTable() {
		return PolozeniPredmeti;
	}

	public Student getStudent() {
		return StudentController.getInstance().getStudentByID(row);
	}

	public NepolozeniTab getNepolozeniTab() {
		return nepolozeniTab;
	}
	
	public PolozeniTab getPolozeniTab() {
		return polozeniTab;
	}
}
