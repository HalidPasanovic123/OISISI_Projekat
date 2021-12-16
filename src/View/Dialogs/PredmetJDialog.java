package View.Dialogs;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import AbstractActions.OdustaniAction;
import View.MainWindowWithComponents.MainWindow;

public class PredmetJDialog extends JDialog{

    public PredmetJDialog() {
        Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
        
        setModalityType(ModalityType.APPLICATION_MODAL);
        setSize(screenSize.width / 6 , screenSize.height *25 / 100);
        setLocationRelativeTo(MainWindow.getInstance());

        GridBagLayout gridBag = new GridBagLayout();
        setLayout(gridBag);

        int gridy = 0;
        
        //Labela za Sifru Predmeta
        GridBagConstraints gridBagConstraints = new GridBagConstraints(0, gridy, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE,new Insets(0, 5, 0, 0), 0, 0);
        JLabel sifra = new JLabel("Sifra Predmeta*");
        add(sifra, gridBagConstraints);

        //TextField za Sifru Predmeta
        gridBagConstraints = new GridBagConstraints(1, gridy, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE,new Insets(5, 25, 0, 0), 225, 0);
        JTextField fieldSifra = new JTextField();
        add(fieldSifra, gridBagConstraints);
        gridy++;

        //Labela za Naziv Predmeta
        gridBagConstraints = new GridBagConstraints(0, gridy, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE,new Insets(0, 5, 0, 0), 0, 0);
        JLabel ime = new JLabel("Naziv Predmeta*");
        add(ime, gridBagConstraints);

        //TextField za Naziv Predmeta
        gridBagConstraints = new GridBagConstraints(1, gridy, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE,new Insets(5, 25, 0, 0), 225, 0);
        JTextField fieldNaziv = new JTextField();
        add(fieldNaziv, gridBagConstraints);
        gridy++;

        //Labela za Godinu studija
        gridBagConstraints = new GridBagConstraints(0, gridy, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE,new Insets(0, 5, 0, 0), 0, 0);
        JLabel godina = new JLabel("Godina Studija*");
        add(godina, gridBagConstraints);

        //TextField za Godinu studija
        gridBagConstraints = new GridBagConstraints(1, gridy, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE,new Insets(5, 25, 0, 0), 225, 0);
        JTextField fieldGodina = new JTextField();
        add(fieldGodina, gridBagConstraints);
        gridy++;

        //Labela za Broj ESPB bodova
        gridBagConstraints = new GridBagConstraints(0, gridy, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE,new Insets(0, 5, 0, 0), 0, 0);
        JLabel bodovi = new JLabel("ESPB Bodovi*");
        add(bodovi, gridBagConstraints);

        //TextField za Broj ESPB bodova
        gridBagConstraints = new GridBagConstraints(1, gridy, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE,new Insets(5, 25, 0, 0), 225, 0);
        JTextField fieldBodovi = new JTextField();
        add(fieldBodovi, gridBagConstraints);
        gridy++;

        //Labela za Semestar
        gridBagConstraints = new GridBagConstraints(0, gridy, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE,new Insets(0, 5, 0, 0), 0, 0);
        JLabel semestar = new JLabel("Semestar*");
        add(semestar, gridBagConstraints);

        //ComboBox za Semestar
        ArrayList<String> semestri = new ArrayList<String>();
        semestri.add("Letnji");
        semestri.add("Zimski");
        JComboBox<String> comboBox = new JComboBox(semestri.toArray());
        gridBagConstraints = new GridBagConstraints(1, gridy, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE,new Insets(5, 25, 0, 0), 165, 0);
        add(comboBox, gridBagConstraints);
        gridy++;

        //Dugme za potvrdi
        JButton potvrdi = new JButton("Potvrdi");
        gridBagConstraints = new GridBagConstraints(0, gridy, 1, 1, 0, 0, GridBagConstraints.EAST, GridBagConstraints.NONE,new Insets(10, 0, 0, 0), 0, 0);
        add(potvrdi, gridBagConstraints);

        //Dugme za potvrdi
        JButton odustani = new JButton(new OdustaniAction(this));
        gridBagConstraints = new GridBagConstraints(1, gridy, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE,new Insets(10, 25, 0, 0), 0, 0);
        add(odustani, gridBagConstraints);
    }
    
}
