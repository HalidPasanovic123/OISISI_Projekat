

import Baze.BazaPredmeta;
import Baze.BazaProfesora;
import Controllers.PredmetController;
import Controllers.ProfesorController;
import View.MainWindowWithComponents.MainWindow;

public class MyApp {

	public static void main(String[] args) {
		BazaPredmeta.getInstance();
		BazaProfesora.getInstance();
		PredmetController.getInstance();
		ProfesorController.getInstance();
		MainWindow.getInstance();
	}

}
