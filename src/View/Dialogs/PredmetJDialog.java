package View.Dialogs;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import AbstractActions.OdustaniAction;
import Controllers.PredmetController;
import Controllers.StudentController;
import Model.Adresa;
import Model.Predmet;
import Model.Semestar;
import Model.Student;
import View.MainWindowWithComponents.MainWindow;


public class PredmetJDialog extends JDialog{

    /**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;

	JTextField fieldSifra;
	JTextField fieldNaziv;
	JTextField fieldGodina;
	JTextField fieldBodovi;
	
	JComboBox<String> comboBox;
	
	JButton potvrdi;
	JButton odustani;
	
	public PredmetJDialog() {
        
        setModalityType(ModalityType.APPLICATION_MODAL);
        setSize(404,260);
        setLocationRelativeTo(MainWindow.getInstance());

        GridBagLayout gridBag = new GridBagLayout();
        setLayout(gridBag);

        int gridy = 0;
        
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
        GridBagConstraints gridBagConstraints = new GridBagConstraints(0, gridy, 1, 1, 0, 0, GridBagConstraints.EAST, GridBagConstraints.NONE,new Insets(0, 5, 0, 0), 0, 0);
        JLabel sifra = new JLabel("Sifra Predmeta*");
        add(sifra, gridBagConstraints);

        //TextField za Sifru Predmeta
        gridBagConstraints = new GridBagConstraints(1, gridy, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,new Insets(5, 25, 0, 0), 225, 0);
        fieldSifra = new JTextField();
        add(fieldSifra, gridBagConstraints);
        fieldSifra.getDocument().addDocumentListener(myDocumentListener);
        gridy++;

        //Labela za Naziv Predmeta
        gridBagConstraints = new GridBagConstraints(0, gridy, 1, 1, 0, 0, GridBagConstraints.EAST, GridBagConstraints.NONE,new Insets(0, 5, 0, 0), 0, 0);
        JLabel ime = new JLabel("Naziv Predmeta*");
        add(ime, gridBagConstraints);

        //TextField za Naziv Predmeta
        gridBagConstraints = new GridBagConstraints(1, gridy, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,new Insets(5, 25, 0, 0), 225, 0);
        fieldNaziv = new JTextField();
        add(fieldNaziv, gridBagConstraints);
        fieldNaziv.getDocument().addDocumentListener(myDocumentListener);
        gridy++;

        //Labela za Godinu studija
        gridBagConstraints = new GridBagConstraints(0, gridy, 1, 1, 0, 0, GridBagConstraints.EAST, GridBagConstraints.NONE,new Insets(0, 5, 0, 0), 0, 0);
        JLabel godina = new JLabel("Godina Studija*");
        add(godina, gridBagConstraints);

        //TextField za Godinu studija
        gridBagConstraints = new GridBagConstraints(1, gridy, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,new Insets(5, 25, 0, 0), 225, 0);
        fieldGodina = new JTextField();
        add(fieldGodina, gridBagConstraints);
        fieldGodina.getDocument().addDocumentListener(myDocumentListener);
        gridy++;

        //Labela za Broj ESPB bodova
        gridBagConstraints = new GridBagConstraints(0, gridy, 1, 1, 0, 0, GridBagConstraints.EAST, GridBagConstraints.NONE,new Insets(0, 5, 0, 0), 0, 0);
        JLabel bodovi = new JLabel("ESPB Bodovi*");
        add(bodovi, gridBagConstraints);

        //TextField za Broj ESPB bodova
        gridBagConstraints = new GridBagConstraints(1, gridy, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,new Insets(5, 25, 0, 0), 225, 0);
        fieldBodovi = new JTextField();
        add(fieldBodovi, gridBagConstraints);
        fieldBodovi.getDocument().addDocumentListener(myDocumentListener);
        gridy++;

        //Labela za Semestar
        gridBagConstraints = new GridBagConstraints(0, gridy, 1, 1, 0, 0, GridBagConstraints.EAST, GridBagConstraints.NONE,new Insets(0, 5, 0, 0), 0, 0);
        JLabel semestar = new JLabel("Semestar*");
        add(semestar, gridBagConstraints);

        //ComboBox za Semestar
        ArrayList<String> semestri = new ArrayList<String>();
        semestri.add("Letnji");
        semestri.add("Zimski");
        comboBox = new JComboBox(semestri.toArray());
        gridBagConstraints = new GridBagConstraints(1, gridy, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE,new Insets(5, 25, 0, 0), 165, 0);
        add(comboBox, gridBagConstraints);
        gridy++;

        //Dugme za potvrdi
        potvrdi = new JButton("Potvrdi");
        gridBagConstraints = new GridBagConstraints(0, gridy, 1, 1, 0, 0, GridBagConstraints.EAST, GridBagConstraints.NONE,new Insets(10, 0, 0, 0), 0, 0);
        add(potvrdi, gridBagConstraints);
        potvrdi.setEnabled(false);

        //Dugme za potvrdi
        odustani = new JButton(new OdustaniAction(this));
        gridBagConstraints = new GridBagConstraints(1, gridy, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE,new Insets(10, 25, 0, 0), 0, 0);
        add(odustani, gridBagConstraints);
        
        
        potvrdi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String sifra=fieldSifra.getText();
				String naziv=fieldNaziv.getText();
				String godina = fieldGodina.getText();
				String espb = fieldBodovi.getText();
				Semestar semestar = Semestar.ZIMSKI;
				if(comboBox.getSelectedItem().equals("Letnji"))
				{
					semestar = Semestar.LETNJI;
				}
				
				boolean postoji = false;
				for (Predmet p : PredmetController.getInstance().getPredmeti())
				{
					if (p.getSifraPredmeta().equals(sifra))
					{
						postoji = true;
					}
						
				}
				
				PredmetController.getInstance().dodajPredmet(sifra, naziv, semestar, godina, null, Integer.valueOf(espb), new ArrayList<Student>(), new ArrayList<Student>());
				provera();
				dispose();
			}
        });
        
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
		String godina = fieldGodina.getText();
		String espb = fieldBodovi.getText();
		Semestar semestar = Semestar.ZIMSKI;
		if(comboBox.getSelectedItem().equals("Letnji"))
		{
			semestar = Semestar.LETNJI;
		}
		
		boolean postoji = false;
		for (Predmet p : PredmetController.getInstance().getPredmeti())
		{
			if (p.getSifraPredmeta().equals(sifra))
			{
				postoji = true;
			}
				
		}
		if(!postoji && Pattern.matches("([a-zA-ZĹˇÄ‘ÄŤÄ‡ĹľĹ Ä�ÄŚÄ†Ĺ˝]+[\\s]*)+", naziv) &&
		Pattern.matches("[1-4]{1}", godina) && Pattern.matches("[0-9]{1,2}", espb))
		{
			potvrdi.setEnabled(true);
		}
		else
		{
			potvrdi.setEnabled(false);
		}
	}
}
