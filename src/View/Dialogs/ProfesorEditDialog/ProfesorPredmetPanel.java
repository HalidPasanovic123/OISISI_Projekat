package View.Dialogs.ProfesorEditDialog;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Model.Predmet;
import Model.Profesor;


public class ProfesorPredmetPanel extends JPanel{

    private JScrollPane predmeti;
    private ProfesorPredmetiJTable profpredTable;
    DodajJDialogPredmetProfesoru dodajDialog;
    
    public ProfesorPredmetPanel(Profesor profesor) {
        profpredTable = new ProfesorPredmetiJTable(profesor);
        predmeti = new JScrollPane(profpredTable);
        JPanel parent = this;
        dodajDialog = new DodajJDialogPredmetProfesoru(profesor,parent,profpredTable);
        JButton addButton = new JButton("Dodaj Predmet");
        this.add(addButton, BorderLayout.NORTH);
        
        addButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                dodajDialog.setVisible(true);
            }
            
        });
        
        JButton removeButton = new JButton("Ukloni predmet");

        removeButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int temp = profpredTable.getSelectedRow();
                Predmet p = profesor.getPredmeti().get(profpredTable.convertRowIndexToModel(temp));
                profesor.izbaciPredmet(p);
                AbstractTableModelPredmeti model = (AbstractTableModelPredmeti) profpredTable.getModel();
            	model.fireTableDataChanged();
        		validate();
                removeButton.setEnabled(false);
            }
            
        });

        this.add(removeButton, BorderLayout.NORTH);
        removeButton.setEnabled(false);

        this.add(predmeti, BorderLayout.CENTER);

        profpredTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            
            @Override
			public void valueChanged(ListSelectionEvent e) 
            {
               if( profpredTable.convertRowIndexToModel(profpredTable.getSelectedRow()) != -1)
               {
                   removeButton.setEnabled(true);
               }
			}
        });
    }
    


}
