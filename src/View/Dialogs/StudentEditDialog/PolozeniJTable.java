package View.Dialogs.StudentEditDialog;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;

import AbstractTableModels.AbstractTableModelPolozeniPredmeti;
import Controllers.StudentController;
import Model.Student;
import View.MainWindowWithComponents.MainWindow;
import View.MainWindowWithComponents.TabPanel;

public class PolozeniJTable extends JTable{

	public PolozeniJTable() {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		int row=TabPanel.getInstance().getTableStudent().convertRowIndexToModel(MainWindow.getInstance().getTabs().getTableStudent().getSelectedRow());
		Student s=StudentController.getInstance().getStudentFromRow(row);
		this.setModel(new AbstractTableModelPolozeniPredmeti(s));
		}

	public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
		Component c = super.prepareRenderer(renderer, row, column);
		if (isRowSelected(row)) {
			c.setBackground(Color.LIGHT_GRAY);
		} else {
			c.setBackground(Color.WHITE);
		}
		return c;
	}
	public void azuriraj() {
		AbstractTableModelPolozeniPredmeti model = (AbstractTableModelPolozeniPredmeti) this.getModel();
		model.fireTableDataChanged();
		validate();
	}
}
