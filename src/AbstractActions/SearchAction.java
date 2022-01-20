package AbstractActions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

import Model.Profesor;
import View.MainWindowWithComponents.MainWindow;

public class SearchAction extends AbstractAction{

    private JTextField searchInput;

    public SearchAction(JTextField searchInput){    
        this.searchInput = searchInput;  
        putValue(SHORT_DESCRIPTION, "Search existing entity");        
        putValue(SMALL_ICON, new ImageIcon("Images/Toolbar_Button_4.png"));        
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (MainWindow.getInstance().getTabs().getJTabbedPane().getSelectedIndex() == 0) {
            
        } else if(MainWindow.getInstance().getTabs().getJTabbedPane().getSelectedIndex() == 1){
            ProfesorSearch();
        } else if(MainWindow.getInstance().getTabs().getJTabbedPane().getSelectedIndex() == 2){
            PredmetSearch();
        }

    }

    private void ProfesorSearch() {

    }

    private void PredmetSearch() {

    }
    
}
