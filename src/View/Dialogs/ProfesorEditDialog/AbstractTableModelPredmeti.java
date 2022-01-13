package View.Dialogs.ProfesorEditDialog;

import javax.swing.table.AbstractTableModel;

import Baze.BazaPredmeta;
import Model.Profesor;

public class AbstractTableModelPredmeti extends AbstractTableModel {

    private Profesor profesor;

    public AbstractTableModelPredmeti(Profesor profesor) {
        this.profesor = profesor;
    }

    @Override
    public int getRowCount() {
        return BazaPredmeta.getInstance().getRowCountProfesor(profesor);
    }

    @Override
    public String getColumnName(int column) {
        return BazaPredmeta.getInstance().getColumnNameProfesor(column);
    }

    @Override
    public int getColumnCount() {
        return BazaPredmeta.getInstance().getColumnCountProfesor();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return BazaPredmeta.getInstance().getValueAtProfesor(rowIndex, columnIndex);
    }

    
}
