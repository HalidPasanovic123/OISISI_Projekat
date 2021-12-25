package AbstractActions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import Controllers.ProfesorController;
import Controllers.StudentController;
import Model.Profesor;
import Model.Student;
import View.MainWindowWithComponents.*;
import View.Dialogs.DeleteProfesorJDialog;
import View.MainWindowWithComponents.MainWindow;
import View.MainWindowWithComponents.MainTabPanels.ProfesorJTable;

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

        if (MainWindow.getInstance().getTabs().getJTabbedPane().getSelectedIndex() == 0) {
            int temp = MainWindow.getInstance().getTabs().getTableStudent().getSelectedRow();
            if (temp != -1) {
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
        } else if(MainWindow.getInstance().getTabs().getJTabbedPane().getSelectedIndex() == 1){
            int temp = MainWindow.getInstance().getTabs().getTabelProfesori().getSelectedRow();
            if (temp != -1) {
                int reply=JOptionPane.showOptionDialog(parent, 
			        "Da li ste sigurni da želite da obrišete profesora?", 
			        "Brisanje studenta", 
			        JOptionPane.OK_CANCEL_OPTION, 
			        JOptionPane.INFORMATION_MESSAGE, 
			        null, 
			        new String[]{"Da", "Ne"}, 
			        "default");
                if(reply==JOptionPane.YES_OPTION) {
                    Profesor s=ProfesorController.getInstance().getProfesorByID(MainWindow.getInstance().getTabs().getTabelProfesori().convertRowIndexToModel(temp));
                    ProfesorController.getInstance().deleteProfesor(s.getBrojLicneKarte());
                    MainWindow.getInstance().updateShowingsOfProfesors();
                }
            }
        } else if(MainWindow.getInstance().getTabs().getJTabbedPane().getSelectedIndex() == 2){

        }
    }
}
