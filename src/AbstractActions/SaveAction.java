package AbstractActions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

import Baze.BazaKatedre;
import Baze.BazaPredmeta;
import Baze.BazaProfesora;
import Baze.BazaStudenata;

public class SaveAction extends AbstractAction {

    public SaveAction(){
        putValue(SHORT_DESCRIPTION, "Save all entities");        
        putValue(SMALL_ICON, new ImageIcon("Images"+File.separator+"save.png"));        
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            BazaPredmeta.getInstance().serialization();
            BazaProfesora.getInstance().serialization();
            BazaStudenata.getInstance().serialization();
            BazaKatedre.getInstance().serialization();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }
    
}
