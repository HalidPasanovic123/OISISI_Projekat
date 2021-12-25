package AbstractActions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

import View.Dialogs.DeleteProfesorJDialog;
import View.MainWindowWithComponents.MainWindow;

public class DeleteAction extends AbstractAction {

    public DeleteAction(){       
        putValue(SHORT_DESCRIPTION, "Delete existing entity");        
        putValue(SMALL_ICON, new ImageIcon("Images/Toolbar_Button_3.png"));        
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (MainWindow.getInstance().getTabs().getJTabbedPane().getSelectedIndex() == 0) {
            
        } else if(MainWindow.getInstance().getTabs().getJTabbedPane().getSelectedIndex() == 1){
            int temp = MainWindow.getInstance().getTabs().getTabelProfesori().getRowSelected();
            if (temp != -1) {
                DeleteProfesorJDialog deleteProfesorJDialog = new DeleteProfesorJDialog();
                deleteProfesorJDialog.setVisible(true);
            }
        } else if(MainWindow.getInstance().getTabs().getJTabbedPane().getSelectedIndex() == 2){
            
        }
        
    }
    
}
