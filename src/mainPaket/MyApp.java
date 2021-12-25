package mainPaket;

import Baze.BazaPredmeta;
import Baze.BazaProfesora;
import Baze.BazaStudenata;
import Controllers.PredmetController;
import Controllers.ProfesorController;
import Controllers.StudentController;
import View.MainWindowWithComponents.MainWindow;

public class MyApp {

	public static void main(String[] args) {
		BazaPredmeta.getInstance();
		BazaProfesora.getInstance();
		BazaStudenata.getInstance();
		StudentController.getInstance();
		PredmetController.getInstance();
		ProfesorController.getInstance();
		MainWindow.getInstance();
	}

}
