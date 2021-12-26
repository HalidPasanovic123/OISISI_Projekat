package AbstractTableModels;

import javax.swing.table.AbstractTableModel;

import Baze.BazaPolozenihPredmeta;
import Model.Student;

public class AbstractTableModelPolozeniPredmeti extends AbstractTableModel{

	BazaPolozenihPredmeta bazaPolozenih;
	
	public AbstractTableModelPolozeniPredmeti(Student s) {
		bazaPolozenih=new BazaPolozenihPredmeta(s);
	}
	@Override
	public int getColumnCount() {
		return bazaPolozenih.getColumnCount();
	}

	@Override
	public int getRowCount() {
		//return bazaPolozenih.getOcenePredmeta().size();
		return 0;
	}
	
	public String getColumnName(int column) {
		return bazaPolozenih.getColumnName(column);
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return bazaPolozenih.getValueAt(rowIndex, columnIndex);
	}
}
