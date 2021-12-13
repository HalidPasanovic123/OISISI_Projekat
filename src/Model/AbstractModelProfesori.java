package Model;

import javax.swing.table.AbstractTableModel;

public class AbstractModelProfesori extends AbstractTableModel{

    @Override
    public int getRowCount() {
        return BazaProfesora.getInstance().getRowCount();
    }

    @Override
    public String getColumnName(int column) {
        return BazaProfesora.getInstance().getColumnName(column);
    }

    @Override
    public int getColumnCount() {
        return BazaProfesora.getInstance().getColumnCount();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return BazaProfesora.getInstance().getValueAt(rowIndex, columnIndex);
    }
    
}
