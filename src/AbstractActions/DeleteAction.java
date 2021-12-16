package AbstractActions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

public class DeleteAction extends AbstractAction {

    public DeleteAction(){       
        putValue(SHORT_DESCRIPTION, "Delete existing entity");        
        putValue(SMALL_ICON, new ImageIcon("Images/Toolbar_Button_3.png"));        
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
    }
    
}
