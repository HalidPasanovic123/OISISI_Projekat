package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

public class SearchAction extends AbstractAction{

    public SearchAction(){       
        putValue(SHORT_DESCRIPTION, "Search existing entity");        
        putValue(SMALL_ICON, new ImageIcon("Images/Toolbar_Button_4.png"));        
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
    }
    
}
