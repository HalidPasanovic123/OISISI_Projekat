package View.MainWindowWithComponents.MainTabPanels;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;

import AbstractTableModels.AbstractTableModelStudent;
import View.MainWindowWithComponents.MainWindow;

public class StudentJTable extends JTable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static StudentJTable instance = null;

	public static StudentJTable getInstance() {
		if (instance == null) {
			instance = new StudentJTable();
		}
		return instance;
	}
	
	public StudentJTable() {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(new AbstractTableModelStudent());
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

}
