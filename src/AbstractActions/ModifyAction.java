package AbstractActions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

import Controllers.ProfesorController;
import View.Dialogs.PredmetJDialog;
import View.Dialogs.ProfesorJDialog;
import View.MainWindowWithComponents.MainWindow;

public class ModifyAction extends AbstractAction{
    
    public ModifyAction(){        
        putValue(SHORT_DESCRIPTION, "Edit existing entity");        
        putValue(SMALL_ICON, new ImageIcon("Images/Toolbar_Button_2.png"));        
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (MainWindow.getInstance().getTabs().getJTabbedPane().getSelectedIndex() == 0) {
            
        } else if(MainWindow.getInstance().getTabs().getJTabbedPane().getSelectedIndex() == 1){
            int temp = MainWindow.getInstance().getTabs().getTabelProfesori().getRowSelected();
            if (temp != -1) {
                ProfesorJDialog profDialog = new ProfesorJDialog(ProfesorController.getInstance().getProfesorByID(temp));
                profDialog.setVisible(true);
            }
        } else if(MainWindow.getInstance().getTabs().getJTabbedPane().getSelectedIndex() == 2){
            PredmetJDialog preDialog = new PredmetJDialog();
            preDialog.setVisible(true);
        }
    }
}
