package AbstractActions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;

import AbstractTableModels.AbstractModelProfesori;
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
        if(searchInput.getText().length() == 0){
            MainWindow.getInstance().getTabs().getTabelProfesori().getSorter().setRowFilter(null);
        }else{
            final Pattern regexStrings = Pattern.compile("([a-zA-ZčČćĆžŽđĐšŠ]+[\\s]*)+");
            final Matcher tempString = regexStrings.matcher(searchInput.getText());

            ArrayList<String> strings = new ArrayList<String>();

            while ( tempString.find() ) {
                strings.add(tempString.group().trim());
            }
            
            if (strings.size() == 1) {
                MainWindow.getInstance().getTabs().getTabelProfesori().getSorter().setRowFilter(RowFilter.regexFilter(strings.get(0), 0));
            } else if(strings.size() == 2){
                ArrayList<RowFilter<Object,Object>> filters = new ArrayList<RowFilter<Object,Object>>();
                filters.add(RowFilter.regexFilter(strings.get(0), 0));
                filters.add(RowFilter.regexFilter(strings.get(1), 1));
                RowFilter<Object,Object> filter = RowFilter.andFilter(filters);
                MainWindow.getInstance().getTabs().getTabelProfesori().getSorter().setRowFilter(filter);
            }
        }
            
    }

    private void PredmetSearch() {
        if(searchInput.getText().length() == 0){
            MainWindow.getInstance().getTabs().getTabelPredmeti().getSorter().setRowFilter(null);
        }else{
            final Pattern regexStrings = Pattern.compile("([a-zA-Z0-9čČćĆžŽđĐšŠ]+[\\s]*)+");
            final Matcher tempString = regexStrings.matcher(searchInput.getText());

            ArrayList<String> strings = new ArrayList<String>();

            while ( tempString.find() ) {
                strings.add(tempString.group().trim());
            }
            
            if (strings.size() == 1) {
                MainWindow.getInstance().getTabs().getTabelPredmeti().getSorter().setRowFilter(RowFilter.regexFilter(strings.get(0), 0));
            } else if(strings.size() == 2){
                ArrayList<RowFilter<Object,Object>> filters = new ArrayList<RowFilter<Object,Object>>();
                filters.add(RowFilter.regexFilter(strings.get(0), 0));
                filters.add(RowFilter.regexFilter(strings.get(1), 1));
                RowFilter<Object,Object> filter = RowFilter.andFilter(filters);
                MainWindow.getInstance().getTabs().getTabelPredmeti().getSorter().setRowFilter(filter);
            }
        }
    }
    
}
