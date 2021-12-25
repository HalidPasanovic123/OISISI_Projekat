package AbstractActions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.KeyStroke;

import View.Dialogs.StudentJDialog;
import View.Dialogs.StudentEditDialog.StudentEditDialog;
import View.MainWindowWithComponents.MainWindow;

public class ModifyAction extends AbstractAction{
    
	private final JFrame parent;
	
    public ModifyAction(final JFrame parent)
    {   
    	this.parent = parent;	
        putValue(SHORT_DESCRIPTION, "Edit existing entity");        
        putValue(SMALL_ICON, new ImageIcon("Images/Toolbar_Button_2.png"));        
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
    	if (MainWindow.getInstance().getTabs().getJTabbedPane().getSelectedIndex() == 0 &&  MainWindow.getInstance().getTabs().getTableStudent().getSelectedRow() != -1) {
        	StudentEditDialog studentDialog = new StudentEditDialog(parent,"Edit");
        	studentDialog.setVisible(true);
    	}
    }
}
