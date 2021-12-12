package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

public class ModifyAction extends AbstractAction{
    
    public ModifyAction(){        
        putValue(SHORT_DESCRIPTION, "Edit existing entity");        
        putValue(SMALL_ICON, new ImageIcon("Images/Toolbar_Button_2.png"));        
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
    }
}
