package AbstractActions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

import View.Dialogs.PredmetJDialog;
import View.Dialogs.ProfesorJDialog;
import View.MainWindowWithComponents.MainWindow;

public class CreateAction extends AbstractAction {
    
    public CreateAction(){              
        putValue(SHORT_DESCRIPTION, "Create new entity");        
        putValue(SMALL_ICON, new ImageIcon("Images/Toolbar_Button_1.png"));        
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (MainWindow.getInstance().getTabs().getJTabbedPane().getSelectedIndex() == 0) {
            
        } else if(MainWindow.getInstance().getTabs().getJTabbedPane().getSelectedIndex() == 1){
            ProfesorJDialog profDialog = new ProfesorJDialog();
            profDialog.setVisible(true);
        } else if(MainWindow.getInstance().getTabs().getJTabbedPane().getSelectedIndex() == 2){
            PredmetJDialog preDialog = new PredmetJDialog();
            preDialog.setVisible(true);
        }
        
    }
}
