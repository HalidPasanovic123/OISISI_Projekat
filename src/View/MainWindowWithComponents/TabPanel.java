package View.MainWindowWithComponents;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

import View.MainWindowWithComponents.MainTabPanels.PredmetJTable;
import View.MainWindowWithComponents.MainTabPanels.ProfesorJTable;

public class TabPanel extends JPanel{
    
    private JTabbedPane tabs;
    private ProfesorJTable tabelProfesori;
    private PredmetJTable tabelPredmeti;

    public TabPanel(){
        super();

        tabs = new JTabbedPane();
        
        Toolkit kit=Toolkit.getDefaultToolkit();
        Dimension size=kit.getScreenSize();
        
        tabs.setPreferredSize(new Dimension(size.width * 73/100,size.height * 63/100));

        JPanel studentiTab = new JPanel();

        tabelProfesori = new ProfesorJTable();
        JScrollPane profesoriTab = new JScrollPane(tabelProfesori);

        tabelPredmeti = new PredmetJTable();
        JScrollPane predmetiTab = new JScrollPane(tabelPredmeti);

        tabs.addTab("Studenti", studentiTab);
        tabs.addTab("Profesori", profesoriTab);
        tabs.addTab("Predmeti", predmetiTab);

        add(tabs);
    }

    public JTabbedPane getJTabbedPane() {
        return tabs;
    }

    public ProfesorJTable getTabelProfesori() {
        return tabelProfesori;
    }

    public PredmetJTable getTabelPredmeti() {
        return tabelPredmeti;
    }

}
