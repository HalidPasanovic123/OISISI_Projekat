package View.MainWindowWithComponents.MainTabPanels;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;

import AbstractTableModels.AbstractModelProfesori;

public class ProfesorJTable extends JTable{
    
    int rowSelected = -1;

    public ProfesorJTable() {
        this.setRowSelectionAllowed(true);
        this.setColumnSelectionAllowed(true);
        this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.setModel(new AbstractModelProfesori());
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                JTable tempTable = (JTable) e.getComponent();
                rowSelected = tempTable.convertRowIndexToModel(tempTable.getSelectedRow());
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

    public int getRowSelected() {
        return rowSelected;
    }
}
