package View.Dialogs.ProfesorEditDialog;

import javax.swing.JTabbedPane;

import Model.Profesor;

public class ProfesorEditJTabbedPane extends JTabbedPane {
     
    public ProfesorEditJTabbedPane(Profesor profesor, ProfesorEditJDialog dialog) {
        ProfesorInfoPanel informacije = new ProfesorInfoPanel(profesor, dialog);

        ProfesorPredmetPanel predmeti = new ProfesorPredmetPanel(profesor);

        this.add(informacije, "Info");
        this.add(predmeti, "Predmeti");
    }
}
