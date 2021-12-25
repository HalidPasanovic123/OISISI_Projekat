package View.MainWindowWithComponents.MainTabPanels;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;

import Model.Student;
import Controllers.StudentController;
import View.MainWindowWithComponents.*;
import AbstractTableModels.AbstractTableModelNepolozeniPredmeti;

public class NepolozeniJTable extends JTable{

	public NepolozeniJTable() {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		int row=TabPanel.getInstance().getTableStudent().convertRowIndexToModel(MainWindow.getInstance().getTabs().getTableStudent().getSelectedRow());
		Student s=StudentController.getInstance().GetStudentFromRow(row);
		this.setModel(new AbstractTableModelNepolozeniPredmeti(s));
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
		AbstractTableModelNepolozeniPredmeti model = (AbstractTableModelNepolozeniPredmeti) this.getModel();
		model.fireTableDataChanged();
	}
}
