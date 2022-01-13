package View.Dialogs.StudentEditDialog.NepolozeniTab.PolaganjeButton;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import AbstractActions.OdustaniAction;
import View.MainWindowWithComponents.MainWindow;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;

public class PolaganjeJDialog extends JDialog {

    public PolaganjeJDialog() {
        setName("Polaganje");
        setSize(420, 250);
        setLocationRelativeTo(MainWindow.getInstance());

        GridBagLayout gridBag = new GridBagLayout();
        setLayout(gridBag);

        GridBagConstraints gbcl = new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 5, 0, 0), 0, 0);

        GridBagConstraints gbct = new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,new Insets(5, 25, 0, 0), 225, 0);

        JLabel sifra = new JLabel("Sifra*");
        add(sifra, gbcl);
        gbcl.gridy++;
        
        JTextField fieldSifra = new JTextField();
        fieldSifra.setEnabled(false);
        add(fieldSifra, gbct);
        gbct.gridy++;

        JLabel naziv = new JLabel("Naziv*");
        add(naziv, gbcl);
        gbcl.gridy++;
        
        JTextField fieldNaziv = new JTextField();
        fieldNaziv.setEnabled(false);
        add(fieldNaziv, gbct);
        gbct.gridy++;
        
        JLabel datum = new JLabel("Datum*");
        add(datum, gbcl);
        gbcl.gridy++;
        
        JTextField fieldDatum = new JTextField();
        add(fieldDatum, gbct);
        gbct.gridy++;
        
        JLabel ocena = new JLabel("Ocena*");
        add(ocena, gbcl);
        gbcl.gridy++;

        ArrayList<Integer> valsGS = new ArrayList<Integer>();
        valsGS.add(6);
        valsGS.add(7);
        valsGS.add(8);
        valsGS.add(9);
        valsGS.add(10);
        JComboBox<Integer> combo = new JComboBox(valsGS.toArray());
        add(combo, gbct);
        gbct.gridy++;

        JButton potvrdi = new JButton("Potvrdi");
        gbcl = new GridBagConstraints(0, 5, 1, 1, 0, 0, GridBagConstraints.EAST, GridBagConstraints.NONE,new Insets(10, 25, 0, 0), 0, 0);
        add(potvrdi, gbcl);

        //Dugme za potvrdi
        JButton odustani = new JButton(new OdustaniAction(this));
        gbct = new GridBagConstraints(1, 5, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE,new Insets(10, 25, 0, 0), 0, 0);
        add(odustani, gbct);
    }
    
}
