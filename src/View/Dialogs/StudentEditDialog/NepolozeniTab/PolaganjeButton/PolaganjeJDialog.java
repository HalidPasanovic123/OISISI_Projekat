package View.Dialogs.StudentEditDialog.NepolozeniTab.PolaganjeButton;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import AbstractActions.OdustaniAction;
import Model.Ocena;
import Model.OcenaNaIspitu;
import Model.Predmet;
import Model.Student;
import View.Dialogs.StudentEditDialog.StudentEditTabbedPane;
import View.MainWindowWithComponents.MainWindow;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.time.DateTimeException;
import java.time.LocalDate;

public class PolaganjeJDialog extends JDialog {

    private boolean datumBool;
    private JButton potvrdi;
    private Student student;

    public PolaganjeJDialog(Predmet predmet, StudentEditTabbedPane parent) {
        student = parent.getStudent();

        setName("Polaganje");
        setSize(420, 250);
        setLocationRelativeTo(MainWindow.getInstance());

        GridBagLayout gridBag = new GridBagLayout();
        setLayout(gridBag);

        GridBagConstraints gbcl = new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 5, 0, 0), 0, 0);

        GridBagConstraints gbct = new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,new Insets(5, 25, 0, 0), 225, 0);

        JLabel sifra = new JLabel("Šifra*");
        add(sifra, gbcl);
        gbcl.gridy++;
        
        JTextField fieldSifra = new JTextField();
        fieldSifra.setEditable(false);
        fieldSifra.setText(predmet.getSifraPredmeta());
        add(fieldSifra, gbct);
        gbct.gridy++;

        JLabel naziv = new JLabel("Naziv*");
        add(naziv, gbcl);
        gbcl.gridy++;
        
        JTextField fieldNaziv = new JTextField();
        fieldNaziv.setEditable(false);
        fieldNaziv.setText(predmet.getNazivPredmeta());
        add(fieldNaziv, gbct);
        gbct.gridy++;
        
        JLabel datum = new JLabel("Datum*");
        add(datum, gbcl);
        gbcl.gridy++;
        
        JTextField fieldDatum = new JTextField();
        fieldDatum.addFocusListener(new FocusListener() {
            @Override
            public void focusLost(FocusEvent e) {
                try {
                    LocalDate.parse(fieldDatum.getText());
                    datumBool = true;
                    fieldDatum.setForeground(Color.BLACK);
                    check();
                } catch (DateTimeException e1) {
                    datumBool = false;
                    fieldDatum.setText("Format mora da bude YYYY-MM-DD");
                    fieldDatum.setForeground(Color.RED);
                    check();
                }
            }
            @Override
            public void focusGained(FocusEvent e) {
                fieldDatum.setForeground(Color.BLACK);
                check();
            }
        });
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

        potvrdi = new JButton("Potvrdi");
        gbcl = new GridBagConstraints(0, 5, 1, 1, 0, 0, GridBagConstraints.EAST, GridBagConstraints.NONE,new Insets(10, 25, 0, 0), 0, 0);
        add(potvrdi, gbcl);
        potvrdi.setEnabled(false);
        potvrdi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //Brisanje predmeta iz liste nepolozenih predmeta kod studenta
                student.brisanjeNepolozenog(predmet);

                Ocena ocena1;

                switch (combo.getSelectedIndex()) {
                    case 0:
                        ocena1 = Ocena.SEST;
                        break;
                    case 1:
                        ocena1 = Ocena.SEDAM;
                        break;
                    case 2:
                        ocena1 = Ocena.OSAM;
                        break;
                    case 3:
                        ocena1 = Ocena.DEVET;
                        break;
                    case 4:
                        ocena1 = Ocena.DESET;
                        break;
                
                    default:
                        ocena1 = Ocena.PET;
                        break;
                }

                OcenaNaIspitu ocenaTemp = new OcenaNaIspitu(student, predmet, LocalDate.parse(fieldDatum.getText()), ocena1);
                
                //Dodavanje ocene studentu
                student.getOcenePolozenihPredmeta().add(ocenaTemp);

                //Brisanje studenta iz liste nepolozenih predmeta
                predmet.brisanjeIzNepolozenih(student);

                //Dodavanje studenta u listu polozenih
                predmet.getSpisakPolozenih().add(student);

                parent.getNepolozeniTab().updateShowingOfNepolozeni();

                parent.getPolozeniTab().updateShowingOfPolozeni();

                dispose();
            }
        });

        //Dugme za potvrdi
        JButton odustani = new JButton(new OdustaniAction(this));
        gbct = new GridBagConstraints(1, 5, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE,new Insets(10, 25, 0, 0), 0, 0);
        add(odustani, gbct);
    }
    
    private void check() {
        if (datumBool) {
            potvrdi.setEnabled(true);
        }
        else
        {
            potvrdi.setEnabled(false);
        }
    }
}
