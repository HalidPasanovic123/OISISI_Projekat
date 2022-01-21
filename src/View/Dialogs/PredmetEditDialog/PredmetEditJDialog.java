package View.Dialogs.PredmetEditDialog;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import AbstractActions.OdustaniAction;
import Controllers.PredmetController;
import Controllers.ProfesorController;
import Model.Predmet;
import Model.Semestar;
import View.Dialogs.PredmetEditDialog.DodajDialog.DodajJDialog;
import View.MainWindowWithComponents.MainWindow;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class PredmetEditJDialog extends JDialog{
	
	private JTextField fieldSifra;
	private JTextField fieldNaziv;
	private JTextField fieldBodovi;
	private JTextField fieldProfesor;
	
	private JComboBox<String> comboBox1;
	private JComboBox<String> comboBox2;
	
	private JButton dodaj;
	private JButton obrisi;
	private JButton potvrdi;
	private JButton odustani;

    private Predmet predmetTemp;
	
	String prethodnaSifra;
    public PredmetEditJDialog(Predmet predmet) {
        super(MainWindow.getInstance());

        predmetTemp = predmet;
        setName("Izmeni Predmet");
        setModalityType(ModalityType.APPLICATION_MODAL);
        setSize(485,278);
        setLocationRelativeTo(MainWindow.getInstance());

        GridBagLayout gridBag = new GridBagLayout();
        setLayout(gridBag);
    	
        int gridy = 0;
        
        prethodnaSifra = predmet.getSifraPredmeta();
        class MyDocListener implements DocumentListener
		  {
			
			@Override
			public void changedUpdate(DocumentEvent arg0) {
				// TODO Auto-generated method stub
				provera();
			}


			@Override
			public void insertUpdate(DocumentEvent arg0) {
				// TODO Auto-generated method stub
				provera();
			}

			@Override
			public void removeUpdate(DocumentEvent arg0) {
				// TODO Auto-generated method stub
				provera();
			}
		 
		  }
		
		
		DocumentListener myDocumentListener=new MyDocListener();
		
        //Labela za Sifru Predmeta
        GridBagConstraints gridBagConstraints = new GridBagConstraints(0, gridy, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE,new Insets(0, 5, 0, 0), 0, 0);
        JLabel sifra = new JLabel("Šifra Predmeta*");
        add(sifra, gridBagConstraints);

        //TextField za Sifru Predmeta
        gridBagConstraints = new GridBagConstraints(1, gridy, 3, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,new Insets(5, 25, 0, 0), 225, 0);
        fieldSifra = new JTextField();
        fieldSifra.setText(predmet.getSifraPredmeta());
        fieldSifra.getDocument().addDocumentListener(myDocumentListener);
        add(fieldSifra, gridBagConstraints);
        gridy++;

        //Labela za Naziv Predmeta
        gridBagConstraints = new GridBagConstraints(0, gridy, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE,new Insets(0, 5, 0, 0), 0, 0);
        JLabel ime = new JLabel("Naziv Predmeta*");
        add(ime, gridBagConstraints);

        //TextField za Naziv Predmeta
        gridBagConstraints = new GridBagConstraints(1, gridy, 3, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,new Insets(5, 25, 0, 0), 225, 0);
        fieldNaziv = new JTextField();
        fieldNaziv.setText(predmet.getNazivPredmeta());
        fieldNaziv.getDocument().addDocumentListener(myDocumentListener);
        add(fieldNaziv, gridBagConstraints);
        gridy++;

        //Labela za Godinu studija
        gridBagConstraints = new GridBagConstraints(0, gridy, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE,new Insets(0, 5, 0, 0), 0, 0);
        JLabel godina = new JLabel("Godina Studija*");
        add(godina, gridBagConstraints);

        //TextField za Godinu studija
        ArrayList<String> godine = new ArrayList<String>();
        godine.add("1");
        godine.add("2");
        godine.add("3");
        godine.add("4");
        godine.add("5");
        comboBox1 = new JComboBox(godine.toArray());
        gridBagConstraints = new GridBagConstraints(1, gridy, 3, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,new Insets(5, 25, 0, 0), 165, 0);
        if(predmet.getGodinaStudija() == "1")
        {
        	comboBox1.setSelectedIndex(0);
        }
        else if(predmet.getGodinaStudija() == "2")
        {
        	comboBox1.setSelectedIndex(1);
        }
        else if(predmet.getGodinaStudija() == "3")
        {
        	comboBox1.setSelectedIndex(2);
        }
        else if(predmet.getGodinaStudija() == "4")
        {
        	comboBox1.setSelectedIndex(3);
        }
        else
        {
        	comboBox1.setSelectedIndex(4);
        }
        add(comboBox1, gridBagConstraints);
        gridy++;

        //Labela za Broj ESPB bodova
        gridBagConstraints = new GridBagConstraints(0, gridy, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE,new Insets(0, 5, 0, 0), 0, 0);
        JLabel bodovi = new JLabel("ESPB Bodovi*");
        add(bodovi, gridBagConstraints);

        //TextField za Broj ESPB bodova
        gridBagConstraints = new GridBagConstraints(1, gridy, 3, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,new Insets(5, 25, 0, 0), 225, 0);
        fieldBodovi = new JTextField();
        fieldBodovi.setText(String.valueOf(predmet.getBrojESPB()));
        fieldBodovi.getDocument().addDocumentListener(myDocumentListener);
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
        comboBox2 = new JComboBox(semestri.toArray());
        gridBagConstraints = new GridBagConstraints(1, gridy, 3, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,new Insets(5, 25, 0, 0), 165, 0);
        if(predmet.getSemestar() == Semestar.LETNJI)
        {
        	comboBox2.setSelectedIndex(0);
        }
        else if(predmet.getSemestar() == Semestar.ZIMSKI)
        {
        	comboBox2.setSelectedIndex(1);
        }
        add(comboBox2, gridBagConstraints);
        gridy++;

        dodaj = new JButton("+");
        gridBagConstraints = new GridBagConstraints(2, gridy, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE,new Insets(10, 10, 0, 0), 0, 0);
        add(dodaj, gridBagConstraints);

        PredmetEditJDialog parentTemp = this;
        dodaj.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                DodajJDialog dodajDialog = new DodajJDialog(predmet, parentTemp);
                dodajDialog.setVisible(true);
                if(predmet.getPredmetniProfesor() != null)
                {
                    dodaj.setEnabled(false);
                    obrisi.setEnabled(true);
                    fieldProfesor.setText(predmet.getPredmetniProfesor().getIme() + " " + predmet.getPredmetniProfesor().getPrezime());
                }
               
            }
            
        });

        obrisi = new JButton("-");
        gridBagConstraints = new GridBagConstraints(3, gridy, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE,new Insets(10, 15, 0, 0), 0, 0);
        add(obrisi, gridBagConstraints);

        obrisi.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int reply=JOptionPane.showOptionDialog(parentTemp, 
			        "Da li ste sigurni da želite da obrišete profesora?", 
			        "Brisanje profesora", 
			        JOptionPane.OK_CANCEL_OPTION, 
			        JOptionPane.INFORMATION_MESSAGE, 
			        null, 
			        new String[]{"Da", "Ne"}, 
			        "default");
                if(reply==JOptionPane.YES_OPTION) {
                    ProfesorController.getInstance().obrisiPredmetSaProfesora(predmet, predmet.getPredmetniProfesor());
                    PredmetController.getInstance().obrisiProfesoraSaPredmeta(predmet);
                    fieldProfesor.setText("");
                    dodaj.setEnabled(true);
                    obrisi.setEnabled(false);
                }
            }
            
        });

        gridBagConstraints = new GridBagConstraints(0, gridy, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE,new Insets(0, 5, 0, 0), 0, 0);
        JLabel profesor = new JLabel("Profesor*");
        add(profesor, gridBagConstraints);

        gridBagConstraints = new GridBagConstraints(1, gridy, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE,new Insets(5, 25, 0, 0), 225, 0);
        fieldProfesor = new JTextField();
        fieldProfesor.setEditable(false);
        if(predmet.getPredmetniProfesor() != null)
        {
            fieldProfesor.setText(predmet.getPredmetniProfesor().getIme() + " " +predmet.getPredmetniProfesor().getPrezime());
            dodaj.setEnabled(false);
            obrisi.setEnabled(true);
        }
        else
        {
            dodaj.setEnabled(true);
            obrisi.setEnabled(false);
        }
        add(fieldProfesor, gridBagConstraints);
        gridy++;

        //Dugme za potvrdi
        potvrdi = new JButton("Potvrdi");
        gridBagConstraints = new GridBagConstraints(0, gridy, 1, 1, 0, 0, GridBagConstraints.EAST, GridBagConstraints.NONE,new Insets(10, 0, 0, 0), 0, 0);
        add(potvrdi, gridBagConstraints);
        potvrdi.setEnabled(true);

        potvrdi.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	String sifra = fieldSifra.getText();
            	String naziv = fieldNaziv.getText();
            	String godina = (String) comboBox1.getSelectedItem();
            	int bodovi = Integer.parseInt(fieldBodovi.getText());
                Semestar s = Semestar.LETNJI;
            	if(comboBox2.getSelectedIndex() == 1)
            	{
            		s= Semestar.ZIMSKI;
            	}
            	PredmetController.getInstance().EditPredmet(sifra, naziv, s, godina, bodovi, prethodnaSifra);
            	dispose();
            }
            
        });
        
        //Dugme za odustani
        odustani = new JButton(new OdustaniAction(this));
        gridBagConstraints = new GridBagConstraints(1, gridy, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE,new Insets(10, 25, 0, 0), 0, 0);
        add(odustani, gridBagConstraints);
        
        odustani.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            	dispose();
            }
        });
    }
    
	public void provera() {
		
		String sifra=fieldSifra.getText();
		String naziv=fieldNaziv.getText();
		String godina = (String) comboBox1.getSelectedItem();
		String espb = fieldBodovi.getText();
		
		boolean postoji = false;
		for (Predmet p : PredmetController.getInstance().getPredmeti())
		{
			if (p.getSifraPredmeta().equals(sifra) && !p.getSifraPredmeta().equals(prethodnaSifra))
			{
				postoji = true;
			}
				
		}
		
    	
		if(!postoji &&  Pattern.matches("([a-zA-ZčČćĆžŽđĐšŠ]+[\\s]*)+[0-9]*", naziv) &&
		Pattern.matches("[1-5]{1}", godina) && Pattern.matches("[0-9]{1,2}", espb))
		{
			potvrdi.setEnabled(true);
		}
		else
		{
			potvrdi.setEnabled(false);
		}
	}

    public Predmet getPredmetTemp() {
        return predmetTemp;
    }
}
