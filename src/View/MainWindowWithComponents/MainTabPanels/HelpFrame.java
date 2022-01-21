package View.MainWindowWithComponents.MainTabPanels;

import java.awt.TextArea;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;


import View.MainWindowWithComponents.MainWindow;

public class HelpFrame extends JFrame{

    public HelpFrame()
    {
        super();
        setSize(500,500);
        setLocationRelativeTo(MainWindow.getInstance());
		setTitle("Uputstvo");

		TextArea uputstvo = new TextArea();
        String s = "FUNKCIJE NAD STUDENTOM:\n"
        + "\ta) Prikaz Studenata - Prikazivanje studenata iz baze u tabeli => [CTRL + T]\n"
        +"\tb) Dodavanje Studenata - Dodavanje novog studenta u bazu => [CTRL + N] na prozoru studenta\n"
        +"\tc) Izmena Studenata - Izmena postojećeg studenta,dodavanje/brisanje položenih i nepoloženih predmeta=> [CTRL + E] na prozoru studenta\n"
        +"\td) Brisanje Studenata - Brisanje studenta iz baze => [CTRL + D] na prozoru studenta\n"
        +"\te) Pretraga Studenata - Pretraga studenta po prezimenu,imenu i prezimenu ili imenu prezimenu i indeksu=>upis u textbox,zatim klik na dugme\n"
        +"\tf) Sortiranje Studenata - Sortiranje po indeksu,imenu,prezimenu,godini studija,statusu i proseku=>klik na imena kolona\n\n"
        +"FUNKCIJE NAD PROFESOROM:\n"
        + "\ta) Prikaz Profesora - Prikazivanje profesora iz baze u tabeli => [CTRL + P]\n"
        +"\tb) Dodavanje Profesora  - Dodavanje novog profesora u bazu => [CTRL + N] na prozoru profesora\n"
        +"\tc) Izmena Profesora - Izmena postojećeg profesora,dodavanje/brisanje predmeta na kojima profesor predaje => [CTRL + E] na prozoru profesora\n"
        +"\td) Brisanje Profesora - Brisanje profesora iz baze  => [CTRL + D] na prozoru profesora\n"
        +"\te) Pretraga Profesora -Pretraga profesora po prezimenu ili imenu i prezimenu=>upis u textbox,zatim klik na dugme\n"
        +"\tf) Sortiranje Profesora - Sortiranje po broju lične karte,imenu,prezimenu,zvanju i email adresi=>klik na imena kolona\n\n"
        +"FUNKCIJE NAD PREDMETOM:\n"
        + "\ta) Prikaz Predmeta - Prikazivanje predmeta iz baze u tabeli=> [CTRL + R]\n"
        +"\tb) Dodavanje Predmeta - Dodavanje novog predmeta u bazu=> [CTRL + N] na prozoru predmeta\n"
        +"\tc) Izmena Predmeta - Izmena postojećeg predmeta, dodavanje/brisanje profesora koji na njemu predaju=> [CTRL + E] na prozoru predmeta\n"
        +"\td) Brisanje Predmeta - Brisanje predmeta iz baze  => [CTRL + D] na prozoru predmeta\n"
        +"\te) Pretraga Predmeta - Pretraga predmeta po njegovoj šifri ili imenu =>upis u textbox,zatim klik na dugme\n"
        +"\tf) Sortiranje Predmeta - Sortiranje predmeta po njegovim parametrima=>klik na imena kolona\n\n"
        +"DODATNE FUNKCIONALNOSTI:\n"
        +"\ta) Prikaz katedri iz MenuBar-a=>[CTRL + K]\n"
        +"\tb) Dodavanje profesora kao šefa katedre na katedru\n"
        +"\tc) Serijalizacija i deserijalizacija za svaki entitet=>[CTRL + S]\n"
        +"\td) Otvaranje help prozora=>[CTRL + H]\n"
        +"\te) Otvaranje help prozora=>[CTRL + A]\n"
        +"\tf) Izlazak iz programa=>[CRTL + C]\n"
        +"\tg) Gomila sitnih funkcionalnosti....";
        
        uputstvo.setText(s);
		uputstvo.setEditable(false);

        JButton btn = new JButton("Cancel");
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//setVisible(false);
				dispose();
				
			}
		});

		this.add(uputstvo,BorderLayout.CENTER);
        this.add(btn,BorderLayout.SOUTH);

    }
        
}
