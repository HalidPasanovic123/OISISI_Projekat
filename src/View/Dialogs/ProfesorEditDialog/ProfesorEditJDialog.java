package View.Dialogs.ProfesorEditDialog;

import javax.swing.JDialog;

import Model.Profesor;
import View.MainWindowWithComponents.MainWindow;


public class ProfesorEditJDialog extends JDialog{
    
    public ProfesorEditJDialog(Profesor profesor) {
		super(MainWindow.getInstance(), "Promena profesora");

		setSize(500, 500);
		setLocationRelativeTo(MainWindow.getInstance());
		this.add(new ProfesorEditJTabbedPane(profesor, this));
	}
}
