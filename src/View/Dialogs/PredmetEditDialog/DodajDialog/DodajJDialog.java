package View.Dialogs.PredmetEditDialog.DodajDialog;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

import javax.swing.JDialog;
import javax.swing.JScrollPane;

import javax.swing.JButton;

import AbstractActions.OdustaniAction;
import Controllers.PredmetController;
import Controllers.ProfesorController;
import Model.Predmet;
import Model.Profesor;
import View.Dialogs.PredmetEditDialog.PredmetEditJDialog;

public class DodajJDialog extends JDialog{

    private DodajJtable tableDodaj;
    private Profesor resultat = null;

    public DodajJDialog(Predmet predmet, PredmetEditJDialog parent) {

        setModalityType(ModalityType.APPLICATION_MODAL);
        setSize(500,500);
        setLocationRelativeTo(parent);

        GridBagLayout gridBag = new GridBagLayout();
        setLayout(gridBag);

        GridBagConstraints gridBagConstraints = new GridBagConstraints(0, 0, 2, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,new Insets(5, 5, 5, 5), 0, 0);

        tableDodaj = new DodajJtable();
        this.add(new JScrollPane(tableDodaj), gridBagConstraints);

        gridBagConstraints = new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE,new Insets(0, 5, 0, 5), 0, 0);

        JButton potvrdi = new JButton("Potvrdi");
        add(potvrdi, gridBagConstraints);

        potvrdi.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            	int temp = tableDodaj.getSelectedRow();
                if(temp != -1)
                {
                    resultat = ProfesorController.getInstance().getProfesorByID(tableDodaj.convertRowIndexToModel(temp));
                    PredmetController.getInstance().dodajProfesorNaPredmet(predmet, resultat);
                    ProfesorController.getInstance().dodajPredmetNaProfesor(parent.getPredmetTemp(), resultat);
                }
                dispose();
            }
            
        });

        gridBagConstraints = new GridBagConstraints(1, 1, 1, 1, 0, 0, GridBagConstraints.EAST, GridBagConstraints.NONE,new Insets(0, 5, 0, 5), 0, 0);

        JButton odustani = new JButton(new OdustaniAction(this));
        add(odustani, gridBagConstraints);
        
        odustani.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            	dispose();
            }
            
        });
    }

    public Profesor getResultat() {
        return resultat;
    }
}
