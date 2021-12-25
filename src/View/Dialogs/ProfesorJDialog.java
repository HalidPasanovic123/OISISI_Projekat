package View.Dialogs;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import AbstractActions.OdustaniAction;
import Controllers.ProfesorController;
import View.MainWindowWithComponents.MainWindow;

import java.awt.GridBagLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProfesorJDialog extends JDialog{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ProfesorJDialog() {
        super(MainWindow.getInstance());

        Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
        
        setModalityType(ModalityType.APPLICATION_MODAL);
        setSize(screenSize.width / 5 , screenSize.height *35 / 100);
        setLocationRelativeTo(MainWindow.getInstance());

        GridBagLayout gridBag = new GridBagLayout();
        setLayout(gridBag);

        int gridy = 0;
        //Labela za Prezime
        GridBagConstraints gridBagConstraints = new GridBagConstraints(0, gridy, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE,new Insets(0, 5, 0, 0), 0, 0);
        JLabel prez = new JLabel("Prezime*");
        add(prez, gridBagConstraints);

        //TextField za Prezime
        gridBagConstraints = new GridBagConstraints(1, gridy, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE,new Insets(5, 25, 0, 0), 225, 0);
        JTextField fieldPrez = new JTextField();
        add(fieldPrez, gridBagConstraints);
        gridy++;

        //Labela za Ime
        gridBagConstraints = new GridBagConstraints(0, gridy, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE,new Insets(0, 5, 0, 0), 0, 0);
        JLabel ime = new JLabel("Ime*");
        add(ime, gridBagConstraints);

        //TextField za Ime
        gridBagConstraints = new GridBagConstraints(1, gridy, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE,new Insets(5, 25, 0, 0), 225, 0);
        JTextField fieldIme = new JTextField();
        add(fieldIme, gridBagConstraints);
        gridy++;

        //Labela za Datum Rodjenja
        gridBagConstraints = new GridBagConstraints(0, gridy, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE,new Insets(0, 5, 0, 0), 0, 0);
        JLabel datum = new JLabel("Datum*");
        add(datum, gridBagConstraints);

        //TextField za Datum Rodjenja
        gridBagConstraints = new GridBagConstraints(1, gridy, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE,new Insets(5, 25, 0, 0), 225, 0);
        JTextField fieldDatum = new JTextField();
        add(fieldDatum, gridBagConstraints);
        gridy++;

        //Labela za Adresu Stanovanja
        gridBagConstraints = new GridBagConstraints(0, gridy, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE,new Insets(0, 5, 0, 0), 0, 0);
        JLabel adresa = new JLabel("Adresa*");
        add(adresa, gridBagConstraints);

        //TextField za Adresu Stanovanja
        gridBagConstraints = new GridBagConstraints(1, gridy, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE,new Insets(5, 25, 0, 0), 225, 0);
        JTextField fieldAdresa = new JTextField();
        add(fieldAdresa, gridBagConstraints);
        gridy++;

        //Labela za Adresu Kancelarije
        gridBagConstraints = new GridBagConstraints(0, gridy, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE,new Insets(0, 5, 0, 0), 0, 0);
        JLabel adresaK = new JLabel("Adresa Kancelarije*");
        add(adresaK, gridBagConstraints);

        //TextField za Adresu Kancelarije
        gridBagConstraints = new GridBagConstraints(1, gridy, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE,new Insets(5, 25, 0, 0), 225, 0);
        JTextField fieldAdresaK = new JTextField();
        add(fieldAdresaK, gridBagConstraints);
        gridy++;

        //Labela za Broj Licne Karte
        gridBagConstraints = new GridBagConstraints(0, gridy, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE,new Insets(0, 5, 0, 0), 0, 0);
        JLabel licna = new JLabel("Broj Lične Karte*");
        add(licna, gridBagConstraints);

        //TextField za Broj Licne Karte
        gridBagConstraints = new GridBagConstraints(1, gridy, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE,new Insets(5, 25, 0, 0), 225, 0);
        JTextField fieldLicna = new JTextField();
        add(fieldLicna, gridBagConstraints);
        gridy++;

        //Labela za Zvanje
        gridBagConstraints = new GridBagConstraints(0, gridy, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE,new Insets(0, 5, 0, 0), 0, 0);
        JLabel zvanje = new JLabel("Zvanje*");
        add(zvanje, gridBagConstraints);

        //TextField za Zvanje
        gridBagConstraints = new GridBagConstraints(1, gridy, 1, 1, 50, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE,new Insets(5, 25, 0, 0), 225, 0);
        JTextField fieldZvanje = new JTextField();
        add(fieldZvanje, gridBagConstraints);
        gridy++;

        //Labela za Godine Staza
        gridBagConstraints = new GridBagConstraints(0, gridy, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE,new Insets(0, 5, 0, 0), 0, 0);
        JLabel staz = new JLabel("Godine Staža*");
        add(staz, gridBagConstraints);

        //TextField za Godine Staza
        gridBagConstraints = new GridBagConstraints(1, gridy, 1, 1, 50, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE,new Insets(5, 25, 0, 0), 225, 0);
        JTextField fieldStaz = new JTextField();
        add(fieldStaz, gridBagConstraints);
        gridy++;

        //Labela za E-mail Adresu
        gridBagConstraints = new GridBagConstraints(0, gridy, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE,new Insets(0, 5, 0, 0), 0, 0);
        JLabel email = new JLabel("E-Mail Adresa");
        add(email, gridBagConstraints);

        //TextField za E-mail Adresu
        gridBagConstraints = new GridBagConstraints(1, gridy, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE,new Insets(5, 25, 0, 0), 225, 0);
        JTextField fieldEmail = new JTextField();
        add(fieldEmail, gridBagConstraints);
        gridy++;

        //Labela za Kontakt Telefon
        gridBagConstraints = new GridBagConstraints(0, gridy, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE,new Insets(0, 5, 0, 0), 0, 0);
        JLabel kontakt = new JLabel("Kontakt Telefon");
        add(kontakt, gridBagConstraints);

        //TextField za Kontakt Telefon
        gridBagConstraints = new GridBagConstraints(1, gridy, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE,new Insets(5, 25, 0, 0), 225, 0);
        JTextField fieldKontakt = new JTextField();
        add(fieldKontakt, gridBagConstraints);
        gridy++;

        //Dugme za potvrdi
        JButton potvrdi = new JButton("Potvrdi");
        gridBagConstraints = new GridBagConstraints(0, gridy, 1, 1, 0, 0, GridBagConstraints.EAST, GridBagConstraints.NONE,new Insets(10, 0, 0, 0), 0, 0);
        add(potvrdi, gridBagConstraints);

        //Dugme za potvrdi
        JButton odustani = new JButton(new OdustaniAction(this));
        gridBagConstraints = new GridBagConstraints(1, gridy, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE,new Insets(10, 25, 0, 0), 0, 0);
        add(odustani, gridBagConstraints);

        potvrdi.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
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

                ProfesorController.getInstance().addProfesor(getPrez, getIme, getDatum, getAdresa, getAdresaK,
                getLicna, getZvanje, getStaz, getEmail, getKontakt);
                
            }

        });

    }
    
}
