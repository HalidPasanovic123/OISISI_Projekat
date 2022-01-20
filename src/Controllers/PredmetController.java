package Controllers;

import java.util.ArrayList;

import Baze.BazaPredmeta;
import Baze.BazaProfesora;
import Model.Predmet;
import Model.Profesor;
import Model.Semestar;
import Model.Student;
import View.MainWindowWithComponents.MainWindow;

public class PredmetController {
    
    private static PredmetController instance = null;

    public static PredmetController getInstance() {
		if (instance == null) {
			instance = new PredmetController();
		}
		return instance;
	}

    public PredmetController(){}

    
	public ArrayList<Predmet> getPredmeti() {
		return BazaPredmeta.getInstance().getPredmeti();
	}
	
    public void addPredmet(Predmet Predmet){
        BazaPredmeta.getInstance().addPredmet(Predmet);
    }

    public void deletePredmet(String sifraPredmeta){
        BazaPredmeta.getInstance().deletePredmet(sifraPredmeta);
    }

    public Predmet getPredmetByID(int id) {
        return BazaPredmeta.getInstance().getPredmet(id);
    }

    public void EditPredmet(String sifraPredmeta, String nazivPredmeta, Semestar semestar, String godinaStudija, int brojESPB, String prethodnaSifra)
    {
        BazaPredmeta.getInstance().changePredmet(sifraPredmeta, nazivPredmeta, semestar, godinaStudija, brojESPB, prethodnaSifra);
        MainWindow.getInstance().updateShowingsOfPredmet();	
    }
    
    public void dodajPredmet(String sifraPredmeta, String nazivPredmeta, Semestar semestar, String godinaStudija,
			Profesor predmetniProfesor, int brojESPB, ArrayList<Student> spisakPolozenih,
			ArrayList<Student> spisakNepolozenih)
    {
    	BazaPredmeta.getInstance().dodajPredmet(sifraPredmeta,  nazivPredmeta,  semestar,  godinaStudija,
   			 predmetniProfesor,  brojESPB, spisakPolozenih, spisakNepolozenih);
    	MainWindow.getInstance().updateShowingsOfPredmet();
    }

    public void dodajProfesorNaPredmet(Predmet predmet, Profesor profesor){
        BazaPredmeta.getInstance().dodajProfesorNaPredmet(predmet, profesor);
    }

    public void obrisiProfesoraSaPredmeta(Predmet predmet){
        BazaPredmeta.getInstance().obrisiProfesoraSaPredmeta(predmet);
    }
    


}
