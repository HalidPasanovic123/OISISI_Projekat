package View.Dialogs.PredmetEditDialog.DodajDialog;

import javax.swing.table.AbstractTableModel;

import Baze.BazaProfesora;

public class ApstractDodajTableModel extends AbstractTableModel {

    @Override
    public int getRowCount() {
        return BazaProfesora.getInstance().getRowCount();
    }

    @Override
    public String getColumnName(int column) {
        return "Profesor";
    }

    @Override
    public int getColumnCount() {
        return 1;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return BazaProfesora.getInstance().getValueAtDodaj(rowIndex, columnIndex);
    }
    
}
