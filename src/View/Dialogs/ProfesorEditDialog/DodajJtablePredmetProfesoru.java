package View.Dialogs.ProfesorEditDialog;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;

import Model.Profesor;
import View.Dialogs.ProfesorEditDialog.ApstractDodajTableModelPredmetProfesoru;

public class DodajJtablePredmetProfesoru extends JTable{
	
    public DodajJtablePredmetProfesoru(Profesor p) {
        this.setRowSelectionAllowed(true);
        this.setColumnSelectionAllowed(true);
        this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.setModel(new ApstractDodajTableModelPredmetProfesoru());
        this.setTableHeader(null);
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

}
