package AbstractTableModels;

import javax.swing.table.AbstractTableModel;

import Baze.BazaNepolozenihPredmeta;
import Baze.BazaStudenata;
import Model.Student;

public class AbstractTableModelNepolozeniPredmeti extends AbstractTableModel {
	
	BazaNepolozenihPredmeta bazaNepolozenih;
	
	 public AbstractTableModelNepolozeniPredmeti(Student s) {
		bazaNepolozenih=new BazaNepolozenihPredmeta(s);
	}
	@Override
	public int getColumnCount() {
		return bazaNepolozenih.getColumnCount();
	}

	@Override
	public int getRowCount() {
		return bazaNepolozenih.getPredmeti().size();
	}
	
	public String getColumnName(int column) {
		return bazaNepolozenih.getColumnName(column);
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return bazaNepolozenih.getValueAt(rowIndex, columnIndex);
	}


}
