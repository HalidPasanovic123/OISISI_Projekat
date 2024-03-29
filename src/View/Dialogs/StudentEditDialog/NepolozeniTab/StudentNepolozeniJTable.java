package View.Dialogs.StudentEditDialog.NepolozeniTab;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;

public class StudentNepolozeniJTable extends JTable {
    
    public StudentNepolozeniJTable(int row) {
        this.setRowSelectionAllowed(true);
        this.setColumnSelectionAllowed(true);
        this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.setModel(new AbstractTableModelNepolozeni(row));
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
		AbstractTableModelNepolozeni model = (AbstractTableModelNepolozeni) this.getModel();
		model.fireTableDataChanged();
        validate();
	}
}
