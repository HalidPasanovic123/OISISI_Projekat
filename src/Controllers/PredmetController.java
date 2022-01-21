package Controllers;

import java.util.ArrayList;

import Baze.BazaPredmeta;
import Baze.BazaProfesora;
import Baze.BazaStudenata;
import Model.OcenaNaIspitu;
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

    public void deletePredmet(Predmet predmet){
        for (Student s : BazaStudenata.getInstance().getStudenti()){

            for(Predmet p : s.getNepolozeniPredmeti()){
                if(p != null){
                    if(p.getSifraPredmeta().equals(predmet.getSifraPredmeta())){
                        s.getNepolozeniPredmeti().remove(p);
                        break;
                    }
                }
            }

            for(OcenaNaIspitu o : s.getOcenePolozenihPredmeta()){
                if(o != null){
                    if(o.getPredmet().getSifraPredmeta().equals(predmet.getSifraPredmeta())){
                        s.getOcenePolozenihPredmeta().remove(o);
                        break;
                    }
                }
            }
        }

        for (Profesor p : BazaProfesora.getInstance().getProfesors()){
            for (Predmet pr : p.getPredmeti()){
                if(pr != null){
                    if(pr.getSifraPredmeta().equals(predmet.getSifraPredmeta())){
                        p.getPredmeti().remove(pr);
                        break;
                    }
                }
            }
        }

        //BazaProfesora.getInstance().brisanjePredmeta(predmet);

        BazaPredmeta.getInstance().deletePredmet(predmet);
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
