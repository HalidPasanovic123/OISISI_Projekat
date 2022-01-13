package Controllers;

import java.time.LocalDate;
import java.util.ArrayList;


import Baze.BazaProfesora;
import Model.Adresa;
import Model.Profesor;
import UsefulClasses.AdressCreatorFromString;
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

        LocalDate datumRodjenja = LocalDate.parse(datum);
        int brojLicneKarte = Integer.parseInt(licna);
        int godineStaza =  Integer.parseInt(staz);

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
        MainWindow.getInstance().updateShowingsOfProfesors();
    }

    public static ArrayList<Profesor> getProfesors() {
        return BazaProfesora.getInstance().getProfesors();
    }

    public Profesor getProfesorByID(int id) {
        return BazaProfesora.getInstance().getProfesorByID(id);
    }

    public Profesor createProfesor(String prezime, String ime, String datum, String adresa, String adresaK, String licna, 
    String zvanje, String staz, String eMail, String kontakt) {
        LocalDate datumRodjenja;
        int brojLicneKarte = -1;
        int godineStaza = -1;

        try {
            brojLicneKarte = Integer.parseInt(licna);
            datumRodjenja = LocalDate.parse(datum);
            godineStaza = Integer.parseInt(staz);

            Adresa adresa1 = AdressCreatorFromString.createAdresa(adresa);
            Adresa adresa2 = AdressCreatorFromString.createAdresa(adresaK);

            Profesor profesor = new Profesor(prezime, ime, datumRodjenja, adresa1, kontakt, eMail, 
            adresa2, brojLicneKarte, zvanje, godineStaza);

            return profesor;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
