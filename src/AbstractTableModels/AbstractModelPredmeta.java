package AbstractTableModels;

import javax.swing.table.AbstractTableModel;

import Baze.BazaPredmeta;

public class AbstractModelPredmeta extends AbstractTableModel {

    @Override
    public int getRowCount() {
        return BazaPredmeta.getInstance().getRowCount();
    }

    @Override
    public String getColumnName(int column) {
        return BazaPredmeta.getInstance().getColumnName(column);
    }

    @Override
    public int getColumnCount() {
        return BazaPredmeta.getInstance().getColumnCount();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return BazaPredmeta.getInstance().getValueAt(rowIndex, columnIndex);
    }
    
}
