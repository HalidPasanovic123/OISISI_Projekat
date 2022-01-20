package View.Dialogs.ProfesorEditDialog;

import javax.swing.JPanel;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import AbstractActions.OdustaniAction;
import Controllers.ProfesorController;
import Model.Profesor;
import UsefulClasses.StringCheckers;

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

public class ProfesorInfoPanel extends JPanel{

    private boolean imeBool = true;
    private boolean prezimeBool = true;
    private boolean datumBool = true;
    private boolean adresaBool = true;
    private boolean adresakBool = true;
    private boolean brojBool = true;
    private boolean zvanjeBool = true;
    private boolean godineBool = true;
    private boolean emailBool = true;
    private boolean kontaktBool = true;
    private JButton potvrdi;
    
    public ProfesorInfoPanel(Profesor profesor, ProfesorEditJDialog dialog) {
        int prethodniBrojLicne = profesor.getBrojLicneKarte();
        
        GridBagLayout gridBag = new GridBagLayout();
        setLayout(gridBag);

        int gridy = 0;
        //Labela za Prezime
        GridBagConstraints gridBagConstraints = new GridBagConstraints(0, gridy, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE,new Insets(0, 5, 0, 0), 0, 0);
        JLabel prez = new JLabel("Prezime*");
        add(prez, gridBagConstraints);

        //TextField za Prezime
        gridBagConstraints = new GridBagConstraints(1, gridy, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,new Insets(5, 25, 0, 0), 225, 0);
        JTextField fieldPrez = new JTextField();
        fieldPrez.setText(profesor.getPrezime());
        fieldPrez.addFocusListener(new FocusListener() {
            @Override
            public void focusLost(FocusEvent e) {
                if (!StringCheckers.checkImeOrPrezime(fieldPrez.getText()) || fieldPrez.getText().equals("Neispravno prezime!")) {
                    prezimeBool = false;
                    fieldPrez.setText("Neispravno prezime!");
                    fieldPrez.setForeground(Color.RED);
                    check();
                } else {
                    prezimeBool = true;
                    fieldPrez.setForeground(Color.BLACK);
                    check();
                }
            }
            @Override
            public void focusGained(FocusEvent e) {
                fieldPrez.setForeground(Color.BLACK);
            }
        });
        add(fieldPrez, gridBagConstraints);
        gridy++;

        //Labela za Ime
        gridBagConstraints = new GridBagConstraints(0, gridy, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE,new Insets(0, 5, 0, 0), 0, 0);
        JLabel ime = new JLabel("Ime*");
        add(ime, gridBagConstraints);

        //TextField za Ime
        gridBagConstraints = new GridBagConstraints(1, gridy, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,new Insets(5, 25, 0, 0), 225, 0);
        JTextField fieldIme = new JTextField();
        fieldIme.setText(profesor.getIme());
        fieldIme.addFocusListener(new FocusListener() {
            @Override
            public void focusLost(FocusEvent e) {
                if (!StringCheckers.checkImeOrPrezime(fieldIme.getText()) || fieldIme.getText().equals("Neispravno ime!")) {
                    imeBool = false;
                    fieldIme.setText("Neispravno ime!");
                    fieldIme.setForeground(Color.RED);
                    check();
                } else {
                    imeBool = true;
                    fieldIme.setForeground(Color.BLACK);
                    check();
                }
            }
            @Override
            public void focusGained(FocusEvent e) {
                fieldIme.setForeground(Color.BLACK);
            }
        });
        add(fieldIme, gridBagConstraints);
        gridy++;

        //Labela za Datum Rodjenja
        gridBagConstraints = new GridBagConstraints(0, gridy, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE,new Insets(0, 5, 0, 0), 0, 0);
        JLabel datum = new JLabel("Datum*");
        add(datum, gridBagConstraints);
        
        //TextField za Datum Rodjenja
        gridBagConstraints = new GridBagConstraints(1, gridy, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,new Insets(5, 25, 0, 0), 225, 0);
        JTextField fieldDatum = new JTextField();
        fieldDatum.setText(profesor.getDatumRodjenja().toString());
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
            }
        });
        add(fieldDatum, gridBagConstraints);
        gridy++;

        //Labela za Adresu Stanovanja
        gridBagConstraints = new GridBagConstraints(0, gridy, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE,new Insets(0, 5, 0, 0), 0, 0);
        JLabel adresa = new JLabel("Adresa*");
        add(adresa, gridBagConstraints);

        //TextField za Adresu Stanovanja
        gridBagConstraints = new GridBagConstraints(1, gridy, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,new Insets(5, 25, 0, 0), 225, 0);
        JTextField fieldAdresa = new JTextField();
        fieldAdresa.setText(profesor.getAdresaStanovanja().toString());
        fieldAdresa.addFocusListener(new FocusListener() {
            @Override
            public void focusLost(FocusEvent e) {
                if (!StringCheckers.checkAdresa(fieldAdresa.getText()) || fieldAdresa.getText().equals("Neispravna adresa! Treba format - ulica broj, grad, drzava")) {
                    adresaBool = false;
                    fieldAdresa.setText("Neispravna adresa! Treba format - ulica broj, grad, drzava");
                    fieldAdresa.setForeground(Color.RED);
                    check();
                } else {
                    adresaBool = true;
                    fieldAdresa.setForeground(Color.BLACK);
                    check();
                }
            }
            @Override
            public void focusGained(FocusEvent e) {
                fieldAdresa.setForeground(Color.BLACK);
            }
        });
        add(fieldAdresa, gridBagConstraints);
        gridy++;

        //Labela za Adresu Kancelarije
        gridBagConstraints = new GridBagConstraints(0, gridy, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE,new Insets(0, 5, 0, 0), 0, 0);
        JLabel adresaK = new JLabel("Adresa Kancelarije*");
        add(adresaK, gridBagConstraints);

        //TextField za Adresu Kancelarije
        gridBagConstraints = new GridBagConstraints(1, gridy, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,new Insets(5, 25, 0, 0), 225, 0);
        JTextField fieldAdresaK = new JTextField();
        fieldAdresaK.setText(profesor.getAdresaKancelarije().toString());
        fieldAdresaK.addFocusListener(new FocusListener() {
            @Override
            public void focusLost(FocusEvent e) {
                if (!StringCheckers.checkAdresa(fieldAdresaK.getText()) || fieldAdresaK.getText().equals("Neispravna adresa! Treba format - ulica broj, grad, drzava")) {
                    adresakBool = false;
                    fieldAdresaK.setText("Neispravna adresa! Treba format - ulica broj, grad, drzava");
                    fieldAdresaK.setForeground(Color.RED);
                    check();
                } else {
                    adresakBool = true;
                    fieldAdresaK.setForeground(Color.BLACK);
                    check();
                }
            }
            @Override
            public void focusGained(FocusEvent e) {
                fieldAdresaK.setForeground(Color.BLACK);
            }
        });
        add(fieldAdresaK, gridBagConstraints);
        gridy++;

        //Labela za Broj Licne Karte
        gridBagConstraints = new GridBagConstraints(0, gridy, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE,new Insets(0, 5, 0, 0), 0, 0);
        JLabel licna = new JLabel("Broj Lične Karte*");
        add(licna, gridBagConstraints);

        //TextField za Broj Licne Karte
        gridBagConstraints = new GridBagConstraints(1, gridy, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,new Insets(5, 25, 0, 0), 225, 0);
        JTextField fieldLicna = new JTextField();
        fieldLicna.setText(Integer.toString(profesor.getBrojLicneKarte()));
        fieldLicna.addFocusListener(new FocusListener() {
            @Override
            public void focusLost(FocusEvent e) {
                try { 
                    int brojLicneKarte = Integer.parseInt(fieldLicna.getText());
                    for (Profesor p : ProfesorController.getProfesors()){
                        if(p.getBrojLicneKarte() == brojLicneKarte && brojLicneKarte != prethodniBrojLicne){
                            brojBool = false;
                            fieldLicna.setForeground(Color.RED);
                            fieldLicna.setText("Broj Licne vec postoji u bazi!");
                            check();
                            return;
                        }
                    }
                    brojBool = true;
                    fieldLicna.setForeground(Color.BLACK);
                    check();
                } catch (NumberFormatException e1) {
                    brojBool = false;
                    fieldLicna.setForeground(Color.RED);
                    fieldLicna.setText("Nije Broj licne dobro uneto! Treba da je broj");
                    check();
                    return;
                }
            }
            @Override
            public void focusGained(FocusEvent e) {
                fieldLicna.setForeground(Color.BLACK);
            }
        });
        add(fieldLicna, gridBagConstraints);
        gridy++;

        //Labela za Zvanje
        gridBagConstraints = new GridBagConstraints(0, gridy, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE,new Insets(0, 5, 0, 0), 0, 0);
        JLabel zvanje = new JLabel("Zvanje*");
        add(zvanje, gridBagConstraints);

        //TextField za Zvanje
        gridBagConstraints = new GridBagConstraints(1, gridy, 1, 1, 50, 0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,new Insets(5, 25, 0, 0), 225, 0);
        JTextField fieldZvanje = new JTextField();
        fieldZvanje.setText(profesor.getZvanje());
        fieldZvanje.addFocusListener(new FocusListener() {
            @Override
            public void focusLost(FocusEvent e) {
                if (!StringCheckers.checkZvanje(fieldZvanje.getText()) || fieldZvanje.getText().equals("Neispravno uneto zvanje!")) {
                    zvanjeBool = false;
                    fieldZvanje.setText("Neispravno uneto zvanje!");
                    fieldZvanje.setForeground(Color.RED);
                    check();
                } else {
                    zvanjeBool = true;
                    fieldZvanje.setForeground(Color.BLACK);
                    check();
                }
            }
            @Override
            public void focusGained(FocusEvent e) {
                fieldZvanje.setForeground(Color.BLACK);
            }
        });
        add(fieldZvanje, gridBagConstraints);
        gridy++;

        //Labela za Godine Staza
        gridBagConstraints = new GridBagConstraints(0, gridy, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE,new Insets(0, 5, 0, 0), 0, 0);
        JLabel staz = new JLabel("Godine Staža*");
        add(staz, gridBagConstraints);

        //TextField za Godine Staza
        gridBagConstraints = new GridBagConstraints(1, gridy, 1, 1, 50, 0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,new Insets(5, 25, 0, 0), 225, 0);
        JTextField fieldStaz = new JTextField();
        fieldStaz.setText(Integer.toString(profesor.getGodineStaza()));
        fieldStaz.addFocusListener(new FocusListener() {
            @Override
            public void focusLost(FocusEvent e) {
                try { 
                    Integer.parseInt(fieldStaz.getText());
                    godineBool = true;
                    fieldStaz.setForeground(Color.BLACK);
                    check();
                } catch (NumberFormatException e1) {
                    godineBool = false;
                    fieldStaz.setForeground(Color.RED);
                    fieldStaz.setText("Nisu godine staza dobro uneto! Treba da je broj");
                    check();
                    return;
                }
            }
            @Override
            public void focusGained(FocusEvent e) {
                fieldStaz.setForeground(Color.BLACK);
            }
        });
        add(fieldStaz, gridBagConstraints);
        gridy++;

        //Labela za E-mail Adresu
        gridBagConstraints = new GridBagConstraints(0, gridy, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE,new Insets(0, 5, 0, 0), 0, 0);
        JLabel email = new JLabel("E-Mail Adresa");
        add(email, gridBagConstraints);

        //TextField za E-mail Adresu
        gridBagConstraints = new GridBagConstraints(1, gridy, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,new Insets(5, 25, 0, 0), 225, 0);
        JTextField fieldEmail = new JTextField();
        fieldEmail.setText(profesor.getEmailAdresa());
        fieldEmail.addFocusListener(new FocusListener() {
            @Override
            public void focusLost(FocusEvent e) {
                if (!StringCheckers.checkEmail(fieldEmail.getText()) || fieldEmail.getText().equals("Neispravan e-mail!")) {
                    emailBool = false;
                    fieldEmail.setText("Neispravan e-mail!");
                    fieldEmail.setForeground(Color.RED);
                    check();
                } else {
                    emailBool = true;
                    fieldEmail.setForeground(Color.BLACK);
                    check();
                }
            }
            @Override
            public void focusGained(FocusEvent e) {
                fieldEmail.setForeground(Color.BLACK);
            }
        });
        add(fieldEmail, gridBagConstraints);
        gridy++;

        //Labela za Kontakt Telefon
        gridBagConstraints = new GridBagConstraints(0, gridy, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE,new Insets(0, 5, 0, 0), 0, 0);
        JLabel kontakt = new JLabel("Kontakt Telefon");
        add(kontakt, gridBagConstraints);

        //TextField za Kontakt Telefon
        gridBagConstraints = new GridBagConstraints(1, gridy, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,new Insets(5, 25, 0, 0), 225, 0);
        JTextField fieldKontakt = new JTextField();
        fieldKontakt.setText(profesor.getKontaktTelefon());
        fieldKontakt.addFocusListener(new FocusListener() {
            @Override
            public void focusLost(FocusEvent e) {
                if (!StringCheckers.checkTelefon(fieldKontakt.getText()) || fieldKontakt.getText().equals("Neispravan kontakt telefon!")) {
                    kontaktBool = false;
                    fieldKontakt.setText("Neispravan kontakt telefon!");
                    fieldKontakt.setForeground(Color.RED);
                    check();
                } else {
                    kontaktBool = true;
                    fieldKontakt.setForeground(Color.BLACK);
                    check();
                }
            }
            @Override
            public void focusGained(FocusEvent e) {
                fieldKontakt.setForeground(Color.BLACK);
            }
        });
        add(fieldKontakt, gridBagConstraints);
        gridy++;

        //Dugme za potvrdi
        potvrdi = new JButton("Potvrdi");
        gridBagConstraints = new GridBagConstraints(0, gridy, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE,new Insets(10, 0, 0, 0), 0, 0);
        add(potvrdi, gridBagConstraints);

        //Dugme za potvrdi
        JButton odustani = new JButton(new OdustaniAction(dialog));
        gridBagConstraints = new GridBagConstraints(1, gridy, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE,new Insets(10, 25, 0, 0), 0, 0);
        add(odustani, gridBagConstraints);

        ProfesorEditJDialog temp = dialog;
        potvrdi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (imeBool && prezimeBool && datumBool && adresaBool && adresakBool && brojBool && zvanjeBool && godineBool && emailBool && kontaktBool) {
                    String getPrez = fieldPrez.getText();
                    String getIme = fieldIme.getText();
                    String getDatum = fieldDatum.getText();
                    String getAdresa = fieldAdresa.getText();
                    String getAdresaK = fieldAdresaK.getText();
                    String getLicna = fieldLicna.getText();
                    String getZvanje = fieldZvanje.getText();
                    String getStaz = fieldStaz.getText();
                    String getEmail = fieldEmail.getText();
                    String getKontakt = fieldKontakt.getText();

                    ProfesorController.getInstance().changeProfesor(ProfesorController.getInstance().createProfesor(getPrez, getIme, getDatum, getAdresa, getAdresaK,
                    getLicna, getZvanje, getStaz, getEmail, getKontakt), prethodniBrojLicne);

                    temp.dispose();
                }
            }
        });

    }

    private void check() {
        if (imeBool && prezimeBool && datumBool && adresaBool && adresakBool && brojBool && zvanjeBool && godineBool && emailBool && kontaktBool) {
            potvrdi.setEnabled(true);
        }
        else
        {
            potvrdi.setEnabled(false);
        }
    }
}
