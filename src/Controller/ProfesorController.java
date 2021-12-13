package Controller;

import Model.BazaProfesora;
import Model.Profesor;

public class ProfesorController {
    
    private static ProfesorController instance = null;

    public static ProfesorController getInstance() {
		if (instance == null) {
			instance = new ProfesorController();
		}
		return instance;
	}

    public ProfesorController(){

    }

    public void addProfesor(Profesor profesor){
        BazaProfesora.getInstance().addProfesor(profesor);
    }

    public void deleteProfesor(int brojLicneKarte){
        BazaProfesora.getInstance().deleteProfesor(brojLicneKarte);
    }

    public void changeProfesor(Profesor profesor){
        BazaProfesora.getInstance().changeProfesor(profesor);
    }
}
