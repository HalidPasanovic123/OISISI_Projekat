package View.MainWindowWithComponents.MainTabPanels;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import AbstractTableModels.AbstractModelPredmeta;

public class PredmetJTable extends JTable {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PredmetJTable() {
        this.setRowSelectionAllowed(true);
        this.setColumnSelectionAllowed(true);
        this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.setModel(new AbstractModelPredmeta());
        this.setRowSorter(new TableRowSorter<TableModel>(this.getModel()));
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
