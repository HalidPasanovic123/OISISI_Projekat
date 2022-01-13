package View.Dialogs.ProfesorEditDialog;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Model.Profesor;

public class ProfesorPredmetPanel extends JPanel{

    private JScrollPane predmeti;

    public ProfesorPredmetPanel(Profesor profesor) {
        predmeti = new JScrollPane(new ProfesorPredmetiJTable(profesor));

        JButton addButton = new JButton("Dodaj Predmet");
        this.add(addButton, BorderLayout.NORTH);

        JButton removeButton = new JButton("Ukloni predmet");
        this.add(removeButton, BorderLayout.NORTH);

        this.add(predmeti, BorderLayout.CENTER);
    }
    


}
