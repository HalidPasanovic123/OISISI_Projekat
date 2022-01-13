package View.Dialogs.StudentEditDialog.NepolozeniTab;

import javax.swing.table.AbstractTableModel;

import Baze.BazaPredmeta;
import Controllers.StudentController;
import Model.Student;

public class AbstractTableModelNepolozeni extends AbstractTableModel {

    private Student student;

    public AbstractTableModelNepolozeni(int row) {
        this.student = StudentController.getInstance().getStudentFromRow(row);
    }

    @Override
    public int getRowCount() {
        return student.getNepolozeniPredmeti().size();
    }

    @Override
    public String getColumnName(int column) {
        return BazaPredmeta.getInstance().getColumnName(column);
    }

    @Override
    public int getColumnCount() {
        return  BazaPredmeta.getInstance().getColumnCount();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return  BazaPredmeta.getInstance().getValueAt(rowIndex, columnIndex);
    }
    
}
