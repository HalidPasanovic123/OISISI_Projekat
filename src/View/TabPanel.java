package View;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class TabPanel extends JPanel{
    
    public TabPanel(){
        super();

        JTabbedPane tabs = new JTabbedPane();
        
        Toolkit kit=Toolkit.getDefaultToolkit();
        Dimension size=kit.getScreenSize();
        
        tabs.setPreferredSize(new Dimension(size.width * 73/100,size.height * 63/100));

        JPanel studentiTab = new JPanel();
        JPanel profesoriTab = new JPanel();
        JPanel predmetiTab = new JPanel();

        tabs.addTab("Studenti", studentiTab);
        tabs.addTab("Profesori", profesoriTab);
        tabs.addTab("Predmeti", predmetiTab);

        add(tabs);
    }

}
