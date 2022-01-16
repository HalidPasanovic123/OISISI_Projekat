package View.Dialogs.PredmetEditDialog;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import AbstractActions.OdustaniAction;
import Model.Predmet;
import View.Dialogs.PredmetEditDialog.DodajDialog.DodajJDialog;
import View.MainWindowWithComponents.MainWindow;

import java.awt.GridBagLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;

public class PredmetEditJDialog extends JDialog{

    public PredmetEditJDialog(Predmet predmet) {
        super(MainWindow.getInstance());

        setName("Izmeni Predmet");
        setModalityType(ModalityType.APPLICATION_MODAL);
        setSize(485,278);
        setLocationRelativeTo(MainWindow.getInstance());

        GridBagLayout gridBag = new GridBagLayout();
        setLayout(gridBag);

        int gridy = 0;
        
        //Labela za Sifru Predmeta
        GridBagConstraints gridBagConstraints = new GridBagConstraints(0, gridy, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE,new Insets(0, 5, 0, 0), 0, 0);
        JLabel sifra = new JLabel("Sifra Predmeta*");
        add(sifra, gridBagConstraints);

        //TextField za Sifru Predmeta
        gridBagConstraints = new GridBagConstraints(1, gridy, 3, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,new Insets(5, 25, 0, 0), 225, 0);
        JTextField fieldSifra = new JTextField();
        add(fieldSifra, gridBagConstraints);
        gridy++;

        //Labela za Naziv Predmeta
        gridBagConstraints = new GridBagConstraints(0, gridy, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE,new Insets(0, 5, 0, 0), 0, 0);
        JLabel ime = new JLabel("Naziv Predmeta*");
        add(ime, gridBagConstraints);

        //TextField za Naziv Predmeta
        gridBagConstraints = new GridBagConstraints(1, gridy, 3, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,new Insets(5, 25, 0, 0), 225, 0);
        JTextField fieldNaziv = new JTextField();
        add(fieldNaziv, gridBagConstraints);
        gridy++;

        //Labela za Godinu studija
        gridBagConstraints = new GridBagConstraints(0, gridy, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE,new Insets(0, 5, 0, 0), 0, 0);
        JLabel godina = new JLabel("Godina Studija*");
        add(godina, gridBagConstraints);

        //TextField za Godinu studija
        gridBagConstraints = new GridBagConstraints(1, gridy, 3, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,new Insets(5, 25, 0, 0), 225, 0);
        JTextField fieldGodina = new JTextField();
        add(fieldGodina, gridBagConstraints);
        gridy++;

        //Labela za Broj ESPB bodova
        gridBagConstraints = new GridBagConstraints(0, gridy, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE,new Insets(0, 5, 0, 0), 0, 0);
        JLabel bodovi = new JLabel("ESPB Bodovi*");
        add(bodovi, gridBagConstraints);

        //TextField za Broj ESPB bodova
        gridBagConstraints = new GridBagConstraints(1, gridy, 3, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,new Insets(5, 25, 0, 0), 225, 0);
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
        gridBagConstraints = new GridBagConstraints(1, gridy, 3, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,new Insets(5, 25, 0, 0), 165, 0);
        add(comboBox, gridBagConstraints);
        gridy++;

        gridBagConstraints = new GridBagConstraints(0, gridy, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE,new Insets(0, 5, 0, 0), 0, 0);
        JLabel profesor = new JLabel("Profesor*");
        add(profesor, gridBagConstraints);

        gridBagConstraints = new GridBagConstraints(1, gridy, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE,new Insets(5, 25, 0, 0), 225, 0);
        JTextField fieldProfesor = new JTextField();
        add(fieldProfesor, gridBagConstraints);

        JButton dodaj = new JButton("+");
        gridBagConstraints = new GridBagConstraints(2, gridy, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE,new Insets(10, 0, 0, 0), 0, 0);
        add(dodaj, gridBagConstraints);

        JDialog parentTemp = this;
        dodaj.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                DodajJDialog dodajDialog = new DodajJDialog(predmet, parentTemp);
                dodajDialog.setVisible(true);
            }
            
        });

        JButton obrisi = new JButton("-");
        gridBagConstraints = new GridBagConstraints(3, gridy, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE,new Insets(10, 25, 0, 0), 0, 0);
        add(obrisi, gridBagConstraints);
        gridy++;

        //Dugme za potvrdi
        JButton potvrdi = new JButton("Potvrdi");
        gridBagConstraints = new GridBagConstraints(0, gridy, 1, 1, 0, 0, GridBagConstraints.EAST, GridBagConstraints.NONE,new Insets(10, 0, 0, 0), 0, 0);
        add(potvrdi, gridBagConstraints);

        //Dugme za odustani
        JButton odustani = new JButton(new OdustaniAction(this));
        gridBagConstraints = new GridBagConstraints(1, gridy, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE,new Insets(10, 25, 0, 0), 0, 0);
        add(odustani, gridBagConstraints);
    }
    
}
