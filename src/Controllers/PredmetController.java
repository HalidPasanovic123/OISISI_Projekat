package Controllers;

import java.util.ArrayList;
import java.util.List;

import Baze.BazaPredmeta;
import Model.Predmet;

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

    public void changePredmet(Predmet Predmet){
        BazaPredmeta.getInstance().changePredmet(Predmet);
    }

}