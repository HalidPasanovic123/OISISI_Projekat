package AbstractTableModels;

import javax.swing.table.AbstractTableModel;

import Baze.BazaPredmeta;
import Baze.BazaStudenata;
import Model.Student;

public class AbstractTableModelPolozeniPredmeti extends AbstractTableModel{

	private Student student;
	
	public AbstractTableModelPolozeniPredmeti(Student s) {
		this.student = s;
	}
	@Override
	public int getColumnCount() {
		return BazaPredmeta.getInstance().getColumnCountPolozeni();
	}

	@Override
	public int getRowCount() {
		return student.getOcenePolozenihPredmeta().size();
	}
	
	public String getColumnName(int column) {
		return BazaPredmeta.getInstance().getColumnNamePolozeni(column);
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return BazaStudenata.getInstance().getValueAtPolozeni(rowIndex, columnIndex, student);
	}
}
