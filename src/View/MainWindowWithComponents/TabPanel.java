package View.MainWindowWithComponents;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import View.MainWindowWithComponents.MainTabPanels.PredmetJTable;
import View.MainWindowWithComponents.MainTabPanels.ProfesorJTable;
import View.MainWindowWithComponents.MainTabPanels.StudentJTable;

public class TabPanel extends JPanel{
    
    private JTabbedPane tabs;
    private ProfesorJTable tabelProfesori;
    private PredmetJTable tabelPredmeti;
    private StudentJTable tableStudent;
    
	private static TabPanel instance = null;

	public static TabPanel getInstance() {
		if (instance == null) {
			instance = new TabPanel();
		}
		return instance;
	}

    public TabPanel(){
        super();

        tabs = new JTabbedPane();
        
        Toolkit kit=Toolkit.getDefaultToolkit();
        Dimension size=kit.getScreenSize();
        
        tabs.setPreferredSize(new Dimension(size.width * 73/100,size.height * 63/100));
        
        tableStudent = new StudentJTable();
		    JScrollPane studentiTab1 = new JScrollPane(tableStudent);

        tabelProfesori = new ProfesorJTable();
        JScrollPane profesoriTab = new JScrollPane(tabelProfesori);

        tabelPredmeti = new PredmetJTable();
        JScrollPane predmetiTab = new JScrollPane(tabelPredmeti);
        
        

        tabs.addTab("Studenti", studentiTab1);
        tabs.addTab("Profesori", profesoriTab);
        tabs.addTab("Predmeti", predmetiTab);
        
        //source - StackOverflow
        tabs.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
            	
              if(tabs.getSelectedIndex() == 0)
              {
            	MainWindow.getInstance().setStatusBar("Studentska Služba-Studenti");
              }
              else if(tabs.getSelectedIndex() == 1)
              {
            	MainWindow.getInstance().setStatusBar("Studentska Služba-Profesori");
              }
              else
              {
            	MainWindow.getInstance().setStatusBar("Studentska Služba-Predmeti");
              }

            }
        });
            
        add(tabs);
    }

    public JTabbedPane getJTabbedPane() {
        return tabs;
    }
    
    public  StudentJTable getTableStudent() {
    	return tableStudent;
    }

    public ProfesorJTable getTabelProfesori() {
        return tabelProfesori;
    }

    public PredmetJTable getTabelPredmeti() {
        return tabelPredmeti;
    }

}
