package AbstractActions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;

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
        searchInput.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                pretrazi(searchInput.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                pretrazi(searchInput.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                pretrazi(searchInput.getText());
            }

            public void pretrazi(String text) {
                if(searchInput.getText().length() == 0){
                    MainWindow.getInstance().getTabs().getTabelProfesori().getSorter().setRowFilter(null);
                }else{
                    //RowFilter sorter = new 
                }
            }
            
        });
    }

    private void PredmetSearch() {

    }
    
}
