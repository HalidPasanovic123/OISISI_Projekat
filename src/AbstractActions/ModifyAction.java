package AbstractActions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.KeyStroke;

import View.Dialogs.ProfesorEditDialog.ProfesorEditJDialog;
import View.Dialogs.StudentEditDialog.StudentEditDialog;
import Controllers.PredmetController;
import Controllers.ProfesorController;
import View.Dialogs.PredmetEditDialog.PredmetEditJDialog;
import View.MainWindowWithComponents.MainWindow;

public class ModifyAction extends AbstractAction{
    
	private final JFrame parent;
	
    public ModifyAction(final JFrame parent)
    {   
    	this.parent = parent;	
        putValue(SHORT_DESCRIPTION, "Edit existing entity");        
        putValue(SMALL_ICON, new ImageIcon("Images"+File.separator+"Toolbar_Button_2.png"));        
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (MainWindow.getInstance().getTabs().getJTabbedPane().getSelectedIndex() == 0) {
            int temp = MainWindow.getInstance().getTabs().getTableStudent().getSelectedRow();
            if (temp != -1) {
                StudentEditDialog studentDialog = new StudentEditDialog(parent,"Edit");
        	    studentDialog.setVisible(true);
            }
        } else if(MainWindow.getInstance().getTabs().getJTabbedPane().getSelectedIndex() == 1){
            int temp = MainWindow.getInstance().getTabs().getTabelProfesori().getSelectedRow();
            if (temp != -1) {
                ProfesorEditJDialog profDialog = new ProfesorEditJDialog(ProfesorController.getInstance().getProfesorByID(MainWindow.getInstance().getTabs().getTabelProfesori().convertRowIndexToModel(temp)));
                profDialog.setVisible(true);
            }
        } else if(MainWindow.getInstance().getTabs().getJTabbedPane().getSelectedIndex() == 2){
            int temp = MainWindow.getInstance().getTabs().getTabelPredmeti().getSelectedRow();
            if (temp != -1) {
                PredmetEditJDialog preDialog = new PredmetEditJDialog(PredmetController.getInstance().getPredmetByID(MainWindow.getInstance().getTabs().getTabelPredmeti().convertRowIndexToModel(temp)));
                preDialog.setVisible(true);
            }
        }
    }
}
