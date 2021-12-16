package Controllers;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Baze.BazaProfesora;
import Model.Adresa;
import Model.Profesor;
import UsefulClasses.AdressCreatorFromString;
import UsefulClasses.StringCheckers;
import View.MainWindowWithComponents.MainWindow;

public class ProfesorController {
    
    private static ProfesorController instance = null;

    public static ProfesorController getInstance() {
		if (instance == null) {
			instance = new ProfesorController();
		}
		return instance;
	}

    public ProfesorController(){}

    public void addProfesor(String prezime, String ime, String datum, String adresa, String adresaK, String licna, 
    String zvanje, String staz, String eMail, String kontakt){

        LocalDate datumRodjenja;
        int brojLicneKarte;
        int godineStaza;

        //Provera da li postoji vec profesor koji hocemo da dodamo
        try {
            brojLicneKarte = Integer.parseInt(licna);
            for (Profesor p : BazaProfesora.getInstance().getProfesors()){
                if(p.getBrojLicneKarte() == brojLicneKarte){
                    JOptionPane.showMessageDialog(null, "Profesor se vec nalazi u bazi!");
                    return;
                }
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Nije Broj licne dobro uneto!\nTreba da je broj");
            return;
        }
        //Provera da li je datum unet dobar
        try {
            datumRodjenja = LocalDate.parse(datum);
        } catch (DateTimeException e1) {
            JOptionPane.showMessageDialog(null, "Nije Datum dobro unet!\nTreba da je oblika YYYY-MM-DD");
            return;
        }

        if (!StringCheckers.checkImeOrPrezime(prezime)) {
            JOptionPane.showMessageDialog(null, "Neispravno prezime!");
            return;
        } else if(!StringCheckers.checkImeOrPrezime(ime)){
            JOptionPane.showMessageDialog(null, "Neispravno ime!");
            return;
        } else if(!StringCheckers.checkAdresa(adresa)){
            JOptionPane.showMessageDialog(null, "Neispravna adresa stanovanja!\nFormat: ulica broj, grad, drzava");
            return;
        } else if(!StringCheckers.checkAdresa(adresaK)){
            JOptionPane.showMessageDialog(null, "Neispravna adresa kancelarije!\nFormat: ulica broj, grad, drzava");
            return;
        } else if(!StringCheckers.checkZvanje(zvanje)){
            JOptionPane.showMessageDialog(null, "Pogresno uneto zvanje!\nZvanje mora samo slovima biti napisano");
            return;
        } else if(!StringCheckers.checkEmail(eMail)){
            JOptionPane.showMessageDialog(null, "Pogresno unet mail!");
            return;
        } else if(!StringCheckers.checkTelefon(kontakt)){
            JOptionPane.showMessageDialog(null, "Pogresno unet kontakt telefon!");
            return;
        } 
        //Provera da li su godine staza dobro unete
        try {
            godineStaza = Integer.parseInt(staz);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Nisu godine staza dobro unete!\nTreba da je broj");
            return;
        }

        Adresa adresa1 = AdressCreatorFromString.createAdresa(adresa);
        Adresa adresa2 = AdressCreatorFromString.createAdresa(adresaK);

        Profesor profesor = new Profesor(prezime, ime, datumRodjenja, adresa1, kontakt, eMail, 
        adresa2, brojLicneKarte, zvanje, godineStaza);

        BazaProfesora.getInstance().addProfesor(profesor);
        MainWindow.getInstance().updateShowingsOfProfesors();
    }

    public void deleteProfesor(int brojLicneKarte){
        BazaProfesora.getInstance().deleteProfesor(brojLicneKarte);
    }

    public void changeProfesor(Profesor profesor, int prethodniBrojLicne){
        BazaProfesora.getInstance().changeProfesor(profesor, prethodniBrojLicne);
    }

    public ArrayList<Profesor> getProfesors() {
        return BazaProfesora.getInstance().getProfesors();
    }
}
