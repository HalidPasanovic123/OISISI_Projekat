package View.Dialogs.ProfesorEditDialog;

import javax.swing.table.AbstractTableModel;

import Baze.BazaPredmeta;

public class ApstractDodajTableModelPredmetProfesoru extends AbstractTableModel{
	
    @Override
    public int getRowCount() {
        return BazaPredmeta.getInstance().getRowCount();
    }

    @Override
    public String getColumnName(int column) {
        return "Predmet";
    }

    @Override
    public int getColumnCount() {
        return 1;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return BazaPredmeta.getInstance().getValueAtDodaj(rowIndex, columnIndex);
    }

}
