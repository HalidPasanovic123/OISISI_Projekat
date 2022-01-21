package View.MainWindowWithComponents.MainTabPanels;

import java.awt.Color;
import java.awt.Component;
import java.util.Comparator;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import AbstractTableModels.AbstractTableModelStudent;

public class StudentJTable extends JTable {

	private static StudentJTable instance = null;

	public static StudentJTable getInstance() {
		if (instance == null) {
			instance = new StudentJTable();
		}
		return instance;
	}
	
	private static TableRowSorter<AbstractTableModelStudent> sorter;
	private static AbstractTableModelStudent model;

	public StudentJTable() {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(new AbstractTableModelStudent());
		this.setAutoCreateRowSorter(false);

		model = new AbstractTableModelStudent();
		sorter = new TableRowSorter<AbstractTableModelStudent>(model);
        this.setRowSorter(sorter);
		this.setModel(model);

		sorter.setComparator(0, new Comparator<String>() {
			public int compare(String o1, String o2)
			{
				String novi1 = o1.substring(3);
				String novi2 = o2.substring(3);
				return novi1.compareTo(novi2);
			}
		});
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

	public TableRowSorter<AbstractTableModelStudent> getSorter() {
		return sorter;
	}

}
