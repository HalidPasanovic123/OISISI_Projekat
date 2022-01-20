package View.Dialogs.ProfesorEditDialog;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import AbstractActions.OdustaniAction;
import Controllers.PredmetController;
import Model.Predmet;
import Model.Profesor;
import View.Dialogs.ProfesorEditDialog.DodajJDialogPredmetProfesoru;

public class DodajJDialogPredmetProfesoru extends JDialog{
    public DodajJDialogPredmetProfesoru(Profesor profesor, JPanel parent,ProfesorPredmetiJTable predmeti) {

        setModalityType(ModalityType.APPLICATION_MODAL);
        setSize(500,500);
        setTitle("Dodaj predmet");
        setLocationRelativeTo(parent);

        GridBagLayout gridBag = new GridBagLayout();
        setLayout(gridBag);
		
        GridBagConstraints gridBagConstraints = new GridBagConstraints(0, 0, 2, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,new Insets(5, 5, 5, 5), 0, 0);

        DodajJtablePredmetProfesoru tableDodaj = new DodajJtablePredmetProfesoru(profesor);
        JScrollPane sp = new JScrollPane(tableDodaj);
        this.add(sp, gridBagConstraints);

        gridBagConstraints = new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE,new Insets(0, 5, 0, 5), 0, 0);

        JButton potvrdi = new JButton("Potvrdi");
        add(potvrdi, gridBagConstraints);
        potvrdi.setEnabled(false);

        potvrdi.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            	Predmet p = PredmetController.getInstance().getPredmetByID(tableDodaj.convertRowIndexToModel(tableDodaj.getSelectedRow()));
            	//System.out.println(p.toString());
                profesor.setPredmet(p);
                //profesor.IspisiTabelu();
            	AbstractTableModelPredmeti model = (AbstractTableModelPredmeti) predmeti.getModel();
            	model.fireTableDataChanged();
        		validate();
        		dispose();
                // TODO Auto-generated method stub
                
            }
            
        });

        gridBagConstraints = new GridBagConstraints(1, 1, 1, 1, 0, 0, GridBagConstraints.EAST, GridBagConstraints.NONE,new Insets(0, 5, 0, 5), 0, 0);

        JButton odustani = new JButton(new OdustaniAction(this));
        add(odustani, gridBagConstraints);
        
        odustani.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	dispose();
                // TODO Auto-generated method stub
                
            }
            
        }); 

        gridBagConstraints = new GridBagConstraints(1, 1, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE,new Insets(0, 5, 0, 5), 0, 0);
		JLabel labela=new JLabel("Predmet je vec dodat!");
		this.add(labela,gridBagConstraints);
        labela.setVisible(false);

        //source: https://stackoverflow.com/questions/375265/jtable-selection-change-event-handling-find-the-source-table-dynamically
        tableDodaj.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            
            @Override
			public void valueChanged(ListSelectionEvent e) 
            {
                potvrdi.setEnabled(true);
                labela.setVisible(false);
            	Predmet p = PredmetController.getInstance().getPredmetByID(tableDodaj.convertRowIndexToModel(tableDodaj.getSelectedRow()));
                for (Predmet pp : profesor.getPredmeti())
                {
                    if (pp.getSifraPredmeta() == p.getSifraPredmeta())
                    {
                        labela.setVisible(true);
                        
                        potvrdi.setEnabled(false);
                    }
                }
			}
        });


    }
    

}
