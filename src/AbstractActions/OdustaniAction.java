package AbstractActions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JDialog;

//Klasa koja implementira AbstractAction za dugme odustani za JDialog-a
public class OdustaniAction extends AbstractAction{
    
    private JDialog dialog;

    public OdustaniAction(JDialog dialog) {
        putValue(NAME, "Odustani");
        this.dialog = dialog;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        dialog.dispose();
    }
    
}
