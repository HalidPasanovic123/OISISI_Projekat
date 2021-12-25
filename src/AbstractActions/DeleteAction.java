package AbstractActions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import Controllers.StudentController;
import Model.Student;
import View.MainWindowWithComponents.*;
import View.Dialogs.DeleteProfesorJDialog;
import View.MainWindowWithComponents.MainWindow;

public class DeleteAction extends AbstractAction {

	private final JFrame parent;
	
    public DeleteAction(final JFrame parent) {
    	this.parent = parent;
        putValue(SHORT_DESCRIPTION, "Delete existing entity");        
        putValue(SMALL_ICON, new ImageIcon("Images/Toolbar_Button_3.png"));        
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
    	if (MainWindow.getInstance().getTabs().getJTabbedPane().getSelectedIndex() == 0 &&  MainWindow.getInstance().getTabs().getTableStudent().getSelectedRow() != -1) {
			int reply=JOptionPane.showOptionDialog(parent, 
			        "Da li ste sigurni da želite da obrišete studenta?", 
			        "Brisanje studenta", 
			        JOptionPane.OK_CANCEL_OPTION, 
			        JOptionPane.INFORMATION_MESSAGE, 
			        null, 
			        new String[]{"Da", "Ne"}, 
			        "default");
			if(reply==JOptionPane.YES_OPTION) {
				int row=TabPanel.getInstance().getTableStudent().convertRowIndexToModel(MainWindow.getInstance().getTabs().getTableStudent().getSelectedRow());
				Student s=StudentController.getInstance().getStudentFromRow(row);
				StudentController.getInstance().izbrisiStudent(s);
				MainWindow.getInstance().updateShowingOfStudent("Brisanje Studenta", -1);
			}
    	}
    }
}
