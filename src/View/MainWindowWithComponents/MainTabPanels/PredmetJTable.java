package View.MainWindowWithComponents.MainTabPanels;

import java.awt.Color;
import java.awt.Component;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import AbstractTableModels.AbstractModelPredmeta;

public class PredmetJTable extends JTable {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    private TableRowSorter<TableModel> sorter;

	public PredmetJTable() {
        this.setRowSelectionAllowed(true);
        this.setColumnSelectionAllowed(true);
        this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.setModel(new AbstractModelPredmeta());
        sorter = new TableRowSorter<TableModel>(this.getModel());
        this.setRowSorter(sorter);

        final Pattern regexStrings = Pattern.compile("([a-zA-ZčČćĆžŽđĐšŠ]+)");
        final Pattern regexNumber = Pattern.compile("([0-9]+)");

        sorter.setComparator(2, new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
            
		});

        sorter.setComparator(0, new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                int result = 0;

                final Matcher tempString1 = regexStrings.matcher(o1);
                final Matcher stringNumber1 = regexNumber.matcher(o1);
                final Matcher tempString2 = regexStrings.matcher(o2);
                final Matcher stringNumber2 = regexNumber.matcher(o2);

                tempString1.find();
                tempString2.find();

                String string1 = tempString1.group();
                String string2 = tempString2.group();

                result += string1.compareTo(string2)*100000;

                stringNumber1.find();
                stringNumber2.find();

                int num1 = Integer.parseInt(stringNumber1.group());
                int num2 = Integer.parseInt(stringNumber2.group());

                result += Math.abs(num1 - num2);

                return result;
            }
		});

        
    }

    public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
        Component c = super.prepareRenderer(renderer, row, column);
        if (isRowSelected(row)) {
            c.setBackground(Color.LIGHT_GRAY);
        } else {
            c.setBackground(Color.WHITE);
        }
        return c;
    }

    public TableRowSorter<TableModel> getSorter() {
        return sorter;
    }
}
