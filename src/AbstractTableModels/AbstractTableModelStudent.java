package AbstractTableModels;

import javax.swing.table.AbstractTableModel;

import Baze.BazaStudenata;

public class AbstractTableModelStudent extends AbstractTableModel {

	@Override
	public int getRowCount() {
		return BazaStudenata.getInstance().getStudenti().size();
	}

	@Override
	public int getColumnCount() {
		return BazaStudenata.getInstance().getColumnCount();
	}
	public String getColumnName(int column) {
		return BazaStudenata.getInstance().getColumnName(column);
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return BazaStudenata.getInstance().getValueAt(rowIndex, columnIndex);
	}

}

